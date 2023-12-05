package edu.fiuba.algo3.modelo.log;

public class Buffer {

    protected String mensajeAImprimir;
    private static Buffer instancia;
    private Buffer(){
                instancia = this;
                mensajeAImprimir = "~ ";
    }
    public static Buffer getBuffer(){
        if(instancia == null){
            instancia = new Buffer();
        }
        return instancia;
    }
    public void agregarABuffer(String mensajito){
        mensajeAImprimir = mensajeAImprimir + mensajito;
    }
    public void imprimirMensaje(){
        // aca se llama al log, pasandole el mensaje a imprimir que tiene
        // el buffer guardado en su atributo

        mensajeAImprimir = "~ "; // antes d terminar, se resetea el valor original para que quede listo
                                 // para el siguiente uso.
    }

}
