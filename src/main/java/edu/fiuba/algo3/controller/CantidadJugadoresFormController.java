package edu.fiuba.algo3.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

import java.io.IOException;



public class CantidadJugadoresFormController {
    @FXML
    public TextField cantidadJugadoresTextField;
    public Button botonContinuar;
    public StackPane mainPane;

    private static final String ESTILO_VALIDO = "valido";
    private static final String ESTILO_INVALIDO = "invalido";
    private static final int CANTIDAD_MINIMA_JUGADORES = 2;
    private static final int CANTIDAD_MAXIMA_JUGADORES = 6;

    public void initialize() {
        cantidadJugadoresTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                actualizarColorTexto();
            }
        });

        cantidadJugadoresTextField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    continuarButtonAction();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private void actualizarColorTexto() {
        int cantidad = getCantidadJugadores();
        if (cantidad >= CANTIDAD_MINIMA_JUGADORES && cantidad <= CANTIDAD_MAXIMA_JUGADORES) {
            cantidadJugadoresTextField.getStyleClass().removeAll(ESTILO_INVALIDO);
            cantidadJugadoresTextField.getStyleClass().add(ESTILO_VALIDO);
        } else {
            cantidadJugadoresTextField.getStyleClass().removeAll(ESTILO_VALIDO);
            cantidadJugadoresTextField.getStyleClass().add(ESTILO_INVALIDO);
        }
    }

    private int getCantidadJugadores() {
        try {
            return Integer.parseInt(cantidadJugadoresTextField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public void mostrarNombreDeJugadoresForm() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CantidadJugadoresFormController.class.getResource("/edu/fiuba/algo3/nombre-jugadores-form-view.fxml"));
        Parent newView = fxmlLoader.load();

        NombreJugadoresFormController nombreJugadoresController = fxmlLoader.getController();
        nombreJugadoresController.initialize(getCantidadJugadores());

        mainPane.getChildren().setAll(newView);

    }

    @FXML
    public void continuarButtonAction() throws IOException {
        int cantidad = getCantidadJugadores();
        if (cantidad >= CANTIDAD_MINIMA_JUGADORES && cantidad <= CANTIDAD_MAXIMA_JUGADORES) mostrarNombreDeJugadoresForm();
    }

}
