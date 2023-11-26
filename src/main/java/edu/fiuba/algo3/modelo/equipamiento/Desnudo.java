package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
public class Desnudo extends Equipable{

    public Desnudo(){
        this.danioReducir = 0 ;
    }

    public Equipable mejorar(){

        return new Casco(this.danioReducir);
    }
}