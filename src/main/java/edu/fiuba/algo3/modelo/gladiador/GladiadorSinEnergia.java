package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.mapa.iCasilla;

public class GladiadorSinEnergia implements Estado{
    String representacion = "Sin energia :[";
    public void avanzar(Gladiador gladiador, iCasilla casillaDeSalida, int pasos){
        Log.getLog().agregarABuffer(" el gladiador no tiene energia, no se pudo mover y pierde su turno :[ |");
        gladiador.aumentarEnergia(5);
        if(gladiador.getEnergia() > 0){
            gladiador.cambiarEstado(new GladiadorSano());
        }
    }
    public String getRepresentacion(){
        return this.representacion;
    }
}
