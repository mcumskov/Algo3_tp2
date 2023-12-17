package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.net.URL;

public class VistaJuego {

    Stage mainStage;


    public VistaJuego(Stage mainStage){
        this.mainStage = mainStage;
    }

    public void mostrarJuego(Button botonJugar, Button botonTerminarTurno, GridPane mapa, String[] nombres, int cantidadPlayers, GridPane datosPlayer){

        VBox Botones = new VBox(50);
        Botones.getChildren().addAll(botonJugar, botonTerminarTurno);
        VBox infoJugadores = new VBox(50);
        for(int i=0; i<cantidadPlayers; i++){
            String num = String.valueOf(i+1);
            Label label = new Label("Jugador"+num+": "+nombres[i]);
            label.getStyleClass().add("labelNombre");//esto es lo q hay q tocar para cambiar como se ve
            infoJugadores.getChildren().add(label);
        }
        VBox infoJugadorActual = new VBox(datosPlayer);

        GridPane pantallaJuego = new GridPane();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(35);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(65);
        pantallaJuego.getColumnConstraints().addAll(col1, col2);

        // Definir filas con porcentajes
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(85);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(15);
        pantallaJuego.getRowConstraints().addAll(row1, row2);



        pantallaJuego.add(infoJugadores,0,0);
        pantallaJuego.add(mapa,1,0);
        pantallaJuego.add(infoJugadorActual,0,1);
        pantallaJuego.add(Botones,1,1);


        pantallaJuego.setBackground(establecerFondoPantalla());
        pantallaJuego.setPadding(new Insets(50, 20, 10, 20));

        Botones.setAlignment(Pos.CENTER_RIGHT);
        infoJugadores.setAlignment(Pos.CENTER_LEFT);

        pantallaJuego.setAlignment(Pos.CENTER_RIGHT);
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
