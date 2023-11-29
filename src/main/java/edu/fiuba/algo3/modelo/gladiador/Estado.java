package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.mapa.iCasilla;

public interface Estado {
    public void avanzar(Gladiador gladiador, iCasilla casilla, int pasos);
}
