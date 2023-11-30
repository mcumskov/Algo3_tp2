package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.*;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.excepciones.ObstaculoInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.PremioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.TipoCasillaInvalidaException;
import edu.fiuba.algo3.modelo.excepciones.FormatoInvalidoMapaException;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<iCasilla> casillas ;

    private int ancho ;
    private int alto ;

    protected iCasilla casillaAnterior;

    public void Parser(){
        this.casillaAnterior = null;
    }

    public List<iCasilla> parsearJSON (String jsonString) {

        List<iCasilla> casillas = new ArrayList<>();

        // Dividir la cadena JSON en partes para analizar
        String[] partes = jsonString.split("\"celdas\":\\s*\\[");

        Coordenada dimensionesMapa ;
        dimensionesMapa = obtenerDimensionesMapa(partes[0]);

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
            if(this.casillaAnterior != null){
                this.casillaAnterior.SetSiguiente(casilla);
            }
            this.casillaAnterior = casilla;
        }

        // Falta implementar
        // validarListaCasillas() ;


        return casillas;
    }

    private void validarListaCasillas(){

        // Tendríamos que validar que:
        // 1) la primera casilla sea de la clase CasillaInicio
        // 2) la última casilla sea de la clase CasillaFinal
        // 3) las casillas del medio sean del tipo CasillaCamino
        // 4) Las coordenadas de las casillas sean contiguas entre sí (que formen un camino continuo)

        // Generar excepciones y tests

    }

    private static iCasilla construirCasillaDesdeJSON(String celdaJsonString) {

        // Validaciones de presencia de llave
        if (!celdaJsonString.contains("\"x\":")){
            throw new FormatoInvalidoMapaException("No se encontró la coordenada X de al menos una casilla. El formato no es válido");
        }

        if (!celdaJsonString.contains("\"y\":")){
            throw new FormatoInvalidoMapaException("No se encontró la coordenada Y de al menos una casilla. El formato no es válido");
        }

        if (!celdaJsonString.contains("\"tipo\":")){
            throw new FormatoInvalidoMapaException("No se encontró la clave con el tipo de casilla de al menos una casilla. El formato no es válido");
        }

        if (!celdaJsonString.contains("\"obstaculo\":")){
            throw new FormatoInvalidoMapaException("No se encontró la clave con el tipo de obstáculo de al menos una casilla. El formato no es válido");
        }

        if (!celdaJsonString.contains("\"premio\":")){
            throw new FormatoInvalidoMapaException("No se encontró la clave con el tipo de premio de al menos una casilla. El formato no es válido");
        }

        int y = obtenerValorNumerico(celdaJsonString, "\"y\":");
        int x = obtenerValorNumerico(celdaJsonString, "\"x\":");

        Coordenada coordenada = new Coordenada(x,y);

        String stringTipo = obtenerValorString(celdaJsonString, "\"tipo\":");
        String stringObstaculo = obtenerValorString(celdaJsonString, "\"obstaculo\":");
        String stringPremio = obtenerValorString(celdaJsonString, "\"premio\":");

        Premio itemPremio = obtenerPremioPorString(stringPremio);
        Obstaculo itemObstaculo = obtenerObstaculoPorString(stringObstaculo);

        if(stringTipo.equals("Camino")){

            return new Casilla(coordenada, null,itemObstaculo, itemPremio);
        } else if(stringTipo.equals("Salida")){

            return new Casilla(coordenada, null, itemObstaculo, itemPremio);
        } else if(stringTipo.equals("Llegada")){

            return new Casilla(coordenada, null, itemObstaculo, itemPremio);
        } else{
            throw new TipoCasillaInvalidaException("El tipo de casilla introducido en una casilla no es válido.");
        }
    }

    private static int obtenerValorNumerico(String json, String clave) {
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

    private static String obtenerValorString(String json, String clave) {
        int inicio = json.indexOf(clave) + clave.length();

        int fin = json.indexOf("\"", inicio + 2);
        return json.substring(inicio + 2, fin).trim();
    }

    private static Premio obtenerPremioPorString(String stringPremio) {

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

    private static Obstaculo obtenerObstaculoPorString(String stringObstaculo){

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

    private static Coordenada obtenerDimensionesMapa(String stringParteMapa){

        // La parte 0 contiene las dimensiones del mapa
        if (!stringParteMapa.contains("\"ancho\":")){
            throw new FormatoInvalidoMapaException("No se encontró la clave con el alto del mapa. El formato no es válido");
        }

        if (!stringParteMapa.contains("\"largo\":")){
            throw new FormatoInvalidoMapaException("No se encontró la clave con el alto del mapa. El formato no es válido");
        }

        int anchoMapa = obtenerValorNumerico(stringParteMapa, "\"ancho\":");
        int largoMapa = obtenerValorNumerico(stringParteMapa, "\"largo\":");

        return new Coordenada(anchoMapa, largoMapa);

    }

}


