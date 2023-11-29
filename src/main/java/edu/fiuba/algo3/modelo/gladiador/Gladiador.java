package edu.fiuba.algo3.modelo.gladiador;

import edu.fiuba.algo3.modelo.equipamiento.Equipamiento;
import edu.fiuba.algo3.modelo.log.Log;
import edu.fiuba.algo3.modelo.seniority.Seniority;

public class Gladiador {

    private Estado estado;
    private Seniority seniority;
    private Equipamiento equipamiento;
    private int energia;

    public Gladiador() {
        Log.obtenerLogger().warning("");
        this.energia = 20;
        this.equipamiento = new Equipamiento();
        //this.estado = new GladiadorSano(this);
        this.seniority = new Seniority();
    }

    private void disminuirEnergia(int energiaDisminuir) {

        this.energia -= energiaDisminuir;

    }

    public void aumentarEnergia(int energiaAumentar){

        this.energia += energiaAumentar;
    }

    public void cambiarEstado(Estado estado_nuevo) {
        this.estado = estado_nuevo;
    }

    public void recibirAtaque(int danio) {

        this.disminuirEnergia(this.equipamiento.recibirAtaque(danio));

    }

    public void mejorarEquipamiento() {

        this.equipamiento.mejorar();
    }

    public void actualizarSeniority(){

        this.seniority.actualizar();
        this.aumentarEnergia(this.seniority.recuperarEnergia());

    }

    public void abrirCasaPompeya() {
        equipamiento.abrirCasaPompeya();
    }

    public int getEnergia() {
        return this.energia;
    }

}