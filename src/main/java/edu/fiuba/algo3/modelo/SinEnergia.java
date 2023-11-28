package edu.fiuba.algo3.modelo;

public class SinEnergia extends EstadoGladiador{
    public void mover(Tablero tablero, Gladiador gladiador, int pasosAvanzar){
        gladiador.cambiarEnergia(5);
        gladiador.cambiarEstado(new Sano());
    }
}
