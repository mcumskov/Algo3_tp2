package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class EscudoEspada extends Equipable{

    public EscudoEspada(int mitigacionAcumulada){

        this.proteccion = 8 + mitigacionAcumulada;

    }

    @Override
    public void abrirCasaPompeya(Gladiador gladiador) {

        ;

    }
}