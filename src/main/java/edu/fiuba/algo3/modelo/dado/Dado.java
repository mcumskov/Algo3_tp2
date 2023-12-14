package edu.fiuba.algo3.modelo.dado;

import java.util.Random;

public class Dado implements iDado{

    private final Random random;
    private int caras;

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
        return this.random.nextInt(caras) + 1 ;
    }
}
