package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
public class Casco extends Equipable{

    public Casco(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 5 ;
    }

    public Equipable mejorar(){
        return new Armadura(this.danioReducir);
    }
}

