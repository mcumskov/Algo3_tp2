package edu.fiuba.algo3.modelo.evento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class EventoComida implements Evento{

    private int incrementoDeEnergia;

    public EventoComida(){
        this.incrementoDeEnergia = 15;
    }
    public void afectar(Gladiador gladiador){
        gladiador.cambiarEnergia(incrementoDeEnergia);
    }
}
