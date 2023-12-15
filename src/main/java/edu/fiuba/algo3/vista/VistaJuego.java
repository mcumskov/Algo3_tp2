package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;

public class VistaJuego {

    Stage mainStage;


    public VistaJuego(Stage mainStage){
        this.mainStage = mainStage;
    }

    public void mostrarJuego(Button botonJugar, Button botonTerminarTurno){

        HBox pantallaJuego = new HBox(10);
        pantallaJuego.setBackground(establecerFondoPantalla());
        pantallaJuego.setPadding(new Insets(20, 20, 20, 20));
        pantallaJuego.setSpacing(40);

        pantallaJuego.getChildren().addAll(botonJugar, botonTerminarTurno);
        pantallaJuego.setAlignment(Pos.CENTER);
        Scene sceneInicio = new Scene(pantallaJuego, 300, 200);
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
