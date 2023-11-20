package edu.fiuba.algo3.modelo.seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public abstract class Seniority{
    public int turnos;
    public int recuperacionEnergia;
    public int turnosParaAscender;
    public Gladiador gladiador;
    public int limiteAsencion;

    public abstract Seniority actualizar();

    public void obtenerEnergia(){
        gladiador.cambiarEnergia(recuperacionEnergia);
    }
}