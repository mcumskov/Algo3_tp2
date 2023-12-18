package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.jugador.iJugador;

import java.net.URL;

public class VistaGanador {
    private Stage mainStage;
    public VistaGanador(Stage mainStage){
        this.mainStage = mainStage;
    }
    public void mostrarGanador(iJugador ganador, Button botonSalir){

        Label nombreGanador = new Label("FELICITACIONES: " + ganador.getNombre() + "\n GANASTE!!\n LA CASA POMPEYANA ES TUYA");
        nombreGanador.getStyleClass().add("labelNombre");
        VBox box = new VBox(nombreGanador, botonSalir);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(100);
        box.setBackground(establecerFondoPantalla());
        Scene sceneInicio = new Scene(box, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneInicio.getStylesheets().add(cssFile);

        mainStage.setScene(sceneInicio);
        mainStage.setTitle("GANADOR");
    }

    private Background establecerFondoPantalla() {
        URL imageUrl = getClass().getResource("/image/casaPompeya.jpg");
        Image backgroundImage = new Image(imageUrl.toExternalForm());
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        return new Background(background);
    }
}
