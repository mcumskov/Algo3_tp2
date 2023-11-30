package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Message;
import edu.fiuba.algo3.modelo.excepciones.MapaJsonNoSePudoAbrirException;
import edu.fiuba.algo3.modelo.mapa.Parser;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MessageTest2 {

   @Test
    public void test13ParseoMapaReciboListaDeCasillasConTamanioCorrespondiente(){

       String nombreArchivo = "src/main/test/edu/fiuba/algo3/jsonTests/mapa.json" ;

       Parser parser = new Parser();

       List<iCasilla> casillas = parser.parsearJSON(nombreArchivo);

       assertEquals(39,casillas.size());

   }
}
