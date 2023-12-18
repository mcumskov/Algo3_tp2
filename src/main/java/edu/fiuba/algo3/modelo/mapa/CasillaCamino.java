package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.excepciones.CasillaTipoMalPosicionadaException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import java.util.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class CasillaCamino extends Observable implements iCasilla{


    protected Obstaculo obstaculo;
    protected Premio premio;
    protected Coordenada coordenada;
    protected iCasilla casillaSiguiente;

    protected List<Gladiador> gladiadoresEnLaCasilla;

    public CasillaCamino(Coordenada coordenada, iCasilla siguiente, Obstaculo obstaculo, Premio premio) {
        this.casillaSiguiente = siguiente;
        this.obstaculo = obstaculo;
        this.premio = premio;
        this.gladiadoresEnLaCasilla = new ArrayList<Gladiador>();
        this.coordenada = coordenada;
    }
    public void setSiguiente(iCasilla siguiente){
        this.casillaSiguiente = siguiente;
    }

    public void moverGladiador(int pasos, Gladiador gladiador){
        this.expulsar(gladiador);

        if( pasos == 0 || casillaSiguiente == null){
            this.recibir(gladiador);
            return;
        }
        casillaSiguiente.moverGladiador(pasos-1, gladiador);

    }

    public void recibir(Gladiador gladiador){
        gladiadoresEnLaCasilla.add(gladiador);
        this.premio.premiarGladiador(gladiador);
        this.obstaculo.obstaculizarGladiador(gladiador);
        this.setChanged();
        this.notifyObservers();
    }

    public void expulsar(Gladiador gladiador){
        gladiadoresEnLaCasilla.remove(gladiador);
        this.setChanged();
        this.notifyObservers();
    }

    public iCasilla buscadoEstaEnLaCasilla(Gladiador gladiador){
        if(gladiadoresEnLaCasilla.contains(gladiador)){
            return this;
        }
        return null;
    }

    public void validarPosicionEnCamino(int posicion, int longitudCamino){

        if ( posicion < 1 || posicion >= (longitudCamino-1)){

            throw new CasillaTipoMalPosicionadaException("Casilla de tipo \"Camino\" mal posicionada en el camino.");

        }
    }

    public boolean esContigua(iCasilla casilla){

        return casilla.esContigua(this.coordenada);

    }

    public boolean esContigua(Coordenada coordenada){

        return this.coordenada.esContigua(coordenada);

    }


    public Coordenada getCoordenada() {

        return this.coordenada;
    }

    public Obstaculo getObstaculo(){
        return this.obstaculo;
    }

    public Premio getPremio(){
        return this.premio;
    }

    public List<Gladiador> getGladiadores(){
        return this.gladiadoresEnLaCasilla;
    }
    public void agregarObserver(Observer observer){
        this.addObserver(observer);
    }
}
