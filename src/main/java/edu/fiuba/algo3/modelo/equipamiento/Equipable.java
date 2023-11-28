package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public abstract class Equipable {

    protected int danioReducir ;

    public abstract Equipable mejorar();

    public int mitigarDanio(int danioRecibido){

        return (danioRecibido - this.danioReducir) ;

    }

    public void abrirCasaPompeya(){

    }

}
