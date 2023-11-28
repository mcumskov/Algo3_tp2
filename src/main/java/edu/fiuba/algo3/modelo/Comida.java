package edu.fiuba.algo3.modelo;

public class Comida extends Premio{
    @Override
    public void premiar(Gladiador gladiador){
        gladiador.cambiarEnergia(15);
    }
}
