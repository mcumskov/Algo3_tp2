package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.evento.EventoEquipamiento;
import edu.fiuba.algo3.modelo.evento.EventoFiera;
import edu.fiuba.algo3.modelo.evento.EventoNulo;
import edu.fiuba.algo3.modelo.evento.EventoPompeya;
import edu.fiuba.algo3.modelo.evento.EventoLesion;
import edu.fiuba.algo3.modelo.evento.EventoComida;
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

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoEquipo);
        Casilla primerCasilla = new Casilla(ultimaCasilla, eventoAburrido);

        Gladiador dummy = new Gladiador(primerCasilla);

        Equipamiento equipoPreEvento = dummy.getEquipamiento();

        dummy.avanzar(1);

        Equipamiento equipoPostEvento = dummy.getEquipamiento();

        assertTrue(equipoPostEvento != equipoPreEvento);
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
}
