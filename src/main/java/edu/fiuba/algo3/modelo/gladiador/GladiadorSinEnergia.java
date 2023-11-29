package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.mapa.Casilla;

public class GladiadorSinEnergia implements Estado{

    public void avanzar(Gladiador gladiador, Casilla casillaDeSalida, int pasos){
        gladiador.aumentarEnergia(5);
        if(gladiador.getEnergia() > 0){
            gladiador.cambiarEstado(new GladiadorSano());
        }
    }
}
