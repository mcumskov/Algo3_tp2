package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.mapa.iCasilla;

public class GladiadorSano implements Estado{
    String representacion = "Sano";
    public void avanzar(Gladiador gladiador, iCasilla casillaDeSalida, int pasos){
        gladiador.actualizarSeniority();
        casillaDeSalida.moverGladiador(pasos, gladiador);
    }
    public String getRepresentacion(){
        return this.representacion;
    }
}