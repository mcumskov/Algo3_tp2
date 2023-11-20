package edu.fiuba.algo3.modelo.evento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.gladiador.GladiadorLesionado;

public  class EventoLesion implements Evento{

    public void afectar(Gladiador gladiador){
        gladiador.cambiarEstado(new GladiadorLesionado(gladiador));
    }
}