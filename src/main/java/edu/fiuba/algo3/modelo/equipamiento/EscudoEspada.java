package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class EscudoEspada extends Equipamiento{

    public EscudoEspada(Gladiador gladiadorRecibido, int mitigacionAcumulada){
        this.gladiador = gladiadorRecibido;
        this.reduccionDeDanio = 8 + mitigacionAcumulada;
    }

    public void mejorarEquipamiento(){
        gladiador.cambiarEquipamiento(new Llave(gladiador, reduccionDeDanio));
    }
}