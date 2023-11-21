package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.casilla.Casilla;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.evento.EventoEquipamiento;
import edu.fiuba.algo3.modelo.evento.EventoFiera;
import edu.fiuba.algo3.modelo.evento.EventoNulo;
import edu.fiuba.algo3.modelo.evento.EventoPompeya;
import edu.fiuba.algo3.modelo.evento.EventoLesion;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.SemiSenior;
import edu.fiuba.algo3.modelo.seniority.Senior;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class Mapa {
    private static Mapa instancia;
    private Casilla primerCasilla;
    private Casilla casillaMedio;
    private Mapa(){

        EventoNulo eventoAburrido = new EventoNulo();
        EventoPompeya eventoPompeya = new EventoPompeya();
        EventoEquipamiento eventoEquipo = new EventoEquipamiento();

        Casilla ultimaCasilla = new Casilla(null, eventoPompeya);
        Casilla novenaCasilla = new Casilla(ultimaCasilla, eventoAburrido);
        Casilla octavaCasilla = new Casilla(novenaCasilla, eventoAburrido);
        Casilla septimaCasilla = new Casilla(octavaCasilla, eventoAburrido);
        Casilla sextaCasilla = new Casilla(septimaCasilla, eventoAburrido);

        Casilla quintaCasilla = new Casilla(sextaCasilla, eventoAburrido);

        Casilla cuartaCasilla = new Casilla(quintaCasilla, eventoEquipo);
        Casilla tercerCasilla = new Casilla(cuartaCasilla, eventoEquipo);
        Casilla segundaCasilla = new Casilla(tercerCasilla,eventoEquipo);
        Casilla primerCasilla = new Casilla(segundaCasilla, eventoAburrido);

        this.casillaMedio = quintaCasilla;
        this.primerCasilla = primerCasilla;

    }
    public static Mapa getMapa(){
        if(instancia == null){
            instancia = new Mapa();
        }
        return instancia;
    }

    public Casilla mitadDeCamino(){
        return this.casillaMedio;
    }
    public Casilla getPrimerCasilla(){
        return this.primerCasilla;
    }
}
