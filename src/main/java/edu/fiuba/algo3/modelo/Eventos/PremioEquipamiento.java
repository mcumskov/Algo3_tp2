package edu.fiuba.algo3.modelo.Eventos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class PremioEquipamiento implements Premio{

    public void premiarGladiador(Gladiador gladiador) {

        gladiador.mejorarEquipamiento();

    }

}
