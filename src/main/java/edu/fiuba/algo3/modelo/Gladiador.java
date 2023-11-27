package edu.fiuba.algo3.modelo;

public class Gladiador {
    private int energia;
    private Seniority seniority;
    private Equipamiento equipamiento;

    public Gladiador(){
        this.seniority = new Novato();
        this.equipamiento = new Desnudo();
    }

    public void actualizar(Tablero tablero, int pasosAvanzar){
        seniority.recuperarEnergia(this);
        seniority.evolucionar(this);
        //Cambiar estado si no tiene energia
        tablero.moverGladiador(this, pasosAvanzar);
        //De esto de arriba se puede encargar el Estado Sano like:
        // estado.moverGladiador(Tablero tablero, Gladiador gladiador){ tablero.moverGladiador(gladiador, pasosAvanzar); }
        //El estado Lesionado no lo hace y cambia a Sano
    }

    public void cambiarEnergia(int cambioEnergia){ this.energia += cambioEnergia; }

    public void cambiarSeniority(Seniority nuevoSeniority){ this.seniority = nuevoSeniority; }

    public void cambiarEquipamiento(Equipamiento nuevoEquipamiento){ this.equipamiento = nuevoEquipamiento; }

    public void recibirDanio(int danio){ this.energia -= equipamiento.mitigarDanio(danio); }
}