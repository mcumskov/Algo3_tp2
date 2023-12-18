package edu.fiuba.algo3.modelo.gestorTurnos;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.jugador.iJugador;


public class GestorTurnos implements iGestorTurnos{

    private Queue<iJugador> colaTurnos;
    private int contador;
    private int cantidadRondas;
    protected iJugador jugadoractual;

    public GestorTurnos(int rondas, List<iJugador> jugadores){

        this.colaTurnos = new LinkedList<>();
        this.cantidadRondas = rondas;
        this.contador = 0;
        this.jugadoractual = null;

        if(!jugadores.isEmpty()){
            for (iJugador jugador : jugadores) {
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

    public void agregarTurno(iJugador jugador){
        this.colaTurnos.add(jugador);
    }

    public void determinarPrimerJugador(){
        Dado dado = new Dado(this.colaTurnos.size());
        int num = dado.lanzar();
        for (int i = 0; i < num; i++) {
            iJugador aux = this.colaTurnos.remove();
            this.colaTurnos.add(aux);
        }
    }

    public iJugador siguienteTurno(){
        if (contador >= (this.colaTurnos.size() * cantidadRondas)){
            this.finalizarSinGanador();
        }
        iJugador jugadorActual = this.colaTurnos.remove();
        this.colaTurnos.add(jugadorActual);
        this.contador++;
        return jugadorActual;
    }
    public void finalizarSinGanador(){
        throw new SinGanadorException("Finalizó sin ganador");
    }

}