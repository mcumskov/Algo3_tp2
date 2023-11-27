package edu.fiuba.algo3.modelo;

public class Casco extends Equipamiento {

    public Casco(int mitigacionAcumulada){
        this.reduccionDeDanio = 5 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(Gladiador gladiador){
        gladiador.cambiarEquipamiento(new Armadura(reduccionDeDanio));
    }
}

