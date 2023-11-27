package edu.fiuba.algo3.modelo;

public class Novato extends Seniority{
    public Novato(){
        this.turnos = 0;
        this.recuperacionEnergia = 0;
        this.limiteAsencion = 8;
    }

    public void evolucionar(Gladiador gladiador){
        turnos++;
        if(turnos >= limiteAsencion){
            Seniority evolucion = new SemiSenior();
            gladiador.cambiarSeniority(evolucion);
        }
    }
}