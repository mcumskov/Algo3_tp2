package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.log.LogFormatter;
import org.junit.jupiter.api.Test;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogFormatterUnitTests {

    @Test
    public void test01ElFormateadorAlRecibirElSiguienteRecordDebeDevolverElSiguienteString(){
        LogFormatter formateador = new LogFormatter();
        LogRecord recordFalso = new LogRecord(Level.FINEST, "SoyUnMensaje");

        String recordFormateado = formateador.format(recordFalso);
        String[] recordFormateadoSinFecha = recordFormateado.split("\\]", 2);


        String mensajeEsperado = " [null] [FINEST]\u001B[37m - SoyUnMensaje\u001B[0m\n";

        assertEquals(mensajeEsperado, recordFormateadoSinFecha[1]);
    }
}
