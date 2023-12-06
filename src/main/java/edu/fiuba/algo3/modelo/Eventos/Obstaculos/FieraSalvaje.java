package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class FieraSalvaje implements Obstaculo{

    private int danioDeFiera ;

    public FieraSalvaje(){
        this.danioDeFiera = 20;
    }

    public void obstaculizarGladiador(Gladiador gladiador){
        Log.getLog().agregarABuffer(" una fiera! se desata una pelea! " );
        gladiador.recibirAtaque(this.danioDeFiera);
    }
}
