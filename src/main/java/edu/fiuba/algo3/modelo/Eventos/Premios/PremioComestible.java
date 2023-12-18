package edu.fiuba.algo3.modelo.Eventos.Premios;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class PremioComestible implements Premio {

    private int energiaParaEntregar ;
    private char representacion;

    public PremioComestible(){
        energiaParaEntregar = 15;
        this.representacion = 'C';
    }
    public void premiarGladiador(Gladiador gladiador) {
        Log.getLog().agregarABuffer(" Se encontro comida en el camino!" );
        gladiador.aumentarEnergia(energiaParaEntregar);
    }

    public char getRepresentacion(){
        return this.representacion;
    }

}
