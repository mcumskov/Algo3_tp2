package edu.fiuba.algo3.modelo;

public abstract class Seniority{
    protected int turnos;
    protected int recuperacionEnergia;
    protected int limiteAsencion;

    public abstract void evolucionar(Gladiador gladiador);

    public void recuperarEnergia(Gladiador gladiador){
        gladiador.cambiarEnergia(recuperacionEnergia);
    }
}