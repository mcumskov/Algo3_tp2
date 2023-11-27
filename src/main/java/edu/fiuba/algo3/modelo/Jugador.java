package edu.fiuba.algo3.modelo;

public class Jugador {
    private Gladiador gladiador;

    public Jugador(Gladiador gladiador){
        this.gladiador = gladiador;
    }

    public void realizarTurno(Tablero tablero, int maxCantidadPasos) {
        Dado dado = new Dado(maxCantidadPasos);
        int pasosAvanzar = dado.lanzar();
        gladiador.actualizar(tablero, pasosAvanzar);
    }

}