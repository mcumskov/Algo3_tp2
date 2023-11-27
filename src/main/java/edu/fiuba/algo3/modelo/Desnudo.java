package edu.fiuba.algo3.modelo;

public class Desnudo extends Equipamiento {

    public Desnudo(){
        this.reduccionDeDanio = 0;
    }

    public void mejorarEquipamiento(Gladiador gladiador){
        gladiador.cambiarEquipamiento(new Casco(reduccionDeDanio));
    }
}