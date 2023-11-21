package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class Juego {

    private static Juego instancia;
    public Mapa mapa;
    public boolean juegoTerminado;

    private Juego (){
        // instanciar un juego
        juegoTerminado = false;

    }

    public static Juego getJuego(){
        if(instancia == null){
            instancia = new Juego();
        }
        return instancia;
    }

    public void finalizar(){
        throw new SinGanadorException("Finalizó sin ganador");
    }

}
