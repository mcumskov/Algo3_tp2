package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
public class Desnudo extends Equipamiento{

    public Desnudo(Gladiador gladiadorRecibido){
        this.gladiador = gladiadorRecibido;
        this.reduccionDeDanio = 0;
    }

    public void mejorarEquipamiento(){
        gladiador.cambiarEquipamiento(new Casco(gladiador, reduccionDeDanio));
    }
}