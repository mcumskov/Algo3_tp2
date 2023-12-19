package edu.fiuba.algo3.modelo.log;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Formatter;

public class Log {
    private static Logger logger;
    private String mensajeAImprimir;
    private static Log instancia;
    private Log(){
        instancia = this;
        mensajeAImprimir = "~ ";
    }
    public static Log getLog(){
        if(instancia == null){
            instancia = new Log();
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

    public static Logger obtenerLogger(){
        if(Log.logger == null){
            logger = Logger.getLogger("logger");
            Log.construirLogger();
        }
        return Log.logger;
    }

    private static void construirLogger(){

        Log.logger.setUseParentHandlers(false);

        ConsoleHandler handler = new ConsoleHandler();

        Formatter formatter = new LogFormatter();
        handler.setFormatter(formatter);

        Log.logger.addHandler(handler);
        Log.logger.setLevel(Level.FINEST);
    }
}
