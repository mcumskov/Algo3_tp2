package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Armadura extends Equipamiento{

    public Armadura(Gladiador gladiadorRecibido, int mitigacionAcumulada){
        this.gladiador = gladiadorRecibido;
        this.reduccionDeDanio = 5 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(){
        gladiador.cambiarEquipamiento(new EscudoEspada(gladiador, reduccionDeDanio));
    }
}