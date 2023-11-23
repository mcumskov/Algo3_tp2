package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.turnos.GestorTurnos;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class GestorTurnosUnitTests {

    @Test
    public void test01GestorTurnosConUnJugadorJuegaUnaVez() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        jugadores.add(jugadorMock);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno();
        verify(jugadorMock, times(1)).jugar();
    }

    @Test
    public void test02GestorTurnosConUnJugadorJuegaUnaDosVeces() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        jugadores.add(jugadorMock);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        verify(jugadorMock, times(2)).jugar();
    }

    @Test
    public void test03GestorTurnosConUnJugadorJuegaCincoVecesLaSextaDevuelveSinGanadorException() throws SinGanadorException {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        jugadores.add(jugadorMock);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        verify(jugadorMock, times(5)).jugar();
        assertThrows(SinGanadorException.class, () -> gestorTurnos.siguienteTurno());

    }

    @Test
    public void test04GestorTurnosConDosJugadoresJueganUnaVezCadaUno() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        Jugador jugadorMock2 = mock(Jugador.class);
        jugadores.add(jugadorMock);
        jugadores.add(jugadorMock2);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        verify(jugadorMock, times(1)).jugar();
        verify(jugadorMock2, times(1)).jugar();
    }

    @Test
    public void test05GestorTurnosConSeisJugadoresJueganUnaVezCadaUno() {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Jugador jugadorMock = mock(Jugador.class);
        Jugador jugadorMock2 = mock(Jugador.class);
        Jugador jugadorMock3 = mock(Jugador.class);
        Jugador jugadorMock4 = mock(Jugador.class);
        Jugador jugadorMock5 = mock(Jugador.class);
        Jugador jugadorMock6 = mock(Jugador.class);
        jugadores.add(jugadorMock);
        jugadores.add(jugadorMock2);
        jugadores.add(jugadorMock3);
        jugadores.add(jugadorMock4);
        jugadores.add(jugadorMock5);
        jugadores.add(jugadorMock6);
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        for (int i = 0; i < 6; i++) {
            gestorTurnos.siguienteTurno();
        }
        verify(jugadorMock, times(1)).jugar();
        verify(jugadorMock2, times(1)).jugar();
        verify(jugadorMock3, times(1)).jugar();
        verify(jugadorMock4, times(1)).jugar();
        verify(jugadorMock5, times(1)).jugar();
        verify(jugadorMock6, times(1)).jugar();
    }

    @Test
    public void test06GestorTurnosAgregarUnJugadorIndividualJuegaUnaVez(){
        Jugador jugadorMock = mock(Jugador.class);
        GestorTurnos gestorTurnos = new GestorTurnos(5);
        gestorTurnos.agregarTurno(jugadorMock);
        gestorTurnos.determinarPrimerJugador();
        gestorTurnos.siguienteTurno();
        verify(jugadorMock, times(1)).jugar();
    }

    @Test
    public void test07GestorTurnosAgregarUnJugadorIndividualJuegaDosVeces(){
        Jugador jugadorMock = mock(Jugador.class);
        GestorTurnos gestorTurnos = new GestorTurnos(5);
        gestorTurnos.agregarTurno(jugadorMock);
        gestorTurnos.determinarPrimerJugador();
        gestorTurnos.siguienteTurno();
        gestorTurnos.siguienteTurno();
        verify(jugadorMock, times(2)).jugar();
    }

    @Test
    public void test08GestorTurnosSinJugadoresDevuelveSinGanadorException() throws SinGanadorException {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        GestorTurnos gestorTurnos = new GestorTurnos(5, jugadores);
        assertThrows(SinGanadorException.class, () -> gestorTurnos.siguienteTurno());
    }
}
