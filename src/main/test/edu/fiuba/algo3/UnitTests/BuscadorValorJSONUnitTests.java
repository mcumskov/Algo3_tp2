package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.ClaveInexistenteException;
import edu.fiuba.algo3.modelo.parser.BuscadorValorJSON;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuscadorValorJSONUnitTests {

    @Test
    public void test01BuscoUnaClaveIntQueNoEstaReciboExcepcion(){

        String stringPrueba = "{\r\n\t\t\"ancho\": 10,\r\n\t\t\"largo\": 18\r\n\t}";

        BuscadorValorJSON buscador = new BuscadorValorJSON();

        assertThrows(ClaveInexistenteException.class, () -> {

            buscador.obtenerValorInt(stringPrueba, "hola");

        });
    }

    @Test
    public void test02BuscoUnaClaveStringQueNoEstaReciboExcepcion(){

        String stringPrueba = "{\r\n\t\t\"ancho\": 10,\r\n\t\t\"largo\": 18\r\n\t}";

        BuscadorValorJSON buscador = new BuscadorValorJSON();

        assertThrows(ClaveInexistenteException.class, () -> {

            buscador.obtenerValorStr(stringPrueba, "hola");
        });
    }

    @Test
    public void test03BuscoUnaClaveIntQueSiEstaReciboValorCorrespondiente(){

        String stringPrueba = "{\r\n\t\t\"ancho\": 10,\r\n\t\t\"largo\": 18\r\n\t}";

        BuscadorValorJSON buscador = new BuscadorValorJSON();

        assertEquals(10,buscador.obtenerValorInt(stringPrueba, "\"ancho\":"));
    }

    @Test
    public void test04BuscoUnaClaveIntQueSiEstaReciboValorCorrespondiente(){

        String stringPrueba = "{\r\n\t\t\"prueba\": \"hola\",\r\n\t\t\"largo\": 18\r\n\t}";

        BuscadorValorJSON buscador = new BuscadorValorJSON();

        assertTrue(buscador.obtenerValorStr(stringPrueba, "\"prueba\":").equals("hola"));
    }


}

