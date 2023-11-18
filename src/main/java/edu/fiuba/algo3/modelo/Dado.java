package edu.fiuba.algo3.modelo;

import java.util.Random;

public class Dado {

    private final Random random;

    public Dado()
    {

        this.random = new Random();

    }

    public int lanzar()
    {
        return this.random.nextInt(6) + 1 ;
    }

}
