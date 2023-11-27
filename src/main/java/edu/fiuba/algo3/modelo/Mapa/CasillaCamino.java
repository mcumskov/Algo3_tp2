package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Mapa.Casilla;
import edu.fiuba.algo3.modelo.Mapa.Coordenada;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class CasillaCamino implements Casilla {

    private Coordenada coordenada ;
    private Obstaculo obstaculo;
    private Premio premio;

    public CasillaCamino(Coordenada coordenada, Obstaculo obstaculo, Premio premio) {

        this.coordenada = coordenada ;
        this.obstaculo = obstaculo ;
        this.premio = premio ;

    }

    public void recibir(Gladiador gladiador){


    }

    public void expulsar(Gladiador gladiador){


    }

    public void afectarGladiador(Gladiador gladiador){


    }

}
