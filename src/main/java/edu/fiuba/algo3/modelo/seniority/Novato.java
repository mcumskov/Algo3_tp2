package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Novato extends Seniority{
    public Novato(Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
        this.turnos = 0;
        this.recuperacionEnergia = 0;
        this.limiteAsencion = 8;
    }

    public void actualizar(){
        turnos++;
        if(turnos >= limiteAsencion){
            Seniority ascencion = new SemiSenior(gladiador);
            gladiador.cambiarSeniority(ascencion);
        }
    }
}