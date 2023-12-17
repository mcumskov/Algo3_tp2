package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class EscudoEspada extends Equipable{
    private String representacion = "Casco|armadura|escudo y espada|";
    public EscudoEspada(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 8 ;
    }

    public Equipable mejorar(){
        Log.getLog().agregarABuffer(" recibe un premio! es una llave para una casa en mardel! |");
        return new Llave(this.danioReducir);
    }
    public String getRepresentacion(){
        return this.representacion;
    }
}