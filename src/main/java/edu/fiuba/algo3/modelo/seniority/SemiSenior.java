package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class SemiSenior extends Seniority{

    public SemiSenior(Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
        this.turnos = 0;
        this.recuperacionEnergia = 5;
        this.limiteAsencion = 4;
    }

    public Seniority actualizar(){
        turnos++;
        if(turnos >= limiteAsencion){
            Seniority ascencion = new Senior(gladiador);
            gladiador.cambiarSeniority(ascencion);
            return ascencion;
        }
        return this;
    }
}