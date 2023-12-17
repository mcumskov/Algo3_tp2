package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.jugador.iJugador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VistaPartidaPerdida {
    Stage mainStage;
    public VistaPartidaPerdida(Stage mainStage){
        this.mainStage = mainStage;
    }

    public void mostrarGameOver(Button botonSalir){

        Label mensajeFinal = new Label("PERDIERON TODOS, SON MALISIMOS!!!\nGAME OVER\n");
        mensajeFinal.getStyleClass().add("labelNombre");
        VBox box = new VBox(mensajeFinal, botonSalir);
        box.setAlignment(Pos.CENTER);

        Scene sceneInicio = new Scene(box, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneInicio.getStylesheets().add(cssFile);

        mainStage.setScene(sceneInicio);
        mainStage.setTitle("GAME OVER");
    }

}
