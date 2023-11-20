package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Llave extends Equipable{

    public Llave(int mitigacionAcumulada){

        this.proteccion = 2 + mitigacionAcumulada;
    }

    @Override
    public void abrirCasaPompeya(Gladiador gladiador) {

        gladiador.victoria();

    }
}