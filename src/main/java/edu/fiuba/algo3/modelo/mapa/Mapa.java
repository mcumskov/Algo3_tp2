package edu.fiuba.algo3.modelo.mapa;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import java.util.List;

public class Mapa implements iMapa{

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

        int mitad = casillas.size()/2;
        int ultima = casillas.size()-1;
        this.casillaMedio = casillas.get(mitad);
        this.casillaUltima = casillas.get(ultima);
    }

    public void ingresarGladiadores(List<Gladiador> gladiadores, int CantJugadores){

        iCasilla primerCasilla = casillas.get(0);

        for(int i=0; i<CantJugadores; i++){
            primerCasilla.recibir(gladiadores.get(i));
        }
    }

    public int getAncho() {
        return ancho;
    }

    public int getLargo() {
        return largo;
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

    public void moverGladiador(Gladiador gladiador, int tiradaDeDado){

        iCasilla inicioMovimiento = this.EncontrarGladiador(gladiador);

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
