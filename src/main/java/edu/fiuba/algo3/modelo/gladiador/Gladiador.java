package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.equipamiento.Desnudo;
import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.mapa.Mapa;
import edu.fiuba.algo3.modelo.seniority.Novato;
import edu.fiuba.algo3.modelo.seniority.Seniority;
import edu.fiuba.algo3.modelo.casilla.Casilla;

public class Gladiador {
    private Casilla casilla;

    private Estado estado;

    private Seniority seniority;

    private Equipamiento equipamiento;

    private int energia;

    private boolean ganador;

    public Gladiador(Casilla casillaInicial){
        this.casilla = casillaInicial;
        this.energia = 20 ;
        this.equipamiento = new Desnudo(this);
        this.estado = new GladiadorSano(this);
        this.seniority = new Novato(this);
        this.ganador = false;
    }

    public Gladiador(){

        Mapa mapa = Mapa.getMapa();

        this.casilla = mapa.getPrimeraCasilla();
        this.energia = 20 ;
        this.equipamiento = new Desnudo(this);
        this.estado = new GladiadorSano(this);
        this.seniority = new Novato(this);
        this.ganador = false;
    }

    public void cambiarEstado(Estado estado_nuevo){
        this.estado = estado_nuevo;
    }

    public void cambiarSeniority(Seniority seniority_nuevo){
        this.seniority = seniority_nuevo;
    }

    public void cambiarEquipamiento(Equipamiento equipamiento_nuevo){
        this.equipamiento = equipamiento_nuevo;
    }

    public void avanzar(int pasos){
        estado.avanzar(pasos);
    }

    public void obtenerEnergia(){
        seniority.obtenerEnergia();
    }

    public void recibirDanio(int danioRecibido){
        equipamiento.mitigarDanio(danioRecibido);
    }

    public void cambiarEnergia(int variacionDeEnergia){
        this.energia = energia + variacionDeEnergia;
        if(this.energia <= 0){
            this.cambiarEstado(new GladiadorSinEnergia(this));
        }
    }

    public void mejorarEquipamiento(){
        equipamiento.mejorarEquipamiento();
    }

    public void abrirCasaPompeya(){
        equipamiento.abrirCasaPompeya();
    }

    public  void irAMitadDelMapa(){
        Mapa mapa = Mapa.getMapa();
        this.casilla = mapa.getMitadDeCamino();
    }

    public void victoria(){
        this.ganador = true;
    }

    public void cambiarPosicion( int pasos ){
        this.obtenerEnergia();
        seniority.actualizar();
        casilla = casilla.obtenerSiguiente(pasos);
        casilla.afectarConEvento(this);
    }

    public int getEnergia(){
        return this.energia;
    }

   public Casilla getCasilla(){
        return this.casilla;
   }

   public Seniority getSeniority(){
        return this.seniority;
   }

    public boolean getGanador(){
        return this.ganador;
    }
}
