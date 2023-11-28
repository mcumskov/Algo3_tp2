package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Juego {

    List<Jugador> jugadores;
    EstadoJuego estadoJuego;
    Tablero tablero;

    public Juego(int cantidadJugadores, List<Casilla> casillas){
        List<Gladiador> gladiadores = new ArrayList<>();

        while(cantidadJugadores > 0){
            gladiadores.add( new Gladiador() );
            jugadores.add( new Jugador( gladiadores.get(gladiadores.size() - 1) ) );
            cantidadJugadores--;
        }

        //Juego llama a parser y crea List casillas

        this.tablero = new Tablero(gladiadores, casillas);
    }

    public void iniciar(){
        Iterator<Jugador> iteradorJugadores = jugadores.iterator();
        while( iteradorJugadores.hasNext() && estadoJuego.determinarContinuidadEjecucion() ){ //Excepciones
            iteradorJugadores.next().realizarTurno(tablero, 6); //GestorTurnos
        }
        estadoJuego.finalizar();
    }

    public void cambiarEstadoJuego( EstadoJuego estadoNuevo){ estadoJuego = estadoNuevo; }
}
