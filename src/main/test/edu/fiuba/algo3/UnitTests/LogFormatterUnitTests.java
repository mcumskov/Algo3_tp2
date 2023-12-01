package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.log.LogFormatter;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogFormatterUnitTests {

    @Test
    public void test01ElFormateadorAlRecibirElSiguienteRecordConParametrosDebeDevolverElSiguienteString(){
        //Arrange
        LogFormatter formateador = new LogFormatter();
        LogRecord recordFalso = new LogRecord(Level.FINEST, "SoyUnMensaje");
        Method metodo = String.class.getDeclaredMethods()[5];
        Object[] parametros = metodo.getParameters();
        recordFalso.setParameters(parametros);

        String mensajeEsperado = " [null] [FINEST]\u001B[37m - SoyUnMensaje\tint arg0, int arg1, char[] arg2, int arg3\u001B[0m\n";

        //Act
        String recordFormateado = formateador.format(recordFalso);
        String[] recordFormateadoSinFecha = recordFormateado.split("\\]", 2);

        //Assert
        assertEquals(mensajeEsperado, recordFormateadoSinFecha[1]);
    }

    @Test
    public void test02ElFormateadorAlRecibirElSiguienteRecordSinParametrosDebeDevolverElSiguienteString(){
        //Arrange
        LogFormatter formateador = new LogFormatter();
        LogRecord recordFalso = new LogRecord(Level.FINEST, "SoyUnMensaje");

        String mensajeEsperado = " [null] [FINEST]\u001B[37m - SoyUnMensaje\u001B[0m\n";

        //Act
        String recordFormateado = formateador.format(recordFalso);
        String[] recordFormateadoSinFecha = recordFormateado.split("\\]", 2);

        //Assert
        assertEquals(mensajeEsperado, recordFormateadoSinFecha[1]);
    }
}
