package edu.fiuba.algo3.vista;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class CantidadJugadoresForm extends GridPane {

    private BorderPane contenedorPrincipal;
    private TextField inputNumerico;
    private Label labelNumerico;
    private Button continuar;
    public CantidadJugadoresForm(BorderPane main) {
        contenedorPrincipal = main;
        labelNumerico = new Label();
        labelNumerico.setText("Cantidad de jugadores");
        inputNumerico = new TextField();
        labelNumerico.setLabelFor(inputNumerico);
        inputNumerico.setPromptText("Ingrese un número");

        inputNumerico.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                inputNumerico.setText(newValue.replaceAll("[^\\d]", ""));
            }
            int cantidadJugadores = this.getCantidadJugadores();
            visualizarErrorCantidadJugadores(this.inputNumerico,cantidadJugadoresConError(cantidadJugadores));
        });

        continuar = new Button("Continuar");
        continuar.setOnAction(e -> {
            int cantidadJugadores = this.getCantidadJugadores();
            if(!cantidadJugadoresConError(cantidadJugadores)){
                mostrarNombreJugadoresForm(cantidadJugadores);
            }
        });

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));

        this.add(labelNumerico, 0, 0);
        this.add(inputNumerico, 1, 0);
        this.add(continuar,1,2);
    }

    private void mostrarNombreJugadoresForm(int cantidadJugadores){
        GridPane nombreJugadoresForm = new NombreJugadoresForm(this.contenedorPrincipal, cantidadJugadores);
        this.contenedorPrincipal.setCenter(nombreJugadoresForm);
    }

    private int getCantidadJugadores() {
        try {
            return Integer.parseInt(inputNumerico.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private boolean cantidadJugadoresConError(int cantidad){
        return !(cantidad >= 2 && cantidad <= 6);
    }

    private void visualizarErrorCantidadJugadores(TextField campo, boolean mostrar){
        if (mostrar){
            campo.setStyle("-fx-text-fill: red;");
        } else {
            campo.setStyle("-fx-text-fill: green;");
        }
    }
}