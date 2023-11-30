package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface iCasilla {

    public void recibir(Gladiador gladiador);

    public void expulsar(Gladiador gladiador);

    public void setSiguiente(iCasilla siguiente);

    public iCasilla buscadoEstaEnLaCasilla(Gladiador gladiador);

    public void moverGladiador(int pasos, Gladiador gladiador);

    public Coordenada getCoordenada();
}
