package edu.fiuba.algo3.modelo;

public class Bacanal extends Obstaculo{
    @Override
    public void obstaculizar(Gladiador gladiador, Equipamiento equipamiento) {
        Dado dado = new Dado(6);
        int copasTomadas = dado.lanzar();
        int disminucionEnergia = (-copasTomadas * 4);
        gladiador.cambiarEnergia( disminucionEnergia );
    }
}
