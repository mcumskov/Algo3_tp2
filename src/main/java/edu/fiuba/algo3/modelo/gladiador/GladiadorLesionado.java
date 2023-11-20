package edu.fiuba.algo3.modelo.gladiador;

public class GladiadorLesionado implements Estado{

    private Gladiador gladiador;

    public GladiadorLesionado( Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
    }

    public void avanzar(int pasos, int energia){
        gladiador.cambiarEstado(new GladiadorSano(gladiador));
    }
}