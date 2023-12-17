package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.dado.iDado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.iMapa;
import java.util.Observable;
import java.util.Observer;

import java.util.logging.Logger;
import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.log.LogFormatter;

public class Jugador implements  iJugador{

    protected Gladiador MiGladiador;
    protected String miNombre;
    int numeroPlayer;
    public Jugador(){
        this.MiGladiador = new Gladiador(1);
        this.miNombre = "mip";
    }
    public Jugador(String nombre, int player){
        this.MiGladiador = new Gladiador(player);
        this.miNombre = nombre;
        this.numeroPlayer = player;
    }

    public void jugar(iDado dado, iMapa mapa){
        int tiradaDeDado = dado.lanzar();
        Log.getLog().agregarABuffer(this.miNombre + " tira el dado y sale: " + tiradaDeDado + " |");
        mapa.moverGladiador(this.MiGladiador, tiradaDeDado);
    }

    public Gladiador getGladiador(){
        return this.MiGladiador;
    }

    public int getNumeroPlayer(){
        return this.numeroPlayer;
    }
}