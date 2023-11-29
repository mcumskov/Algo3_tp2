package edu.fiuba.algo3.UnitTests;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.mapa.Casilla;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CasillaUnitTests {

    @Test
    public void test01CasillaRecibeUnGladiadorCorrectamente(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        Casilla primeraCasilla = new Casilla(null,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        iCasilla casillaObtenida = primeraCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, primeraCasilla);
    }
    @Test
    public void test02CasillaExpulsaUnGladiadorCorrectamente(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        Casilla primeraCasilla = new Casilla(null,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        iCasilla casillaObtenida = primeraCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, primeraCasilla);
        primeraCasilla.expulsar(dummy);
        assertNull(primeraCasilla.BuscadoEstaEnLaCasilla(dummy));
    }

    @Test
    public void test03CasillasEncuentraSuSiguienteYMueveGladiador1Paso(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        Casilla ultimaCasilla = new Casilla(null,obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, obstaculoAburrido,premioAburrido);
        Casilla primeraCasilla = new Casilla(segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(1,dummy);
        iCasilla casillaObtenida = segundaCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, segundaCasilla);
    }
    @Test
    public void test04CasillasEncuentraSuSiguienteYMueveGladiador10Pasos(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        Casilla doceCasilla = new Casilla(null,obstaculoAburrido, premioAburrido);
        Casilla onceCasilla = new Casilla(doceCasilla, obstaculoAburrido,premioAburrido);
        Casilla decimaCasilla = new Casilla(onceCasilla,obstaculoAburrido,premioAburrido);
        Casilla novenaCasilla = new Casilla(decimaCasilla,obstaculoAburrido, premioAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, obstaculoAburrido,premioAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla,obstaculoAburrido,premioAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla,obstaculoAburrido, premioAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, obstaculoAburrido,premioAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla,obstaculoAburrido,premioAburrido);
        Casilla terceraCasilla = new Casilla(cuartaCasilla,obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(terceraCasilla, obstaculoAburrido,premioAburrido);
        Casilla primeraCasilla = new Casilla(segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(10,dummy);
        iCasilla casillaObtenida = onceCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, onceCasilla);
    }

    @Test
    public void test05CasillasEncuentraSuSiguienteYMueveGladiador100PasosYpermaneceEnLaUltima(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        Casilla ultimaCasilla = new Casilla(null,obstaculoAburrido, premioAburrido);
        Casilla onceCasilla = new Casilla(ultimaCasilla, obstaculoAburrido,premioAburrido);
        Casilla decimaCasilla = new Casilla(onceCasilla,obstaculoAburrido,premioAburrido);
        Casilla novenaCasilla = new Casilla(decimaCasilla,obstaculoAburrido, premioAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, obstaculoAburrido,premioAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla,obstaculoAburrido,premioAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla,obstaculoAburrido, premioAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, obstaculoAburrido,premioAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla,obstaculoAburrido,premioAburrido);
        Casilla terceraCasilla = new Casilla(cuartaCasilla,obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(terceraCasilla, obstaculoAburrido,premioAburrido);
        Casilla primeraCasilla = new Casilla(segundaCasilla,obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();
        primeraCasilla.recibir(dummy);
        primeraCasilla.moverGladiador(100,dummy);
        iCasilla casillaObtenida = ultimaCasilla.BuscadoEstaEnLaCasilla(dummy);
        assertSame(casillaObtenida, ultimaCasilla);
    }

}
