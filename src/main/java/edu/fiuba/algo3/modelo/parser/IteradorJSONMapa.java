package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.MapaSinMasCasillasException;

import java.util.ArrayList;
import java.util.List;

public class IteradorJSONMapa {

    int casillaIteracion ;
    String stringMapaDim;
    List<String> listaCasillas ;


    public IteradorJSONMapa(String stringRecibida){

        casillaIteracion = 0 ;

        String[] partes = stringRecibida.split("\"celdas\":\\s*\\[");

        this.stringMapaDim = this.obtenerCeldaMapa(partes[0]);
        String stringCamino = this.obtenerCamino(partes[1]);

        this.listaCasillas = this.separarCeldasCasillas(stringCamino);
    }

    private String obtenerCeldaMapa(String stringInicio){

        String claveInicio = ":";
        String claveFin = "}" ;

        int inicio = stringInicio.indexOf(claveInicio) ;
        int fin = stringInicio.indexOf(claveFin) ;

        return stringInicio.substring(inicio+claveInicio.length(), fin+claveFin.length()).trim();

    }

    private String obtenerCamino(String stringInicio){

        String claveInicio = "[";
        String claveFin = "]" ;

        int inicio = stringInicio.indexOf(claveInicio) ;
        int fin = stringInicio.indexOf(claveFin) - 1;


        return stringInicio.substring(inicio+claveInicio.length(), fin+claveFin.length());

    }

    private List<String> separarCeldasCasillas(String stringCasillas){

        List<String> listaCasillas = new ArrayList<>();

        int inicio = 0 ;
        int fin = 0 ;

        while (inicio != -1) {

            inicio = stringCasillas.indexOf("{", fin + 1);
            fin = stringCasillas.indexOf("}", inicio);

            if(inicio != -1) {
                listaCasillas.add(stringCasillas.substring(inicio, fin + 1));
            }
        }

        return listaCasillas;
    }

    private String obtenerCasilla(int i ){

        return this.listaCasillas.get(i);
    }

    public String obtenerSiguienteCasilla(){

        String stringRet ;

        try {
            stringRet = obtenerCasilla(this.casillaIteracion);
        } catch (Exception e){

            throw new MapaSinMasCasillasException("");
        }

        this.casillaIteracion++;

        return stringRet ;

    }

    public String obtenerDimensionesMapa(){

        return this.stringMapaDim;

    }




}
