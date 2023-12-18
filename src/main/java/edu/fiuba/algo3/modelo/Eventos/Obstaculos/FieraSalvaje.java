package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class FieraSalvaje implements Obstaculo{

    private int danioDeFiera ;
    private char representacion;

    public FieraSalvaje(){
        this.danioDeFiera = 20;
        this.representacion = 'F';
    }

    public void obstaculizarGladiador(Gladiador gladiador){
        Log.getLog().agregarABuffer(" una fiera! se desata una pelea! " );
        gladiador.recibirAtaque(this.danioDeFiera);
    }
    public char getRepresentacion(){
        return this.representacion;
    }
}
