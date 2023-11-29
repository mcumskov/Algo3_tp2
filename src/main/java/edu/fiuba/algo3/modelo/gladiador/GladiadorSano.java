package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.mapa.Casilla;

public class GladiadorSano implements Estado{
    public void avanzar(Gladiador gladiador, Casilla casillaDeSalida, int pasos){
        gladiador.actualizarSeniority();
        casillaDeSalida.moverGladiador(pasos, gladiador);
    }
}