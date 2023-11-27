package edu.fiuba.algo3.modelo;

public class Armadura extends Equipamiento{

    public Armadura(int mitigacionAcumulada){
        this.reduccionDeDanio = 5 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(Gladiador gladiador){
        gladiador.cambiarEquipamiento(new EscudoEspada(reduccionDeDanio));
    }
}