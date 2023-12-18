package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.*;
import edu.fiuba.algo3.modelo.mapa.*;

import java.util.ArrayList;

public class ValidadorDeCamino {

    public void validarCamino(ArrayList<iCasilla> casillas){

        iCasilla casillaAnterior = null;
        iCasilla casillaActual = null ;

        int longitudCamino = casillas.size();

        for (int i = 0; i < longitudCamino; i++) {

            casillaActual = casillas.get(i) ;

            if (casillaAnterior != null) {

                if (!(casillaActual.esContigua(casillaAnterior))) {

                    throw new CaminoDiscontinuoException("El camino proporcionado no es continuo. ");
                }
            }

            try {

                casillaActual.validarPosicionEnCamino(i, longitudCamino);
            } catch(Exception e){

                throw new FormatoInvalidoMapaException("El formato del mapa es inválido: " + e );

            }
            casillaAnterior = casillaActual ;
        }
    }

}
