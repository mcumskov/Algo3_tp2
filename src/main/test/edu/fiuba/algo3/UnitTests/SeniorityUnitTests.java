package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.seniority.Seniority;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class SeniorityUnitTests {

    @Test
    public void test01NovatoNoGanaEnergia(){

        Seniority seniority = new Seniority();

        int energiaRecibida = seniority.recuperarEnergia();

        assertEquals(0, energiaRecibida);

    }
    @Test
    public void test02NovatoToma7TurnosNoAsciendeSigueSinGanarEnergia(){

        Seniority seniority = new Seniority();

        int energiaRecibida = seniority.recuperarEnergia();

        for (int i = 1; i <= 7; i++) {

            seniority.actualizar();

            energiaRecibida += seniority.recuperarEnergia();

        }

        assertEquals(0, energiaRecibida);

    }

    @Test
    public void test03NovatoToma8TurnosAsciendeSeniorityYGana5DeEnergia(){

        Seniority seniority = new Seniority();

        int energiaRecibida = seniority.recuperarEnergia();

        for (int i = 1; i <= 7; i++) {

            seniority.actualizar();

            energiaRecibida += seniority.recuperarEnergia();

        }

        assertEquals(0, energiaRecibida);

    }

    @Test
    public void test04NovatoToma11TurnosAsciendeSeniorityYAcumula20DeEnergiaEnLosUltimos4Turnos(){

        Seniority seniority = new Seniority();

        int energiaRecibida = seniority.recuperarEnergia();

        for (int i = 1; i <= 7; i++) {

            seniority.actualizar();

            energiaRecibida += seniority.recuperarEnergia();

        }

        assertEquals(0, energiaRecibida);

        for (int i = 1; i <= 4; i++) {

            seniority.actualizar();

            energiaRecibida += seniority.recuperarEnergia();

        }

        assertEquals(20, energiaRecibida);

    }
    @Test
    public void test05NovatoToma12TurnosYAsciendeASeniorEnElUltimoTurnoGana10DeEnergia()
    {
        Seniority seniority = new Seniority();

        for (int i = 1; i <= 11; i++) {

            seniority.actualizar();
        }

        int energiaRecibida = 0;

        seniority.actualizar();

        energiaRecibida += seniority.recuperarEnergia();

        assertEquals(10, energiaRecibida);

    }

    @Test
    public void test06NovatoToma12TurnosYAsciendeASeniorLuegoEnCadaTurnoEntrega10DeEnergiaPor20TurnosMas()
    {
        Seniority seniority = new Seniority();

        for (int i = 1; i <= 11; i++) {

            seniority.actualizar();
        }

        int energiaRecibida = 0;
        int energiaEsperada = 0;

        for (int i = 1; i <= 20; i++) {

            seniority.actualizar();

            energiaRecibida += seniority.recuperarEnergia();
            energiaEsperada += 10 ;

            assertEquals(energiaEsperada, energiaRecibida);
        }


    }

}