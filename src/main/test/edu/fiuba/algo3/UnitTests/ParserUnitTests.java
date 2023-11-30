package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.mapa.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParserUnitTests {

    @Test
    public void test01LeoJsonConCasillaDeTipoInvalidoYReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaInvalida.json")));
        Parser parser = new Parser();


        assertThrows(TipoCasillaInvalidaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test02LeoJsonConPremioDeTipoInvalidoYReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaPremioInvalido.json")));
        Parser parser = new Parser();


        assertThrows(PremioInvalidoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test03LeoJsonConObstaculoDeTipoInvalidoYReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaObstaculoInvalido.json")));
        Parser parser = new Parser();


        assertThrows(ObstaculoInvalidoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test04ParseoUnMapaValidoCon10CasillasYReciboListaConTamanio10() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaValido10Casillas.json")));

        Parser parser = new Parser();

        List<iCasilla> casillas = parser.parsearJSON(jsonString);

        assertEquals(10,casillas.size());

    }

    @Test
    public void test05ParseoUnMapaConClaveInvalidaDePremioReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClavePremioInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test06ParseoUnMapaConClaveInvalidaDeObstaculoReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveObstaculoInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test07ParseoUnMapaConClaveInvalidaDeTipoReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveTipoInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test08ParseoUnMapaConClaveInvalidaDeXReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveXInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test09ParseoUnMapaConClaveInvalidaDeYReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveYInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test10ParseoUnMapaConClaveInvalidaDeAnchoDeMapaYReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveAnchoMapaInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test11ParseoUnMapaConClaveInvalidaDeAltoDeMapaYReciboExcepcionDeFormatoInvalido() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveAltoMapaInvalida.json")));

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test12ParseoUnMapaCorrectoSinProblemas() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapa.json")));

        Parser parser = new Parser();

        List<iCasilla> casillas = parser.parsearJSON(jsonString);

    }

    @Test
    public void test13ParseoUnMapaConLaCasillaInicialQueNoEsDelTipoSalidaReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaInicialNoEsDeTipoSalida.json")));

        Parser parser = new Parser();

        assertThrows(CasillaInicialNoEsDeTipoSalidaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test14ParseoUnMapaConLaCasillaFinaQueNoEsDelTipoLlegadaReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaFinalNoEsDeTipoLlegada.json")));

        Parser parser = new Parser();

        assertThrows(CasillaFinalNoEsDeTipoLlegadaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test15ParseoUnMapaConUnaCasillaIntermediaQueNoEsDelTipoCaminoReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaIntermediaNoEsDeTipoCamino.json")));

        Parser parser = new Parser();

        assertThrows(CasillaIntermediaNoEsDeTipoCaminoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }

    @Test
    public void test16ParseoUnMapaConUnCaminoDiscontinuoReciboExcepcion() throws IOException {

        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/test/edu/fiuba/algo3/jsonTests/mapaConCaminoDiscontinuo.json")));

        Parser parser = new Parser();

        assertThrows(CaminoDiscontinuoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(jsonString);

        });
    }
}
