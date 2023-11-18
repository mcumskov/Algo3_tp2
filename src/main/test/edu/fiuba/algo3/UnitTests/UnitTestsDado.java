package edu.fiuba.algo3.UnitTests;

import edu.fiuba.algo3.modelo.Dado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTestsDado {

    @Test
    public void test01LanzoUnDadoYElResultadoEstaEntre1y6(){

        Dado dado = new Dado();

        int resultado = dado.lanzar();

        assertTrue(resultado >= 1 && resultado <= 6 );

    }

    @Test
    public void test02LanzoDiezMilVecesElDadoYVerifcoQueTodasLasVecesElResultadoEsteEntre1Y6(){

        int resultado ;

        Dado dado = new Dado();

        for(int i = 0 ; i < 10000 ; i++)
        {
            resultado = dado.lanzar();

            assertTrue(resultado >= 1 && resultado <= 6 );
        }
    }

    @Test
    public void test03LanzoDiezMilVecesElDadoYVerifcoQueSalgaAlMenos1000VecesCadaNumeroParaVerificarEquiprobabilidad(){

        int cantidad1 = 0 ;
        int cantidad2 = 0 ;
        int cantidad3 = 0 ;
        int cantidad4 = 0 ;
        int cantidad5 = 0 ;
        int cantidad6 = 0 ;

        boolean pruebaFallida = false ;

        Dado dado = new Dado();

        for(int i = 0 ; i < 10000 ; i++)
        {
            switch(dado.lanzar()){

                case 1:
                    cantidad1++;
                    break;
                case 2:
                    cantidad2++;
                    break;
                case 3:
                    cantidad3++;
                    break;
                case 4:
                    cantidad4++;
                    break;
                case 5:
                    cantidad5++;
                    break;
                case 6:
                    cantidad6++;
                    break;
                default:
                    pruebaFallida = true;
                    break;

            }
        }

        assertTrue(cantidad1 >= 1000 && cantidad2 >= 1000 && cantidad3 >= 1000 && cantidad4 >= 1000 && cantidad5 >= 1000 && cantidad6 >= 1000 && (!pruebaFallida));
    }

}
