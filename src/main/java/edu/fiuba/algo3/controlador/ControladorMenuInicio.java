package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.mapa.Coordenada;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.parser.Parser;
import edu.fiuba.algo3.vista.VistaMenuInicio;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.util.ArrayList;
import java.util.List;

public class ControladorMenuInicio extends Application {
    private Stage primaryStage;
    private VistaMenuInicio vistaInicio;
    private List<Button> buttons;
    private Mapa miMapa;

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
        continuarButton.setOnAction(e -> MostrarPantallaNombres());
        buttons.add(continuarButton);

        Button atrasButton = new Button("Volver");
        atrasButton.setOnAction(e -> mostrarPantallaInicio());
        buttons.add(atrasButton);

        Button ElegirMapaButton = new Button("Elegir mapa");
        ElegirMapaButton.setOnAction(e -> PantallaelegirMapa());
        buttons.add(ElegirMapaButton);

        Button verMapaButton = new Button("Ver mapa elegido");
        verMapaButton.setOnAction(e -> PantallaMostrarMapa());
        buttons.add(verMapaButton);

        Button jugarButton = new Button("~JUGAR~");
        //ElegirMapaButton.setOnAction(e -> PantallaMostrarMapa());
        buttons.add(jugarButton);

        Button volverButton = new Button("Volver");
        volverButton.setOnAction(e -> MostrarPantallaNombres());
        buttons.add(volverButton);

        vistaInicio.mostrarPantallaInicio(continuarButton);

        primaryStage.show();
    }

    private void MostrarPantallaNombres() {
        vistaInicio.mostrarSiguientePantalla(buttons.get(1), buttons.get(2), buttons.get(3));
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
                this.miMapa = parser.parsearMapa(filePath);
                System.out.println("Selected JSON file path: " + filePath);
                System.out.println("se eligio un archivo");
                vistaInicio.setMapaCargado(true);
                vistaInicio.actualizarBotonIniciarJuego(buttons.get(3));
            }catch (Exception e){
                System.out.println("Error con el JSON seleccionado: " + e);

            }
        }
    }

    private void PantallaMostrarMapa(){

        int largoMapa = this.miMapa.getLargo();
        int anchoMapa = this.miMapa.getAncho();
        List<iCasilla> casillas = this.miMapa.getCasillas();
        List<Coordenada> coordenadas = new ArrayList<>();
        GridPane gridPane = new GridPane();

        for (iCasilla casilla:casillas) {
            coordenadas.add(casilla.getCoordenada());
        }

        for (iCasilla casilla:casillas) {
            coordenadas.add(casilla.getCoordenada());
        }

        for (int fila = 1; fila <= anchoMapa; fila++) {
            for (int col = 1; col <= largoMapa; col++) {
                Rectangle rectangulo = new Rectangle(42, 32);
                rectangulo.setFill(Color.ROSYBROWN);
                rectangulo.setStroke(Color.ROSYBROWN.darker());

                gridPane.add(rectangulo, col, fila);
            }
        }

        int tope = coordenadas.size();

        for (int i=0 ; i< tope; i++){
            Coordenada coordenada = coordenadas.get(i);
            Node nodito = getNodo(gridPane,coordenada.getX() ,coordenada.getY());
            Rectangle rectangulito =  (Rectangle) nodito;
            rectangulito.setFill(Color.SANDYBROWN);
            rectangulito.setStroke(Color.BLACK);
            if(i==0){
                rectangulito.setFill(Color.GAINSBORO);
            } else if (i == tope-1){
                rectangulito.setFill(Color.GREY);
            }
        }

        vistaInicio.MostrarMapa(buttons.get(5), buttons.get(4),gridPane);
    }

    private Node getNodo(GridPane gridPane, int col, int fila) {
        for (Node nodo : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(nodo) == col && GridPane.getRowIndex(nodo) == fila) {
                return nodo;
            }
        }
        return null;
    }

}