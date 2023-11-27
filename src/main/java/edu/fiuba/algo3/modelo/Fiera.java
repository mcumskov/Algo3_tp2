package edu.fiuba.algo3.modelo;

public class Fiera extends Obstaculo{
    @Override
    public void obstaculizar(Gladiador gladiador, Equipamiento equipamiento) {
        int danioFinal = equipamiento.mitigarDanio(20);
        gladiador.cambiarEnergia(-danioFinal);
    }
}
