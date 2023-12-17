package edu.fiuba.algo3.modelo.Eventos.Obstaculos;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface Obstaculo {

    public void obstaculizarGladiador(Gladiador gladiador);

    public char getRepresentacion();

}
