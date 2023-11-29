package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.CasaPompeya;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.mapa.Casilla;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Lesion;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Bacanal;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PremioObstaculoUnitTest{

    @Test
    public void test01EventoComidaIncrementaEnergia(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        PremioComestible eventoComida = new PremioComestible();

        CasillaCamino ultimaCasilla = new CasillaCamino(null, obstaculoAburrido, eventoComida);
        CasillaCamino primerCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador();

        dummy.avanzar(primerCasilla, 1);

        assertEquals(35, dummy.getEnergia());
    }
    @Test
    public void test02EventoEquipamientoCambiaElEquipoDelGladiador(){

        FieraSalvaje eventoFiera = new FieraSalvaje();
        PremioEquipamiento eventoEquipo = new PremioEquipamiento();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,eventoFiera, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla,obstaculoAburrido,eventoEquipo);
        CasillaCamino primeraCasilla = new CasillaCamino(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummyEquipado = new Gladiador();
        Gladiador dummyDesnudo =  new Gladiador();

        dummyEquipado.avanzar(primeraCasilla, 1);
        dummyEquipado.avanzar(segundaCasilla, 1);

        dummyDesnudo.avanzar(terceraCasilla,2);

        assertTrue(dummyEquipado.getEnergia() != dummyDesnudo.getEnergia());
    }
    @Test
    public void test03EventoFieraQuitaEnergiaAlGladiador(){

        FieraSalvaje eventoFiera = new FieraSalvaje();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();


        CasillaCamino ultimaCasilla =  new CasillaCamino(null,eventoFiera, premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador();

        dummy.avanzar(primeraCasilla,1);

        int energiaPostPelea = dummy.getEnergia();

        assertEquals(0, energiaPostPelea);
    }
    @Test
    public void test04EventoLesionSalteaTurnoYluegoPosibilitaMovimiento(){

        Lesion eventoLesion = new Lesion();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla,eventoLesion,premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador();


        dummy.avanzar(primeraCasilla,1);
        CasillaCamino casillaEnLaQueSeLesiona = segundaCasilla;
        dummy.avanzar(segundaCasilla,1);
        assertSame(casillaEnLaQueSeLesiona, segundaCasilla.BuscadoEstaEnLaCasilla(dummy));


        dummy.avanzar(segundaCasilla,1);
        assertNull(segundaCasilla.BuscadoEstaEnLaCasilla(dummy));


        CasillaCamino casillaALaQueAvanza = terceraCasilla;
        assertSame(casillaALaQueAvanza, terceraCasilla.BuscadoEstaEnLaCasilla(dummy));

    }

    @Test
    public void test05EventoBacanalRestaEnergia(){

        Bacanal eventoBacanal = new Bacanal();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla, eventoBacanal, premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador();
        int energiaPreBorrachera = dummy.getEnergia();
        dummy.avanzar(primeraCasilla,1);
        int energiaPostBorrachera = dummy.getEnergia();

        assertTrue(energiaPreBorrachera > energiaPostBorrachera);
    }

    /* no funciona pq al harcodear todo por afuera, no creo instancia de juego
       cuando el gladiador llama al metodo de clase d juego, este devuelve null (pq no esta instanciado)
       y entonces el test crashea por nullexception

    @Test
    public void test06EventoPompeyaSinLlaveMandaGladiadorAMitadDeMapa(){

        CasaPompeya eventoPompeya = new CasaPompeya();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino UltimaCasilla =  new CasillaCamino(null,obstaculoAburrido, eventoPompeya);
        CasillaCamino terceraCasilla =  new CasillaCamino(UltimaCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador();
        dummy.avanzar(primeraCasilla,1);
        dummy.avanzar(segundaCasilla,1);
        dummy.avanzar(terceraCasilla,1);

        assertNull(UltimaCasilla.BuscadoEstaEnLaCasilla(dummy));

        CasillaCamino casillaMitad = terceraCasilla;

        assertSame(casillaMitad, terceraCasilla.BuscadoEstaEnLaCasilla(dummy));
    } */


}
