package edu.fiuba.algo3.modelo;

public class Llave extends Equipamiento {

    public Llave(int mitigacionAcumulada){
        this.reduccionDeDanio = 2 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(Gladiador gladiador){}
}