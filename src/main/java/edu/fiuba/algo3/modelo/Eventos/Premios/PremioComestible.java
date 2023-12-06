package edu.fiuba.algo3.modelo.Eventos.Premios;

import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.log.Log;

public class PremioComestible implements Premio {

    private int energiaParaEntregar ;

    public PremioComestible(){
        energiaParaEntregar = 15;
    }
    public void premiarGladiador(Gladiador gladiador) {
        Log.getLog().agregarABuffer(" Se encontro comida en el camino!" );
        gladiador.aumentarEnergia(energiaParaEntregar);
    }

}
