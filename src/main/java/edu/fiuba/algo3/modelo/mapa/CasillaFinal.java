package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;

public class CasillaFinal implements iCasilla{

    protected iCasilla casillaSiguiente;
    protected Coordenada coordenada;
    protected List<Gladiador> gladiadoresEnLaCasilla;

    public CasillaFinal(Casilla siguiente){
        this.casillaSiguiente = siguiente;
        this.gladiadoresEnLaCasilla = new ArrayList<Gladiador>();
    }
    public void SetSiguiente(iCasilla siguiente){
        this.casillaSiguiente = siguiente;
    }
    public void moverGladiador(int pasos, Gladiador gladiador){
        if( pasos == 0 || casillaSiguiente == null){
            this.recibir(gladiador);
            return;
        }
        casillaSiguiente.moverGladiador(pasos-1, gladiador);
        this.expulsar(gladiador);
    }

    public void recibir(Gladiador gladiador){
        gladiadoresEnLaCasilla.add(gladiador);
        gladiador.abrirCasaPompeya(gladiador);
    }

    public void expulsar(Gladiador gladiador){
        gladiadoresEnLaCasilla.remove(gladiador);
    }

    public iCasilla BuscadoEstaEnLaCasilla(Gladiador gladiador){
        if(gladiadoresEnLaCasilla.contains(gladiador)){
            return this;
        }
        return null;
    }

    public Coordenada getCoordenada(){

        return this.coordenada;

    }


}
