package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.MapaSinMasCasillasException;
import edu.fiuba.algo3.modelo.mapa.*;

import java.util.ArrayList;

public class Parser {

    LectorJSON lector ;
    IteradorJSONMapa iteradorJSON ;
    CasillaFactory casillaFactory ;
    MapaFactory mapaFactory ;

    public Parser(){


    }

    public Mapa parsearMapa(String nombreArchivo){

        this.lector = new LectorJSON();
        String stringMapa = lector.leerJSON(nombreArchivo);
        this.iteradorJSON = new IteradorJSONMapa(stringMapa);
        this.casillaFactory = new CasillaFactory();
        this.mapaFactory = new MapaFactory();

        Mapa mapa ;

        mapa = mapaFactory.crearMapa(this.iteradorJSON.obtenerDimensionesMapa());

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();

        while(true){

            try {

                listaCasillas.add(casillaFactory.crearCasilla(iteradorJSON.obtenerSiguienteCasilla()));

            }catch(MapaSinMasCasillasException e){

                break ;

            }
        }

        ValidadorDeCamino validadorCamino = new ValidadorDeCamino();

        validadorCamino.validarCamino(listaCasillas);

        mapa.agregarCamino(listaCasillas);

        return mapa ;

    }


}