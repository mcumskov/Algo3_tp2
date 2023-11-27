package edu.fiuba.algo3.modelo.Eventos;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Nulo implements Obstaculo, Premio {

    public void obstaculizarGladiador(Gladiador gladiador){}

    public void premiarGladiador(Gladiador gladiador){}

}
