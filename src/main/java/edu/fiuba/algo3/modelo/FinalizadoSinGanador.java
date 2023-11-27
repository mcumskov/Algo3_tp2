package edu.fiuba.algo3.modelo;

public class FinalizadoSinGanador extends EstadoJuego{
    public boolean determinarContinuidadEjecucion(){ return false; }

    public void finalizar(){
        System.out.println("No gano nadie");
    }
}
