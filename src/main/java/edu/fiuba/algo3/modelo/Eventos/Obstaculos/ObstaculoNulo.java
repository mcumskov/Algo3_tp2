package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class ObstaculoNulo implements Obstaculo {

    char representacion;
    public ObstaculoNulo(){
        this.representacion = ' ';
    }
    public void obstaculizarGladiador(Gladiador gladiador){
    }
    public char getRepresentacion(){
        return this.representacion;
    }

}
