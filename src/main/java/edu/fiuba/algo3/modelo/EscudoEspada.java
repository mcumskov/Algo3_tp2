package edu.fiuba.algo3.modelo;

public class EscudoEspada extends Equipamiento {

    public EscudoEspada(int mitigacionAcumulada){
        this.reduccionDeDanio = 8 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(Gladiador gladiador){
        gladiador.cambiarEquipamiento(new Llave(reduccionDeDanio));
    }
}