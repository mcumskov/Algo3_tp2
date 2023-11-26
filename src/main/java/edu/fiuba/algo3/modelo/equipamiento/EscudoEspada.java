package edu.fiuba.algo3.modelo.equipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class EscudoEspada extends Equipable{

    public EscudoEspada(int reduccionAcumulada){
        this.danioReducir = reduccionAcumulada + 8 ;
    }

    public Equipable mejorar(){

        return new Llave(this.danioReducir);
    }
}