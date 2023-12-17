package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.List;
import java.util.Observer;

public interface iCasilla {

    public void recibir(Gladiador gladiador);

    public void expulsar(Gladiador gladiador);

    public void setSiguiente(iCasilla siguiente);

    public iCasilla buscadoEstaEnLaCasilla(Gladiador gladiador);

    public void moverGladiador(int pasos, Gladiador gladiador);

    public void validarPosicionEnCamino(int posicion, int longitudCamino);

    public boolean esContigua(iCasilla casilla);

    public boolean esContigua(Coordenada coordenada);

    public Coordenada getCoordenada();

    public Obstaculo getObstaculo();

    public Premio getPremio();

    public List<Gladiador> getGladiadores();

    public void agregarObserver(Observer observer);



}
