package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface Casilla {

    public void recibir(Gladiador gladiador);

    public void expulsar(Gladiador gladiador);

    public void afectarGladiador(Gladiador gladiador);

}
