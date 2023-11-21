package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public abstract class Equipamiento{

    public Gladiador gladiador;
    public int reduccionDeDanio;

    public void mitigarDanio(int DanioRecibido){
        int danioFinal = DanioRecibido + reduccionDeDanio;
        if(danioFinal <= 0){
            gladiador.cambiarEnergia(danioFinal);
            return;
        }
        gladiador.cambiarEnergia(0);
    }

    public void abrirCasaPompeya(){
        gladiador.irAMitadDelMapa();
    }

    public abstract void mejorarEquipamiento();

}