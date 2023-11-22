package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.equipamiento.Desnudo;
import edu.fiuba.algo3.modelo.equipamiento.Casco;
import edu.fiuba.algo3.modelo.equipamiento.Armadura;
import edu.fiuba.algo3.modelo.equipamiento.EscudoEspada;
import edu.fiuba.algo3.modelo.equipamiento.Llave;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EquipamientoUnitTests{

    @Test
    public void test01EquipamientoDesnudoNoCubreDanio(){

        Gladiador gladiador =  new Gladiador();
        Equipamiento equipamiento = new Desnudo(gladiador);

        int danioEfectuado = -10;

        equipamiento.mitigarDanio(danioEfectuado);

        int energiaResultante = gladiador.getEnergia();

        assertEquals(energiaResultante, 10);

    }

    @Test
    public void test02EquipamientoCascoCubre5DeDanio(){

        Gladiador gladiador =  new Gladiador();
        Equipamiento equipamiento = new Casco(gladiador, 0);

        int danioEfectuado = -10;

        equipamiento.mitigarDanio(danioEfectuado);

        int energiaResultante = gladiador.getEnergia();

        assertEquals(energiaResultante, 15);

    }

    @Test
    public void test03EquipamientoArmaduraCubre10DeDanio(){

        Gladiador gladiador =  new Gladiador();
        Equipamiento equipamiento = new Armadura(gladiador, 5);

        int danioEfectuado = -10;

        equipamiento.mitigarDanio(danioEfectuado);

        int energiaResultante = gladiador.getEnergia();

        assertEquals(energiaResultante, 20);

    }

    @Test
    public void test04EquipamientoEscudoEspadaCubre18DeDanio(){

        Gladiador gladiador =  new Gladiador();
        Equipamiento equipamiento = new EscudoEspada(gladiador, 10);

        int danioEfectuado = -20;

        equipamiento.mitigarDanio(danioEfectuado);

        int energiaResultante = gladiador.getEnergia();

        assertEquals(energiaResultante, 18);

    }

    @Test
    public void test05EquipamientoLlaveCubre20DeDanio(){

        Gladiador gladiador =  new Gladiador();
        Equipamiento equipamiento = new EscudoEspada(gladiador, 18);

        int danioEfectuado = -20;

        equipamiento.mitigarDanio(danioEfectuado);

        int energiaResultante = gladiador.getEnergia();

        assertEquals(energiaResultante, 20);

    }

    @Test
    public void test06EquipamientoDesnudoAsciendeACascoYProteje5(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();

        gladiador.recibirDanio(-10);

        assertEquals(gladiador.getEnergia(), 15);
    }

    @Test
    public void test07EquipamientoDesnudoAsciendeAArmaduraYProteje10(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();

        gladiador.recibirDanio(-10);

        assertEquals(gladiador.getEnergia(), 20);
    }

    @Test
    public void test08EquipamientoDesnudoAsciendeAEscudoYEspadaYProteje18(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();

        gladiador.recibirDanio(-18);

        assertEquals(gladiador.getEnergia(), 20);
    }

    @Test
    public void test09EquipamientoDesnudoAsciendeALlaveYProteje20(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();

        gladiador.recibirDanio(-20);

        assertEquals(gladiador.getEnergia(), 20);
    }

    @Test
    public void test10EquipamientoDesnudoNoAbreCasaPompeya(){

        Gladiador gladiador =  new Gladiador();

        gladiador.abrirCasaPompeya();

        assertFalse(gladiador.getGanador());
    }

    @Test
    public void test11EquipamientoCascoNoAbreCasaPompeya(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();


        gladiador.abrirCasaPompeya();

        assertFalse(gladiador.getGanador());
    }

    @Test
    public void test12EquipamientoArmaduraNoAbreCasaPompeya(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();


        gladiador.abrirCasaPompeya();

        assertFalse(gladiador.getGanador());
    }

    @Test
    public void test13EquipamientoEscudoEspadaNoAbreCasaPompeya(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();


        gladiador.abrirCasaPompeya();

        assertFalse(gladiador.getGanador());
    }

    @Test
    public void test14EquipamientoLlaveSiAbreCasaPompeya(){

        Gladiador gladiador =  new Gladiador();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();
        gladiador.mejorarEquipamiento();


        gladiador.abrirCasaPompeya();

        assertTrue(gladiador.getGanador());
    }



}
