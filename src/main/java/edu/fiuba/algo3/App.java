package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.CantidadJugadoresForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
    private BorderPane contenedorPrincipal;

    @Override
    public void start(Stage primaryStage) {
        Screen screen = Screen.getPrimary();

        double screenWidth = screen.getBounds().getWidth();
        double screenHeight = screen.getBounds().getHeight();

        Button startButton = new Button("Jugar nueva partida");
        startButton.setOnAction(e -> {
            mostrarCantidadJugadoresForm();
        });

        this.contenedorPrincipal = new BorderPane();
        this.contenedorPrincipal.setCenter(startButton);

        Scene scene = new Scene(this.contenedorPrincipal, screenWidth*0.7, screenHeight*0.7);

        primaryStage.setScene(scene);
        primaryStage.setTitle("POC JavaFX");
        primaryStage.show();
    }

    private void mostrarCantidadJugadoresForm(){
        CantidadJugadoresForm cantidadJugadoresForm = new CantidadJugadoresForm(this.contenedorPrincipal);
        this.contenedorPrincipal.setCenter(cantidadJugadoresForm);
    }

    public static void main(String[] args) {
        launch(args);
    }

}