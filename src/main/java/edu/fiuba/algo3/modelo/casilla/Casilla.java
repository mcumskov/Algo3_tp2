package edu.fiuba.algo3.modelo.casilla;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.evento.Evento;

public class Casilla{
    private Casilla siguiente;
    private Evento evento;

    public Casilla (Casilla siguiente, Evento evento){
        this.siguiente = siguiente;
        this.evento = evento;
    }

    public Casilla obtenerSiguiente( int avance ){
        if( avance == 0 || siguiente == null){
            return this;
        }
        return siguiente.obtenerSiguiente(avance-1);
    }

    public void afectarConEvento(Gladiador gladiador){
        evento.afectar(gladiador);
    }
}