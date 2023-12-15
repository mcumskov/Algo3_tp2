package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.dado.Dado;
import edu.fiuba.algo3.modelo.dado.iDado;
import edu.fiuba.algo3.modelo.gladiador.Gladiador;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.jugador.Jugador;
import edu.fiuba.algo3.modelo.jugador.iJugador;
import edu.fiuba.algo3.modelo.mapa.Coordenada;
import edu.fiuba.algo3.modelo.mapa.iCasilla;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.mapa.iMapa;

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

public ControladorJuego(Stage mainStage, iMapa mapa){
    this.mainStage = mainStage;
    this.vistaJuego = new VistaJuego(mainStage);
    this.mapa = mapa;
    this.buttons = new ArrayList<>();
    this.juego = null;

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

    GridPane grid = crearGrid();


    this.vistaJuego.mostrarJuego(buttons.get(0), buttons.get(1), grid);
}

public void tirarDado(){
    this.juego.tirarDado();
    buttons.get(1).setDisable(false);
    buttons.get(0).setDisable(true);
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
    List<Coordenada> coordenadas = new ArrayList<>();
    GridPane gridPane = new GridPane();

    for (iCasilla casilla:casillas) {
        coordenadas.add(casilla.getCoordenada());
    }

    for (int fila = 1; fila <= anchoMapa; fila++) {
        for (int col = 1; col <= largoMapa; col++) {
            Rectangle rectangulo = new Rectangle(42, 32);
            rectangulo.setFill(Color.ROSYBROWN);
            rectangulo.setStroke(Color.ROSYBROWN.darker());

            gridPane.add(rectangulo, col, fila);
        }
    }

    int tope = coordenadas.size();

    for (int i=0 ; i< tope; i++){
        Coordenada coordenada = coordenadas.get(i);
        Node nodito = getNodo(gridPane,coordenada.getX() ,coordenada.getY());
        Rectangle rectangulito =  (Rectangle) nodito;
        rectangulito.setFill(Color.SANDYBROWN);
        rectangulito.setStroke(Color.BLACK);
        if(i==0){
            rectangulito.setFill(Color.GAINSBORO);
        } else if (i == tope-1){
            rectangulito.setFill(Color.GREY);
        }
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

    @Override
    public void update(Observable o, Object arg) {

    }

}
