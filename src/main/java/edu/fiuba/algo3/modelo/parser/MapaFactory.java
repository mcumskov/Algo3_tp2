package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.FormatoInvalidoMapaException;
import edu.fiuba.algo3.modelo.mapa.Mapa;

public class MapaFactory {

    BuscadorValorJSON buscadorValor ;
    public MapaFactory(){

        this.buscadorValor = new BuscadorValorJSON();

    }

    public Mapa crearMapa(String infoMapa){

        String claveAncho = "\"ancho\":";
        String claveLargo = "\"largo\":";


        int anchoMapa ;
        int largoMapa ;

        try {

            anchoMapa = buscadorValor.obtenerValorInt(infoMapa, claveAncho);
            largoMapa = buscadorValor.obtenerValorInt(infoMapa, claveLargo);

        } catch(Exception e) {

            throw new FormatoInvalidoMapaException("El formato del mapa es inválido. " + e ) ;

        }


        return new Mapa(anchoMapa,largoMapa);
    }


}
