package edu.fiuba.algo3.modelo.parser;

import edu.fiuba.algo3.modelo.excepciones.NoSePudoAbrirArchivoException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectorJSON {

    public LectorJSON(){};

    public String leerJSON(String nombreJSON){

        String contenidoJSON ;

        try {

            contenidoJSON = new String(Files.readAllBytes(Paths.get(nombreJSON)));

        } catch (IOException e) {

            throw new NoSePudoAbrirArchivoException("No se pudo abrir el archivo con ruta: " + nombreJSON +" . || " + e.getMessage());
        }

        return contenidoJSON ;

    }
}
