package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.log.Log;

public class Novato extends NivelDeSeniority{
    private String representacion = "Novato";
    public Novato()
    {
        this.turnosRestantesParaMejora = 8 ;
        this.recuperacionDeEnergiaPorTurno = 0 ;
    }
    public NivelDeSeniority actualizar() {

        this.turnosRestantesParaMejora--;

        if(this.turnosRestantesParaMejora < 1 ) {
            Log.getLog().agregarABuffer(" El gladiador asciende a SemiSenior !! un crack! |");
            return new SemiSenior();
        }

        return this;
    }
    public String getRepresentacion(){
        return this.representacion;
    }
}