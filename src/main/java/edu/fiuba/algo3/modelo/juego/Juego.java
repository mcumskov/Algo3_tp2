package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.dado.iDado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.gestorTurnos.iGestorTurnos;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.iMapa;
import edu.fiuba.algo3.modelo.jugador.iJugador;
import edu.fiuba.algo3.modelo.log.Log;
import java.util.Observable;

public class Juego extends Observable{

    public iMapa mapa;
    public iGestorTurnos gestorTurnos;
    public iDado dado;
    private static Juego instancia;
    private iJugador jugadorActual;
    private iJugador ganador;


    private Juego (iMapa mapa, iDado dado, iGestorTurnos gestor) {

        this.gestorTurnos = gestor;
        this.dado = dado;
        this.mapa = mapa;
        this.jugadorActual = null;
        this.ganador = null;
    }

    public void siguienteTurno(){
        try{
            this.jugadorActual = this.gestorTurnos.siguienteTurno();
            setChanged();
            notifyObservers();
        }catch (SinGanadorException finalTriste){
            Log.getLog().imprimirMensaje();
            Log.getLog().agregarABuffer("SE TERMINARON LOS TURNOS...|FIN DEL JUEGO|" );
            Log.getLog().imprimirMensaje();
            throw finalTriste;

        }
    }

    public iJugador tirarDado(){
        this.jugadorActual.jugar(this.dado, this.mapa);
        Log.getLog().imprimirMensaje();
        return this.ganador;
    }

    public static Juego instanciarJuego(iMapa mapa, iDado dado, iGestorTurnos gestor) {
        if(instancia == null){
            instancia = new Juego(mapa, dado, gestor);
        }
        return instancia;
    }
    private void moverGladiadorAMitadMapa(Gladiador gladiador) {
        Log.getLog().agregarABuffer(" no tenia la llave asi que fue enviado a la mitad del mapa |" );
        Log.getLog().imprimirMensaje();
        this.mapa.enviarAMitad(gladiador);
    }
    private void buscarGanador() {
        this.ganador = this.jugadorActual;
        Log.getLog().imprimirMensaje();
        Log.getLog().agregarABuffer(" LA LLAVE ABRE LA CASA!! VICTORIA " );
        Log.getLog().imprimirMensaje();
        setChanged();
        notifyObservers();
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

    public static void resetInstancia() {
        instancia = null;
    }

    public iJugador getJugadorActual(){
        return this.jugadorActual;
    }
    public iJugador getGanador(){
        return this.ganador;
    }
}