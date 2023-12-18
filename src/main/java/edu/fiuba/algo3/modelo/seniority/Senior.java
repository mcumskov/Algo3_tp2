package edu.fiuba.algo3.modelo.seniority;


public class Senior extends NivelDeSeniority{
    private String representacion = "Senior";
    public Senior()
    {
        this.turnosRestantesParaMejora = 1 ;
        this.recuperacionDeEnergiaPorTurno = 10 ;

    }
    public NivelDeSeniority actualizar() {

        return this;

    }
    public String getRepresentacion(){
        return this.representacion;
    }
}