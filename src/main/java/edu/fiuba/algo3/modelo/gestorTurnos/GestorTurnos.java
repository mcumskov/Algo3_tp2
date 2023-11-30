package edu.fiuba.algo3.modelo.gestorTurnos;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class GestorTurnos {

    private Queue<Jugador> colaTurnos;
    private int contador;
    private int cantidadRondas;
    protected Jugador jugadoractual;

    public GestorTurnos(int rondas, ArrayList<Jugador> jugadores){

        this.colaTurnos = new LinkedList<>();
        this.cantidadRondas = rondas;
        this.contador = 0;
        this.jugadoractual = null;

        if(!jugadores.isEmpty()){
            for (Jugador jugador : jugadores) {
                agregarTurno(jugador);
            }
            this.determinarPrimerJugador();
        }
    }

    public GestorTurnos(int rondas){
        this.colaTurnos = new LinkedList<>();
        this.cantidadRondas = rondas;
        this.contador = 0;
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

    public void siguienteTurno(Dado dado, Mapa mapa){
        if (contador >= (this.colaTurnos.size() * cantidadRondas)){
            //Juego juego = Juego.getJuego();
            //juego.finalizarSinGanador();
            this.finalizarSinGanador();
        }
        this.jugadoractual = this.colaTurnos.remove();
        this.colaTurnos.add(this.jugadoractual);
        this.jugadoractual.jugar(dado, mapa);
        this.contador++;
    }

    public void finalizarSinGanador(){
        throw new SinGanadorException("Finalizó sin ganador");
    }

    public Jugador getJugadoractual() {
        return jugadoractual;
    }
}