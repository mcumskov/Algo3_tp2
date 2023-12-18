package edu.fiuba.algo3.UnitTests;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Coordenada;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaUnitTests {

    @Test
    public void test01CasillaRecibeUnGladiadorCorrectamente(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino primeraCasilla = new CasillaCamino(null,null,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador(1);
        primeraCasilla.recibir(dummy);
        iCasilla casillaObtenida = primeraCasilla.buscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, primeraCasilla);
    }
    @Test
    public void test02CasillaExpulsaUnGladiadorCorrectamente(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino primeraCasilla = new CasillaCamino(null,null,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador(1);
        primeraCasilla.recibir(dummy);
        iCasilla casillaObtenida = primeraCasilla.buscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, primeraCasilla);
        primeraCasilla.expulsar(dummy);
        assertNull(primeraCasilla.buscadoEstaEnLaCasilla(dummy));
    }

    @Test
    public void test03CasillasEncuentraSuSiguienteYMueveGladiador1Paso(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino ultimaCasilla = new CasillaCamino(null,null,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,ultimaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(null,segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador(1);
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(1,dummy);
        iCasilla casillaObtenida = segundaCasilla.buscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, segundaCasilla);
    }
    @Test
    public void test04CasillasEncuentraSuSiguienteYMueveGladiador10Pasos(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino doceCasilla = new CasillaCamino(null,null,obstaculoAburrido, premioAburrido);
        CasillaCamino onceCasilla = new CasillaCamino(null,doceCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino decimaCasilla = new CasillaCamino(null,onceCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino novenaCasilla = new CasillaCamino(null,decimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(null,novenaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(null,octavaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino sextaCasilla = new CasillaCamino(null,septimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino quintaCasilla = new CasillaCamino(null,sextaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(null,quintaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino terceraCasilla = new CasillaCamino(null,cuartaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,terceraCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(null,segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador(1);
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(10,dummy);
        iCasilla casillaObtenida = onceCasilla.buscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, onceCasilla);
    }

    @Test
    public void test05CasillasEncuentraSuSiguienteYMueveGladiador100PasosYpermaneceEnLaUltima(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino ultimaCasilla = new CasillaCamino(null,null,obstaculoAburrido, premioAburrido);
        CasillaCamino onceCasilla = new CasillaCamino(null,ultimaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino decimaCasilla = new CasillaCamino(null,onceCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino novenaCasilla = new CasillaCamino(null,decimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(null,novenaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(null,octavaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino sextaCasilla = new CasillaCamino(null,septimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino quintaCasilla = new CasillaCamino(null,sextaCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(null,quintaCasilla,obstaculoAburrido,premioAburrido);
        CasillaCamino terceraCasilla = new CasillaCamino(null,cuartaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,terceraCasilla, obstaculoAburrido,premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(null,segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador(1);
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(100,dummy);
        iCasilla casillaObtenida = ultimaCasilla.buscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, ultimaCasilla);
    }

    @Test
    public void test06InstancioCasillasConCoordenadasNoContinuasYReciboQueNoSonContinuas(){

        CasillaCamino casilla1 = new CasillaCamino(new Coordenada(1,1), null, new ObstaculoNulo(), new PremioNulo());
        CasillaCamino casilla2 = new CasillaCamino(new Coordenada(5,12), null, new ObstaculoNulo(), new PremioNulo());

        assertFalse(casilla1.esContigua(casilla2));
    }

    @Test
    public void test07InstancioCasillasConCoordenadasContinuasYReciboQueSonContinuas(){

        CasillaCamino casilla1 = new CasillaCamino(new Coordenada(1,1), null, new ObstaculoNulo(), new PremioNulo());
        CasillaCamino casilla2 = new CasillaCamino(new Coordenada(2,1), null, new ObstaculoNulo(), new PremioNulo());

        assertTrue(casilla1.esContigua(casilla2));
    }

}
