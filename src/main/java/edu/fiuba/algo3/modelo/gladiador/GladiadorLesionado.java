package edu.fiuba.algo3.modelo.gladiador;
import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.mapa.iCasilla;

public class GladiadorLesionado implements Estado{

    String representacion = "LESIONADO";
    public void avanzar(Gladiador gladiador, iCasilla casillaDeSalida, int pasos){

        gladiador.cambiarEstado(new GladiadorSano());
        Log.getLog().agregarABuffer(" el gladiador esta lesionado, no se pudo mover y pierde su turno :[ |");
    }
    public String getRepresentacion(){
        return this.representacion;
    }
}