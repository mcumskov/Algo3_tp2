package edu.fiuba.algo3.UnitTests;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Senior;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.mockito.Mockito.*;
public class SeniorityUnitTests {

    @Test
    public void test01NovatoTomaUnTurnoNoAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority novato = new Novato(gladiadorMock);
        novato.actualizar();
        verify(gladiadorMock,times(0)).cambiarSeniority(any(SemiSenior.class));
    }
    @Test
    public void test02NovatoToma7TurnosNoAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority novato = new Novato(gladiadorMock);
        for (int i = 0; i < 7; i++) {
            novato.actualizar();
        }
        verify(gladiadorMock,times(0)).cambiarSeniority(any(SemiSenior.class));
    }
    @Test
    public void test03NovatoToma8TurnosAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority novato = new Novato(gladiadorMock);
        for (int i = 0; i < 7; i++) {
            novato.actualizar();
        }
        verify(gladiadorMock,times(0)).cambiarSeniority(any(SemiSenior.class));
        novato.actualizar();
        verify(gladiadorMock,times(1)).cambiarSeniority(any(SemiSenior.class));
    }

    @Test
    public void test04SemiSeniorToma3TurnosNoAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority semiSenior = new SemiSenior(gladiadorMock);
        for (int i = 0; i < 3; i++) {
            semiSenior.actualizar();
        }
        verify(gladiadorMock,times(0)).cambiarSeniority(any(Senior.class));
    }

    @Test
    public void test05SemiSeniorToma4TurnosAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority semiSenior = new SemiSenior(gladiadorMock);
        for (int i = 0; i < 3; i++) {
            semiSenior.actualizar();
        }
        verify(gladiadorMock,times(0)).cambiarSeniority(any(Senior.class));
        semiSenior.actualizar();
        verify(gladiadorMock,times(1)).cambiarSeniority(any(Senior.class));
    }

    @Test
    public void test06SeniorToma1TurnoNoAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority senior = new Senior(gladiadorMock);
        senior.actualizar();
        verify(gladiadorMock,times(0)).cambiarSeniority(any(Seniority.class));
    }

    @Test
    public void test07SeniorToma20TurnosNoAsciende(){
        Gladiador gladiadorMock = mock(Gladiador.class);
        Seniority senior = new Senior(gladiadorMock);
        for (int i = 0; i < 20; i++) {
            senior.actualizar();
        }
        verify(gladiadorMock,times(0)).cambiarSeniority(any(Seniority.class));
    }
}