package edu.fiuba.algo3.modelo;

public abstract class Equipamiento{
    protected int reduccionDeDanio;

    public int mitigarDanio(int danio){
        int danioFinal = (danio - reduccionDeDanio);
        if(danioFinal <= 0)
            return 0;
        return danioFinal;
    }

    public abstract void mejorarEquipamiento(Gladiador gladiador);

}