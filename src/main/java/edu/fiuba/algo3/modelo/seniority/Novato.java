package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Buffer;

public class Novato extends NivelDeSeniority{

    public Novato()
    {
        this.turnosRestantesParaMejora = 8 ;
        this.recuperacionDeEnergiaPorTurno = 0 ;
    }
    public NivelDeSeniority actualizar() {

        this.turnosRestantesParaMejora--;

        if(this.turnosRestantesParaMejora < 1 ) {
            Buffer.getBuffer().agregarABuffer(" El gladiador asciende a SemiSenior !! un crack! ");
            return new SemiSenior();
        }

        return this;


    }
}