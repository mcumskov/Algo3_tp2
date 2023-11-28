package edu.fiuba.algo3.modelo;

public class Sano extends EstadoGladiador{
    public void mover(Tablero tablero, Gladiador gladiador, int pasosAvanzar){
        tablero.moverGladiador(gladiador, pasosAvanzar);
    }
}
