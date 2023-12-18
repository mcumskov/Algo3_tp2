package edu.fiuba.algo3.modelo.gestorTurnos;

import edu.fiuba.algo3.modelo.jugador.iJugador;

public interface iGestorTurnos {
    public void determinarPrimerJugador();
    public iJugador siguienteTurno();
}
