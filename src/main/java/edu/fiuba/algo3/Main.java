package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorJuego;
import edu.fiuba.algo3.controlador.ControladorMenuInicio;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage mainStage){
        mainStage.setWidth(1800);
        mainStage.setHeight(1000);

        ControladorMenuInicio controladorInicio = new ControladorMenuInicio(mainStage);
        controladorInicio.start();

    }
}
