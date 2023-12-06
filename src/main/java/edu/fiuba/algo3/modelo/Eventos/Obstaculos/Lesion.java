package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.GladiadorLesionado;
import edu.fiuba.algo3.modelo.log.Log;

public class Lesion implements Obstaculo{

    public void obstaculizarGladiador(Gladiador gladiador){
        Log.getLog().agregarABuffer(" se lesiono el gladiador! |" );
       gladiador.cambiarEstado(new GladiadorLesionado());
    }


}
