package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.*;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioNulo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioComestible;
import edu.fiuba.algo3.modelo.Eventos.Premios.PremioEquipamiento;
import edu.fiuba.algo3.modelo.excepciones.ObstaculoInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.PremioInvalidoException;
import edu.fiuba.algo3.modelo.excepciones.TipoCasillaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    List<Casilla> casillas ;

    private int ancho ;
    private int alto ; // esto calculo q tampoco lo necesitamos

    protected Casilla casillaAnterior;

    public void Parser(){
        this.casillaAnterior = null;
    }

    public List<Casilla> parsearJSON (String jsonString) {

        List<Casilla> casillas = new ArrayList<>();

        // Dividir la cadena JSON en partes para analizar
        String[] partes = jsonString.split("\"celdas\":\\s*\\[");

        // La parte[1] contiene las celdas
        String celdasJson = partes[1].substring(0, partes[1].length() - 3);
        String[] celdasArray = celdasJson.split("\\},\\s*\\{");

        // Iterar sobre las celdas y construir objetos Casilla
        for (String celdaJson : celdasArray) {
            // Agregar llaves faltantes para convertir cada celda en un objeto JSON válido
            celdaJson = "{" + celdaJson + "}";

            // Crear objeto Casilla y agregar a la lista
            Casilla casilla = construirCasillaDesdeJSON(celdaJson);
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

    private static Casilla construirCasillaDesdeJSON(String celdaJson) {


        //int x = obtenerValorNumerico(celdaJson, "\"x\":"); esto maia dijo q ya no
        //int y = obtenerValorNumerico(celdaJson, "\"y\":"); lo queremos
        //Coordenada coordenada = new Coordenada(x,y);

        String tipo = obtenerValorString(celdaJson, "\"tipo\":");
        String obstaculo = obtenerValorString(celdaJson, "\"obstaculo\":");
        String premio = obtenerValorString(celdaJson, "\"premio\":");

        Obstaculo itemObstaculo ;

        if(obstaculo.equals("Fiera")){
            itemObstaculo = new FieraSalvaje();
        } else if (obstaculo.equals("Lesion")) {
            itemObstaculo = new Lesion();
        } else if(obstaculo.equals("Bacanal")){
            itemObstaculo = new Bacanal();
        } else if (obstaculo.isEmpty()){
            itemObstaculo = new ObstaculoNulo();
        } else {
            throw new ObstaculoInvalidoException("El obstáculo introducido en una casilla no es válido.");
        }

        Premio itemPremio ;

        if(premio.equals("Equipamiento")){
            itemPremio = new PremioEquipamiento();
        } else if (premio.equals("Comida")) {
            itemPremio = new PremioComestible();
        } else if(premio.isEmpty()){
            itemPremio = new PremioNulo();
        } else {
            throw new PremioInvalidoException("El premio introducido en una casilla no es válido.");
        }

        if(tipo.equals("Camino")){

            return new CasillaCamino(null,itemObstaculo, itemPremio);

        }
        else if(tipo.equals("Salida")){

            return new CasillaInicio(null, itemObstaculo, itemPremio);

        }else if(tipo.equals("Llegada")){

            return new CasillaFinal(null, itemObstaculo, itemPremio);

        }else{
            throw new TipoCasillaInvalidaException("El tipo de casilla introducido en una casilla no es válido.");
        }
    }

    private static int obtenerValorNumerico(String json, String clave) {
        int inicio = json.indexOf(clave) + clave.length();
        int fin = json.indexOf(",", inicio);
        if (fin == -1) {
            fin = json.indexOf("}", inicio);
        }
        return Integer.parseInt(json.substring(inicio, fin).trim());
    }

    private static String obtenerValorString(String json, String clave) {
        int inicio = json.indexOf(clave) + clave.length();

        int fin = json.indexOf("\"", inicio + 2);
        return json.substring(inicio + 2, fin).trim();
    }


}


