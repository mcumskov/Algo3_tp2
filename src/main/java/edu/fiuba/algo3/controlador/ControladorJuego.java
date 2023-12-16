package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.dado.iDado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.iJugador;
import edu.fiuba.algo3.modelo.mapa.CasillaCamino;
import edu.fiuba.algo3.modelo.mapa.Coordenada;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.mapa.iMapa;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class ControladorJuego implements Observer{

    Stage mainStage;
    VistaJuego vistaJuego;
    iMapa mapa;
    private List<Button> buttons;
    Juego juego;

    GridPane grid;
    int anchoCasilla;
    int largoCasilla;

public ControladorJuego(Stage mainStage, iMapa mapa){
    this.mainStage = mainStage;
    this.vistaJuego = new VistaJuego(mainStage);
    this.mapa = mapa;
    this.buttons = new ArrayList<>();
    this.juego = null;
    this.anchoCasilla = 65;
    this.largoCasilla = 70;

}
public void start(){
    Button jugarButton = new Button("Tirar dado");
    jugarButton.setOnAction(e -> tirarDado());
    this.buttons.add(jugarButton);

    Button pasarButton = new Button("Pasar");
    pasarButton.setOnAction(e -> terminarTurno());
    this.buttons.add(pasarButton);
    pasarButton.setDisable(true);
    iJugador jugador1 = new Jugador("mip");
    iJugador jugador2 = new Jugador("tip");

    ArrayList<iJugador> jugadores = new ArrayList<>();
    jugadores.add(jugador1);
    jugadores.add(jugador2);

    List<Gladiador> gladiadores = new ArrayList<>();
    gladiadores.add(jugador1.getGladiador());
    gladiadores.add(jugador2.getGladiador());

    mapa.ingresarGladiadores(gladiadores, 2);

    iDado dado = new Dado();

    Juego.resetInstancia();
    this.juego = Juego.instanciarJuego(mapa, jugadores, dado);
    this.juego.siguienteTurno();

    this.grid = crearGrid();



    this.vistaJuego.mostrarJuego(buttons.get(0), buttons.get(1), this.grid);
}

public void tirarDado(){
    this.juego.tirarDado();
    buttons.get(1).setDisable(false);
    buttons.get(0).setDisable(true);
/*
    ControladorPrototipo caca = new ControladorPrototipo();
    caca.caca(this.grid);*/
}
public void terminarTurno(){
    this.juego.siguienteTurno();
    buttons.get(1).setDisable(true);
    buttons.get(0).setDisable(false);
}

public GridPane crearGrid(){

    int largoMapa = this.mapa.getLargo();
    int anchoMapa = this.mapa.getAncho();
    List<iCasilla> casillas = this.mapa.getCasillas();
    GridPane gridPane = new GridPane();

    for (int fila = 1; fila <= anchoMapa; fila++) {
        for (int col = 1; col <= largoMapa; col++) {
            StackPane stackPane = new StackPane();
            String path1 = "/image/imagenDesierto.png";
            InputStream input = getClass().getResourceAsStream(path1);
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(this.anchoCasilla); // Ancho deseado
            imageView.setFitHeight(this.largoCasilla); // Altura deseada

            stackPane.getChildren().addAll(imageView);

            gridPane.add(stackPane, col, fila);
        }
    }

    int tope = casillas.size();

    for (int i=0 ; i< tope; i++){

        iCasilla casilla = casillas.get(i);
        Coordenada coordenada = casilla.getCoordenada();
        Node nodito = getNodo(gridPane,coordenada.getX() ,coordenada.getY());
        StackPane stack =  (StackPane) nodito;



        String path1 = "/image/imagenCamino.png";


        if(i==0){
            path1 = "/image/imagenCasillaInicio.png";

        } else if (i == tope-1){
            path1 = "/image/imagenCasillaFinal.png";
        }

        InputStream input = getClass().getResourceAsStream(path1);
        Image image = new Image(input);

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(this.anchoCasilla); // Ancho deseado
        imageView.setFitHeight(this.largoCasilla); // Altura deseada

        Canvas canvas = new Canvas(anchoCasilla, largoCasilla);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFont(javafx.scene.text.Font.font("Arial", 15));
      //gc.setFill(javafx.scene.paint.Color.WHITE);
        gc.fillText("A", 16, 62);

        GraphicsContext gc2 = canvas.getGraphicsContext2D();
        gc2.setFont(javafx.scene.text.Font.font("Arial", 15));

        //gc2.setFill(javafx.scene.paint.Color.WHITE);
        gc2.fillText("B", 38, 62);

        StackPane.setAlignment(canvas, javafx.geometry.Pos.CENTER_RIGHT);

        stack.getChildren().addAll(imageView, canvas);

    }
    return gridPane;
}
private Node getNodo(GridPane gridPane, int col, int fila) {
    for (Node nodo : gridPane.getChildren()) {
        if (GridPane.getColumnIndex(nodo) == col && GridPane.getRowIndex(nodo) == fila) {
            return nodo;
        }
    }
    return null;
}
public void update(Observable o, Object arg) {

    this.grid = crearGrid();
    this.vistaJuego.mostrarJuego(buttons.get(0), buttons.get(1), this.grid);

}

}
