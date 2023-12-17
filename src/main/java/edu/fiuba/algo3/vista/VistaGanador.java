package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.jugador.iJugador;

public class VistaGanador {
    Stage mainStage;
    public VistaGanador(Stage mainStage){
        this.mainStage = mainStage;
    }
    public void mostrarGanador(iJugador ganador, Button botonSalir){

        Label nombreGanador = new Label("FELICITACIONES A: " + ganador.getNombre() + "\n GANASTE!!");
        nombreGanador.getStyleClass().add("labelNombre");
        VBox box = new VBox(nombreGanador, botonSalir);
        box.setAlignment(Pos.CENTER);

        Scene sceneInicio = new Scene(box, 300, 200);
        String cssFile = getClass().getResource("/style.css").toExternalForm();
        sceneInicio.getStylesheets().add(cssFile);

        mainStage.setScene(sceneInicio);
        mainStage.setTitle("GANADOR");
    }
}
