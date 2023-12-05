package edu.fiuba.algo3.controller;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class NombreJugadoresFormController {

    public VBox mainBox;
    public Button botonContinuar;

    private static final String ESTILO_TEXT_FIELD = "textField";

    public void inicializarTextFields(int cantidadJugadores) {
        for (int i = 0; i < cantidadJugadores; i++) {
            Label label = new Label();
            label.setText("Nombre Jugador" + (i + 1));
            TextField textField = new TextField();
            textField.setPromptText("nombre");

            textField.getStyleClass().add(ESTILO_TEXT_FIELD);
            mainBox.getChildren().add(label);
            mainBox.getChildren().add(textField);
        }
    }
}
