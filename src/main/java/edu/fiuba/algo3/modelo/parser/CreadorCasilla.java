package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.mapa.Coordenada;
import edu.fiuba.algo3.modelo.mapa.iCasilla;

public interface CreadorCasilla {

    public iCasilla crearCasilla(Coordenada coordenada, Obstaculo obstaculo, Premio premio);

}
