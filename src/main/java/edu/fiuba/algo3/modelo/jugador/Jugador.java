package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import java.util.Observable;
import java.util.Observer;

import java.util.logging.Logger;
import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.log.LogFormatter;

public class Jugador{

    protected Gladiador MiGladiador;
    protected String miNombre;
    public Jugador(){
        this.MiGladiador = new Gladiador();
        this.miNombre = "mip";
    }
    public Jugador(String nombre){
        this.MiGladiador = new Gladiador();
        this.miNombre = nombre;
    }

    public void jugar(Dado dado, Mapa mapa){
        int tiradaDeDado = dado.lanzar();

    }

    public Gladiador getGladiador(){
        return this.MiGladiador;
    }
}