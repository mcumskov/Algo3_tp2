package edu.fiuba.algo3.controlador;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
public class ControladorPrototipo {

    public ControladorPrototipo(){

    }

    public void caca(GridPane gridPane){

        Node nodito = getNodo(gridPane,5 ,5);
        Rectangle rectangulito =  (Rectangle) nodito;
        rectangulito.setFill(Color.WHITESMOKE);

    }

    private Node getNodo(GridPane gridPane, int col, int fila) {
        for (Node nodo : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(nodo) == col && GridPane.getRowIndex(nodo) == fila) {
                return nodo;
            }
        }
        return null;
    }

}
