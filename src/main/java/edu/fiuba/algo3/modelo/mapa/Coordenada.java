package edu.fiuba.algo3.modelo.mapa;

public class Coordenada {

    private int x ;
    private int y ;

    public Coordenada(int x, int y){

        this.x = x ;
        this.y = y ;
    }

    public int getX(){

        return this.x ;

    }

    public int getY(){

        return this.y ;
    }

    public Boolean esContigua(Coordenada coordenada){

        int minX = this.x - 1 ;
        int maxX = this.x + 1 ;
        int minY = this.y - 1 ;
        int maxY = this.y + 1 ;

        return ((coordenada.getX() <= maxX) && (coordenada.getX() >= minX) && (coordenada.getY() <= maxY) && (coordenada.getY() >= minY));
    }

}
