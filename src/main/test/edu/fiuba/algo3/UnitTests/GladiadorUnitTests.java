package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.Eventos.Premio;
import edu.fiuba.algo3.modelo.Eventos.PremioEquipamiento;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GladiadorUnitTests {

    @Test
    public void test01GladiadorIniciaCon20DeEnergia(){

        Gladiador gladiador = new Gladiador();

        assertEquals(20, gladiador.getEnergia());

    }

    @Test
    public void test02GladiadorIniciaCon20DeEnergiaYSinEquipamiento(){

        Gladiador gladiador = new Gladiador();

        gladiador.recibirAtaque(20);

        assertEquals(0, gladiador.getEnergia());

    }

    @Test
    public void test03GladiadorMejoraEquipamientoYProteje5ElDanio(){

        Gladiador gladiador = new Gladiador();

        gladiador.mejorarEquipamiento();

        gladiador.recibirAtaque(20);

        assertEquals(5, gladiador.getEnergia());

    }

    @Test
    public void test04GladiadorMejoraEquipamientoDosVecesYProteje10ElDanio(){

        Gladiador gladiador = new Gladiador();

        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();

        gladiador.recibirAtaque(20);

        assertEquals(10, gladiador.getEnergia());

    }

    @Test
    public void test04GladiadorMejoraEquipamientoTresVecesYProteje18ElDanio(){

        Gladiador gladiador = new Gladiador();

        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();

        gladiador.recibirAtaque(20);

        assertEquals(18, gladiador.getEnergia());

    }

    @Test
    public void test05GladiadorMejoraEquipamientoCuatroVecesYProteje20ElDanio(){

        Gladiador gladiador = new Gladiador();

        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();

        gladiador.recibirAtaque(20);

        assertEquals(20, gladiador.getEnergia());

    }

    @Test
    public void test06GladiadorActualizaSuSeniority7VecesYPermaneceConLaEnergiaInicial(){

        Gladiador gladiador = new Gladiador();

        gladiador.actualizarSeniority();
        gladiador.actualizarSeniority();
        gladiador.actualizarSeniority();
        gladiador.actualizarSeniority();
        gladiador.actualizarSeniority();
        gladiador.actualizarSeniority();
        gladiador.actualizarSeniority();

        assertEquals(20, gladiador.getEnergia());

    }

    @Test
    public void test07GladiadorActualizaSuSeniority8VecesYVeSuEnergiaIncrementadaEn5(){

        Gladiador gladiador = new Gladiador();

        for (int i = 1; i <= 8 ; i++) {

            gladiador.actualizarSeniority();
        }


        assertEquals(25, gladiador.getEnergia());

    }

    @Test
    public void test08GladiadorActualizaSuSeniority11VecesYVeSuEnergiaIncrementadaEn20(){

        Gladiador gladiador = new Gladiador();

        for (int i = 1; i <= 11 ; i++) {

            gladiador.actualizarSeniority();
        }

        assertEquals(40, gladiador.getEnergia());

    }

    @Test
    public void test09GladiadorActualizaSuSeniority12VecesYVeSuEnergiaIncrementadaEn30(){

        Gladiador gladiador = new Gladiador();

        for (int i = 1; i <= 12 ; i++) {

            gladiador.actualizarSeniority();
        }

        assertEquals(50, gladiador.getEnergia());

    }


}