package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;
class Tablero {
    private List<Casilla> casillas;
    private Map<Gladiador, Integer> posicionesGladiadores;

    public Tablero(List<Gladiador> gladiadores, List<Casilla> casillas){
        this.casillas = casillas;
        for(Gladiador gladiador : gladiadores){
            inicializarPosicion(gladiador);
        }
    }

    public void inicializarPosicion(Gladiador gladiador) {
        posicionesGladiadores.put(gladiador, 0);
    }

    public void moverGladiador(Gladiador gladiador, int pasosAvanzar) {
        int posicionActual = posicionesGladiadores.get(gladiador);
        int nuevaPosicion = (posicionActual + pasosAvanzar);
        posicionesGladiadores.put(gladiador, nuevaPosicion);

        Casilla casilla = casillas.get(nuevaPosicion);

        casilla.afectar(gladiador);
    }
}