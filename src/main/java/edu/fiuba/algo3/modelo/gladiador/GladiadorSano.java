package edu.fiuba.algo3.modelo.gladiador;

public class GladiadorSano implements Estado{

    private Gladiador gladiador;

    public GladiadorSano(Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
    }

    public void avanzar(int pasos){
        //gladiador.cambiarPosicion(pasos);
    }
}