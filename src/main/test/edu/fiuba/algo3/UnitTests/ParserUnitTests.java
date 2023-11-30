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
    public void test01LeoJsonConCasillaDeTipoInvalidoYReciboExcepcion(){

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaInvalida.json";
        Parser parser = new Parser();

        assertThrows(TipoCasillaInvalidaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);
        });
    }

    @Test
    public void test02LeoJsonConPremioDeTipoInvalidoYReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaPremioInvalido.json";

        Parser parser = new Parser();

        assertThrows(PremioInvalidoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test03LeoJsonConObstaculoDeTipoInvalidoYReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaObstaculoInvalido.json";
        Parser parser = new Parser();


        assertThrows(ObstaculoInvalidoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test04ParseoUnMapaValidoCon10CasillasYReciboListaConTamanio10(){

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaValido10Casillas.json";

        Parser parser = new Parser();

        List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        assertEquals(10,casillas.size());

    }

    @Test
    public void test05ParseoUnMapaConClaveInvalidaDePremioReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClavePremioInvalida.json" ;

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test06ParseoUnMapaConClaveInvalidaDeObstaculoReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveObstaculoInvalida.json";

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test07ParseoUnMapaConClaveInvalidaDeTipoReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveTipoInvalida.json";

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test08ParseoUnMapaConClaveInvalidaDeXReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveXInvalida.json";

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test09ParseoUnMapaConClaveInvalidaDeYReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveYInvalida.json";

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test10ParseoUnMapaConClaveInvalidaDeAnchoDeMapaYReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveAnchoMapaInvalida.json" ;

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test11ParseoUnMapaConClaveInvalidaDeAltoDeMapaYReciboExcepcionDeFormatoInvalido() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaClaveAltoMapaInvalida.json" ;

        Parser parser = new Parser();

        assertThrows(FormatoInvalidoMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test12ParseoUnMapaCorrectoSinProblemas() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapa.json" ;

        Parser parser = new Parser();

        List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

    }

    @Test
    public void test13ParseoUnMapaConLaCasillaInicialQueNoEsDelTipoSalidaReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaInicialNoEsDeTipoSalida.json";

        Parser parser = new Parser();

        assertThrows(CasillaInicialNoEsDeTipoSalidaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test14ParseoUnMapaConLaCasillaFinaQueNoEsDelTipoLlegadaReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaFinalNoEsDeTipoLlegada.json";

        Parser parser = new Parser();

        assertThrows(CasillaFinalNoEsDeTipoLlegadaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test15ParseoUnMapaConUnaCasillaIntermediaQueNoEsDelTipoCaminoReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaIntermediaNoEsDeTipoCamino.json" ;

        Parser parser = new Parser();

        assertThrows(CasillaIntermediaNoEsDeTipoCaminoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test16ParseoUnMapaConUnCaminoDiscontinuoReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaConCaminoDiscontinuo.json" ;

        Parser parser = new Parser();

        assertThrows(CaminoDiscontinuoException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test17ParseoUnMapaConUnaCasillaFueraDeMapaReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaConCasillaFueraDeMapa.json" ;

        Parser parser = new Parser();

        assertThrows(CasillaFueraDeMapaException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test18ParseoUnMapaConAnchoInvalidoReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaAnchoinvalido.json" ;

        Parser parser = new Parser();

        assertThrows(MapaDimensionesInconsistentesException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test19ParseoUnMapaConAltoInvalidoReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaAltoinvalido.json" ;

        Parser parser = new Parser();

        assertThrows(MapaDimensionesInconsistentesException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

    @Test
    public void test20IntentoParsearUnMapaConPathInvalidoReciboExcepcion() {

        String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/HolaJuanCarlos.json" ;

        Parser parser = new Parser();

        assertThrows(MapaJsonNoSePudoAbrirException.class, () -> {

            List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

        });
    }

}
