package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.mapa.Casilla;

public interface Estado {
    public void avanzar(Gladiador gladiador, Casilla casilla, int pasos);
}
