package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.jugador.iJugador;
import edu.fiuba.algo3.vista.VistaGanador;
import edu.fiuba.algo3.vista.VistaJuego;
import edu.fiuba.algo3.vista.VistaPartidaPerdida;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorPantallaFinal {
    iJugador ganador;
    Stage mainStage;
    VistaGanador vistaWin;
    VistaPartidaPerdida vistaLose;
    Button salir;
    //Button volverAJugar;
    public ControladorPantallaFinal(iJugador ganador, Stage mainStage){
        this.mainStage = mainStage;
        this.ganador = ganador;
        this.vistaWin = new VistaGanador(mainStage);
        this.vistaLose = new VistaPartidaPerdida(mainStage);

        Button salirButton = new Button("Salir del juego");
        salirButton.getStyleClass().add("boton");
        salirButton.setOnAction(e -> salirDelJuego());
        this.salir = salirButton;
       /* Button JugarDenuevoButton = new Button("Volver a jugar");
        JugarDenuevoButton.getStyleClass().add("boton");
        JugarDenuevoButton.setOnAction(e -> reiniciarJuego());
        this.volverAJugar = JugarDenuevoButton;*/
    }
    public void startGanador(){
        this.vistaWin.mostrarGanador(this.ganador, this.salir);
    }
    public void startGameOVer(){
        this.vistaLose.mostrarGameOver(this.salir);
    }

    public void salirDelJuego(){
        this.mainStage.close();
    }

}
