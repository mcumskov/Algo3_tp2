package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class FieraSalvaje implements Obstaculo{

    private int danioDeFiera ;

    public FieraSalvaje(){

        this.danioDeFiera = 20;

    }

    public void obstaculizarGladiador(Gladiador gladiador){

        gladiador.recibirAtaque(this.danioDeFiera);

    }
}
