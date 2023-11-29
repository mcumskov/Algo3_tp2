package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.ObstaculoInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.PremioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.TipoCasillaInvalidaException;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.Casilla;
import edu.fiuba.algo3.modelo.mapa.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParserUnitTests {

    @Test
    public void test01LeoJsonConCasillaDeTipoInvalidoYReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/mapaCasillaInvalida.json")));
        Parser parser = new Parser();


        assertThrows(TipoCasillaInvalidaException.class, () -> {

            List<Casilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test02LeoJsonConPremioDeTipoInvalidoYReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/mapaPremioInvalido.json")));
        Parser parser = new Parser();


        assertThrows(PremioInvalidoException.class, () -> {

            List<Casilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test03LeoJsonConObstaculoDeTipoInvalidoYReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/mapaObstaculoInvalido.json")));
        Parser parser = new Parser();


        assertThrows(ObstaculoInvalidoException.class, () -> {

            List<Casilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test04ParseoUnMapaValidoCon10CasillasYReciboListaConTamanio10() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/mapaValido10Casillas.json")));

        Parser parser = new Parser();

        List<Casilla> casillas = parser.parsearJSON(jsonString);

        assertEquals(10,casillas.size());

    }
}
