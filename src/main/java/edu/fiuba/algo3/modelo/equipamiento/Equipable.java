package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public abstract class Equipable {

    protected int proteccion ;

    public int mitigarDanio(int danio)
    {
        int danioFinal = danio + this.proteccion;

        if(danioFinal > 0){

            danioFinal = 0 ;
        }

        return danioFinal ;

    }

    public int getProteccion()
    {

        return this.proteccion;

    }

    public abstract void abrirCasaPompeya(Gladiador gladiador);
}
