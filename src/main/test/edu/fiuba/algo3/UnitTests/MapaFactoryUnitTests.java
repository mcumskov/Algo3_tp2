package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.FormatoInvalidoMapaException;
import edu.fiuba.algo3.modelo.excepciones.NoSePudoAbrirArchivoException;
import edu.fiuba.algo3.modelo.parser.MapaFactory;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.Mapa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapaFactoryUnitTests {

    @Test
    public void test01ReciboUnStringSinClaveAnchoDeMapaYLanzoExcepcion(){

        MapaFactory mapaFactory = new MapaFactory();

        String stringPruebaFalla = "{\r\n\t\t\"HOLA\": 10,\r\n\t\t\"largo\": 18\r\n\t}";

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            mapaFactory.crearMapa(stringPruebaFalla);

        });
    }

    @Test
    public void test02ReciboUnStringSinClaveAltoDeMapaYLanzoExcepcion(){

        MapaFactory mapaFactory = new MapaFactory();

        String stringPruebaFalla = "{\r\n\t\t\"ancho\": 10,\r\n\t\t\"HOLA\": 18\r\n\t}";

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            mapaFactory.crearMapa(stringPruebaFalla);

        });
    }

    @Test
    public void test03ReciboUnStringCorrectoDeMapaEInstancioUnMapaConDimensionesCorrectas(){

        MapaFactory mapaFactory = new MapaFactory();

        String stringCorrecta = "{\r\n\t\t\"ancho\": 10,\r\n\t\t\"largo\": 18\r\n\t}";

        Mapa mapa = mapaFactory.crearMapa(stringCorrecta);

        assertEquals(10, mapa.getAncho());

        assertEquals(18, mapa.getLargo());

    }






}
