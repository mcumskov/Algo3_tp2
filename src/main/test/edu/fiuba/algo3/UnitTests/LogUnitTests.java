package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.log.Log;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.logging.Logger;

public class LogUnitTests {

    @Test
    public void test01LaClaseLogNoDebeDarDistintasInstanciasDeLogger(){

        Logger log = Log.obtenerLogger();
        assertEquals(log, Log.obtenerLogger());

    }

}
