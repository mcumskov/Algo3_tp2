package edu.fiuba.algo3.modelo.evento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public  class EventoEquipamiento implements Evento{

    public void afectar(Gladiador gladiador){
        gladiador.mejorarEquipamiento();
    }
}