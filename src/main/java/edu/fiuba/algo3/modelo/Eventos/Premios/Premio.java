package edu.fiuba.algo3.modelo.Eventos.Premios;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface Premio {

    public void premiarGladiador(Gladiador gladiador);

    public char getRepresentacion();

}
