package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.excepciones.SinGanadorException;
import edu.fiuba.algo3.modelo.juego.Juego;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JuegoUnitTests {

    @Test
    public void test01FinalizarSinGanadorDevuelveSinGanadorException(){
        Juego juego = Juego.getJuego();
        assertThrows(SinGanadorException.class, () -> juego.finalizarSinGanador());
    }
}
