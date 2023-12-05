package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.App;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;



public class CantidadJugadoresFormController {
    @FXML
    public TextField cantidadJugadoresTextField;
    public Button botonContinuar;
    public StackPane mainPane;

    private static final String ESTILO_VALIDO = "valido";
    private static final String ESTILO_INVALIDO = "invalido";

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
        if (cantidad >= 2 && cantidad <= 6) {
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
        if (cantidad >= 2 && cantidad <= 6) {

            mostrarNombreDeJugadoresForm();

        } else {
            // Muestra un mensaje de error o toma alguna acción según tus necesidades
            System.out.println("La cantidad de jugadores debe estar entre 2 y 6");
        }
    }

}
