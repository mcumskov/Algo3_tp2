package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.gestorTurnos.GestorTurnos;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.log.Log;


import java.util.ArrayList;
import java.util.List;

public class Juego {

    public Mapa mapa;
    public GestorTurnos gestorTurnos;
    public Dado dado;
    public List<Jugador> jugadores;
    public int cantidadJugadores;
    private static Juego instancia;
    Jugador ganador;

    private Juego (Mapa mapa, List<Jugador> jugadores) {

        this.jugadores = jugadores;
        this.cantidadJugadores = jugadores.size();
        this.gestorTurnos = new GestorTurnos(30, (ArrayList<Jugador>) this.jugadores);
        this.dado = new Dado();
        this.mapa = mapa;
        this.jugadores = jugadores;
        this.ganador = null;

    }

    public Jugador iniciarPartida(){

        try{
            while(this.ganador == null){
                this.gestorTurnos.siguienteTurno(this.dado,this.mapa);
                Log.getLog().imprimirMensaje();
            }
        }catch (SinGanadorException finalTriste){
        }
        return this.ganador;
    }

    public static Juego instanciarJuego(Mapa mapa, List<Jugador> jugadores) {
        if(instancia == null){
            instancia = new Juego(mapa, jugadores);
        }
        return instancia;
    }
    private void moverGladiadorAMitadMapa(Gladiador gladiador) {
        Log.getLog().agregarABuffer(" no tenia la llave asi que fue enviado a la mitad del mapa |" );
        Log.getLog().imprimirMensaje();
        this.mapa.enviarAMitad(gladiador);
    }
    private void buscarGanador() {
        this.ganador = gestorTurnos.getJugadoractual();
        //hacerle una fiesta al ganador
    }
    public static void gladiadorSinLlaveLlegaAlFinal(Gladiador gladiador){
        if(instancia == null){
            return;
        }
        instancia.moverGladiadorAMitadMapa(gladiador);
    }


    public static void gladiadorConLlaveLlegaAlFinal(){
        if(instancia == null){
            return;
        }
        instancia.buscarGanador();
    }

}