package edu.fiuba.algo3.modelo.gladiador;

public class GladiadorSinEnergia implements Estado{

    private Gladiador gladiador;

    public GladiadorSinEnergia( Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
    }

    public void avanzar(int pasos, int energia){

        gladiador.obtenerEnergia();
        gladiador.cambiarEstado(new GladiadorSano(gladiador));

    }
}
