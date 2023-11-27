package edu.fiuba.algo3.modelo;

public class GanarEquipo extends Premio{
    @Override
    public void premiar(Gladiador gladiador, Equipamiento equipamiento){
        equipamiento.mejorarEquipamiento(gladiador);
    }
}
