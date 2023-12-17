package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Eventos.Obstaculos.Obstaculo;
import edu.fiuba.algo3.modelo.Eventos.Premios.Premio;
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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.mapa.iMapa;

import java.io.InputStream;
import java.io.PrintStream;
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
        int anchoCasilla;
        int largoCasilla;
        private String[] nombres;
        private int cantidadPlayers;

    public ControladorJuego(Stage mainStage, iMapa mapa, int cantidadPlayers, String[] nombres){
        this.mainStage = mainStage;
        this.vistaJuego = new VistaJuego(mainStage);
        this.mapa = mapa;
        this.buttons = new ArrayList<>();
        this.juego = null;
        this.anchoCasilla = 65;
        this.largoCasilla = 70;
        this.cantidadPlayers = cantidadPlayers;
        this.nombres = nombres;
    }

    public void start(){
        Button jugarButton = new Button("Tirar dado");
        jugarButton.setOnAction(e -> tirarDado());
        this.buttons.add(jugarButton);

        Button pasarButton = new Button("Pasar");
        pasarButton.setOnAction(e -> terminarTurno());
        this.buttons.add(pasarButton);
        pasarButton.setDisable(true);

        ArrayList<iJugador> jugadores = new ArrayList<>();
        List<Gladiador> gladiadores = new ArrayList<>();
        for(int i = 0; i<this.cantidadPlayers; i++){
            iJugador jugador = new Jugador(this.nombres[i],i+1);
            jugadores.add(jugador);
            gladiadores.add(jugador.getGladiador());
        }

        mapa.ingresarGladiadores(gladiadores, this.cantidadPlayers);

        iDado dado = new Dado();

        Juego.resetInstancia();
        this.juego = Juego.instanciarJuego(mapa, jugadores, dado);
        this.juego.siguienteTurno();

        GridPane renderMapa = crearMapa();


        this.vistaJuego.mostrarJuego(buttons.get(0), buttons.get(1), renderMapa);
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

    public GridPane crearMapa(){

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

            dibujarCasilla(canvas,casilla);


            StackPane.setAlignment(canvas, javafx.geometry.Pos.CENTER_RIGHT);

            stack.getChildren().addAll(imageView, canvas);

            casilla.agregarObserver((o, arg) -> dibujarCasilla(canvas, casilla));

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


    public void dibujarCasilla(Canvas canvas, iCasilla casilla){

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, anchoCasilla, largoCasilla);
        gc.setFont(javafx.scene.text.Font.font("Arial", 15));
        GraphicsContext gc2 = canvas.getGraphicsContext2D();
        gc2.setFont(javafx.scene.text.Font.font("Arial", 15));

        dibujarPremioObstaculo(casilla, gc, gc2);

        GraphicsContext gc3 = canvas.getGraphicsContext2D();
        gc2.setFont(javafx.scene.text.Font.font("Arial", 15));
        dibujarGladiadores(casilla,gc3);

    }

    private void dibujarGladiadores(iCasilla casilla, GraphicsContext gc) {

        int[][] Posiciones = {
                {10, 10, 5, 15},
                {30, 10, 25, 15},
                {50, 10, 45, 15},
                {10, 30, 5, 35},
                {30, 30, 25, 35},
                {50, 30, 45, 35}
        };

        List<Gladiador> gladiadores = casilla.getGladiadores();
        int cantidadGladiadores = gladiadores.size();
        for(int i=0; i<cantidadGladiadores; i++){
            int[] posiciones = Posiciones[i];
            dibujarCirculo(gc, posiciones[0], posiciones[1], 8, Color.BLACK);
            gc.setFill(javafx.scene.paint.Color.WHITE);
            char num = (char)(gladiadores.get(i).getNumeroPlayer() + '0');
            gc.fillText(""+num, posiciones[2], posiciones[3]);
        }
    }

    private void dibujarPremioObstaculo(iCasilla casilla, GraphicsContext gc, GraphicsContext gc2){
        Premio premio = casilla.getPremio();
        char letraPremio = ' ';
        if(premio!=null){
            letraPremio = premio.getRepresentacion();
            if(letraPremio != ' '){
                dibujarCirculo(gc, 22, 56, 8, Color.GREEN);
            }
        }
        gc.setFill(javafx.scene.paint.Color.BLACK);
        gc.fillText(""+letraPremio, 16, 62);

        Obstaculo obstaculo = casilla.getObstaculo();
        char letraObstaculo = ' ';
        if(obstaculo != null){
            letraObstaculo = obstaculo.getRepresentacion();
            if(letraObstaculo != ' '){
                dibujarCirculo(gc2, 42, 56, 8, Color.RED);
            }
        }
        gc2.setFill(javafx.scene.paint.Color.BLACK);
        gc2.fillText(""+letraObstaculo, 38, 62);

    }

    private void dibujarCirculo(GraphicsContext gc, double x, double y, double radio, Color color){
        gc.setFill(color);
        gc.fillOval(x - radio, y - radio, 2 * radio, 2 * radio);
    }

    public void update(Observable o, Object arg) {

    }
}
