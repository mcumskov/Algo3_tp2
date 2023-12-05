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
        Log.obtenerLogger().info(mensajeAImprimir);
        mensajeAImprimir = "~ ";
    }

}
