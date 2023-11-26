package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class EquipamientoUnitTests{

    @Test
    public void test01EquipamientoDesnudoNoCubreDanio(){

        Equipamiento equipamiento = new Equipamiento();

        int danioRecibido = equipamiento.recibirAtaque(20);

        assertEquals(20, danioRecibido);

    }

    @Test
    public void test02EquipamientoAsciendeACascoYCubre5DeDanio(){

        Equipamiento equipamiento = new Equipamiento();
        equipamiento.mejorar();

        int danioRecibido = equipamiento.recibirAtaque(20);

        assertEquals(15, danioRecibido);

    }

    @Test
    public void test03EquipamientoAsciendeAArmaduraYCubre10DeDanio(){

        Equipamiento equipamiento = new Equipamiento();
        equipamiento.mejorar();
        equipamiento.mejorar();

        int danioRecibido = equipamiento.recibirAtaque(20);

        assertEquals(10, danioRecibido);

    }

    @Test
    public void test04EquipamientoAsciendeAEscudoEspadaYCubre18DeDanio(){

        Equipamiento equipamiento = new Equipamiento();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();

        int danioRecibido = equipamiento.recibirAtaque(20);

        assertEquals(2, danioRecibido);

    }

    @Test
    public void test05EquipamientoAsciendeALlaveYCubre20DeDanio(){

        Equipamiento equipamiento = new Equipamiento();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();

        int danioRecibido = equipamiento.recibirAtaque(20);

        assertEquals(0, danioRecibido);
    }

    @Test
    public void test06EquipamientoAsciendeALlaveYLuegoNoSigueMejorandoYSigueCubriendo20DeDanio(){

        Equipamiento equipamiento = new Equipamiento();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();
        equipamiento.mejorar();

        int danioRecibido = equipamiento.recibirAtaque(21);

        assertEquals(1, danioRecibido);
    }


}
