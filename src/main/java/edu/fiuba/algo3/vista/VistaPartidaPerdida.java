package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.iJugador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;

public class VistaPartidaPerdida {
    private Stage mainStage;
    public VistaPartidaPerdida(Stage mainStage){
        this.mainStage = mainStage;
    }

    public void mostrarGameOver(Button botonSalir){

        Label mensajeFinal = new Label("PERDIERON TODOS, SON MALISIMOS!!!\nGAME OVER\n");
        mensajeFinal.getStyleClass().add("labelNombre");
        VBox box = new VBox(mensajeFinal, botonSalir);
        box.setAlignment(Pos.CENTER_LEFT);
        box.setBackground(establecerFondoPantalla());
        Scene sceneInicio = new Scene(box, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneInicio.getStylesheets().add(cssFile);

        mainStage.setScene(sceneInicio);
        mainStage.setTitle("GAME OVER");
    }

    private Background establecerFondoPantalla() {
        URL imageUrl = getClass().getResource("/image/GameOver.jpg");
        Image backgroundImage = new Image(imageUrl.toExternalForm());
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true));
        return new Background(background);
    }

}
