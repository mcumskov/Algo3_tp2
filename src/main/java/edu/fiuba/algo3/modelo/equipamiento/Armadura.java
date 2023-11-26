package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Armadura extends Equipable{

    public Armadura(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 5 ;
    }

    public Equipable mejorar(){

        return new EscudoEspada(this.danioReducir);
    }
}