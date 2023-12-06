package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

import java.util.ArrayList;
import java.util.List;

public class CasillaCamino implements iCasilla {


    protected Obstaculo obstaculo;
    protected Premio premio;
    protected Coordenada coordenada;
    protected iCasilla casillaSiguiente;

    protected List<Gladiador> gladiadoresEnLaCasilla;

    public CasillaCamino(iCasilla siguiente, Obstaculo obstaculo, Premio premio) {
        this.casillaSiguiente = siguiente;
        this.obstaculo = obstaculo;
        this.premio = premio;
        this.gladiadoresEnLaCasilla = new ArrayList<Gladiador>();
        this.coordenada = null; // Mock para test
    }

    public CasillaCamino(Coordenada coordenada, iCasilla siguiente, Obstaculo obstaculo, Premio premio) {
        this.casillaSiguiente = siguiente;
        this.obstaculo = obstaculo;
        this.premio = premio;
        this.gladiadoresEnLaCasilla = new ArrayList<Gladiador>();
        this.coordenada = coordenada ;
    }
    public void setSiguiente(iCasilla siguiente){
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
        System.out.println("List contents before recibir: " + gladiadoresEnLaCasilla);
        gladiadoresEnLaCasilla.add(gladiador);
        System.out.println("List contents after recibir: " + gladiadoresEnLaCasilla);
        this.premio.premiarGladiador(gladiador);
        this.obstaculo.obstaculizarGladiador(gladiador);
    }

    public void expulsar(Gladiador gladiador){
        gladiadoresEnLaCasilla.remove(gladiador);
    }

    public iCasilla buscadoEstaEnLaCasilla(Gladiador gladiador){
        System.out.println("List contents before buscar: " + gladiadoresEnLaCasilla);
        if(gladiadoresEnLaCasilla.contains(gladiador)){
            return this;
        }
        return null;
    }

    public Coordenada getCoordenada(){

        return this.coordenada;

    }

}
