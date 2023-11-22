package edu.fiuba.algo3.modelo.evento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.Dado;
public  class EventoBacanal implements Evento{

    public void afectar(Gladiador gladiador){

        Dado miDado = new Dado(6);
        int perdidaEnergiaMinima = -4 ;
        gladiador.cambiarEnergia(miDado.lanzar()*perdidaEnergiaMinima);
    }
}