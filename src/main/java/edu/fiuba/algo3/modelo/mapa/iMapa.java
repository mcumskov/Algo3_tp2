package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.List;

public interface iMapa {
    public void moverGladiador(Gladiador gladiador, int tiradaDeDado);

    public void enviarAMitad(Gladiador gladiador);

    public int getAncho();

    public int getLargo();

    public List<iCasilla> getCasillas();

    public void ingresarGladiadores(List<Gladiador> gladiadores, int CantJugadores);

    }
