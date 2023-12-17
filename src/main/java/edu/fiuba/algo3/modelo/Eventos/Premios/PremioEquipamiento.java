package edu.fiuba.algo3.modelo.Eventos.Premios;

import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class PremioEquipamiento implements Premio {
    char representacion;
    public PremioEquipamiento(){
        this.representacion = 'E';
    }
    public void premiarGladiador(Gladiador gladiador) {
        gladiador.mejorarEquipamiento();
    }

    public char getRepresentacion(){
        return this.representacion;
    }
}
