package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.gestorTurnos.GestorTurnos;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Parser;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Juego {

    public Mapa mapa;
    public GestorTurnos gestorTurnos;
    public Dado dado;
    public List<Jugador> jugadores;
    public int cantidadJugadores;
    private static Juego instancia;

    private Juego (Mapa mapa, List<Jugador> jugadores) throws IOException {

        this.jugadores = jugadores;
        this.cantidadJugadores = jugadores.size();
        this.gestorTurnos = new GestorTurnos(30, (ArrayList<Jugador>) this.jugadores);
        this.dado = new Dado();
        this.mapa = mapa;
        this.jugadores = jugadores;

    }

    public Jugador iniciarPartida(){

        try{
            while(true){
                this.gestorTurnos.siguienteTurno(this.dado,this.mapa);
            }
        }catch (SinGanadorException | IOException exception){
            return null;
        }
    }

    public static Juego instanciarJuego(Mapa mapa, List<Jugador> jugadores) throws IOException {
        if(instancia == null){
            instancia = new Juego(mapa, jugadores);
        }
        return instancia;
    }
    private void moverGladiadorAMitadMapa(Gladiador gladiador) {
        this.mapa.enviarAMitad(gladiador);
    }
    private void buscarGanador() {
        Jugador ganador = gestorTurnos.getJugadoractual();
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