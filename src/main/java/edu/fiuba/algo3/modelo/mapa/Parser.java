package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.*;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.excepciones.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    private int ancho ;
    private int largo;

    protected iCasilla casillaAnterior;

    public void Parser(){
        this.casillaAnterior = null;
    }

    public List<iCasilla> parsearJSON (String pathJson) {

        String jsonString;

        try {

            jsonString = new String(Files.readAllBytes(Paths.get(pathJson)));

        } catch (IOException e) {

            throw new MapaJsonNoSePudoAbrirException("No se pudo abrir el archivo de mapa especificado: " + pathJson +" . " + e.getMessage());
        }

        List<iCasilla> casillas = new ArrayList<>();

        // Dividir la cadena JSON en partes para analizar
        String[] partes = jsonString.split("\"celdas\":\\s*\\[");

        obtenerDimensionesMapa(partes[0]);

        // La parte 1 contiene las celdas
        String celdasJson = partes[1].substring(0, partes[1].length() - 3);
        String[] celdasArray = celdasJson.split("\\},\\s*\\{");

        // Iterar sobre las celdas y construir objetos Casilla
        for (String celdaJson : celdasArray) {
            // Agregar llaves faltantes para convertir cada celda en un objeto JSON válido
            celdaJson = "{" + celdaJson + "}";

            // Crear objeto Casilla y agregar a la lista
            iCasilla casilla = construirCasillaDesdeJSON(celdaJson);
            casillas.add(casilla);
            if (this.casillaAnterior != null) {
                this.casillaAnterior.setSiguiente(casilla);
            }
            this.casillaAnterior = casilla;
        }

        validarListaCasillas(casillas);

        return casillas;
    }

    private void validarListaCasillas(List<iCasilla> casillas){

        int finIteracion = casillas.size() - 1;
        Coordenada coordenadaAnterior = null;
        Coordenada coordenadaIteracion = null ;

        for(int i = 0; i <= finIteracion; i++) {

            iCasilla casillaIteracion = casillas.get(i);
            coordenadaIteracion = casillaIteracion.getCoordenada();

            validarCoordenadaCasilla(coordenadaIteracion);

            if(i == 0)
            {
                if(!(casillaIteracion instanceof CasillaInicio)){

                    throw new CasillaInicialNoEsDeTipoSalidaException("La primera casilla del mapa debe ser del tipo \"Salida\". Formato de mapa inválido.");

                }

            } else if( i == finIteracion ){

                if(!(casillaIteracion instanceof CasillaFinal)){

                    throw new CasillaFinalNoEsDeTipoLlegadaException("La útlima casilla del mapa debe ser del tipo \"Llegada\". Formato de mapa inválido.");

                }

            } else {

                if(!(casillaIteracion instanceof CasillaCamino)){

                    throw new CasillaIntermediaNoEsDeTipoCaminoException("Una o más de las casillas intermedia no cumplen con el tipo \"Camino\". Formato de mapa inválido.");

                }

            }

            if(i != 0 ){

                if(!casillaIteracion.getCoordenada().esContigua(coordenadaAnterior)){

                    throw new CaminoDiscontinuoException("Al menos dos casillas del mapa no son contiguas. Formato de mapa inválido. ");

                }

            }

            coordenadaAnterior = coordenadaIteracion;
        }

    }

    private iCasilla construirCasillaDesdeJSON(String celdaJsonString) {

        int y = obtenerValorNumerico(celdaJsonString, "\"y\":");
        int x = obtenerValorNumerico(celdaJsonString, "\"x\":");

        String stringTipo = obtenerValorString(celdaJsonString, "\"tipo\":");
        String stringObstaculo = obtenerValorString(celdaJsonString, "\"obstaculo\":");
        String stringPremio = obtenerValorString(celdaJsonString, "\"premio\":");

        Premio itemPremio = obtenerPremioPorString(stringPremio);
        Obstaculo itemObstaculo = obtenerObstaculoPorString(stringObstaculo);

        Coordenada coordenada = new Coordenada(x,y);

        if(stringTipo.equals("Camino")){

            return new CasillaCamino(coordenada, null,itemObstaculo, itemPremio);
        } else if(stringTipo.equals("Salida")){

            return new CasillaInicio(coordenada, null);
        } else if(stringTipo.equals("Llegada")){

            return new CasillaFinal(coordenada);
        } else{
            throw new TipoCasillaInvalidaException("El tipo de casilla introducido en una casilla no es válido.");
        }
    }

    private int obtenerValorNumerico(String json, String clave) {

        if (!json.contains(clave)){
            throw new FormatoInvalidoMapaException("No se encontró la clave" + clave + " en al menos una casilla. El formato no es válido");
        }

        int inicio = json.indexOf(clave) + clave.length();
        int fin ;
        int proxComa = json.indexOf(",", inicio);
        int proxLlave = json.indexOf("}", inicio);

        if(proxComa < proxLlave)
            fin = proxComa;
        else
            fin = proxLlave;

        return Integer.parseInt(json.substring(inicio, fin).trim());
    }

    private String obtenerValorString(String json, String clave) {

        if (!json.contains(clave)){
            throw new FormatoInvalidoMapaException("No se encontró la clave" + clave + " en al menos una casilla. El formato no es válido");
        }

        int inicio = json.indexOf(clave) + clave.length();

        int fin = json.indexOf("\"", inicio + 2);
        return json.substring(inicio + 2, fin).trim();
    }

    private Premio obtenerPremioPorString(String stringPremio) {

        Premio itemPremio ;

        if(stringPremio.equals("Equipamiento")){
            itemPremio = new PremioEquipamiento();
        } else if (stringPremio.equals("Comida")) {
            itemPremio = new PremioComestible();
        } else if(stringPremio.isEmpty()){
            itemPremio = new PremioNulo();
        } else {
            throw new PremioInvalidoException("El premio introducido en una casilla no es válido.");
        }

        return itemPremio;
    }

    private Obstaculo obtenerObstaculoPorString(String stringObstaculo){

        Obstaculo itemObstaculo ;

        if(stringObstaculo.equals("Fiera")){
            itemObstaculo = new FieraSalvaje();
        } else if (stringObstaculo.equals("Lesion")) {
            itemObstaculo = new Lesion();
        } else if(stringObstaculo.equals("Bacanal")){
            itemObstaculo = new Bacanal();
        } else if (stringObstaculo.isEmpty()){
            itemObstaculo = new ObstaculoNulo();
        } else {
            throw new ObstaculoInvalidoException("El obstáculo introducido en una casilla no es válido.");
        }

        return itemObstaculo;

    }

    private void obtenerDimensionesMapa(String stringParteMapa){

        int anchoMapa = obtenerValorNumerico(stringParteMapa, "\"ancho\":");
        int largoMapa = obtenerValorNumerico(stringParteMapa, "\"largo\":");

        if (largoMapa < 1){

            throw new MapaDimensionesInconsistentesException("Se ingresó un mapa con largo menor o igual a cero. Formato inválido");
        }

        if (anchoMapa < 1){

            throw new MapaDimensionesInconsistentesException("Se ingresó un mapa con ancho menor o igual a cero. Formato inválido");

        }

        this.largo = largoMapa ;
        this.ancho = anchoMapa ;

    }

    private void validarCoordenadaCasilla(Coordenada coordenada){

        if(coordenada.getX() < 1 || coordenada.getX() > this.largo || coordenada.getY() < 0 || coordenada.getY() > this.ancho){

            throw new CasillaFueraDeMapaException("Al menos una casilla se encuentra fuera de las dimensiones del mapa. Formato de mapa inválido. ");

        }


    }

}


