package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.*;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.excepciones.ObstaculoInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.PremioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.TipoCasillaInvalidaException;
import edu.fiuba.algo3.modelo.mapa.Coordenada;
import edu.fiuba.algo3.modelo.mapa.iCasilla;

public class CasillaFactory {

    BuscadorValorJSON buscadorValor ;
    CreadorCasillaInicio creadorCasillaInicio ;
    CreadorCasillaCamino creadorCasillaCamino ;

    CreadorCasillaFinal creadorCasillaFinal ;
    public CasillaFactory(){

        this.buscadorValor = new BuscadorValorJSON();

        this.creadorCasillaInicio = new CreadorCasillaInicio();
        this.creadorCasillaCamino = new CreadorCasillaCamino();
        this.creadorCasillaFinal = new CreadorCasillaFinal();
    }

    public iCasilla crearCasilla(String infoCasilla){

        String claveX = "\"x\":";
        String claveY = "\"y\":";
        String claveTipo = "\"tipo\":";
        String claveObstaculo = "\"obstaculo\":";
        String clavePremio = "\"premio\":";

        int valorX = buscadorValor.obtenerValorInt(infoCasilla, claveX);
        int valorY = buscadorValor.obtenerValorInt(infoCasilla, claveY);

        String valorTipo = buscadorValor.obtenerValorStr(infoCasilla, claveTipo);
        String valorObstaculo = buscadorValor.obtenerValorStr(infoCasilla, claveObstaculo);
        String valorPremio = buscadorValor.obtenerValorStr(infoCasilla, clavePremio);

        Coordenada coordenada = new Coordenada(valorX, valorY);

        Premio premio = instanciarPremio(valorPremio) ;

        Obstaculo obstaculo = instanciarObstaculo(valorObstaculo);

        iCasilla casillaReturn ;

        switch(valorTipo){

            case "Salida":
                casillaReturn = creadorCasillaInicio.crearCasilla(coordenada, obstaculo, premio);
                break;
            case "Camino":
                casillaReturn = creadorCasillaCamino.crearCasilla(coordenada, obstaculo, premio);
                break;
            case "Llegada":
                casillaReturn = creadorCasillaFinal.crearCasilla(coordenada, obstaculo, premio);
                break;
            default:
                throw new TipoCasillaInvalidaException("El valor de la clave tipo no es válido. ");
        }

        return casillaReturn ;
    }

    private Premio instanciarPremio(String nombrePremio){

        Premio premio ;

        switch(nombrePremio){

            case "Equipamiento":
                premio = new PremioEquipamiento() ;
                break;
            case "Comida":
                premio = new PremioComestible() ;
                break;
            case "":
                premio = new PremioNulo() ;
                break;
            default:
                throw new PremioInvalidoException("El valor de la clave premio no es válido. " );
        }
        return premio ;
    }

    private Obstaculo instanciarObstaculo(String nombreObstaculo){

        Obstaculo obstaculo;

        switch(nombreObstaculo){

            case "Bacanal":
                obstaculo = new Bacanal() ;
                break;
            case "Fiera":
                obstaculo = new FieraSalvaje() ;
                break;
            case "Lesion":
                obstaculo = new Lesion() ;
                break;
            case "":
                obstaculo = new ObstaculoNulo() ;
                break;
            default:
                throw new ObstaculoInvalidoException("El valor de la clave obstaculo no es válido. " );
        }

        return obstaculo ;
    }




}
