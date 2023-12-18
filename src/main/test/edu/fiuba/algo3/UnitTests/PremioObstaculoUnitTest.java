package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Lesion;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Bacanal;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PremioObstaculoUnitTest{

    @Test
    public void test01EventoComidaIncrementaEnergia(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        PremioComestible eventoComida = new PremioComestible();

        CasillaCamino ultimaCasilla = new CasillaCamino(null,null, obstaculoAburrido, eventoComida);
        CasillaCamino primerCasilla = new CasillaCamino(null,ultimaCasilla, obstaculoAburrido,premioAburrido);

        Gladiador dummy = new Gladiador(1);

        dummy.avanzar(primerCasilla, 1);

        assertEquals(35, dummy.getEnergia());
    }
    @Test
    public void test02EventoEquipamientoCambiaElEquipoDelGladiador(){

        FieraSalvaje eventoFiera = new FieraSalvaje();
        PremioEquipamiento eventoEquipo = new PremioEquipamiento();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,null,eventoFiera, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,terceraCasilla,obstaculoAburrido,eventoEquipo);
        CasillaCamino primeraCasilla = new CasillaCamino(null,segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummyEquipado = new Gladiador(1);
        Gladiador dummyDesnudo =  new Gladiador(2);

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


        CasillaCamino ultimaCasilla =  new CasillaCamino(null,null,eventoFiera, premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(null,ultimaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador(1);

        dummy.avanzar(primeraCasilla,1);

        int energiaPostPelea = dummy.getEnergia();

        assertEquals(0, energiaPostPelea);
    }
    @Test
    public void test04EventoLesionSalteaTurnoYluegoPosibilitaMovimiento(){

        Lesion eventoLesion = new Lesion();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,null,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,terceraCasilla,eventoLesion,premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(null,segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador(1);


        dummy.avanzar(primeraCasilla,1);
        CasillaCamino casillaEnLaQueSeLesiona = segundaCasilla;
        dummy.avanzar(segundaCasilla,1);
        assertSame(casillaEnLaQueSeLesiona, segundaCasilla.buscadoEstaEnLaCasilla(dummy));


        dummy.avanzar(segundaCasilla,1);
        assertNull(segundaCasilla.buscadoEstaEnLaCasilla(dummy));


        CasillaCamino casillaALaQueAvanza = terceraCasilla;
        assertSame(casillaALaQueAvanza, terceraCasilla.buscadoEstaEnLaCasilla(dummy));

    }

    @Test
    public void test05EventoBacanalRestaEnergia(){

        Bacanal eventoBacanal = new Bacanal();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,null,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,terceraCasilla, eventoBacanal, premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(null,segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador dummy = new Gladiador(1);
        int energiaPreBorrachera = dummy.getEnergia();
        dummy.avanzar(primeraCasilla,1);
        int energiaPostBorrachera = dummy.getEnergia();

        assertTrue(energiaPreBorrachera > energiaPostBorrachera);
    }

}
