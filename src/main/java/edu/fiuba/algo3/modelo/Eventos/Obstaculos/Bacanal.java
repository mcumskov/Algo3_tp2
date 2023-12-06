package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.log.Log;

public class Bacanal implements Obstaculo{

    protected int perdidaEnergiaMinima;

    public Bacanal(){
        this.perdidaEnergiaMinima = 4;
    }

    public void obstaculizarGladiador(Gladiador gladiador){

        Dado miDado = new Dado(6);
        Log.getLog().agregarABuffer( " terminar el bacanal ");
        gladiador.disminuirEnergia(miDado.lanzar()*this.perdidaEnergiaMinima);
    }

}
