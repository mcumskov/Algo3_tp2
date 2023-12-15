package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.dado.iDado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.iMapa;

public interface iJugador {
    public void jugar(iDado dado, iMapa mapa);
    public Gladiador getGladiador();
}
