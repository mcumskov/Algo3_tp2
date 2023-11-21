package edu.fiuba.algo3.modelo.turnos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import edu.fiuba.algo3.modelo.Dado;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;

public class GestorTurnos {

    private Queue<Jugador> colaTurnos;
    private int contador;
    private int cantidadRondas;

    public GestorTurnos(int rondas, ArrayList<Jugador> jugadores){
        this.colaTurnos = new LinkedList<>();
        this.cantidadRondas = rondas;
        this.contador = 0;

        if(!jugadores.isEmpty()){
            for (Jugador jugador : jugadores) {
                agregarTurno(jugador);
            }
            this.determinarPrimerJugador();
        }
    }

    public void agregarTurno(Jugador jugador){
        this.colaTurnos.add(jugador);
    }

    public void determinarPrimerJugador(){
        Dado dado = new Dado(this.colaTurnos.size());
        int num = dado.lanzar();
        for (int i = 0; i < num; i++) {
            Jugador aux = this.colaTurnos.remove();
            this.colaTurnos.add(aux);
        }
    }

    public void siguienteTurno(){
        if (contador >= (this.colaTurnos.size() * cantidadRondas)){
            Juego juego = Juego.getJuego();
            juego.finalizarSinGanador();
        }

        Jugador actual = this.colaTurnos.remove();
        this.colaTurnos.add(actual);
        actual.jugar();
        this.contador++;
    }
}
