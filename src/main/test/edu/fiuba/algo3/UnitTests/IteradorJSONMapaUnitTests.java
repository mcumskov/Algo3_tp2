package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.MapaSinMasCasillasException;
//import edu.fiuba.algo3.modelo.excepciones.NoSePudoAbrirArchivoException;
import edu.fiuba.algo3.modelo.parser.IteradorJSONMapa;
import edu.fiuba.algo3.modelo.parser.LectorJSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IteradorJSONMapaUnitTests {

    @Test
    public void test01LeoMapaJSONObtengo39StringsDeCasillasYLuegoExcepcionDeFinDeArchivo() {

        LectorJSON lector = new LectorJSON();

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapa.json" ;

        String archivo = lector.leerJSON(nombreArchivo);

        IteradorJSONMapa iterador = new IteradorJSONMapa(archivo);


        for (int i = 0; i < 39; i++) {

            iterador.obtenerSiguienteCasilla();

        }
        assertThrows(MapaSinMasCasillasException.class, iterador::obtenerSiguienteCasilla);
    }

    @Test
    public void test02LeoMapaJSONConsultStringMapaYObtengoStringConAnchoYAlto(){

        LectorJSON lector = new LectorJSON();

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapa.json" ;

        String archivo = lector.leerJSON(nombreArchivo);

        String dimMapaEnArchivo = "{\r\n\t\t\"ancho\": 10,\r\n\t\t\"largo\": 18\r\n\t}";

        IteradorJSONMapa iterador = new IteradorJSONMapa(archivo);

        String stringRet = iterador.obtenerDimensionesMapa();

        assertEquals(dimMapaEnArchivo, stringRet);
    }


}
