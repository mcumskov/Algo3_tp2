package edu.fiuba.algo3.modelo.excepciones;

public class SinGanadorException extends  RuntimeException {
    public SinGanadorException(String mensaje){
        super(mensaje);
    }
}
