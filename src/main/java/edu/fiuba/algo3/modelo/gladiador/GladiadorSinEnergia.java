package edu.fiuba.algo3.modelo.gladiador;

public class GladiadorSinEnergia implements Estado{

    private Gladiador gladiador;

    public GladiadorSinEnergia( Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
    }

    public void avanzar(int pasos){
        gladiador.cambiarEnergia(5);
        gladiador.cambiarEstado(new GladiadorSano(gladiador));
    }
}
