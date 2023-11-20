package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
public class Casco extends Equipable{

    public Casco(int mitigacionAcumulada){


        this.proteccion = 5 + mitigacionAcumulada;
    }

    @Override
    public void abrirCasaPompeya(Gladiador gladiador) {

        ;

    }
}

