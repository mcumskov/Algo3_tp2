package edu.fiuba.algo3.modelo;

public class Comida extends Premio{
    @Override
    public void premiar(Gladiador gladiador, Equipamiento equipamiento){
        gladiador.cambiarEnergia(15);
    }
}
