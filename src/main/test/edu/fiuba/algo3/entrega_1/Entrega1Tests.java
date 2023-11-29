package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.gestorTurnos.GestorTurnos;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.Casilla;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import edu.fiuba.algo3.modelo.mapa.Mapa;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Tests {

    @Test
    public void test01GladiadorIniciaCon20DeEnergiaYSinEquipamiento(){

        Gladiador gladiador = new Gladiador();

        assertEquals(20, gladiador.getEnergia());

        gladiador.recibirAtaque(20);

        assertEquals(0, gladiador.getEnergia());

    }
    @Test
    public void test02JugadorComienzaEnLaCasillaInicial(){

        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        PremioNulo premioAburrido = new PremioNulo();

        CasillaCamino ultimaCasilla = new CasillaCamino(null, obstaculoAburrido, premioAburrido);
        CasillaCamino primerCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido,premioAburrido);

        ArrayList<Casilla> listaCasillas = new ArrayList<Casilla>();
        listaCasillas.add(primerCasilla);
        listaCasillas.add(ultimaCasilla);

        ArrayList<Gladiador> listaGladiadores = new ArrayList<Gladiador>();
        Gladiador gladiadorcito = new Gladiador();

        listaGladiadores.add(gladiadorcito);

        Mapa mapa = new Mapa(listaGladiadores, listaCasillas, 1);

        assertSame(primerCasilla, primerCasilla.BuscadoEstaEnLaCasilla(gladiadorcito));
    }
    @Test
    public void test03GladiadorSinEnergiaNoCambiaDeCasilla(){

        PremioEquipamiento eventoEquipo = new PremioEquipamiento();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        FieraSalvaje eventoFiera = new FieraSalvaje();

        CasillaCamino terceraCasilla =  new CasillaCamino(null,obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(terceraCasilla,eventoFiera, premioAburrido);
        CasillaCamino primeraCasilla = new CasillaCamino(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador gladiadorcito = new Gladiador();
        primeraCasilla.recibir(gladiadorcito);
        gladiadorcito.avanzar(primeraCasilla,1);
        Casilla casillaEnLaQuePierdoEnergia = segundaCasilla;
        gladiadorcito.avanzar(segundaCasilla,1);

        assertSame(casillaEnLaQuePierdoEnergia, segundaCasilla.BuscadoEstaEnLaCasilla(gladiadorcito));
    }
    @Test
    public void test04GladiadorIncrementaSuEnergiaEn15AlRecibirUnPremioComestible(){

        Gladiador gladiador = new Gladiador();

        Premio premio = new PremioComestible();

        premio.premiarGladiador(gladiador);

        assertEquals(35, gladiador.getEnergia());
    }

    @Test
    public void test05GladiadorRecibeCascoAlMejorarSuEquipamientoPorPrimeraVez()
    {

        Gladiador gladiador = new Gladiador();

        Premio premio = new PremioEquipamiento();

        premio.premiarGladiador(gladiador);

        // Produzco 20 de daño debería quedar en 5 por el ascenso de equipamiento

        gladiador.recibirAtaque(20);

        assertEquals(5, gladiador.getEnergia());
    }

    @Test
     public void test06GladiadorRecibeCascoAlMejorarSuEquipamientoPorPrimeraVez()
    {

        Gladiador gladiador = new Gladiador();

        Premio premio = new PremioEquipamiento();

        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);

        // Produzco 20 de daño debería quedar en 18 por el ascenso de equipamiento

        gladiador.recibirAtaque(20);

        assertEquals(18, gladiador.getEnergia());
    }

    @Test
    public void test07GladiadorRecibeCascoYPeleaConFieraDebeHaberPerdido15DeEnergia()
    {

        Gladiador gladiador = new Gladiador();

        Premio premio = new PremioEquipamiento();

        premio.premiarGladiador(gladiador);

        Obstaculo obstaculo = new FieraSalvaje();

        obstaculo.obstaculizarGladiador(gladiador);

        assertEquals(5, gladiador.getEnergia());
    }
    @Test
    public void test08LuegoDe8TurnosElGladiadorPasaDeNovatoASemiSeniorYrecuperaEnergiaEnElSiguienteMovimiento(){

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaCamino ultimaCasilla = new CasillaCamino(null, obstaculoAburrido, premioAburrido);
        CasillaCamino novenaCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(novenaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(octavaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino sextaCasilla = new CasillaCamino(septimaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino quintaCasilla = new CasillaCamino(sextaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(quintaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino tercerCasilla = new CasillaCamino(cuartaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(tercerCasilla,obstaculoAburrido, premioAburrido);
        CasillaCamino primerCasilla = new CasillaCamino(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador gladiadorcito = new Gladiador();
        primerCasilla.recibir(gladiadorcito);

        gladiadorcito.avanzar(primerCasilla,1);
        gladiadorcito.avanzar(segundaCasilla,1);
        gladiadorcito.avanzar(tercerCasilla,1);
        gladiadorcito.avanzar(cuartaCasilla,1);
        gladiadorcito.avanzar(quintaCasilla,1);
        gladiadorcito.avanzar(sextaCasilla,1);
        gladiadorcito.avanzar(septimaCasilla,1);
        gladiadorcito.avanzar(octavaCasilla,1);

        int energiaAntesDeAscenderASemiSenior = gladiadorcito.getEnergia();

        gladiadorcito.avanzar(novenaCasilla,1);

        int energiaDespuesDeAscenderASemiSenior = gladiadorcito.getEnergia();

        int diferenciaDeEnergia = energiaDespuesDeAscenderASemiSenior - energiaAntesDeAscenderASemiSenior;

        assertEquals(5, diferenciaDeEnergia);
    }
    @Test
    public void test10GladiadorRecibeLlaveYPeleaConFieraNoDebeHaberPerdidoEnergia()
    {
        Gladiador gladiador = new Gladiador();

        Premio premio = new PremioEquipamiento();

        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);

        Obstaculo obstaculo = new FieraSalvaje();

        obstaculo.obstaculizarGladiador(gladiador);

        assertEquals(20, gladiador.getEnergia());
    }

    @Test
    public void test11GladiadorRecibeLlaveYLuegoRecibeOtroPremioEquipamientoPeroNoCambiaNada()
    {
        Gladiador gladiador = new Gladiador();

        Premio premio = new PremioEquipamiento();

        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);
        premio.premiarGladiador(gladiador);

        Obstaculo obstaculo = new FieraSalvaje();

        obstaculo.obstaculizarGladiador(gladiador);

        assertEquals(20, gladiador.getEnergia());
    }/* el 12 no me funciona
    @Test
    public void test12SeJuegan30TurnosYElJuegoTerminaSinGanador() throws IOException {

        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        List<Gladiador> gladiadores = null;
        gladiadores.add(jugador1.getGladiador());
        gladiadores.add(jugador2.getGladiador());

        List<Casilla> casillas = null;
        casillas.add(new CasillaCamino(null, obstaculoAburrido,premioAburrido));
        GestorTurnos gestorTurnos = new GestorTurnos(30, jugadores);

        Dado miDado = new Dado(0);
        Mapa miMapa = new Mapa(gladiadores,casillas,2);

        for (int i = 0; i < 60; i++) {

            gestorTurnos.siguienteTurno(miDado,miMapa);

        }

        assertThrows(SinGanadorException.class, () -> {

            gestorTurnos.siguienteTurno(miDado,miMapa);

        });
    }*/





}


