package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;

public class Llave extends Equipable{
    private String representacion = "Casco|armadura|escudo y espada|LLAVE";

    public Llave(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 2 ;
    }

    public Equipable mejorar(){

        return this;
    }
    public void abrirCasaPompeya(Gladiador gladiador){
        Juego.gladiadorConLlaveLlegaAlFinal();
    }

    public String getRepresentacion(){
        return this.representacion;
    }
}