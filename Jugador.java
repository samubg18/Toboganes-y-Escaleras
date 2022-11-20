/**
 * CLASE JUGADOR.
 * 
 * Esta clase permite generar objetos de tipo jugador, almacenando
 * los atributos que los describen y permitiendo operar con estos.
 * 
 * @author Samuel Borque.
 * @version V01 - 11/22.
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
        this.casilla = 1;
        this.nombre = nombre;
    }
    
    /**
     * Constructor de objeto jugador. Clona un objeto Jugador.
     *
     * @param j Objeto jugador a clonar.
     */
    public Jugador(Jugador j){
        this.casilla = j.casilla;
        this.nombre = j.nombre;
    }

    
    
    // Métodos:
    
    /**
     * Método observador que devuelve el nombre del jugador.
     *
     * @return Nombre del jugador (String).
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Método observador que devuelve la casilla en la que se
     * encuentra el jugador.
     *
     * @return Casilla en la que se encuentra el jugador (int).
     */
    public int getCasilla(){
        return this.casilla;
    }
    
    /**
     * Método que permite el avance del jugador por el tablero.
     * El número de casillas debe ser positivo y estar entre 
     * uno y seis ambos incluidos.
     *
     * @param n_casillas Número de casillas a mover (int).
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
     * @param e Objeto de la clase Elememto (tobogán o escalera).
     */
    public void UsaElemento(Elemento e){
        this.casilla = e.CasillaFinal();
    }
    
    /**
     * Método que devuelve a un jugador a la casilla 1.
     */
    public void RegresaInicio(){
        this.casilla = 1;
    }
    
    /**
     * Este método comprueba si el jugador ha ganado la partida.
     *
     * @param tablero Objeto tablero.
     * @return Resultado de la comprobación (boolean).
     */
    public boolean HaGanado(Tablero tablero){
        return this.casilla == tablero.CasillaFinal();
    }
    
    /**
     * Método que comprueba si al sumar el resultado del dado a
     * la casilla en la que se encuentra el jugador, se supera 
     * la casilla final del tablero.
     *
     * @param res_dado  Resultado de la tiradad del dado (int).
     * @param cFinal    Casilla final del tablero (int).
     * @return Resultado de la comprobación (boolean).
     */
    public boolean SuperaCasillaFinal(int res_dado, int cFinal){
        return this.casilla + res_dado > cFinal;
    }
    
    
    /**
     * Método que devuelve en formato String una representación 
     * textual de un objeto Jugador.
     *
     * @return Representación textual (String).
     */
    public String toString(){
        return this.nombre + ", casilla " + this.casilla;
    }
    
    /**
     * Este método concatena y escribe por pantalla un mensaje introducido
     * como argumento y la información que describe a un objeto Jugador. 
     *
     * @param msg Mensaje a escribir por pantalla (String).
     */
    public void escribirJugador(String msg){
        System.out.println(msg + this.toString());
    }
    
    /**
     * Método que permite generar un nuevo objeto Jugador introduciendo 
     * su nombre por pantalla.
     *
     * @return El valor de retorno
     */
    public static Jugador leerJugador(){
        String nombre = Teclado.leerCadena("Nombre: ");
        return new Jugador(nombre);
    }
}
