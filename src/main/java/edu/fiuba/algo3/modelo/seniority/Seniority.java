package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public abstract class Seniority{
    protected int turnos;
    protected int recuperacionEnergia;

    protected Gladiador gladiador;
    protected int limiteAsencion;

    public abstract void actualizar();

    public void obtenerEnergia(){
        gladiador.cambiarEnergia(recuperacionEnergia);
    }
}