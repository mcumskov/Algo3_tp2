package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaMenuInicio {
    private Stage primaryStage;
    private TextField cantidadDeJugadoresTextField;

    public VistaMenuInicio(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void mostrarPantallaInicio(Button continuarButton) {
        VBox pantallaInicio = new VBox(10);
        pantallaInicio.setPadding(new Insets(20, 20, 20, 20));

        cantidadDeJugadoresTextField = new TextField();
        cantidadDeJugadoresTextField.setStyle("-fx-max-width: 200");

        cantidadDeJugadoresTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            validarCantidadJugadores(newValue, continuarButton);
        });

        pantallaInicio.getChildren().addAll(cantidadDeJugadoresTextField, continuarButton);

        pantallaInicio.setAlignment(Pos.CENTER);

        Scene sceneInicio = new Scene(pantallaInicio, 300, 200);
        primaryStage.setScene(sceneInicio);
        primaryStage.setTitle("Menú Inicio");
    }

    private void validarCantidadJugadores(String cantidad, Button continuar) {
        try {
            int cantidadJugadores = Integer.parseInt(cantidad);
            if (cantidadJugadores >= 2 && cantidadJugadores <= 6) {
                cantidadDeJugadoresTextField.setStyle("-fx-max-width: 200; -fx-text-fill: green;");
                continuar.setDisable(false);
            } else {
                cantidadDeJugadoresTextField.setStyle("-fx-max-width: 200; -fx-text-fill: red;");
                continuar.setDisable(true);
            }
        } catch (NumberFormatException e) {
            cantidadDeJugadoresTextField.setStyle("-fx-max-width: 200; -fx-text-fill: red;");
            continuar.setDisable(true);
        }
    }

    public void mostrarSiguientePantalla(Button atrasButton) {
        VBox pantallaSiguiente = new VBox(10);
        pantallaSiguiente.setPadding(new Insets(20, 20, 20, 20));

        Button iniciarJuegoButton = new Button("Iniciar juego");

        pantallaSiguiente.getChildren().addAll(iniciarJuegoButton, atrasButton);

        pantallaSiguiente.setAlignment(Pos.CENTER);

        Scene sceneSiguiente = new Scene(pantallaSiguiente, 300, 200);
        primaryStage.setScene(sceneSiguiente);
        primaryStage.setTitle("GLADIATORS");
    }

    public int getCantidadDeJugadores() {
        return Integer.parseInt(cantidadDeJugadoresTextField.getText());
    }
}
