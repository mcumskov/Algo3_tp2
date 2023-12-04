package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.ClaveInexistenteException;

public class BuscadorValorJSON {

    public int obtenerValorInt(String stringBusqueda, String clave){

        if (!stringBusqueda.contains(clave)){

            throw new ClaveInexistenteException("No se encontró la clave" + clave + " . \n");

        }

        int inicio = stringBusqueda.indexOf(clave) + clave.length() ;
        int fin ;
        int proxComa = stringBusqueda.indexOf(",", inicio);
        int proxLlave = stringBusqueda.indexOf("}", inicio);

        if(proxComa < proxLlave && proxComa > 0)
            fin = proxComa;
        else
            fin = proxLlave;

        return Integer.parseInt(stringBusqueda.substring(inicio, fin).trim());
    }

    public String obtenerValorStr(String stringBusqueda, String clave) {

        if (!stringBusqueda.contains(clave)){
            throw new ClaveInexistenteException("No se encontró la clave" + clave + " . \n");
        }

        int inicio = stringBusqueda.indexOf(clave) + clave.length();

        int fin = stringBusqueda.indexOf("\"", inicio + 2);

        return stringBusqueda.substring(inicio + 2, fin).trim();
    }


}
