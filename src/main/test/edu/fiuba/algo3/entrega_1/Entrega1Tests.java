package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.CasillaFinal;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.mapa.Casilla;
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

        Casilla ultimaCasilla = new Casilla(null, obstaculoAburrido, premioAburrido);
        Casilla primerCasilla = new Casilla(ultimaCasilla, obstaculoAburrido,premioAburrido);

        ArrayList<iCasilla> listaCasillas = new ArrayList<iCasilla>();
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

        Casilla terceraCasilla =  new Casilla(null,obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(terceraCasilla,eventoFiera, premioAburrido);
        Casilla primeraCasilla = new Casilla(segundaCasilla, obstaculoAburrido, premioAburrido);

        Gladiador gladiadorcito = new Gladiador();
        primeraCasilla.recibir(gladiadorcito);
        gladiadorcito.avanzar(primeraCasilla,1);
        iCasilla casillaEnLaQuePierdoEnergia = segundaCasilla;
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

        Casilla ultimaCasilla = new Casilla(null, obstaculoAburrido, premioAburrido);
        Casilla novenaCasilla = new Casilla(ultimaCasilla, obstaculoAburrido, premioAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, obstaculoAburrido, premioAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla, obstaculoAburrido, premioAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla, obstaculoAburrido, premioAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, obstaculoAburrido, premioAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, obstaculoAburrido, premioAburrido);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,obstaculoAburrido, premioAburrido);
        Casilla primerCasilla = new Casilla(segundaCasilla, obstaculoAburrido, premioAburrido);

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
    public void test09GladiadorConEscudoEspadaNoAbrePompeyaYvaALaMitadDelMapa() throws IOException {

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        CasillaFinal ultimaCasilla = new CasillaFinal(null);
        Casilla novenaCasilla = new Casilla(ultimaCasilla, obstaculoAburrido, premioAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, obstaculoAburrido, premioAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla, obstaculoAburrido, premioAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla, obstaculoAburrido, premioAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, obstaculoAburrido, premioAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, obstaculoAburrido, premioAburrido);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,obstaculoAburrido, premioAburrido);
        Casilla primerCasilla = new Casilla(segundaCasilla, obstaculoAburrido, premioAburrido);

        List<iCasilla> casillas = new ArrayList<>();
        casillas.add(primerCasilla);
        casillas.add(segundaCasilla);
        casillas.add(tercerCasilla);
        casillas.add(cuartaCasilla);
        casillas.add(quintaCasilla);
        casillas.add(sextaCasilla);
        casillas.add(septimaCasilla);
        casillas.add(octavaCasilla);
        casillas.add(novenaCasilla);
        casillas.add(ultimaCasilla);

        Jugador jugador = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        List<Gladiador> gladiador = new ArrayList<>();
        Gladiador gladiadorcito = jugador.getGladiador();
        gladiador.add(jugador.getGladiador());
        Mapa mapa = new Mapa(gladiador, casillas, 1);

        Juego juego = Juego.instanciarJuego(mapa,jugadores);

        novenaCasilla.recibir(gladiadorcito);
        gladiadorcito.avanzar(novenaCasilla, 1);

        assertNull(ultimaCasilla.BuscadoEstaEnLaCasilla(gladiadorcito));
        iCasilla casillaObtenida =  sextaCasilla.BuscadoEstaEnLaCasilla(gladiadorcito);

        assertSame(casillaObtenida, sextaCasilla);
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
    }
    @Test
    public void test12SeJuegan30TurnosYElJuegoTerminaSinGanador() throws IOException {

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();

        Casilla ultimaCasilla = new Casilla(null, obstaculoAburrido, premioAburrido);
        Casilla novenaCasilla = new Casilla(ultimaCasilla, obstaculoAburrido, premioAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, obstaculoAburrido, premioAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla, obstaculoAburrido, premioAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla, obstaculoAburrido, premioAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, obstaculoAburrido, premioAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, obstaculoAburrido, premioAburrido);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, obstaculoAburrido, premioAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,obstaculoAburrido, premioAburrido);
        Casilla primerCasilla = new Casilla(segundaCasilla, obstaculoAburrido, premioAburrido);

        List<iCasilla> casillas = new ArrayList<>();
        casillas.add(primerCasilla);
        casillas.add(segundaCasilla);
        casillas.add(tercerCasilla);
        casillas.add(cuartaCasilla);
        casillas.add(quintaCasilla);
        casillas.add(sextaCasilla);
        casillas.add(septimaCasilla);
        casillas.add(octavaCasilla);
        casillas.add(novenaCasilla);
        casillas.add(ultimaCasilla);

        Jugador jugador = new Jugador();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        List<Gladiador> gladiador = new ArrayList<>();
        Gladiador gladiadorcito = jugador.getGladiador();
        gladiador.add(jugador.getGladiador());
        Mapa mapa = new Mapa(gladiador, casillas, 1);

        Juego juego = Juego.instanciarJuego(mapa,jugadores);

        primerCasilla.recibir(gladiadorcito);

        assertNull(juego.iniciarPartida());

    }





}


