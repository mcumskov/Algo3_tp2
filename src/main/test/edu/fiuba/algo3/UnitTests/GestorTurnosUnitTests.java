package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.iJugador;
import edu.fiuba.algo3.modelo.gestorTurnos.GestorTurnos;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
public class GestorTurnosUnitTests {
    @Test
    public void test01GestorTurnosConUnJugadorJuegaUnaVez() throws IOException {
        ArrayList<iJugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        jugadores.add(jugadorMock);

        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        verify(jugadorMock, times(1)).jugar(dadoMock, mapaMock);
    }
    @Test
    public void test02GestorTurnosConUnJugadorJuegaDosVeces() throws IOException {
        ArrayList<iJugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        jugadores.add(jugadorMock);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        verify(jugadorMock, times(2)).jugar(dadoMock, mapaMock);
    }
    @Test
    public void test03GestorTurnosConUnJugadorJuegaCincoVecesLaSextaDevuelveSinGanadorException() throws SinGanadorException, IOException {
        ArrayList<iJugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        jugadores.add(jugadorMock);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        verify(jugadorMock, times(5)).jugar(dadoMock, mapaMock);
        assertThrows(SinGanadorException.class, () -> gestorTurnos.siguienteTurno(dadoMock, mapaMock));
    }
    @Test
    public void test04GestorTurnosConDosJugadoresJueganUnaVezCadaUno() throws IOException {
        ArrayList<iJugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        Jugador jugadorMock2 = mock(Jugador.class);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        jugadores.add(jugadorMock);
        jugadores.add(jugadorMock2);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        verify(jugadorMock, times(1)).jugar(dadoMock, mapaMock);
        verify(jugadorMock2, times(1)).jugar(dadoMock, mapaMock);
    }
    @Test
    public void test05GestorTurnosConSeisJugadoresJueganUnaVezCadaUno() throws IOException {
        ArrayList<iJugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        Jugador jugadorMock2 = mock(Jugador.class);
        Jugador jugadorMock3 = mock(Jugador.class);
        Jugador jugadorMock4 = mock(Jugador.class);
        Jugador jugadorMock5 = mock(Jugador.class);
        Jugador jugadorMock6 = mock(Jugador.class);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        jugadores.add(jugadorMock);
        jugadores.add(jugadorMock2);
        jugadores.add(jugadorMock3);
        jugadores.add(jugadorMock4);
        jugadores.add(jugadorMock5);
        jugadores.add(jugadorMock6);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        for (int i = 0; i < 6; i++) {
            gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        }
        verify(jugadorMock, times(1)).jugar(dadoMock, mapaMock);
        verify(jugadorMock2, times(1)).jugar(dadoMock, mapaMock);
        verify(jugadorMock3, times(1)).jugar(dadoMock, mapaMock);
        verify(jugadorMock4, times(1)).jugar(dadoMock, mapaMock);
        verify(jugadorMock5, times(1)).jugar(dadoMock, mapaMock);
        verify(jugadorMock6, times(1)).jugar(dadoMock, mapaMock);
    }
    @Test
    public void test06GestorTurnosAgregarUnJugadorIndividualJuegaUnaVez() throws IOException {
        Jugador jugadorMock = mock(Jugador.class);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        GestorTurnos gestorTurnos = new GestorTurnos(5);
        gestorTurnos.agregarTurno(jugadorMock);
        gestorTurnos.determinarPrimerJugador();
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        verify(jugadorMock, times(1)).jugar(dadoMock, mapaMock);
    }
    @Test
    public void test07GestorTurnosAgregarUnJugadorIndividualJuegaDosVeces() throws IOException {
        Jugador jugadorMock = mock(Jugador.class);
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        GestorTurnos gestorTurnos = new GestorTurnos(5);
        gestorTurnos.agregarTurno(jugadorMock);
        gestorTurnos.determinarPrimerJugador();
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        gestorTurnos.siguienteTurno(dadoMock, mapaMock);
        verify(jugadorMock, times(2)).jugar(dadoMock, mapaMock);
    }
    @Test
    public void test08GestorTurnosSinJugadoresDevuelveSinGanadorException() throws SinGanadorException {
        ArrayList<iJugador> jugadores = new ArrayList<>();
        Dado dadoMock = mock(Dado.class);
        Mapa mapaMock = mock(Mapa.class);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        assertThrows(SinGanadorException.class, () -> gestorTurnos.siguienteTurno(dadoMock, mapaMock));
    }
}
