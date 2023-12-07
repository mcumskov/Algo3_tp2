package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.parser.Parser;
import edu.fiuba.algo3.vista.VistaMenuInicio;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ControladorMenuInicio extends Application {
    private Stage primaryStage;
    private VistaMenuInicio vistaInicio;
    private List<Button> buttons;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setWidth(800);
        this.primaryStage.setHeight(600);

        this.vistaInicio = new VistaMenuInicio(primaryStage);
        this.buttons = new ArrayList<>();

        Button continuarButton = new Button("Continuar");
        continuarButton.setOnAction(e -> mostrarSiguientePantalla());
        buttons.add(continuarButton);

        Button atrasButton = new Button("Atrás");
        atrasButton.setOnAction(e -> mostrarPantallaInicio());
        buttons.add(atrasButton);

        Button ElegirMapaButton = new Button("Elegir mapa :0!!");
        ElegirMapaButton.setOnAction(e -> PantallaelegirMapa());
        buttons.add(ElegirMapaButton);

        vistaInicio.mostrarPantallaInicio(continuarButton);

        primaryStage.show();
    }

    private void mostrarSiguientePantalla() {
        vistaInicio.mostrarSiguientePantalla(buttons.get(1), buttons.get(2));
    }

    private void mostrarPantallaInicio() {
        vistaInicio.mostrarPantallaInicio(buttons.get(0));
    }

    private void PantallaelegirMapa(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("archivos JSON", "*.json"));
        java.io.File selectedFile = fileChooser.showOpenDialog(primaryStage);
        Parser parser = new Parser();
        if (selectedFile != null) {
            try{
                String filePath = selectedFile.getAbsolutePath();
                Mapa miMapa = parser.parsearMapa(filePath);
                System.out.println("Selected JSON file path: " + filePath);
                System.out.println("se eligio un archivo");
            }catch (Exception e){
                System.out.println("Error con el JSON seleccionado: " + e);
            }



        }else {
            System.out.println("No file selected.");
        }
    }
}