package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.stage.Stage;

import java.net.URL;

public class VistaJuego {

    private Stage mainStage;


    public VistaJuego(Stage mainStage){
        this.mainStage = mainStage;
    }

    public void mostrarJuego(Button botonJugar, Button botonTerminarTurno, GridPane mapa, String[] nombres, int cantidadPlayers, GridPane datosPlayer){

        HBox botones = new HBox(10);
        botones.getChildren().addAll(botonJugar, botonTerminarTurno);
        botones.setAlignment(Pos.CENTER);

        VBox infoJugadores = new VBox(10);
        for(int i=0; i<cantidadPlayers; i++){
            String num = String.valueOf(i+1);
            Label label = new Label("Jugador"+num+": "+nombres[i]);
            label.getStyleClass().add("labelNombre");
            infoJugadores.getChildren().add(label);
            infoJugadores.setAlignment(Pos.TOP_LEFT);
            infoJugadores.setPadding(new Insets(10, 10, 0, 10));
        }
        infoJugadores.getStyleClass().add("contenedorInfo");

        VBox pantallaJuego = new VBox();

        SplitPane parteSuperior = new SplitPane();
        StackPane leftPane = new StackPane();

        leftPane.getChildren().addAll(infoJugadores);
        leftPane.setPadding(new Insets(10, 200, 450, 10));
        leftPane.setAlignment(Pos.CENTER);

        StackPane rightPane = new StackPane();
        rightPane.getChildren().add(mapa);
        rightPane.setMargin(mapa, new Insets(10));

        parteSuperior.getItems().addAll(leftPane, rightPane);
        parteSuperior.getStyleClass().add("fondoTransparente");
        parteSuperior.setMouseTransparent(true);

        VBox infoJugadorActual = new VBox(datosPlayer);
        infoJugadorActual.getStyleClass().add("contenedorInfo");
        infoJugadorActual.setMargin(datosPlayer, new Insets(10));

        HBox parteInferior = new HBox();

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        parteInferior.getChildren().addAll(infoJugadorActual,spacer,botones);
        parteInferior.setMargin(infoJugadorActual, new Insets(10));
        parteInferior.setMargin(botones, new Insets(10));

        pantallaJuego.getChildren().addAll(parteSuperior,parteInferior);

        pantallaJuego.setBackground(establecerFondoPantalla());
        pantallaJuego.setAlignment(Pos.TOP_CENTER);

        Scene sceneInicio = new Scene(pantallaJuego, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneInicio.getStylesheets().add(cssFile);

        mainStage.setScene(sceneInicio);
        mainStage.setTitle("carrera a pompeya");

    }

    private Background establecerFondoPantalla() {
        URL imageUrl = getClass().getResource("/image/coliseo.png");
        Image backgroundImage = new Image(imageUrl.toExternalForm());
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        return new Background(background);
    }
}
