package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface Casilla {

    public void recibir(Gladiador gladiador);

    public void expulsar(Gladiador gladiador);

    public void SetSiguiente(Casilla siguiente);

    public Casilla BuscadoEstaEnLaCasilla(Gladiador gladiador);

    public void moverGladiador(int pasos, Gladiador gladiador);
}
