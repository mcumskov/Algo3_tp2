package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class NombreJugadoresForm extends GridPane{
    private BorderPane contenedorPrincipal;

    public NombreJugadoresForm(BorderPane main, int cantidadJugadores) {
        this.contenedorPrincipal = main;
        ArrayList<TextField> arrayInputs = new ArrayList<>();
        int fila = 0;
        for (int i = 1; i <= cantidadJugadores; i++) {
            Label nombreLabel = new Label();
            nombreLabel.setText("Nombre Jugador "+i+":");
            TextField nombreField = new TextField();
            nombreLabel.setLabelFor(nombreField);

            nombreField.textProperty().addListener((observable, oldValue, newValue) -> {
                visualizarErrorNombreJugador(nombreField, nombreJugadorConError(newValue));
            });

            this.add(nombreLabel, 0, fila);
            this.add(nombreField, 1, fila);
            arrayInputs.add(nombreField);

            fila++;
        }

        Button continuar = new Button("Continuar");
        continuar.setOnAction(e -> {
            boolean error = false;
            for (TextField campo: arrayInputs) {
                if(!error){
                    error = this.nombreJugadorConError(campo.getText());
                }
            }

            if (!error){
                this.mostrarMenu();
            }
        });

        this.add(continuar,1,fila);

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));


    }

    private void mostrarMenu(){
        Menu menu = new Menu(this.contenedorPrincipal);
        this.contenedorPrincipal.setCenter(menu);
    }

    private boolean nombreJugadorConError(String nombre){
        return !(Pattern.matches(".{4,}", nombre));
    }

    private void visualizarErrorNombreJugador(TextField campo, boolean mostrar){
        if (mostrar){
            campo.setStyle("-fx-text-fill: red;");
        } else {
            campo.setStyle("-fx-text-fill: green;");
        }
    }
}
