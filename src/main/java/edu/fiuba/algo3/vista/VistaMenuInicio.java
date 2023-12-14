package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.mapa.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VistaMenuInicio{
    private Stage primaryStage;
    private TextField cantidadDeJugadoresTextField;
    private Label cantidadJugadoresLabel;
    private Label titulo;

    public boolean mapaCargado;

    private List<TextField> nombresTextFields;

    public VistaMenuInicio(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.mapaCargado = false;

    }
    public void setMapaCargado(Boolean bool){
        this.mapaCargado = bool;
    }

    public void mostrarPantallaInicio(Button continuarButton) {

        continuarButton.setDisable(true);
        continuarButton.getStyleClass().add("botonContinuar");

        VBox pantallaInicio = new VBox(10);
        pantallaInicio.setBackground(establecerFondoPantalla());
        pantallaInicio.setPadding(new Insets(20, 20, 20, 20));
        pantallaInicio.setSpacing(40);

        titulo = new Label("GLADIATORS");
        titulo.getStyleClass().add("titulo");

        cantidadJugadoresLabel = new Label("Ingrese la cantidad de jugadores");
        cantidadJugadoresLabel.getStyleClass().add("subtitulo");

        cantidadDeJugadoresTextField = new TextField();
        cantidadDeJugadoresTextField.getStyleClass().add("textField");

        VBox contenedorCantidadJugadores = new VBox();
        contenedorCantidadJugadores.getStyleClass().add("jugadorBox");
        contenedorCantidadJugadores.setSpacing(10);
        contenedorCantidadJugadores.setAlignment(Pos.CENTER);
        contenedorCantidadJugadores.getChildren().addAll(cantidadJugadoresLabel, cantidadDeJugadoresTextField);

        cantidadDeJugadoresTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            validarCantidadJugadores(newValue, continuarButton);
        });

        pantallaInicio.getChildren().addAll(titulo, contenedorCantidadJugadores, continuarButton);

        pantallaInicio.setAlignment(Pos.CENTER);

        Scene sceneInicio = new Scene(pantallaInicio, 300, 200);
        // Cargar el archivo CSS desde resources
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneInicio.getStylesheets().add(cssFile);
        primaryStage.setScene(sceneInicio);
        primaryStage.setTitle("Menú Inicio");
    }

    private void validarCantidadJugadores(String cantidad, Button continuar) {
        try {
            int cantidadJugadores = Integer.parseInt(cantidad);
            if (cantidadJugadores >= 2 && cantidadJugadores <= 6) {
                cantidadDeJugadoresTextField.getStyleClass().removeAll("invalido");
                cantidadDeJugadoresTextField.getStyleClass().add("valido");
                continuar.setDisable(false);
            } else {
                cantidadDeJugadoresTextField.getStyleClass().removeAll("valido");
                cantidadDeJugadoresTextField.getStyleClass().add("invalido");
                continuar.setDisable(true);
            }
        } catch (NumberFormatException e) {
            continuar.setDisable(true);
        }
    }

    public void mostrarSiguientePantalla(Button atrasButton, Button elegirMapaButton, Button verMapaButton) {

        VBox pantallaSiguiente = new VBox(10);
        pantallaSiguiente.setBackground(establecerFondoPantalla());
        pantallaSiguiente.setPadding(new Insets(20, 20, 20, 20));
        pantallaSiguiente.setSpacing(50);

        atrasButton.getStyleClass().add("botonAtras");
        pantallaSiguiente.getChildren().add(atrasButton);

        VBox boxJugadores = new VBox();
        boxJugadores.setSpacing(20);

        nombresTextFields = new ArrayList<TextField>();
        for (int i = 0; i < getCantidadDeJugadores(); i++) {
            Label label = new Label("Nombre Jugador " + (i + 1));
            label.getStyleClass().add("labelNombre");

            TextField nombreTextField = new TextField();
            nombreTextField.getStyleClass().add("textField");
            nombresTextFields.add(nombreTextField);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(label, nombreTextField);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);

            boxJugadores.getChildren().add(hBox);
        }

        boxJugadores.setAlignment(Pos.CENTER);
        pantallaSiguiente.getChildren().add(boxJugadores);
        elegirMapaButton.getStyleClass().add("botonContinuar");
        pantallaSiguiente.getChildren().add(elegirMapaButton);

        verMapaButton.setDisable(true);
        verMapaButton.getStyleClass().add("botonContinuar");
        pantallaSiguiente.getChildren().add(verMapaButton);

        for (TextField textField : nombresTextFields) {
            validacionDeNombresEnTiempoReal(textField, verMapaButton);
        }

        pantallaSiguiente.setAlignment(Pos.CENTER);

        Scene sceneSiguiente = new Scene(pantallaSiguiente, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneSiguiente.getStylesheets().add(cssFile);
        primaryStage.setScene(sceneSiguiente);
        primaryStage.setTitle("GLADIATORS");
    }

    public void MostrarMapa(Button atrasButton, Button empezarJuego, GridPane DatosMapa){

        VBox pantallaMapa = new VBox(10);
        pantallaMapa.setBackground(establecerFondoPantalla());
        pantallaMapa.setPadding(new Insets(20, 20, 20, 20));
        pantallaMapa.setSpacing(50);

        atrasButton.getStyleClass().add("botonAtras");
        pantallaMapa.getChildren().add(atrasButton);
        empezarJuego.getStyleClass().add("botonContinuar");
        pantallaMapa.getChildren().add(empezarJuego);

        DatosMapa.setAlignment(Pos.CENTER);
        pantallaMapa.getChildren().add(DatosMapa);
        pantallaMapa.setAlignment(Pos.CENTER);
        Scene sceneMapa = new Scene(pantallaMapa, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneMapa.getStylesheets().add(cssFile);
        primaryStage.setScene(sceneMapa);
        primaryStage.setTitle("GLADIATORS");
    }



    private void validacionDeNombresEnTiempoReal(TextField textField, Button verMapaButton) {
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue.length() >= 4) {
                textField.getStyleClass().removeAll("invalido");
                textField.getStyleClass().add("valido");
            } else {
                textField.getStyleClass().removeAll("valido");
                textField.getStyleClass().add("invalido");
            }
            actualizarBotonIniciarJuego(verMapaButton);
        });
    }

    public void actualizarBotonIniciarJuego(Button verMapaButton) {
        boolean status = false;
        for (TextField textField : nombresTextFields) {
            if (textField.getText().length() < 4 ) {
                status = true;
            }
        }
        if(!this.mapaCargado){
            status = true;
        }
        verMapaButton.setDisable(status);
    }

    private Background establecerFondoPantalla() {
        URL imageUrl = getClass().getResource("/image/coliseo.png");
        Image backgroundImage = new Image(imageUrl.toExternalForm());
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        return new Background(background);
    }

    public int getCantidadDeJugadores() {
        return Integer.parseInt(cantidadDeJugadoresTextField.getText());
    }

}
