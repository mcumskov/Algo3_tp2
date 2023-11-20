package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
public class Casco extends Equipamiento{

    public Casco(Gladiador gladiadorRecibido, int mitigacionAcumulada){
        this.gladiador = gladiadorRecibido;
        this.reduccionDeDanio = 5 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(){
        gladiador.cambiarEquipamiento(new Armadura(gladiador, reduccionDeDanio));
    }
}

