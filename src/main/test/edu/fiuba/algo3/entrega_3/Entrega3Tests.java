package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Lesion;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.mapa.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega3Tests {
    @Test
    public void test01JugadorGanaUnaPartida(){
        Juego.resetInstancia();

        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        Premio premio = new PremioEquipamiento();

        CasillaFinal ultimaCasilla = new CasillaFinal(null);
        CasillaCamino novenaCasilla = new CasillaCamino(ultimaCasilla, obstaculoAburrido, premio);
        CasillaCamino octavaCasilla = new CasillaCamino(novenaCasilla, obstaculoAburrido, premio);
        CasillaCamino septimaCasilla = new CasillaCamino(octavaCasilla, obstaculoAburrido, premio);
        CasillaCamino sextaCasilla = new CasillaCamino(septimaCasilla, obstaculoAburrido, premio);
        CasillaCamino quintaCasilla = new CasillaCamino(sextaCasilla, obstaculoAburrido, premio);
        CasillaCamino cuartaCasilla = new CasillaCamino(quintaCasilla, obstaculoAburrido, premio);
        CasillaCamino tercerCasilla = new CasillaCamino(cuartaCasilla, obstaculoAburrido, premio);
        CasillaCamino segundaCasilla = new CasillaCamino(tercerCasilla,obstaculoAburrido, premio);
        CasillaInicio primerCasilla = new CasillaInicio(null, segundaCasilla);

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

        Jugador jugador1 = new Jugador("mip");
        Jugador jugador2 = new Jugador("tip");
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        List<Gladiador> gladiador = new ArrayList<>();
        Gladiador gladiadorcito1 = jugador1.getGladiador();
        Gladiador gladiadorcito2 = jugador2.getGladiador();
        gladiador.add(gladiadorcito1);
        gladiador.add(gladiadorcito2);
        Mapa mapa = new Mapa(gladiador, casillas, 2);

        Juego juego = Juego.instanciarJuego(mapa,jugadores);



        assertNotNull(juego.iniciarPartida());
    }

    @Test
    public void test02JugadorPierdeUnaPartida(){
        Juego.resetInstancia();

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        Premio premio = new PremioEquipamiento();
        Premio comida = new PremioComestible();
        Obstaculo fiera = new FieraSalvaje();
        Obstaculo Lesion = new Lesion();

        CasillaFinal ultimaCasilla = new CasillaFinal(null);
        CasillaCamino novenaCasilla = new CasillaCamino(ultimaCasilla, fiera, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(novenaCasilla, Lesion, premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(octavaCasilla, fiera, comida);
        CasillaCamino sextaCasilla = new CasillaCamino(septimaCasilla, obstaculoAburrido, comida);
        CasillaCamino quintaCasilla = new CasillaCamino(sextaCasilla, Lesion, premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(quintaCasilla, Lesion, comida);
        CasillaCamino tercerCasilla = new CasillaCamino(cuartaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(tercerCasilla,obstaculoAburrido, premioAburrido);
        CasillaInicio primerCasilla = new CasillaInicio(null, segundaCasilla);

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

        Jugador jugador1 = new Jugador("mip");
        Jugador jugador2 = new Jugador("tip");
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        jugadores.add(jugador2);
        List<Gladiador> gladiador = new ArrayList<>();
        Gladiador gladiadorcito1 = jugador1.getGladiador();
        Gladiador gladiadorcito2 = jugador2.getGladiador();
        gladiador.add(gladiadorcito1);
        gladiador.add(gladiadorcito2);
        Mapa mapa = new Mapa(gladiador, casillas, 2);

        Juego juego = Juego.instanciarJuego(mapa,jugadores);


        assertNull(juego.iniciarPartida());
    }

}