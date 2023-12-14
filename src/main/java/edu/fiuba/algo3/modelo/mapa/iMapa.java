package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface iMapa {
    public void moverGladiador(Gladiador gladiador, int tiradaDeDado);

    public void enviarAMitad(Gladiador gladiador);

}
