package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.mapa.iCasilla;

public class GladiadorLesionado implements Estado{

    public void avanzar(Gladiador gladiador, iCasilla casillaDeSalida, int pasos){

        gladiador.cambiarEstado(new GladiadorSano());
    }
}