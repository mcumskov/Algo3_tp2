package edu.fiuba.algo3.modelo;

public class Gladiador {
    private int energia;
    private Seniority seniority;
    private Equipamiento equipamiento;

    private EstadoGladiador estadoGladiador;

    public Gladiador(){
        this.seniority = new Novato();
        this.equipamiento = new Desnudo();
        this.estadoGladiador = new Sano();
    }

    public void actualizar(Tablero tablero, int pasosAvanzar){
        seniority.recuperarEnergia(this);
        seniority.evolucionar(this);
        estadoGladiador.mover(tablero, this, pasosAvanzar);
    }

    public void cambiarEnergia(int cambioEnergia){
        this.energia += cambioEnergia;
        if(this.energia <= 0){
            cambiarEstado(new SinEnergia());
            this.energia = 0;
        }
    }

    public void cambiarSeniority(Seniority nuevoSeniority){ this.seniority = nuevoSeniority; }

    public void cambiarEquipamiento(Equipamiento nuevoEquipamiento){ this.equipamiento = nuevoEquipamiento; }

    public void cambiarEstado(EstadoGladiador nuevoEstadoGladiador){ this.estadoGladiador = nuevoEstadoGladiador; };

    public void mejorarEquipamiento(){ equipamiento.mejorarEquipamiento(this); }

    public void llegarPompeya(){ equipamiento.llegarPompeya(); }
}