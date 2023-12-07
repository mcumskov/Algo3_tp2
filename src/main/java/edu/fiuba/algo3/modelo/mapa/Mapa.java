package edu.fiuba.algo3.modelo.mapa;
import edu.fiuba.algo3.modelo.excepciones.CaminoDiscontinuoException;
import edu.fiuba.algo3.modelo.excepciones.CasillaFinalNoEsDeTipoLlegadaException;
import edu.fiuba.algo3.modelo.excepciones.CasillaInicialNoEsDeTipoSalidaException;
import edu.fiuba.algo3.modelo.excepciones.CasillaIntermediaNoEsDeTipoCaminoException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.ArrayList;
import java.util.List;

public class Mapa {

    protected List<iCasilla> casillas;
    protected iCasilla casillaMedio;
    protected iCasilla casillaUltima;

    private int largo;
    private int ancho;

    public Mapa(int ancho, int largo){

        this.largo = largo ;
        this.ancho = ancho ;
    }

    public void agregarCamino(List<iCasilla> casillas){

        this.casillas = casillas ;

        validarCamino();

        int mitad = casillas.size()/2;
        int ultima = casillas.size()-1;
        this.casillaMedio = casillas.get(mitad);
        this.casillaUltima = casillas.get(ultima);

    }


    private void validarCamino(){

        Coordenada coordenadaAnterior = null;

        for (int i = 0; i < casillas.size(); i++) {

            if(coordenadaAnterior!=null){

                if(!(casillas.get(i).getCoordenada().esContigua(coordenadaAnterior))){

                    throw new CaminoDiscontinuoException("El camino proporcionado no es continuo. ");
                }

            }

            if(i == 0){
                if(!(casillas.get(i) instanceof CasillaInicio)){
                    throw new CasillaInicialNoEsDeTipoSalidaException("La casilla inicial no es de tipo \"Salida\". ");
                }
            } else if(i == (casillas.size()-1)){
                if(!(casillas.get(i) instanceof CasillaFinal)){
                    throw new CasillaFinalNoEsDeTipoLlegadaException("La casilla final no es de tipo \"Llegada\". ");
                }
            } else {
                if(!(casillas.get(i) instanceof CasillaCamino)){

                    throw new CasillaIntermediaNoEsDeTipoCaminoException("Una o más casillas intermedias no son del tipo \"Camino\". ");
                }
            }
            coordenadaAnterior = casillas.get(i).getCoordenada();
        }
    }



    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
    }

    public Mapa(List<Gladiador> gladiadores, List<iCasilla> casillas, int CantJugadores){

        this.casillas = casillas;
        iCasilla primerCasilla = casillas.get(0);
        int mitad = casillas.size()/2;
        int ultima = casillas.size()-1;
        this.casillaMedio = casillas.get(mitad);
        this.casillaUltima = casillas.get(ultima);

        for(int i=0; i<CantJugadores; i++){
            primerCasilla.recibir(gladiadores.get(i));
        }
    }

    private iCasilla EncontrarGladiador(Gladiador gladiador){

        iCasilla casillaBuscada = null;
        int i = 0;
        while (casillaBuscada == null){
            iCasilla casillaCandidata = casillas.get(i);
            casillaBuscada = casillaCandidata.buscadoEstaEnLaCasilla(gladiador);
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

        iCasilla inicioMovimiento = this.EncontrarGladiador(gladiador);

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

    public List<iCasilla> getCasillas(){
        return this.casillas;
    }

}
