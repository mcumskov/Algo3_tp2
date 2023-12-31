package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.log.Log;

public class SemiSenior extends NivelDeSeniority{

    private String representacion = "SemiSenior";
    public SemiSenior()
    {
        this.turnosRestantesParaMejora = 4 ;
        this.recuperacionDeEnergiaPorTurno = 5 ;

    }
    public NivelDeSeniority actualizar() {

        this.turnosRestantesParaMejora--;

        if(this.turnosRestantesParaMejora < 1 ) {
            Log.getLog().agregarABuffer(" el gladiador asciende a senior!! |");
            return new Senior();
        } else {
            return this;
        }

    }
    public String getRepresentacion(){
        return this.representacion;
    }
}