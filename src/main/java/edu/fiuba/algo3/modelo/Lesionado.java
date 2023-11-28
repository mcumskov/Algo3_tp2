package edu.fiuba.algo3.modelo;

public class Lesionado extends EstadoGladiador{
    public void mover(Tablero tablero, Gladiador gladiador, int pasosAvanzar){
        gladiador.cambiarEstado(new Sano());
    }
}
