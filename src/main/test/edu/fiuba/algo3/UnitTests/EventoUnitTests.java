package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.evento.*;
import edu.fiuba.algo3.modelo.evento.EventoLesion;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertSame;

public class EventoUnitTests {

    @Test
    public void test01EventoComidaIncrementaEnergia(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoComida eventoComida = new EventoComida();

        Casilla ultimaCasilla = new Casilla(null, eventoComida);
        Casilla primerCasilla = new Casilla(ultimaCasilla, eventoAburrido);

        Gladiador dummy = new Gladiador(primerCasilla);

        dummy.avanzar(1);

        assertEquals(35, dummy.getEnergia());
    }

    @Test
    public void test02EventoEquipamientoCambiaElEquipoDelGladiador(){

        EventoFiera eventoFiera = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla terceraCasilla =  new Casilla(null, eventoFiera);
        Casilla segundaCasilla = new Casilla(terceraCasilla, eventoEquipo);
        Casilla primeraCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador dummyEquipado = new Gladiador(primeraCasilla);
        Gladiador dummyDesnudo =  new Gladiador(primeraCasilla);

        dummyEquipado.avanzar(1);
        dummyEquipado.avanzar(1);

        dummyDesnudo.avanzar(2);

        assertTrue(dummyEquipado.getEnergia() != dummyDesnudo.getEnergia());

    }
    @Test
    public void test03EventoFieraQuitaEnergiaAlGladiador(){

        EventoFiera eventoCombate = new EventoFiera();
        EventoNulo eventoAburrido = new EventoNulo();


        Casilla ultimaCasilla = new Casilla(null, eventoCombate);

        Casilla primerCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Gladiador dummy = new Gladiador(primerCasilla);

        dummy.avanzar(1);

        int energiaPostPelea = dummy.getEnergia();

        assertEquals(0, energiaPostPelea);
    }
    @Test
    public void test04EventoLesionSalteaTurnoYluegoPosibilitaMovimiento(){

        EventoLesion eventoLesion = new EventoLesion();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, eventoLesion);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador dummy = new Gladiador(primerCasilla);

        dummy.avanzar(1);
        Casilla casillaEnLaQueSeLesiona = dummy.getCasilla();
        dummy.avanzar(1);
        Casilla casillaPostIntentoDeMovimientoLesionado = dummy.getCasilla();

        assertSame(casillaEnLaQueSeLesiona, casillaPostIntentoDeMovimientoLesionado);

        dummy.avanzar(1);

        Casilla casillaPostRecuperacion = dummy.getCasilla();

        assertSame(ultimaCasilla, casillaPostRecuperacion);
    }
    @Test
    public void test05EventoBacanalRestaEnergia(){

        EventoBacanal eventoBacanal = new EventoBacanal();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, eventoBacanal);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador dummy = new Gladiador(primerCasilla);
        int energiaPreBorrachera = dummy.getEnergia();
        dummy.avanzar(1);
        int energiaPostBorrachera = dummy.getEnergia();

        assertTrue(energiaPreBorrachera > energiaPostBorrachera);
    }
}
