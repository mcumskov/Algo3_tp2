package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.excepciones.CaminoDiscontinuoException;
import edu.fiuba.algo3.modelo.excepciones.CasillaTipoSalidaMalPosicionadaException;
import edu.fiuba.algo3.modelo.excepciones.FormatoInvalidoMapaException;
import edu.fiuba.algo3.modelo.excepciones.MapaSinMasCasillasException;
import edu.fiuba.algo3.modelo.mapa.*;
import edu.fiuba.algo3.modelo.parser.ValidadorDeCamino;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidadorDeCaminoUnitTests {


    @Test
    public void test01CreoUnCaminoConUnaCasillaInicialEnElMedioReciboExcepcion() {

        iCasilla casilla1 = new CasillaInicio(new Coordenada(1,1), null);
        iCasilla casilla2 = new CasillaCamino(new Coordenada(1,2), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla3 = new CasillaCamino(new Coordenada(1,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla4 = new CasillaCamino(new Coordenada(2,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla5 = new CasillaCamino(new Coordenada(2,4), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla6MalPuesta = new CasillaInicio(new Coordenada(2, 5), null);
        iCasilla casilla7 = new CasillaCamino(new Coordenada(2,6), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla8final = new CasillaFinal(new Coordenada(2,7));

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        listaCasillas.add(casilla4);
        listaCasillas.add(casilla5);
        listaCasillas.add(casilla6MalPuesta);
        listaCasillas.add(casilla7);
        listaCasillas.add(casilla8final);

        ValidadorDeCamino validador = new ValidadorDeCamino();

        assertThrows(FormatoInvalidoMapaException.class, () -> {
            validador.validarCamino(listaCasillas);
        });
    }

    @Test
    public void test02CreoUnCaminoConUnaCasillaFinalEnElMedioReciboExcepcion() {

        iCasilla casilla1 = new CasillaInicio(new Coordenada(1,1), null);
        iCasilla casilla2 = new CasillaCamino(new Coordenada(1,2), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla3 = new CasillaCamino(new Coordenada(1,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla4 = new CasillaCamino(new Coordenada(2,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla5 = new CasillaCamino(new Coordenada(2,4), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla6MalPuesta = new CasillaFinal(new Coordenada(2, 5));
        iCasilla casilla7 = new CasillaCamino(new Coordenada(2,6), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla8final = new CasillaFinal(new Coordenada(2,7));

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
        listaCasillas.add(casilla1);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        listaCasillas.add(casilla4);
        listaCasillas.add(casilla5);
        listaCasillas.add(casilla6MalPuesta);
        listaCasillas.add(casilla7);
        listaCasillas.add(casilla8final);

        ValidadorDeCamino validador = new ValidadorDeCamino();

        assertThrows(FormatoInvalidoMapaException.class, () -> {
            validador.validarCamino(listaCasillas);
        });
    }

    @Test
    public void test03CreoUnCaminoConUnaCasillaCaminoEnElComienzoReciboExcepcion() {

        iCasilla casilla1inicio = new CasillaCamino(new Coordenada(1,1), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla2 = new CasillaCamino(new Coordenada(1,2), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla3 = new CasillaCamino(new Coordenada(1,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla4 = new CasillaCamino(new Coordenada(2,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla5 = new CasillaCamino(new Coordenada(2,4), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla6 = new CasillaCamino(new Coordenada(2,5), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla7 = new CasillaCamino(new Coordenada(2,6), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla8final = new CasillaFinal(new Coordenada(2,7));

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
        listaCasillas.add(casilla1inicio);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        listaCasillas.add(casilla4);
        listaCasillas.add(casilla5);
        listaCasillas.add(casilla6);
        listaCasillas.add(casilla7);
        listaCasillas.add(casilla8final);

        ValidadorDeCamino validador = new ValidadorDeCamino();

        assertThrows(FormatoInvalidoMapaException.class, () -> {
            validador.validarCamino(listaCasillas);
        });
    }

    @Test
    public void test04CreoUnCaminoConUnaCasillaCaminoEnElFinalReciboExcepcion() {

        iCasilla casilla1inicio = new CasillaInicio(new Coordenada(1,1), null);
        iCasilla casilla2 = new CasillaCamino(new Coordenada(1,2), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla3 = new CasillaCamino(new Coordenada(1,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla4 = new CasillaCamino(new Coordenada(2,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla5 = new CasillaCamino(new Coordenada(2,4), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla6 = new CasillaCamino(new Coordenada(2,5), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla7 = new CasillaCamino(new Coordenada(2,6), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla8final = new CasillaCamino(new Coordenada(2,7), null, new ObstaculoNulo(), new PremioNulo());

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
        listaCasillas.add(casilla1inicio);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        listaCasillas.add(casilla4);
        listaCasillas.add(casilla5);
        listaCasillas.add(casilla6);
        listaCasillas.add(casilla7);
        listaCasillas.add(casilla8final);

        ValidadorDeCamino validador = new ValidadorDeCamino();

        assertThrows(FormatoInvalidoMapaException.class, () -> {
            validador.validarCamino(listaCasillas);
        });
    }

    @Test
    public void test05CreoUnCaminoDiscontinuoReciboExcepcion() {

        iCasilla casilla1inicio = new CasillaInicio(new Coordenada(1,1), null);
        iCasilla casilla2 = new CasillaCamino(new Coordenada(1,2), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla3 = new CasillaCamino(new Coordenada(1,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla4 = new CasillaCamino(new Coordenada(2,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla5 = new CasillaCamino(new Coordenada(2,4), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla6 = new CasillaCamino(new Coordenada(2,9), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla7 = new CasillaCamino(new Coordenada(2,6), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla8final = new CasillaFinal(new Coordenada(2,7));

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
        listaCasillas.add(casilla1inicio);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        listaCasillas.add(casilla4);
        listaCasillas.add(casilla5);
        listaCasillas.add(casilla6);
        listaCasillas.add(casilla7);
        listaCasillas.add(casilla8final);

        ValidadorDeCamino validador = new ValidadorDeCamino();

        assertThrows(CaminoDiscontinuoException.class, () -> {
            validador.validarCamino(listaCasillas);
        });
    }

    @Test
    public void test06CreoUnCaminoConFormatoCorrectoNoReciboExcepcion() {

        iCasilla casilla1inicio = new CasillaInicio(new Coordenada(1,1), null);
        iCasilla casilla2 = new CasillaCamino(new Coordenada(1,2), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla3 = new CasillaCamino(new Coordenada(1,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla4 = new CasillaCamino(new Coordenada(2,3), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla5 = new CasillaCamino(new Coordenada(2,4), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla6 = new CasillaCamino(new Coordenada(2,5), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla7 = new CasillaCamino(new Coordenada(2,6), null, new ObstaculoNulo(), new PremioNulo());
        iCasilla casilla8final = new CasillaFinal(new Coordenada(2,7));

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
        listaCasillas.add(casilla1inicio);
        listaCasillas.add(casilla2);
        listaCasillas.add(casilla3);
        listaCasillas.add(casilla4);
        listaCasillas.add(casilla5);
        listaCasillas.add(casilla6);
        listaCasillas.add(casilla7);
        listaCasillas.add(casilla8final);

        ValidadorDeCamino validador = new ValidadorDeCamino();

        validador.validarCamino(listaCasillas);

    }


}
