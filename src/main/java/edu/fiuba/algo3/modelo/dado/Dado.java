package edu.fiuba.algo3.modelo.dado;

import java.util.Observable;
import java.util.Random;

public class Dado extends Observable implements iDado{

    private final Random random;
    private int caras;

    private int numeroObtenido;

    public Dado(int caras) {
        this.caras = caras;
        this.random = new Random();
    }

    public Dado() {
        this.caras = 6;
        this.random = new Random();
    }

    public int lanzar()
    {
        this.numeroObtenido = this.random.nextInt(caras) + 1;
        setChanged();
        notifyObservers();
        return  this.numeroObtenido;
    }
    public int getNumeroObtenido(){
        return this.numeroObtenido;
    }
}
