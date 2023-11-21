package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.evento.*;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Senior;

import static org.junit.jupiter.api.Assertions.*;

public class Entrega1Tests {

    @Test
    public void test01JugadorEmpiezaConEnergiaYEquipamientoCorrespondiente(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoCombate);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

         assertEquals(20, gladiadorcito.getEnergia());

         gladiadorcito.avanzar(1);

        // si el gladiador desp del combate tiene 0 energia es pq tenia el equipamiento
        // "desnudo" que es con el que ese debe incializar
        assertEquals(0, gladiadorcito.getEnergia());
    }
    @Test
    public void test02JugadorComienzaEnLaCasillaInicial(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoCombate);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        assertSame(primerCasilla, gladiadorcito.getCasilla());
    }
    @Test
    public void test03GladiadorSinEnergiaNoCambiaDeCasilla(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla segundaCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        Casilla casillaEnLaQuePierdoEnergia = gladiadorcito.getCasilla();
        gladiadorcito.avanzar(1);
        Casilla casillaPostIntentoDeMovimientoSinEnergia = gladiadorcito.getCasilla();

        assertSame(casillaEnLaQuePierdoEnergia, casillaPostIntentoDeMovimientoSinEnergia);
    }
    @Test
    public void test04EventoComidaIncrementaEnergia(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoComida eventoComida = new EventoComida();

        Casilla ultimaCasilla = new Casilla(null, eventoComida);
        Casilla primerCasilla = new Casilla(ultimaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);

        assertEquals(35, gladiadorcito.getEnergia());
    }
    @Test
    public void test05SeRecibePremioPorPrimeraVezYGladiadorRecibeCasco(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        // al combarit con una fiera y teniendo casco, debe quedar con 5 energia
        assertEquals(5, gladiadorcito.getEnergia());
    }
    @Test
    public void test06SeRecibePremioPorTerceraVezYGladiadorRecibeEscudoEspada(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla cuartaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        // al combarit con una fiera y teniendo EscudoYEspada, debe quedar con 18 energia
        assertEquals(18, gladiadorcito.getEnergia());
    }
    @Test
    public void test07SePeleaConFieraConCascoYSePierdeLaEnergiaCorrespondiente(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla tercerCasilla = new Casilla(ultimaCasilla, eventoCombate);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        // al combarit con una fiera y teniendo casco, debe quedar con 5 energia
        assertEquals(5, gladiadorcito.getEnergia());
    }
    @Test
    public void test08LuegoDe8TurnosElGladiadorPasaDeNovatoASemiSeniorYrecuperaEnergiaEnElSiguienteMovimiento(){

        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoAburrido);
        Casilla novenaCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, eventoAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla, eventoAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla, eventoAburrido);
        Casilla quintaCasilla = new Casilla(sextaCasilla, eventoAburrido);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoAburrido);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoAburrido);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoAburrido);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);
        Seniority seniorityNovato = gladiadorcito.getSeniority();

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);

        Seniority senioritySemiSenior = gladiadorcito.getSeniority();

        assertNotSame(seniorityNovato, senioritySemiSenior);

        gladiadorcito.avanzar(1);
        int energiaPostAscenso = gladiadorcito.getEnergia();

        assertEquals(25, energiaPostAscenso);
    }

    @Test
    public void test09GladiadorConEscudoEspadaNoAbrePompeyaYvaALaMitadDelMapa(){

        Mapa mapa = Mapa.getMapa();

        Gladiador gladiadorcito = new Gladiador(mapa.getPrimerCasilla());

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);

        assertSame(gladiadorcito.getCasilla(), mapa.mitadDeCamino());

    }

    @Test
    public void test10GladiadorConTodoElEquipamientoNoRecibeDanioDeLaFiera(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();
        EventoFiera eventoCombate = new EventoFiera();

        Casilla ultimaCasilla = new Casilla(null, eventoCombate);
        Casilla quintaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        int energiaPrePelea = gladiadorcito.getEnergia();
        gladiadorcito.avanzar(1);

        int energiaPostPelea = gladiadorcito.getEnergia();
        assertEquals(energiaPrePelea, energiaPostPelea);
    }
    @Test
    public void test11GladiadorConLlaveRecibePremioPeroNoCambiaNada(){

        EventoEquipamiento eventoEquipo = new EventoEquipamiento();
        EventoNulo eventoAburrido = new EventoNulo();

        Casilla ultimaCasilla = new Casilla(null, eventoEquipo);
        Casilla quintaCasilla = new Casilla(ultimaCasilla, eventoEquipo);
        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla, eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        Gladiador gladiadorcito = new Gladiador(primerCasilla);

        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        gladiadorcito.avanzar(1);
        Equipamiento equipoPrePelea = gladiadorcito.getEquipamiento();
        gladiadorcito.avanzar(1);

        Equipamiento equipoPostPelea = gladiadorcito.getEquipamiento();

        assertSame(equipoPrePelea, equipoPostPelea);
    }
}


