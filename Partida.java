/**
 * Esta clase contiene los constructores y métodos necesarios para simular el
 * funcionamiento de una partida del juego Toboganes y Escaleras.
 * 
 * @author Samuel Borque.
 * @version V01 - 11/22.
 */
public class Partida {
    // Atributos.
    private Tablero tablero;
    private Jugador j1;
    private Jugador j2;
    private Dado dado;
    
    /**
     * Constructor privado del objeto Partida.
     *
     * @param tab Objeto tablero.
     * @param j1 Objeto Jugador del jugador 1.
     * @param j2 Objeto Jugador del jugador 2.
     */
    private Partida (Tablero tab, Jugador j1, Jugador j2){
        this.tablero = tab;
        this.j1 = j1;
        this.j2 = j2;
        this.dado = new Dado(6);
    }
    
    
    
    /**
     * Método que escribe por pantalla la configuración de la partida
     * de forma esquemática concatenada con un mensaje introducido como
     * parámetro.
     *
     * @param msg Mensaje (String).
     */
    public void escribirPartida(String msg){
        System.out.println(msg);
        this.j1.escribirJugador("- Jugador 1: ");
        this.j2.escribirJugador("- Jugador 2: ");
        this.tablero.escribirTablero("- Tablero:\n");
    }
    
    /**
     * Este método comprueba si algunos de los jugadores ha ganado la partida.
     *
     * @return Resultado de la comprobación (boolean).
     */
    public boolean finPartida(){
        return this.j1.HaGanado(this.tablero) || this.j2.HaGanado(this.tablero);
    }
    
    /**
     * Método que devuelve el nombre del ganador de la partida. Si ningún jugador
     * ha llegado a la casilla final cuando se ejecuta el método, este devuelve
     * un String vacío.
     *
     * @return Nombre del gandor (String).
     */
    public String MostrarGanador(){
        String ganador = "";
        if (this.j1.HaGanado(this.tablero))
            ganador = this.j1.getNombre();
        else if ( this.j2.HaGanado(this.tablero))
            ganador = this.j2.getNombre();
        
        return ganador;
    }
    
    /**
     * Método que permite a los jugadores configurar cada uno de los atributos del objeto
     * partida mediante la introducciónd de valores por teclado.
     *
     * @param minCasillas Número mínimo de casillas (int).
     * @param maxCasillas Número máximo de casillas (int).
     * @return Objeto Partida.
     */
    public static Partida configurarPartida(int minCasillas, int maxCasillas){
        // Configuración de los jugadores.
        System.out.println("\nJugador 1. ");
        Jugador j1 = Jugador.leerJugador();
        System.out.println("\nJugador 2. ");
        Jugador j2 = Jugador.leerJugador();
        
        // Configuración del tablero.
        System.out.println("\nTablero. ");
        Tablero t = Tablero.leerTablero(minCasillas, maxCasillas);
        
        return new Partida(t, j1, j2);
    }
    
    /**
     * Método que permite decidir de forma justa qué jugador comenzará la partida.
     * Para ello ambos jugadores tirarán el dado y el que saque un número más alto
     * se convertirá en j1. El perdedor será j2.
     * 
     * Para conseguir esto el método cambia el orden inicial de los jugadores (orden
     * en el que se han introducido los nombres) en caso de ser necesario.
     */
    public void EleccPrimerJugador(){
        int tiradaJ1;
        int tiradaJ2;
        do{
            Teclado.leerCaracter(this.j1.getNombre() + ", pulsa <enter> para tirar el dado.");
            tiradaJ1 = this.dado.tirar();
            System.out.println(this.j1.getNombre() + " ha sacado un: " + tiradaJ1 + ".\n");
            Teclado.leerCaracter(this.j2.getNombre() + ", pulsa <enter> para tirar el dado.");
            tiradaJ2 = this.dado.tirar();
            System.out.println(this.j2.getNombre() + " ha sacado un: " + tiradaJ2 + ".\n");
            if (tiradaJ1 == tiradaJ2) 
                System.out.println("\n¡EMPATE!\n");
        }while(tiradaJ1 == tiradaJ2);
        
        if (tiradaJ1 < tiradaJ2){
            System.out.println("\n" + this.j2.getNombre() + " jugará primero.");
            Jugador temp = this.j1;
            // Se cambia el orden de los jugadores.
            this.j1 = this.j2;
            this.j2 = temp;
        }
        else
            System.out.println("\n" + this.j1.getNombre() + " jugará primero.");
    }
    
    /**
     * Método que simula el desarrollo de un turno para un jugador. 
     *
     * @param j Objeto del jugador al que le toca jugar.
     */
    public void turno(Jugador j){
        if (!this.finPartida()){
            int tirada;
            int n_seises = 0;
            boolean pierdeTurno = false;
            do{
                System.out.println("\nTurno de " + j.getNombre() + "! Estás en la casilla " + j.getCasilla());
                Teclado.leerCaracter("Pulse <enter> para tirar el dado.");
                tirada = this.dado.tirar();
                System.out.print("Has sacado un: " + tirada);
                
                // Comprueba si el jugador ha sacado un 6.
                if (tirada == 6){
                    n_seises += 1;
                    if (n_seises < 3){
                        // Si ha sacado un 6 tiene un turno extra.
                        System.out.println(". Tienes turno EXTRA.");
                    }
                    else{
                        // Si es su tercer 6 pierde el turno y regresa a la casilla inicial.
                        System.out.println(".\n¡Es tu tercer 6 seguido! Vuelves a la casilla inicial.");
                        j.RegresaInicio();
                        System.out.println("Te encuentra en la casilla " + j.getCasilla());
                        pierdeTurno = true;
                    }
                }
                else
                    System.out.println(".");
                    
                if (!j.SuperaCasillaFinal(tirada, this.tablero.CasillaFinal()) && !pierdeTurno){
                    // Si el jugador no supera la casilla final con su última tirada avanza.
                    j.AvanzaCasillas(tirada);
                    System.out.println("Te mueves hasta la casilla " + j.getCasilla());
                    
                    Elemento e;
                    do{
                        // Se comprueba si existe algún elemento en la nueva casilla.
                        e = this.tablero.ElementoEn(j.getCasilla());
                        if(e != null){
                            // En caso de existir elemento, se utiliza.
                            e.escribirElemento("\nHas caido en ");
                            j.UsaElemento(e);
                            System.out.println("Te has desplazado hasta la casilla " + e.CasillaFinal() + ".");
                        }
                    }while(e != null); // Se repite la comprobación para la nueva casilla.
                }
                else if (!pierdeTurno)
                System.out.println("\n¡Te has pasado la casilla final! Te quedas en la casilla " + j.getCasilla());
                
            }while(tirada == 6 && !pierdeTurno && !this.finPartida()); // Se repite el turno hasta que pierda turno o no saque 6.
        }
    }
    
    /**
     * MÉTODO PRINCIPAL (main)
     */
    public static void main(String[] args){
        System.out.println("### TOBOGANES Y ESCALERAS ###");
        
        // Configuración de la partida con un número de casillas de entre 100 y 200.
        System.out.println("\nA continuación se van a configurar todos los elementos necesarios para "
        + "comenzar la partida: ");
        Partida partida = configurarPartida(100, 200);
        
        // Se muestra por pantalla la configuración de la partida.
        partida.escribirPartida("\nResumen de la configuración de la partida:");
        
        
        // Elección del jugador que empezará la partida.
        System.out.println("\nEl jugador que saque el número más alto con la siguiente tirada comenzará"
        + " la partida.");
        partida.EleccPrimerJugador();
        
        System.out.println("\nINICIO DE LA PARTIDA");
        do{
            /* Ambos jugadores juegan sus turnos sucesivamente hasta que unos de ellos
             * gane la partida. */
            partida.turno(partida.j1);
            partida.turno(partida.j2);
        }while(!partida.finPartida());
        
        System.out.println("\n¡Final de la partida! Ha ganado: " + partida.MostrarGanador());
    }
}
