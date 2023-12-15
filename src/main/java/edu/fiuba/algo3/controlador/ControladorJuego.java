package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.dado.iDado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.iJugador;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.mapa.iMapa;

import java.util.ArrayList;
import java.util.List;

public class ControladorJuego {

    Stage mainStage;
    VistaJuego vistaJuego;
    iMapa mapa;
    private List<Button> buttons;
    Juego juego;

public ControladorJuego(Stage mainStage, iMapa mapa){
    this.mainStage = mainStage;
    this.vistaJuego = new VistaJuego(mainStage);
    this.mapa = mapa;
    this.buttons = new ArrayList<>();
    this.juego = null;

}
public void start(){
    Button jugarButton = new Button("Tirar dado");
    jugarButton.setOnAction(e -> tirarDado());
    this.buttons.add(jugarButton);

    Button pasarButton = new Button("Pasar");
    pasarButton.setOnAction(e -> terminarTurno());
    this.buttons.add(pasarButton);
    pasarButton.setDisable(true);
    iJugador jugador1 = new Jugador("mip");
    iJugador jugador2 = new Jugador("tip");

    ArrayList<iJugador> jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);

    List<Gladiador> gladiadores = new ArrayList<>();
    gladiadores.add(jugador1.getGladiador());
    gladiadores.add(jugador2.getGladiador());

    mapa.ingresarGladiadores(gladiadores, 2);

    iDado dado = new Dado();

    Juego.resetInstancia();
    this.juego = Juego.instanciarJuego(mapa, jugadores, dado);
    this.juego.siguienteTurno();
    this.vistaJuego.mostrarJuego(buttons.get(0), buttons.get(1));

}

public void tirarDado(){
    this.juego.tirarDado();
    buttons.get(1).setDisable(false);
    buttons.get(0).setDisable(true);
}
public void terminarTurno(){
    this.juego.siguienteTurno();
    buttons.get(1).setDisable(true);
    buttons.get(0).setDisable(false);
}

}
