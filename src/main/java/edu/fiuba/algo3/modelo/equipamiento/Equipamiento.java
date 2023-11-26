package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Equipamiento implements IEquipamiento{

    private Equipable equipable ;

    public Equipamiento(){

        this.equipable = new Desnudo();

    }

    public int recibirAtaque(int danioRecibido){

        return (this.equipable.mitigarDanio(danioRecibido));

    }

    public void mejorar(){

        this.equipable = equipable.mejorar();

    }

    public void abrirCasaPompeya(){


    }


}