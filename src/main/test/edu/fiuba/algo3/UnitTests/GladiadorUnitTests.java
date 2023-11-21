package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.evento.EventoEquipamiento;
import edu.fiuba.algo3.modelo.evento.EventoFiera;
import edu.fiuba.algo3.modelo.evento.EventoNulo;
import edu.fiuba.algo3.modelo.evento.EventoPompeya;
import edu.fiuba.algo3.modelo.evento.EventoLesion;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GladiadorUnitTests {

    @Test
    public void test01GladiadorPasaDeCasilla1ACasilla2(){

        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);

        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoAburrido);

        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoAburrido);

        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);

        Casilla casillaDeLlegada = gladiadorLoco.getCasilla();

        assertTrue(casillaDeLlegada == segundaCasilla);
    }

    @Test
    public void test02GladiadorSacaUn6yLlegaALaCasillaCorrecta(){

        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);

        Casilla septimaCasilla = new Casilla(ultimaCasilla, eventoAburrido);

        Casilla sextaCasilla = new Casilla(septimaCasilla, eventoAburrido);

        Casilla quintaCasilla = new Casilla(sextaCasilla, eventoAburrido);

        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoAburrido);

        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoAburrido);

        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoAburrido);

        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(6);

        Casilla casillaDeLlegada = gladiadorLoco.getCasilla();

        assertTrue(casillaDeLlegada == septimaCasilla);

    }

    @Test
    public void test03GladiadorDesnudoSeQuedaSinEnergiaAlPelearConFiera(){

        EventoFiera eventoCombate = new EventoFiera();
        EventoNulo eventoAburrido = new EventoNulo();


        Casilla ultimaCasilla = new Casilla(null, eventoCombate);

        Casilla primerCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);

        int energiaPostPelea = gladiadorLoco.getEnergia();

        assertEquals(0, energiaPostPelea);
    }


    @Test
    public void test04GladiadorDesnudoGanaCascoEnelEventoCorrespondienteYPuedeAvanzarLuegoDeLuchaAlContrarioDelGladiadorQueNoPuedePorqueNoRecibioCasco(){

        EventoFiera eventoFiera = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla cuartaCasilla = new Casilla(null, eventoAburrido);
        Casilla terceraCasilla = new Casilla(cuartaCasilla, eventoFiera);
        Casilla segundaCasilla = new Casilla(terceraCasilla, eventoEquipo);
        Casilla primeraCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorRecontraMamadisimo = new Gladiador(primeraCasilla);
        Gladiador gladiadorDesnudo = new Gladiador(primeraCasilla);

        gladiadorRecontraMamadisimo.avanzar(1); // recibe casco
        gladiadorRecontraMamadisimo.avanzar(1); // pelea

        gladiadorDesnudo.avanzar(2); // pelea

        gladiadorRecontraMamadisimo.avanzar(1);// puede avanzar
        gladiadorDesnudo.avanzar(1); // no puede avnazar

        assertTrue(gladiadorRecontraMamadisimo.getCasilla() != gladiadorDesnudo.getCasilla() );
    }

    @Test
    public void test05GladiadorConCascoGanaArmaduraYluchaConFiera(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        int energiaPostPelea = gladiadorLoco.getEnergia();
        assertEquals(10, energiaPostPelea);
    }

    @Test
    public void test06GladiadorConArmaduraGanaEscudoEspadaYluchaConFiera(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla cuartaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        int energiaPostPelea = gladiadorLoco.getEnergia();
        assertEquals(18, energiaPostPelea);
    }

    @Test
    public void test07GladiadorConEscudoEspadaGanaLlaveYluchaConFiera(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla quintaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        int energiaPostPelea = gladiadorLoco.getEnergia();
        assertEquals(20, energiaPostPelea);
    }

    @Test
    public void test08GladiadorConEscudoEspadaNoAbrePompeya(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoPompeya eventoPompeya = new EventoPompeya();

        Casilla ultimaCasilla = new Casilla(null, eventoPompeya);
        Casilla cuartaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        assertFalse(gladiadorLoco.getGanador());
    }

    @Test
    public void test09GladiadorConLlaveAbrePompeya(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoPompeya eventoPompeya = new EventoPompeya();

        Casilla ultimaCasilla = new Casilla(null, eventoPompeya);
        Casilla quintaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        assertTrue(gladiadorLoco.getGanador());
    }

    @Test
    public void test10GladiadorSinEnergiaNoCambiaDeCasilla(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        Casilla casillaEnLaQuePierdoEnergia = gladiadorLoco.getCasilla();
        gladiadorLoco.avanzar(1);
        Casilla casillaPostIntentoDeMovimientoSinEnergia = gladiadorLoco.getCasilla();

        assertSame(casillaEnLaQuePierdoEnergia, casillaPostIntentoDeMovimientoSinEnergia);
    }
    @Test
    public void test11GladiadorSeLesionaPierdeUnTurnoYDespPuedeSeguirJugando(){

        EventoLesion eventoLesion = new EventoLesion();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, eventoLesion);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);

        gladiadorLoco.avanzar(1);
        Casilla casillaEnLaQueSeLesiona = gladiadorLoco.getCasilla();
        gladiadorLoco.avanzar(1);
        Casilla casillaPostIntentoDeMovimientoLesionado = gladiadorLoco.getCasilla();

        assertSame(casillaEnLaQueSeLesiona, casillaPostIntentoDeMovimientoLesionado);

        gladiadorLoco.avanzar(1);

        Casilla casillaPostRecuperacion = gladiadorLoco.getCasilla();

        assertSame(ultimaCasilla, casillaPostRecuperacion);
    }

    @Test
    public void test12GladiadorNovatoAsciendeYrecuperaEnergiaEnElSiguienteMovimiento(){

        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla novenaCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, eventoAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla, eventoAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla, eventoAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, eventoAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoAburrido);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoAburrido);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorLoco = new Gladiador(primerCasilla);
        Seniority seniorityNovato = gladiadorLoco.getSeniority();

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        Seniority senioritySemiSenior = gladiadorLoco.getSeniority();

        assertNotSame(seniorityNovato, senioritySemiSenior);

        gladiadorLoco.avanzar(1);
        int energiaPostAscenso = gladiadorLoco.getEnergia();

        assertEquals(25, energiaPostAscenso);
    }

    @Test
    public void test13GladiadorConEscudoEspadaNoAbrePompeyaYvaALaMitadDelMapa(){

        Mapa mapa = Mapa.getMapa();

        Gladiador gladiadorLoco = new Gladiador(mapa.getPrimeraCasilla());

        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);
        gladiadorLoco.avanzar(1);

        assertSame(gladiadorLoco.getCasilla(), mapa.getMitadDeCamino());

    }

}