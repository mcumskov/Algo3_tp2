package edu.fiuba.algo3.modelo.equipamiento;

import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public interface IEquipamiento {

    public int recibirAtaque(int danioRecibido);

    public void mejorar();

    public void abrirCasaPompeya(Gladiador gladiador);

}
