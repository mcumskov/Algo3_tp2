package edu.fiuba.algo3.modelo;

public class SemiSenior extends Seniority{

    public SemiSenior(){
        this.turnos = 0;
        this.recuperacionEnergia = 5;
        this.limiteAsencion = 4;
    }

    public void evolucionar(Gladiador gladiador){
        turnos++;
        if(turnos >= limiteAsencion){
            Seniority evolucion = new Senior();
            gladiador.cambiarSeniority(evolucion);
        }
    }
}