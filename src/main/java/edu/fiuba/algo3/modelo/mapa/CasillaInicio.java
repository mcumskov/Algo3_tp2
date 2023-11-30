package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;

public class CasillaInicio  implements iCasilla{

    protected Obstaculo obstaculo;
    protected Premio premio;
    protected iCasilla casillaSiguiente;

    protected List<Gladiador> gladiadoresEnLaCasilla;
    private Coordenada coordenada;

    public CasillaInicio(iCasilla siguiente, Obstaculo obstaculo, Premio premio){
        this.casillaSiguiente = siguiente;
        this.obstaculo = obstaculo;
        this.premio = premio;
        this.gladiadoresEnLaCasilla = new ArrayList<Gladiador>();
    }
    public void SetSiguiente(iCasilla siguiente){
        this.casillaSiguiente = siguiente;
    }
    public void moverGladiador(int pasos, Gladiador gladiador){
        if( pasos == 0 || casillaSiguiente == null){
            this.recibir(gladiador);
            return;
        }
        casillaSiguiente.moverGladiador(pasos-1, gladiador);
        this.expulsar(gladiador);
    }

    public void recibir(Gladiador gladiador){
        gladiadoresEnLaCasilla.add(gladiador);
        this.premio.premiarGladiador(gladiador);
        this.obstaculo.obstaculizarGladiador(gladiador);
    }

    public void expulsar(Gladiador gladiador){
        gladiadoresEnLaCasilla.remove(gladiador);
    }

    public iCasilla BuscadoEstaEnLaCasilla(Gladiador gladiador){
        if(gladiadoresEnLaCasilla.contains(gladiador)){
            return this;
        }
        return null;
    }

    public Coordenada getCoordenada(){

        return this.coordenada;

    }

}
