package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VistaMenuInicio {
    private Stage primaryStage;
    private TextField cantidadDeJugadoresTextField;
    private Label cantidadJugadoresLabel;
    private Label titulo;

    private List<TextField> nombresTextFields;

    public VistaMenuInicio(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void mostrarPantallaInicio(Button continuarButton) {

        continuarButton.setDisable(true);
        continuarButton.setStyle("-fx-background-color: #de9532; -fx-border-radius: 4; -fx-text-fill: white");

        VBox pantallaInicio = new VBox(10);
        pantallaInicio.setBackground(establecerFondoPantalla());
        pantallaInicio.setPadding(new Insets(20, 20, 20, 20));
        pantallaInicio.setSpacing(40);

        titulo = new Label("GLADIATORS");
        titulo.setStyle("-fx-font-size: 40; -fx-font-weight: BOLDER; -fx-text-fill: white");

        cantidadJugadoresLabel = new Label("Ingrese la cantidad de jugadores");
        cantidadJugadoresLabel.setStyle("-fx-font-weight: BOLD; -fx-text-fill: white; -fx-font-size: 16");

        cantidadDeJugadoresTextField = new TextField();
        cantidadDeJugadoresTextField.setStyle("-fx-max-width: 100");

        VBox contenedorCantidadJugadores = new VBox();
        contenedorCantidadJugadores.setSpacing(10);
        contenedorCantidadJugadores.setAlignment(Pos.CENTER);
        contenedorCantidadJugadores.getChildren().addAll(cantidadJugadoresLabel, cantidadDeJugadoresTextField);

        cantidadDeJugadoresTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            validarCantidadJugadores(newValue, continuarButton);
        });

        pantallaInicio.getChildren().addAll(titulo, contenedorCantidadJugadores, continuarButton);

        pantallaInicio.setAlignment(Pos.CENTER);

        Scene sceneInicio = new Scene(pantallaInicio, 300, 200);
        primaryStage.setScene(sceneInicio);
        primaryStage.setTitle("Menú Inicio");
    }

    private void validarCantidadJugadores(String cantidad, Button continuar) {
        try {
            int cantidadJugadores = Integer.parseInt(cantidad);
            if (cantidadJugadores >= 2 && cantidadJugadores <= 6) {
                cantidadDeJugadoresTextField.setStyle("-fx-max-width: 100; -fx-text-fill: green;");
                continuar.setDisable(false);
            } else {
                cantidadDeJugadoresTextField.setStyle("-fx-max-width: 100; -fx-text-fill: red;");
                continuar.setDisable(true);
            }
        } catch (NumberFormatException e) {
            cantidadDeJugadoresTextField.setStyle("-fx-max-width: 100; -fx-text-fill: red;");
            continuar.setDisable(true);
        }
    }

    public void mostrarSiguientePantalla(Button atrasButton) {

        VBox pantallaSiguiente = new VBox(10);
        pantallaSiguiente.setBackground(establecerFondoPantalla());
        pantallaSiguiente.setPadding(new Insets(20, 20, 20, 20));
        pantallaSiguiente.setSpacing(50);

        atrasButton.setStyle("-fx-background-color: #de9532; -fx-border-radius: 4; -fx-text-fill: white");
        pantallaSiguiente.getChildren().add(atrasButton);

        VBox boxJugadores = new VBox();
        boxJugadores.setSpacing(20);

        nombresTextFields = new ArrayList<TextField>();
        for (int i = 0; i < getCantidadDeJugadores(); i++) {
            Label label = new Label("Nombre Jugador " + (i + 1));
            label.setStyle("-fx-font-weight: BOLD; -fx-text-fill: white; -fx-font-size: 14");

            TextField nombreTextField = new TextField();
            nombreTextField.setStyle("-fx-max-width: 200");
            nombresTextFields.add(nombreTextField);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(label, nombreTextField);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);

            boxJugadores.getChildren().add(hBox);
        }

        boxJugadores.setAlignment(Pos.CENTER);
        pantallaSiguiente.getChildren().add(boxJugadores);

        Button iniciarJuegoButton = new Button("Iniciar juego");
        iniciarJuegoButton.setStyle("-fx-background-color: #de9532; -fx-border-radius: 4; -fx-text-fill: white");
        iniciarJuegoButton.setDisable(true);
        pantallaSiguiente.getChildren().add(iniciarJuegoButton);

        for (TextField textField : nombresTextFields) {
            validacionDeNombresEnTiempoReal(textField, iniciarJuegoButton);
        }

        pantallaSiguiente.setAlignment(Pos.CENTER);

        Scene sceneSiguiente = new Scene(pantallaSiguiente, 300, 200);
        primaryStage.setScene(sceneSiguiente);
        primaryStage.setTitle("GLADIATORS");
    }

    private void validacionDeNombresEnTiempoReal(TextField textField, Button iniciarJuego) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.length() >= 4) {
                textField.setStyle("-fx-text-fill: green;");
            } else {
                textField.setStyle("-fx-text-fill: red;");
            }
            actualizarBotonIniciarJuego(iniciarJuego);
        });
    }

    private void actualizarBotonIniciarJuego(Button iniciarJuego) {
        for (TextField textField : nombresTextFields) {
            if (textField.getText().length() < 4) {
                iniciarJuego.setDisable(true);
                return;
            }
        }
        iniciarJuego.setDisable(false);
    }

    private Background establecerFondoPantalla() {
        URL imageUrl = getClass().getResource("/image/coliseo.png");
        Image backgroundImage = new Image(imageUrl.toExternalForm());
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        return new Background(background);
    }

    public int getCantidadDeJugadores() {
        return Integer.parseInt(cantidadDeJugadoresTextField.getText());
    }
}
