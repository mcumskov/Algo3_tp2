package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.evento.*;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.turnos.GestorTurnos;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Tests {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoCombate);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        assertEquals(20, gladiadorcito.getEnergia());

        gladiadorcito.avanzar(1);

        assertEquals(0, gladiadorcito.getEnergia());
    }

    @Test
    public void test02JugadorComienzaEnLaCasillaInicial(){

        Mapa mapa = Mapa.getMapa();

        Gladiador gladiadorcito = new Gladiador();

        assertSame(mapa.getPrimeraCasilla(), gladiadorcito.getCasilla());

    }
    @Test
    public void test03GladiadorSinEnergiaNoCambiaDeCasilla(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        Casilla casillaEnLaQuePierdoEnergia = gladiadorcito.getCasilla();
        gladiadorcito.avanzar(1);
        Casilla casillaPostIntentoDeMovimientoSinEnergia = gladiadorcito.getCasilla();

        assertSame(casillaEnLaQuePierdoEnergia, casillaPostIntentoDeMovimientoSinEnergia);
    }
    @Test
    public void test04EventoComidaIncrementaEnergia(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoComida eventoComida = new EventoComida();

        Casilla ultimaCasilla = new Casilla(null, eventoComida);
        Casilla primerCasilla = new Casilla(ultimaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);

        assertEquals(35, gladiadorcito.getEnergia());
    }
    @Test
    public void test05SeRecibePremioPorPrimeraVezYGladiadorRecibeCasco(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        // al combarit con una fiera y teniendo casco, debe quedar con 5 energia
        assertEquals(5, gladiadorcito.getEnergia());
    }
    @Test
    public void test06SeRecibePremioPorTerceraVezYGladiadorRecibeEscudoEspada(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla cuartaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        // al combarit con una fiera y teniendo EscudoYEspada, debe quedar con 18 energia
        assertEquals(18, gladiadorcito.getEnergia());
    }
    @Test
    public void test07SePeleaConFieraConCascoYSePierdeLaEnergiaCorrespondiente(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        // al combarit con una fiera y teniendo casco, debe quedar con 5 energia
        assertEquals(5, gladiadorcito.getEnergia());
    }
    @Test
    public void test08LuegoDe8TurnosElGladiadorPasaDeNovatoASemiSeniorYrecuperaEnergiaEnElSiguienteMovimiento(){

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

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);

        int energiaAntesDeAscenderASemiSenior = gladiadorcito.getEnergia();

        gladiadorcito.avanzar(1);

        int energiaDespuesDeAscenderASemiSenior = gladiadorcito.getEnergia();

        int diferenciaDeEnergia = energiaDespuesDeAscenderASemiSenior - energiaAntesDeAscenderASemiSenior;

        assertEquals(5, diferenciaDeEnergia);
    }

    @Test
    public void test09GladiadorConEscudoEspadaNoAbrePompeyaYvaALaMitadDelMapa(){

        Mapa mapa = Mapa.getMapa();

        Gladiador gladiadorcito = new Gladiador(mapa.getPrimeraCasilla());

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);

        assertSame(gladiadorcito.getCasilla(), mapa.getMitadDeCamino());

    }

    @Test
    public void test10GladiadorConTodoElEquipamientoNoRecibeDanioDeLaFiera(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla quintaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        int energiaPrePelea = gladiadorcito.getEnergia();
        gladiadorcito.avanzar(1);

        int energiaPostPelea = gladiadorcito.getEnergia();
        assertEquals(energiaPrePelea, energiaPostPelea);
    }
    @Test
    public void test11GladiadorConLlaveRecibePremioPeroNoCambiaNada(){

        EventoFiera eventoFiera = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla septimaCasilla = new Casilla(null, eventoFiera);
        Casilla sextaCasilla = new Casilla(septimaCasilla, eventoEquipo);
        Casilla quintaCasilla = new Casilla(sextaCasilla, eventoEquipo);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito1 = new Gladiador(primerCasilla);
        Gladiador gladiadorcito2 = new Gladiador(primerCasilla);

        for (int i = 0; i < 4; i++) {

            gladiadorcito1.avanzar(1);
            gladiadorcito2.avanzar(1);

        }

        gladiadorcito1.avanzar(1); // recibe un evento equipamiento más que gladiadorcito2
        gladiadorcito1.avanzar(1); // pelea

        gladiadorcito2.avanzar(2); // pelea

        assertSame(gladiadorcito1.getEnergia(), gladiadorcito2.getEnergia());
    }

    @Test
    public void test12SeJuegan30TurnosYElJuegoTerminaSinGanador(){

        Juego juego = Juego.getJuego();

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        GestorTurnos gestorTurnos = new GestorTurnos(30, jugadores);

        for (int i = 0; i < 60; i++) {

            gestorTurnos.siguienteTurno();

        }

        assertThrows(SinGanadorException.class, () -> {

            gestorTurnos.siguienteTurno();

        });
    }
}


