package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.GladiadorLesionado;
import edu.fiuba.algo3.modelo.log.Log;

public class Lesion implements Obstaculo{
    private char representacion;

    public Lesion(){
        this.representacion = 'L';
    }
    public void obstaculizarGladiador(Gladiador gladiador){
        Log.getLog().agregarABuffer(" se lesiono el gladiador! |" );
       gladiador.cambiarEstado(new GladiadorLesionado());
    }

    public char getRepresentacion(){
        return this.representacion;
    }
}
