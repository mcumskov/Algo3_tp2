package edu.fiuba.algo3.modelo.seniority;

public abstract class NivelDeSeniority{

    protected int turnosRestantesParaMejora ;
    protected int recuperacionDeEnergiaPorTurno;
    public abstract NivelDeSeniority actualizar();

    public int recuperarEnergiaEnTurno(){

        return this.recuperacionDeEnergiaPorTurno;

    }
    public String getRepresentacion(){
        return "nada";
    }
}
