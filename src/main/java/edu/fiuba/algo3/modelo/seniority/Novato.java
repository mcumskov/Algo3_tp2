package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Novato extends NivelDeSeniority{

    public Novato()
    {
        this.turnosRestantesParaMejora = 8 ;
        this.recuperacionDeEnergiaPorTurno = 0 ;
    }
    public NivelDeSeniority actualizar() {

        this.turnosRestantesParaMejora--;

        if(this.turnosRestantesParaMejora < 1 ) {
            return new SemiSenior();
        } else {
            return this;
        }

    }
}