package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.parser.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class ParserUnitTests {

    @Test
    public void test01IntentoParsearUnArchivoInexistenteReciboExcepcion(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/noExiste.json";

        Parser parser = new Parser();

        assertThrows(NoSePudoAbrirArchivoException.class, () -> parser.parsearMapa(pathArchivo));
    }

    @Test
    public void test02ParseoMapaJSONObtengoUnMapaConLasDimensionesCorrectas(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapa.json";

        Parser parser = new Parser();

        Mapa mapa = parser.parsearMapa(pathArchivo);

        assertEquals(10, mapa.getAncho());
        assertEquals(18, mapa.getLargo());
    }

    @Test
    public void test03ParseoMapaJSONObtengoUnMapaConLasDimensionesCorrectas(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapa.json";

        Parser parser = new Parser();

        Mapa mapa = parser.parsearMapa(pathArchivo);

        assertEquals(10, mapa.getAncho());
        assertEquals(18, mapa.getLargo());
    }

    @Test
    public void test04ParseoMapaConPrimeraCasillaQueNoEsDeTipoInicioLanzoExcepcion(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaInicialNoEsDeTipoSalida.json";

        Parser parser = new Parser();


        assertThrows(CasillaInicialNoEsDeTipoSalidaException.class, () -> parser.parsearMapa(pathArchivo));
    }

    @Test
    public void test05ParseoMapaConCasillaInermediaQueNoEsDeTipoCaminoLanzoExcepcion(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaIntermediaNoEsDeTipoCamino.json";

        Parser parser = new Parser();

        assertThrows(CasillaIntermediaNoEsDeTipoCaminoException.class, () -> parser.parsearMapa(pathArchivo));
    }

    @Test
    public void test06ParseoMapaConCasillaFinalQueNoEsDeTipoLlegadaLanzoExcepcion(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaCasillaFinalNoEsDeTipoLlegada.json";

        Parser parser = new Parser();

        assertThrows(CasillaFinalNoEsDeTipoLlegadaException.class, () -> parser.parsearMapa(pathArchivo));
    }

    @Test
    public void test07ParseoMapaDiscontinuoLanzoExcepcion(){

        String pathArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapaConCaminoDiscontinuo.json";

        Parser parser = new Parser();

        assertThrows(CaminoDiscontinuoException.class, () -> parser.parsearMapa(pathArchivo));
    }






}
