package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Senior;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class SeniorityUnitTests {

    @Test
    public void test01NovatoTomaUnTurnoYNoAsciende(){

        Seniority noob = new Novato(null);

        Seniority noob2 = noob.actualizar();

        assertTrue(noob2 == noob);

    }
    @Test
    public void test02NovatoToma7TurnosYNoAsciende(){

        Seniority noob = new Novato(null);
        Seniority noob2 = null;
        for(int i=0; i<7; i++) {
            noob2 = noob.actualizar();
        }
        assertTrue(noob2 == noob);
    }
    @Test
    public void test03Novatotoma7TurnosNoAsciendeYAlTomarUnTurnoMasAsciende(){

        Seniority noob = new Novato(null);
        Seniority noob2 = null;
        for(int i=0; i<7; i++) {
            noob2 = noob.actualizar();
        }
        noob2 = noob.actualizar();
        assertTrue(noob2 != noob);
    }

    @Test
    public void test04NovatoAciendeASemiSeniorYDespSemiSeniorAsciendeASenior(){

        Seniority noob = new Novato(null);
        Seniority noob2 = null;
        for(int i=0; i<8; i++) {
            noob2 = noob.actualizar();
        }
        Seniority noob3 = null;

        for(int i=0; i<4; i++) {
            noob3 = noob.actualizar();
        }

        assertTrue(noob2 != noob && noob2 != noob3 && noob3 != noob);
    }

    @Test
    public void test05SeniorAsciendeYSeDevuelveASiMismo(){

        Seniority noob = new Senior(null);
        Seniority noob2 = null;
        for(int i=0; i<10; i++) {
            noob2 = noob.actualizar();
        }

        assertTrue(noob2 == noob);

    }

}
