package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.NoSePudoAbrirArchivoException;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.parser.LectorJSON;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LectorJSONUnitTests {

    @Test
    public void test01IntentoAbrirUnArchivoInexistenteReciboExcepcion(){

        LectorJSON lector = new LectorJSON();

        assertThrows(NoSePudoAbrirArchivoException.class, () -> {

            lector.leerJSON("La7maDeBokita");

        });
    }

    @Test
    public void test02AbroUnArchivoJSONYVerificoHaberSuContenidoCorrectamente(){

        LectorJSON lector = new LectorJSON();

        String stringLeida = lector.leerJSON("src/main/test/edu/fiuba/algo3/jsonTests/pruebaAbrirArchivo.json");

        assertEquals(stringLeida, "\"San lorenzo campeón de América 13/08/2014\"");

    }
}
