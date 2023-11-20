package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;


public class Senior extends Seniority{

    public Senior(Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
        this.turnos = 0;
        this.recuperacionEnergia = 10;
        this.limiteAsencion = 0;
    }

    public Seniority actualizar(){
        return this;
    }

}