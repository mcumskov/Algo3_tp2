package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.log.Log;

public class Armadura extends Equipable{
    private String representacion = "Casco|armadura";
    public Armadura(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 5 ;
    }

    public Equipable mejorar(){
        Log.getLog().agregarABuffer(" recibe un premio! es un escudo y espada! |");
        return new EscudoEspada(this.danioReducir);
    }
    public String getRepresentacion(){
        return this.representacion;
    }
}