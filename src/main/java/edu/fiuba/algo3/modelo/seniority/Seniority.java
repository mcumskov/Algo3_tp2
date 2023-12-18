package edu.fiuba.algo3.modelo.seniority;

public class Seniority implements ISeniority{

    private NivelDeSeniority nivelDeSeniority;

    public Seniority()
    {
        this.nivelDeSeniority = new Novato();
    }

    public void actualizar(){

        this.nivelDeSeniority = this.nivelDeSeniority.actualizar();

    }
    public int recuperarEnergia(){

        return this.nivelDeSeniority.recuperarEnergiaEnTurno();
    }

    public NivelDeSeniority getNivelDeSeniority(){
        return this.nivelDeSeniority;
    }
}