package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class SemiSenior extends NivelDeSeniority{

    public SemiSenior()
    {
        this.turnosRestantesParaMejora = 4 ;
        this.recuperacionDeEnergiaPorTurno = 5 ;

    }
    public NivelDeSeniority actualizar() {

        this.turnosRestantesParaMejora--;

        if(this.turnosRestantesParaMejora < 1 ) {
            return new Senior();
        } else {
            return this;
        }

    }
}