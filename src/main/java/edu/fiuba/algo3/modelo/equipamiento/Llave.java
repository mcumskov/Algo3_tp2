package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Llave extends Equipable{

    public Llave(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 2 ;
    }

    public Equipable mejorar(){

        return this;
    }
}