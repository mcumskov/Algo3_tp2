package edu.fiuba.algo3.modelo.log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class LogFormatter extends Formatter
{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_AMARILLO = "\u001B[33m";
    public static final String ANSI_BLANCO = "\u001B[37m";
    @Override
    public String format(LogRecord record)
    {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append(ANSI_AMARILLO);

        //Fecha
        mensaje.append("[");
        mensaje.append(  calcularFecha( record.getMillis() )  );
        mensaje.append("]");

        //Clase desde donde es invocado el log
        //mensaje.append(" [");
        //mensaje.append( record.getSourceClassName() );
        //mensaje.append("]");

        //Nivel
        mensaje.append(" [");
        mensaje.append( record.getLevel().getName() );
        mensaje.append("]");

        //Mensaje
        mensaje.append(ANSI_BLANCO);
        mensaje.append(" - ");
        mensaje.append(record.getMessage());

        //Parametros
        Object[] parametros = record.getParameters();

        if (parametros != null)
        {
            mensaje.append("\t");
            for (int i = 0; i < parametros.length; i++)
            {
                mensaje.append(parametros[i]);
                if (i < parametros.length - 1)
                    mensaje.append(", ");
            }
        }

        mensaje.append(ANSI_RESET);
        mensaje.append("\n");
        return mensaje.toString();
    }

    private String calcularFecha(long millisecs) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date fecha = new Date(millisecs);
        return formatoFecha.format(fecha);
    }
}
