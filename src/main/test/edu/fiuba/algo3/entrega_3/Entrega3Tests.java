package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.FieraSalvaje;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Lesion;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.gestorTurnos.GestorTurnos;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.iJugador;
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
        CasillaCamino novenaCasilla = new CasillaCamino(null,ultimaCasilla, obstaculoAburrido, premio);
        CasillaCamino octavaCasilla = new CasillaCamino(null,novenaCasilla, obstaculoAburrido, premio);
        CasillaCamino septimaCasilla = new CasillaCamino(null,octavaCasilla, obstaculoAburrido, premio);
        CasillaCamino sextaCasilla = new CasillaCamino(null,septimaCasilla, obstaculoAburrido, premio);
        CasillaCamino quintaCasilla = new CasillaCamino(null,sextaCasilla, obstaculoAburrido, premio);
        CasillaCamino cuartaCasilla = new CasillaCamino(null,quintaCasilla, obstaculoAburrido, premio);
        CasillaCamino tercerCasilla = new CasillaCamino(null,cuartaCasilla, obstaculoAburrido, premio);
        CasillaCamino segundaCasilla = new CasillaCamino(null,tercerCasilla,obstaculoAburrido, premio);
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

        Jugador jugador1 = new Jugador("mip", 1);
        List<iJugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Gladiador> gladiador = new ArrayList<>();
        Gladiador gladiadorcito1 = jugador1.getGladiador();
        gladiador.add(gladiadorcito1);
        Mapa mapa = new Mapa(1,1);
        mapa.agregarCamino(casillas);
        mapa.ingresarGladiadores(gladiador, 1);
        Dado dado = new Dado(1);

        GestorTurnos gestor = new GestorTurnos(30, jugadores);
        Juego.resetInstancia();
        Juego juego = Juego.instanciarJuego(mapa, dado, gestor);

        for (int i = 0; i < 9; i++) {
            juego.siguienteTurno();
            juego.tirarDado();
        }
        juego.siguienteTurno();
        assertNotNull(juego.tirarDado());
    }

    @Test
    public void test02JugadorPierdeUnaPartida(){
        Juego.resetInstancia();

        PremioNulo premioAburrido = new PremioNulo();
        ObstaculoNulo obstaculoAburrido = new ObstaculoNulo();
        Premio comida = new PremioComestible();
        Obstaculo fiera = new FieraSalvaje();
        Obstaculo Lesion = new Lesion();

        CasillaFinal ultimaCasilla = new CasillaFinal(null);
        CasillaCamino novenaCasilla = new CasillaCamino(null,ultimaCasilla, fiera, premioAburrido);
        CasillaCamino octavaCasilla = new CasillaCamino(null,novenaCasilla, Lesion, premioAburrido);
        CasillaCamino septimaCasilla = new CasillaCamino(null,octavaCasilla, fiera, comida);
        CasillaCamino sextaCasilla = new CasillaCamino(null,septimaCasilla, obstaculoAburrido, comida);
        CasillaCamino quintaCasilla = new CasillaCamino(null,sextaCasilla, Lesion, premioAburrido);
        CasillaCamino cuartaCasilla = new CasillaCamino(null,quintaCasilla, Lesion, comida);
        CasillaCamino tercerCasilla = new CasillaCamino(null,cuartaCasilla, obstaculoAburrido, premioAburrido);
        CasillaCamino segundaCasilla = new CasillaCamino(null,tercerCasilla,obstaculoAburrido, premioAburrido);
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

        Jugador jugador1 = new Jugador("tip", 1);
        List<iJugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        List<Gladiador> gladiador = new ArrayList<>();
        Gladiador gladiadorcito1 = jugador1.getGladiador();
        gladiador.add(gladiadorcito1);
        Mapa mapa = new Mapa(1,1);
        mapa.agregarCamino(casillas);
        mapa.ingresarGladiadores(gladiador, 1);
        Dado dado = new Dado(1);

        GestorTurnos gestor = new GestorTurnos(30, jugadores);
        Juego.resetInstancia();
        Juego juego = Juego.instanciarJuego(mapa, dado, gestor);


        for (int i = 0; i < 30; i++) {
            juego.siguienteTurno();
            juego.tirarDado();
        }

        assertThrows(SinGanadorException.class, juego::siguienteTurno);
    }

}
