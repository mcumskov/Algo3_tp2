package edu.fiuba.algo3.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NombreJugadoresFormController {

    @FXML
    public StackPane mainPane;
    public VBox nombreJugadoresBox;
    public Button botonContinuarAJuego;

    private List<TextField> textFields;

    private static final String ESTILO_VALIDO = "valido";
    private static final String ESTILO_INVALIDO = "invalido";
    private static final String TEXT_FIELD_CLASS = "textField";
    private static final String LABEL_CLASS = "labelNombre";
    private static final String JUGADOR_BOX_CLASS = "jugadorBox";


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
            HBox jugadorBox = new HBox();  // Nuevo HBox para cada par de Label y TextField
            jugadorBox.getStyleClass().add(JUGADOR_BOX_CLASS);

            Label label = new Label();
            label.setText("Jugador" + (i + 1));
            label.getStyleClass().add(LABEL_CLASS);

            TextField textField = new TextField();
            textField.setPromptText("nombre");
            textField.getStyleClass().add(TEXT_FIELD_CLASS);
            textField.setId("nombre" + (i + 1));

            jugadorBox.getChildren().addAll(label, textField);
            nombreJugadoresBox.getChildren().add(jugadorBox);

            textFields.add(textField);
        }
    }

    public void continuarAJuego(ActionEvent actionEvent) {
        if(nombresValidos()) System.out.println("Inicia el Juego...");
    }

    private boolean nombresValidos() {
        boolean nombreValido = true;
        for (TextField t : textFields) {
            String nombre = t.getText();
            if (nombre.length() < 4) {
                nombreValido = false;
            }
        }
        return nombreValido;
    }
}
