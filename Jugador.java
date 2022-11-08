/**
 * CLASE JUGADOR.
 * 
 * Esta clase permite generar objetos de tipo jugador, almacenando
 * los atributos que a estos describen y permitiendo operar con estos.
 * 
 * @author Samuel Borque 
 * @version V01 - 11/22
 */

import java.lang.Math;

public class Jugador {
    // Atributos:
    private int casilla;
    private String nombre;
    
    // Constructores:
    /**
     * Constructor de objeto jugador. Genera un objeto jugador y 
     * permite introducir el nombre de este.
     *
     * @param nombre Nombre del jugador.
     */
    public Jugador(String nombre){
        this.casilla = 0;
        this.nombre = nombre;
    }
    
    
    // Métodos:    
    /**
     * Método que permite el avance del jugador por el tablero.
     * El número de casillas debe ser positivo y estar entre 
     * uno y seis ambos incluidos.
     *
     * @param n_casillas Número de casillas a mover.
     */
    public void AvanzaCasillas(int n_casillas){
        if (n_casillas > 0 && n_casillas <= 6)
            this.casilla += Math.abs(n_casillas);
    }
    
    /**
     * Este método permite al jugador utilizar elementos de
     * la partida (toboganes y escaleras).
     * Para ello iguala la casilla en la que se encuentra el
     * jugador a la casilla final del elemento introducido 
     * como argumento.
     *
     * @param e Objeto de la clase Elememto.
     */
    public void UsaElemento(Elemento e){
        this.casilla = e.CasillaFinal();
    }
    
    /**
     * Este método comprueba si el jugador ha ganado la partida.
     *
     * @param tablero Objeto tablero.
     * @return Resultado de la comprobación.
     */
    public boolean HaGanado(Tablero tablero){
        return this.casilla == tablero.CasillaFinal();
    }
    
    /**
     * Método que imprime por pantalla el nombre del jugador y
     * la casilla en la que se encuentra.
     *
     */
    public void MostrarPosicion(){
        System.out.println(this.nombre + ": Casilla " + this.casilla + ".");
    }
}
