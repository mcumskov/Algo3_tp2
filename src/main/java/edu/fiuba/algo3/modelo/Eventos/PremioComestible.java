package edu.fiuba.algo3.modelo.Eventos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class PremioComestible implements Premio{

    private int energiaParaEntregar ;

    public PremioComestible(){

        energiaParaEntregar = 15 ;
    }
    public void premiarGladiador(Gladiador gladiador) {

        gladiador.aumentarEnergia(energiaParaEntregar);

    }

}
