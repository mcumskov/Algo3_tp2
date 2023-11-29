package edu.fiuba.algo3.modelo.mapa;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    protected List<Casilla> casillas;
    protected Casilla casillaMedio;
    protected Casilla casillaUltima;
    public Mapa(List<Gladiador> gladiadores, List<Casilla> casillas, int CantJugadores){

        this.casillas = casillas;
        Casilla primerCasilla = casillas.get(0);
        int mitad = casillas.size()/2;
        int ultima = casillas.size()-1;
        this.casillaMedio = casillas.get(mitad);
        this.casillaUltima = casillas.get(ultima);

        for(int i=0; i<CantJugadores; i++){
            primerCasilla.recibir(gladiadores.get(i));
        }
    }

    private Casilla EncontrarGladiador(Gladiador gladiador){

        Casilla casillaBuscada = null;
        int i = 0;
        while (casillaBuscada == null){
            Casilla casillaCandidata = casillas.get(i);
            casillaBuscada = casillaCandidata.BuscadoEstaEnLaCasilla(gladiador);
            i++;
        }
        return casillaBuscada;
    }

   /* private Casilla ObtenerCasillaDeLLegada(Casilla salida, int pasos){

        int max = casillas.size();
        int indexSalida = casillas.indexOf(salida);

        if(indexSalida+pasos >= max){
            return casillas.get(max-1);
        }

        return casillas.get(indexSalida+pasos);
    } */

    public void moverGladiador(Gladiador gladiador, int tiradaDeDado){

        Casilla inicioMovimiento = this.EncontrarGladiador(gladiador);

        /*Casilla finalMovimiento = ObtenerCasillaDeLLegada(inicioMovimiento, tiradaDeDado);

          esto de arriba, si vamos a hacer q las casillas conozcan sus siguitnes, no hace falta
          en su defecto, si es necesario, por eso no lo borro del todo por si cambiamos d
          opinion*/

        gladiador.avanzar(inicioMovimiento, tiradaDeDado);
    }
    public void enviarAMitad(Gladiador gladiador){
        this.casillaUltima.expulsar(gladiador);
        this.casillaMedio.recibir(gladiador);
    }
}
