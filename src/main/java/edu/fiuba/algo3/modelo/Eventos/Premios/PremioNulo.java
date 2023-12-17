package edu.fiuba.algo3.modelo.Eventos.Premios;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;

public class PremioNulo implements Premio {

   char representacion;
   public PremioNulo(){
      this.representacion = ' ';
   }

   public void premiarGladiador(Gladiador gladiador){}

   public char getRepresentacion(){
      return this.representacion;
   }

}
