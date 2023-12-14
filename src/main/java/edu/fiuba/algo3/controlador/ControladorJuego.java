package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.VistaJuego;
import javafx.stage.Stage;

public class ControladorJuego {

    Stage primaryStage;

    VistaJuego vistaJuego;


public ControladorJuego(Stage primaryStage){
    this.primaryStage = primaryStage;
    this.vistaJuego = new VistaJuego(primaryStage);

}
public static void main(){

}


}
