package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Llave extends Equipamiento{

    public Llave(Gladiador gladiadorRecibido, int mitigacionAcumulada){
        this.gladiador = gladiadorRecibido;
        this.reduccionDeDanio = 2 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(){
        // hace nada
    }
    public void abrirCasaPompeya(){
        gladiador.victoria();
    }
}