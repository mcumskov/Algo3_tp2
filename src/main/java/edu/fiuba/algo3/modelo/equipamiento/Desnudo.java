package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class Desnudo extends Equipable{

    public Desnudo(){
        this.danioReducir = 0 ;
    }

    public Equipable mejorar(){
        Log.getLog().agregarABuffer(" recibe un premio! es un casco! |");
        return new Casco(this.danioReducir);
    }
}