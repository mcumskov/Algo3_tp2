package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Buffer;

public class SemiSenior extends NivelDeSeniority{

    public SemiSenior()
    {
        this.turnosRestantesParaMejora = 4 ;
        this.recuperacionDeEnergiaPorTurno = 5 ;

    }
    public NivelDeSeniority actualizar() {

        this.turnosRestantesParaMejora--;

        if(this.turnosRestantesParaMejora < 1 ) {
            Buffer.getBuffer().agregarABuffer(" el gladiador asciende a senior!! ");
            return new Senior();
        } else {
            return this;
        }

    }
}