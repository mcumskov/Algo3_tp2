package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class Jugador {

    protected Gladiador MiGladiador;
    public Jugador(){
        this.MiGladiador = new Gladiador();
    }

    public void jugar(Dado dado, Mapa mapa){
        int tiradaDeDado = dado.lanzar();
        mapa.moverGladiador(this.MiGladiador, tiradaDeDado);
    }

    public Gladiador getGladiador(){
        return this.MiGladiador;
    }
}