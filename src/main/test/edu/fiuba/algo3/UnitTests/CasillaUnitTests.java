package edu.fiuba.algo3.UnitTests;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Casilla;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import edu.fiuba.algo3.modelo.mapa.CasillaFinal;
import edu.fiuba.algo3.modelo.mapa.CasillaInicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CasillaUnitTests {

    @Test
    public void test01CasillaRecibeUnGladiadorCorrectamente(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaInicio primeraCasilla = new CasillaInicio(null,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        Casilla casillaObtenida = primeraCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, primeraCasilla);
    }
    @Test
    public void test02CasillaExpulsaUnGladiadorCorrectamente(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaInicio primeraCasilla = new CasillaInicio(null,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        Casilla casillaObtenida = primeraCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, primeraCasilla);
        primeraCasilla.expulsar(dummy);
        assertNull(primeraCasilla.BuscadoEstaEnLaCasilla(dummy));
    }

    @Test
    public void test03CasillasEncuentraSuSiguienteYMueveGladiador1Paso(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaFinal ultimaCasilla = new CasillaFinal(null,obstaculoAburrido, premioAburrido);

        CasillaCamino segundaCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido,premioAburrido);

        CasillaInicio primeraCasilla = new CasillaInicio(segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(1,dummy);
        Casilla casillaObtenida = segundaCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, segundaCasilla);
    }
    @Test
    public void test04CasillasEncuentraSuSiguienteYMueveGladiador10Pasos(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaFinal doceCasilla = new CasillaFinal(null,obstaculoAburrido, premioAburrido);
        CasillaCamino onceCasilla = new CasillaCamino(doceCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino decimaCasilla = new CasillaCamino(onceCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino novenaCasilla = new CasillaCamino(decimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(novenaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(octavaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino sextaCasilla = new CasillaCamino(septimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino quintaCasilla = new CasillaCamino(sextaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(quintaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino terceraCasilla = new CasillaCamino(cuartaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla, obstaculoAburrido,premioAburrido);
        CasillaInicio primeraCasilla = new CasillaInicio(segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(10,dummy);
        Casilla casillaObtenida = onceCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, onceCasilla);
    }

    @Test
    public void test05CasillasEncuentraSuSiguienteYMueveGladiador100PasosYpermaneceEnLaUltima(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaFinal ultimaCasilla = new CasillaFinal(null,obstaculoAburrido, premioAburrido);
        CasillaCamino onceCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino decimaCasilla = new CasillaCamino(onceCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino novenaCasilla = new CasillaCamino(decimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(novenaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(octavaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino sextaCasilla = new CasillaCamino(septimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino quintaCasilla = new CasillaCamino(sextaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(quintaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino terceraCasilla = new CasillaCamino(cuartaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla, obstaculoAburrido,premioAburrido);
        CasillaInicio primeraCasilla = new CasillaInicio(segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(100,dummy);
        Casilla casillaObtenida = ultimaCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, ultimaCasilla);
    }

}
