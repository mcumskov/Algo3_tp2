package edu.fiuba.algo3.modelo;

class Casilla implements Afectador {
    private Premio premio;
    private Obstaculo obstaculo;

    public Casilla(){
        premio = new PremioNulo();
        obstaculo = new ObstaculoNulo();
    }

    public void afectar(Gladiador gladiador){
        premio.afectar(gladiador);
        obstaculo.afectar(gladiador);
    }
}