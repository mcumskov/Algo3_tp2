package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Menu extends GridPane {

    private BorderPane contenedorPrincipal;
    public Menu(BorderPane main){
        this.contenedorPrincipal = main;


        Button iniciarJuego = new Button("Iniciar Juego");
        iniciarJuego.setOnAction(e -> {
        });

        Button mostrarMapa = new Button("Mostrar Mapa");
        mostrarMapa.setOnAction(e -> {

        });

        this.add(iniciarJuego, 0,0);
        this.add(mostrarMapa, 1,0);

        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(20));
    }
}
