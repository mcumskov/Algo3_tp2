package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.ClaveInexistenteException;
import edu.fiuba.algo3.modelo.excepciones.ObstaculoInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.PremioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.TipoCasillaInvalidaException;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import edu.fiuba.algo3.modelo.mapa.CasillaFinal;
import edu.fiuba.algo3.modelo.mapa.CasillaInicio;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.parser.CasillaFactory;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasillaFactoryUnitTests {

    @Test
    public void test01CreoUnaCasillaConTipoDeCasillaInvalidoReciboExcepcion(){

        String stringPrueba = "{\r\n\t\t\"x\": 10," +
                "\r\n\t\t\"y\": 18," +
                "\r\n\t\t\"tipo\": \"TipoInvalido\"," +
                "\r\n\t\t\"obstaculo\": \"Bacanal\",\n" +
                "\r\n\t\t\"premio\": \"Equipamiento\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        assertThrows(TipoCasillaInvalidaException.class, () -> {

            casillaFactory.crearCasilla(stringPrueba);
        });
    }

    @Test
    public void test02CreoUnaCasillaConObstaculoInvalidoReciboExcepcion(){

        String stringPrueba = "{\r\n\t\t\"x\": 10," +
                "\r\n\t\t\"y\": 18," +
                "\r\n\t\t\"tipo\": \"Salida\"," +
                "\r\n\t\t\"obstaculo\": \"ObstaculoInvalido\",\n" +
                "\r\n\t\t\"premio\": \"Equipamiento\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        assertThrows(ObstaculoInvalidoException.class, () -> {

            casillaFactory.crearCasilla(stringPrueba);
        });
    }

    @Test
    public void test03CreoUnaCasillaConPremioInvalidoReciboExcepcion(){

        String stringPrueba = "{\r\n\t\t\"x\": 10," +
                "\r\n\t\t\"y\": 18," +
                "\r\n\t\t\"tipo\": \"Salida\"," +
                "\r\n\t\t\"obstaculo\": \"Bacanal\",\n" +
                "\r\n\t\t\"premio\": \"ComidaNoEs\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        assertThrows(PremioInvalidoException.class, () -> {

            casillaFactory.crearCasilla(stringPrueba);

        });
    }

    @Test
    public void test04CreoUnaCasillaConParametrosCorrectosYTipoSalidaReciboCasillaInicio(){

        String stringPrueba = "{\r\n\t\t\"x\": 1," +
                "\r\n\t\t\"y\": 1," +
                "\r\n\t\t\"tipo\": \"Salida\"," +
                "\r\n\t\t\"obstaculo\": \"Bacanal\",\n" +
                "\r\n\t\t\"premio\": \"Comida\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        iCasilla casilla = casillaFactory.crearCasilla(stringPrueba);

        assertTrue(casilla instanceof CasillaInicio );
    }

    @Test
    public void test05CreoUnaCasillaConParametrosCorrectosYTipoCaminoReciboCasillaCamino(){

        String stringPrueba = "{\r\n\t\t\"x\": 1," +
                "\r\n\t\t\"y\": 1," +
                "\r\n\t\t\"tipo\": \"Camino\"," +
                "\r\n\t\t\"obstaculo\": \"Lesion\",\n" +
                "\r\n\t\t\"premio\": \"Equipamiento\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        iCasilla casilla = casillaFactory.crearCasilla(stringPrueba);

        assertTrue(casilla instanceof CasillaCamino);
    }

    @Test
    public void test06CreoUnaCasillaConParametrosCorrectosYTipoCaminoReciboCasillaCamino(){

        String stringPrueba = "{\r\n\t\t\"x\": 1," +
                "\r\n\t\t\"y\": 1," +
                "\r\n\t\t\"tipo\": \"Llegada\"," +
                "\r\n\t\t\"obstaculo\": \"Fiera\",\n" +
                "\r\n\t\t\"premio\": \"\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        iCasilla casilla = casillaFactory.crearCasilla(stringPrueba);

        assertTrue(casilla instanceof CasillaFinal);
    }

    @Test
    public void test07CreoUnaCasillaConParametrosCorrectosYNoReciboExcepcion(){

        String stringPrueba = "{\r\n\t\t\"x\": 1," +
                "\r\n\t\t\"y\": 1," +
                "\r\n\t\t\"tipo\": \"Camino\"," +
                "\r\n\t\t\"obstaculo\": \"\",\n" +
                "\r\n\t\t\"premio\": \"\"" +
                "\r\n\t}";

        CasillaFactory casillaFactory = new CasillaFactory();

        iCasilla casilla = casillaFactory.crearCasilla(stringPrueba);
    }


}
