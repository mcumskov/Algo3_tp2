package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.excepciones.CasillaTipoLlegadaMalPosicionadaException;
import edu.fiuba.algo3.modelo.excepciones.CasillaTipoSalidaMalPosicionadaException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CasillaInicio extends Observable implements iCasilla{

    protected iCasilla casillaSiguiente;

    protected List<Gladiador> gladiadoresEnLaCasilla;
    private Coordenada coordenada;

    public CasillaInicio(Coordenada coordenada, iCasilla siguiente){

        this.coordenada = coordenada ;
        this.casillaSiguiente = siguiente;
        this.gladiadoresEnLaCasilla = new ArrayList<Gladiador>();

    }
    public void setSiguiente(iCasilla siguiente){
        this.casillaSiguiente = siguiente;
    }
    public void moverGladiador(int pasos, Gladiador gladiador){
        this.expulsar(gladiador);
        if( pasos == 0 || casillaSiguiente == null){
            this.recibir(gladiador);
            this.setChanged();
            this.notifyObservers();
            return;
        }
        casillaSiguiente.moverGladiador(pasos-1, gladiador);
        this.setChanged();
        this.notifyObservers();
    }

    public void recibir(Gladiador gladiador){
        gladiadoresEnLaCasilla.add(gladiador);
    }

    public void expulsar(Gladiador gladiador){
        gladiadoresEnLaCasilla.remove(gladiador);
    }

    public iCasilla buscadoEstaEnLaCasilla(Gladiador gladiador){
        if(gladiadoresEnLaCasilla.contains(gladiador)){
            return this;
        }
        return null;
    }

    public void validarPosicionEnCamino(int posicion, int longitudCamino){

        if(posicion != 0 ){

            throw new CasillaTipoSalidaMalPosicionadaException("\"Casilla de tipo \"Salida\" mal posicionada en el camino.\"");
        }
    }

    public boolean esContigua(iCasilla casilla){

        return casilla.esContigua(this.coordenada);

    }

    public boolean esContigua(Coordenada coordenada){

        return this.coordenada.esContigua(coordenada);

    }

    public Coordenada getCoordenada(){
        return this.coordenada;
    }

    public Obstaculo getObstaculo(){
        return null;
    }

    public Premio getPremio(){
        return null;
    }

    public List<Gladiador> getGladiadores(){
        return this.gladiadoresEnLaCasilla;
    }

    public void agregarObserver(Observer observer){
        this.addObserver(observer);
    }
}
