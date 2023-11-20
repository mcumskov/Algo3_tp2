package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Equipamiento{

    private int numeroMejoras ;
    private Gladiador gladiador ;

    private Equipable equipable ;
    public Equipamiento(Gladiador gladiador)
    {
        this.gladiador = gladiador ;

        this.equipable = new SinEquipamiento();

        numeroMejoras = 0 ;
    }

    public void mitigarDanio(int danioRecibido){

        gladiador.cambiarEnergia(this.equipable.mitigarDanio(danioRecibido));

    }

    public void mejorarEquipamiento()
    {
        numeroMejoras ++;
        int proteccionAcumulada = equipable.getProteccion();

        if (numeroMejoras == 1){

            this.equipable = new Casco(proteccionAcumulada);

        } else if (numeroMejoras == 2 ) {

            this.equipable = new Armadura(proteccionAcumulada) ;

        } else if(numeroMejoras == 3){

            this.equipable = new EscudoEspada(proteccionAcumulada) ;

        } else if(numeroMejoras == 4) {

            this.equipable = new Llave(proteccionAcumulada);
        } else {

            // No hace nada, se queda con el que tiene
        }


    }

    public void abrirCasaPompeya(){

        this.equipable.abrirCasaPompeya(this.gladiador);

    }


}