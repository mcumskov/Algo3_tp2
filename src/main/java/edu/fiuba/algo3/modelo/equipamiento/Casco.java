package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class Casco extends Equipable{

    public Casco(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 5 ;
    }

    public Equipable mejorar(){
        Log.getLog().agregarABuffer(" recibe un premio! es una armadura! |");
        return new Armadura(this.danioReducir);
    }
}

