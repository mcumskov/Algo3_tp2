package edu.fiuba.algo3.modelo;

public abstract class EstadoJuego implements DeterminadorContinuidadEjecucion, Finalizador{
    public abstract void finalizar();

    public abstract boolean determinarContinuidadEjecucion();
}
