package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorMenuInicio;
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
        nombresTextFields = new ArrayList<TextField>();

    }
    public void setMapaCargado(Boolean bool){
        this.mapaCargado = bool;
    }

    public void mostrarPantallaInicio(Button continuarButton) {

        continuarButton.setDisable(true);
        continuarButton.getStyleClass().add("boton");

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

    public void mostrarSiguientePantalla(Button atrasButton, Button elegirMapaButton, Button verMapaButton, ControladorMenuInicio controlador) {

        VBox pantallaSiguiente = new VBox(10);
        pantallaSiguiente.setBackground(establecerFondoPantalla());
        pantallaSiguiente.setPadding(new Insets(20, 20, 20, 20));
        pantallaSiguiente.setSpacing(50);

        atrasButton.getStyleClass().add("boton");
        pantallaSiguiente.getChildren().add(atrasButton);

        VBox boxJugadores = new VBox();
        boxJugadores.setSpacing(20);

        int cantJugadores = getCantidadDeJugadores();

        for (int i = 0; i < cantJugadores; i++) {
            Label label = new Label("Nombre Jugador " + (i + 1));
            label.getStyleClass().add("labelNombre");

            TextField nombreTextField = new TextField();
            nombreTextField.getStyleClass().add("textField");
            int finalI = i;
            nombreTextField.setOnKeyReleased(event -> controlador.nombreJugadores(nombreTextField.getText(), finalI, cantJugadores));

            nombresTextFields.add(nombreTextField);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(label, nombreTextField);
            hBox.setAlignment(Pos.CENTER);
            hBox.setSpacing(10);

            boxJugadores.getChildren().add(hBox);
        }

        boxJugadores.setAlignment(Pos.CENTER);
        pantallaSiguiente.getChildren().add(boxJugadores);
        elegirMapaButton.getStyleClass().add("boton");
        pantallaSiguiente.getChildren().add(elegirMapaButton);

        verMapaButton.setDisable(true);
        verMapaButton.getStyleClass().add("boton");
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

        HBox pantallaMapa1 = new HBox(10);
        VBox pantallaMapa2 = new VBox(pantallaMapa1);
        Label instrucciones = new Label("El objetivo del juego es llegar a la casilla final y abrir la puerta de la casa" +
                " de pompeya.\nPara abrir la puerta se requiere una llave que podra ser encontrada en las casillas de equipamiento. A continuacion se listan los tipos" +
                "de casilla junto a sus representaciones:\n\nF: fiera salvaje, se desata una pelea con una fiera y se pierde energia segun que equipamiento se tenga\n" +
                "C: el gladiador se encuentra comida y recpuera energia.\nB: el gladiador entra a un bar y se toma una cantidad aleatoria de birras y pierde energia segun cuanto tomo\n" +
                "L: el gladiador se lesiona y al sigiente turno no podra moverse\nE: recibe equipamiento nuevo\nCada jugador tiene 30 turnos para ganar o seran atrapados por una fiera suprema!");
        instrucciones.getStyleClass().add("labelNombre");

        HBox boxInstrucciones = new HBox(instrucciones);
        boxInstrucciones.setAlignment(Pos.CENTER);

        VBox mainPantallaMapa = new VBox(pantallaMapa1, pantallaMapa2, boxInstrucciones);

        mainPantallaMapa.setBackground(establecerFondoPantalla());
        mainPantallaMapa.setPadding(new Insets(20, 20, 20, 20));
        mainPantallaMapa.setSpacing(50);

        atrasButton.getStyleClass().add("boton");
        pantallaMapa1.getChildren().add(atrasButton);
        empezarJuego.getStyleClass().add("boton");
        pantallaMapa1.getChildren().add(empezarJuego);
        pantallaMapa1.setAlignment(Pos.CENTER);

        DatosMapa.setAlignment(Pos.CENTER);
        pantallaMapa2.getChildren().add(DatosMapa);
        pantallaMapa2.setAlignment(Pos.CENTER);

        Scene sceneMapa = new Scene(mainPantallaMapa, 300, 200);
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
