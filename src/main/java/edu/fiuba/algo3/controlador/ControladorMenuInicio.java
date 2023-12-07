package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaMenuInicio;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorMenuInicio extends Application {
    private Stage primaryStage;
    private VistaMenuInicio vistaInicio;
    private Button atrasButton;
    private Button continuarButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setWidth(900);
        primaryStage.setHeight(600);
        vistaInicio = new VistaMenuInicio(primaryStage);

        continuarButton = new Button("Continuar");
        continuarButton.setDisable(true);
        continuarButton.setOnAction(e -> mostrarSiguientePantalla());

        atrasButton = new Button("Atrás");
        atrasButton.setOnAction(e -> mostrarPantallaInicio());

        vistaInicio.mostrarPantallaInicio(continuarButton);

        primaryStage.show();
    }



    private void mostrarSiguientePantalla() {
        vistaInicio.mostrarSiguientePantalla(atrasButton);
    }

    private void mostrarPantallaInicio() {
        vistaInicio.mostrarPantallaInicio(continuarButton);
    }
}