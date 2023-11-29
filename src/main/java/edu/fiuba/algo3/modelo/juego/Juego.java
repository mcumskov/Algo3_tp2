package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.gestorTurnos.GestorTurnos;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Casilla;
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
    public ArrayList<Jugador> jugadores;
    public int cantidadJugadores;
    private static Juego instancia;

    private Juego () throws IOException {

        //se pide al usuario la cantidad de jugadores, por ahora lo hardcodeo en 6
        this.cantidadJugadores = 6;
        List<Gladiador> gladiadores = null;

        for(int i=0; i<cantidadJugadores; i++){
            Jugador jugadorNuevo = new Jugador();
            this.jugadores.add(jugadorNuevo);
            gladiadores.add(jugadorNuevo.getGladiador());
        }

        //se llama al parser y parse devuelve una lista de casillas validas
        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/mapaValido10Casillas.json")));
        Parser parser = new Parser();
        List<Casilla> casillas = parser.parsearJSON(jsonString);

        this.mapa = new Mapa(gladiadores, casillas, cantidadJugadores);

        this.gestorTurnos = new GestorTurnos(30, this.jugadores);
        this.dado = new Dado();
        this.iniciarPartida();
    }

    private void iniciarPartida(){

        try{
            while(true){
                this.gestorTurnos.siguienteTurno(this.dado,this.mapa);
            }
        }catch (SinGanadorException | IOException exception){
            //ya no se juega el jueguito
        }
    }

    public static Juego getJuego() throws IOException {
        if(instancia == null){
            instancia = new Juego();
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