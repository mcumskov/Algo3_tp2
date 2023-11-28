package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.GladiadorLesionado;

public class Lesion implements Obstaculo{

    public void obstaculizarGladiador(Gladiador gladiador){
       gladiador.cambiarEstado(new GladiadorLesionado());
    }


}
