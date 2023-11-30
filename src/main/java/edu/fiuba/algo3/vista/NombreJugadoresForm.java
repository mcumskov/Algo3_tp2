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

public class NombreJugadoresForm extends GridPane{
    private BorderPane contenedorPrincipal;

    private Button continuar;

    public NombreJugadoresForm(BorderPane main, int cantidadJugadores) {
        this.contenedorPrincipal = main;
        ArrayList<HashMap> inputs = new ArrayList<>();

        for (int i = 1; i <= cantidadJugadores; i++) {
            Label nombreLabel = new Label();
            nombreLabel.setText("Nombre Jugador "+i+":");
            TextField nombreField = new TextField();
            nombreLabel.setLabelFor(nombreField);

            HashMap<String, Object> comboInput = new HashMap();
            comboInput.put("label", nombreLabel);
            comboInput.put("input", nombreField);;

            inputs.add(comboInput);
        }

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));

        int fila = 0;
        for (HashMap<String, Object> comboInput : inputs) {
            Label label = (Label) comboInput.get("label");
            TextField textField = (TextField) comboInput.get("input");

            this.add(label, 0, fila);
            this.add(textField, 1, fila);

            fila++;
        }

        this.continuar = new Button("Continuar");
        this.continuar.setOnAction(e -> {

        });
    }
}
