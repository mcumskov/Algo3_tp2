package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CasillaUnitTests {

    @Test
    public void test01CasillasEncuentraSuSiguiente(){

        Casilla ultimaCasilla = new Casilla(null, null);

        Casilla segundaCasilla = new Casilla(ultimaCasilla, null);

        Casilla primeraCasilla = new Casilla(segundaCasilla, null);

        Casilla casillaObtenida = primeraCasilla.obtenerSiguiente(1);

        assertTrue(casillaObtenida == segundaCasilla);
    }

    @Test
    public void test02LaUltimaCasillaSeDevuelveASiMisma(){

        Casilla ultimaCasilla = new Casilla(null, null);

        Casilla segundaCasilla = new Casilla(ultimaCasilla, null);

        Casilla primerCasilla = new Casilla(segundaCasilla, null);

        Casilla casillaObtenida = ultimaCasilla.obtenerSiguiente(1);

        assertEquals(casillaObtenida , ultimaCasilla);

    }

    @Test
    public void test03LaBusquedaEnCadenaFunciona(){

        Casilla ultimaCasilla = new Casilla(null, null);

        Casilla tercerCasilla = new Casilla(ultimaCasilla, null);

        Casilla segundaCasilla = new Casilla(tercerCasilla, null);

        Casilla primerCasilla = new Casilla(segundaCasilla, null);

        Casilla casillaObtenida = primerCasilla.obtenerSiguiente(2);

        assertTrue(casillaObtenida == tercerCasilla);

        casillaObtenida = primerCasilla.obtenerSiguiente(3);
        assertTrue(casillaObtenida == ultimaCasilla);
    }

    @Test
    public  void test04DarMuchosPasosDeMasSigueDevolviendoLaUltimaCasilla(){

        Casilla ultimaCasilla = new Casilla(null, null);

        Casilla tercerCasilla = new Casilla(ultimaCasilla, null);

        Casilla segundaCasilla = new Casilla(tercerCasilla, null);

        Casilla primerCasilla = new Casilla(segundaCasilla, null);

        Casilla casillaObtenida = primerCasilla.obtenerSiguiente(99);

        assertTrue(casillaObtenida == ultimaCasilla);

    }


}

