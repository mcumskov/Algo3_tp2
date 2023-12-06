package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.modelo.seniority.Seniority;

public class Gladiador {

    private Estado estado;
    private Seniority seniority;
    private Equipamiento equipamiento;
    private int energia;

    public Gladiador() {
        this.energia = 20;
        this.equipamiento = new Equipamiento();
        this.estado = new GladiadorSano();
        this.seniority = new Seniority();
    }

    public void disminuirEnergia(int energiaDisminuir) {
        this.energia -= energiaDisminuir;
        if(this.energia <= 0){
            this.estado = new GladiadorSinEnergia();
        }
    }

    public void aumentarEnergia(int energiaAumentar){
        this.energia += energiaAumentar;
        Log.getLog().agregarABuffer( " | se recupera " + energiaAumentar + " de energia");
    }

    public void cambiarEstado(Estado estado_nuevo) {
        this.estado = estado_nuevo;
    }

    public void recibirAtaque(int danio) {
        this.disminuirEnergia(this.equipamiento.recibirAtaque(danio));
    }

    public void avanzar(iCasilla casilla, int pasos){
       this.estado.avanzar(this, casilla, pasos);
    }

    public void mejorarEquipamiento() {
        this.equipamiento.mejorar();
    }

    public void actualizarSeniority(){
        this.seniority.actualizar();
        this.aumentarEnergia(this.seniority.recuperarEnergia());
    }

    public void abrirCasaPompeya(Gladiador gladiador) {
        equipamiento.abrirCasaPompeya(gladiador);
    }

    public int getEnergia() {
        return this.energia;
    }

    @Override
    public boolean equals(Object gladiadorAComparar) {
        boolean resultado = false;
        if (this == gladiadorAComparar) {
            resultado = true;
        }
        return resultado;
    }

}