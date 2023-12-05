package edu.fiuba.algo3.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NombreJugadoresFormController {

    public VBox mainBox;
    public Button botonContinuar;

    private List<TextField> textFields;

    private static final String ESTILO_VALIDO = "valido";
    private static final String ESTILO_INVALIDO = "invalido";
    private static final String ESTILO_TEXT_FIELD = "textField";

    public void initialize(int cantidadJugadores) {

        textFields = new ArrayList<TextField>();
        inicializarTextFields(cantidadJugadores);
        for (TextField t : textFields) {
            t.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    actualizarColorTexto();
                }
            });
        }

    }

    private void actualizarColorTexto() {

        for (TextField t : textFields) {
            String nombre = t.getText();
            if (nombre.length() >= 4) {
                t.getStyleClass().removeAll(ESTILO_INVALIDO);
                t.getStyleClass().add(ESTILO_VALIDO);
            } else {
                t.getStyleClass().removeAll(ESTILO_VALIDO);
                t.getStyleClass().add(ESTILO_INVALIDO);
            }
        }

    }

    public void inicializarTextFields(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {

            Label label = new Label();
            label.setText("Nombre Jugador" + (i + 1));

            TextField textField = new TextField();
            textField.setPromptText("nombre");
            textField.getStyleClass().add(ESTILO_TEXT_FIELD);
            textField.setId("nombre" + i+1);

            mainBox.getChildren().add(label);
            textFields.add(textField);
            mainBox.getChildren().add(textField);
        }
    }

}
