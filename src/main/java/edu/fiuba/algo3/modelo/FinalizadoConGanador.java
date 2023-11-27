package edu.fiuba.algo3.modelo;

public class FinalizadoConGanador extends EstadoJuego {
    public boolean determinarContinuidadEjecucion(){ return false; }

    public void finalizar(){
        System.out.println("Gano concha");
    }
}
