package edu.fiuba.algo3.modelo;

class Casilla{
    private Premio premio;
    private Obstaculo obstaculo;

    public Casilla(){
        premio = new PremioNulo();
        obstaculo = new ObstaculoNulo();
    }

    public void afectar(Gladiador gladiador){
        gladiador.premiar(premio);
        gladiador.obstaculizar(obstaculo);
    }
}