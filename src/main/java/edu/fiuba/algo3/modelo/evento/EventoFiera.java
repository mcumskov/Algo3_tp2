package edu.fiuba.algo3.modelo.evento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public  class EventoFiera implements Evento{

    private int danioDeFiera;

    public EventoFiera(){
        this.danioDeFiera = -20;
    }
    public void afectar(Gladiador gladiador){
        gladiador.recibirDanio(danioDeFiera);
    }
}
