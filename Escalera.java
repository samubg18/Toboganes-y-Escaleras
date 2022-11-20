
/**
 * Esta es una clase heredada de la clase abstracta Elemento que permite
 * generar objetos Escalera y operar con ellos utilizando los métodos de
 * esta misma clase y de la clase Elemento.
 * 
 * @author Juan Miguel.
 * @version V01 - 11/22.
 */
public class Escalera extends Elemento {
    /**
     * Constructor de objeto Escalera que permite la introducción de los
     * valores de sus atributos como argumentos.
     *
     * @param inicio Casilla de inicio (int).
     * @param fin Casilla final (int).
     */
    public Escalera(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
    }
    
    /**
     * Constructor de objeto Escalera que genera que inicializa los 
     * atributos de este a 0.
     */
    public Escalera(){
        this.inicio = 0;
        this.fin = 0;
    }
    
    /**
     * Constructor que clona un objeto Escalera.
     *
     * @param t Objeto Escalera a clonar.
     */
    public Escalera(Escalera t){
        this.inicio = t.inicio;
        this.fin = t.fin;
    }
    
    
    /**
     * Método que devuelve una representación textual de los atributos del 
     * objeto Escalera.
     *
     * @return Representación textual (String).
     */
    public String toString(){
        return "Escalera [ " + this.inicio + " -> " + this.fin + " ]";
    }
    
    /**
     * Este método escribe por pantalla una descripción del objeto 
     * Escalera concatenada con un mensaje introducido como parámetro.
     *
     * @param msg Mensaje a concatenar (String).
     */
    public void escribirElemento(String msg){
        System.out.println(msg + "una escalera que SUBE hasta la casilla " + this.fin);
    }
    
    /**
     * Método que gener un objeto Escalera de forma aleatoria. El objeto
     * generado respeta las reglas de las escaleras, es decir, la casilla
     * inical debe ser inferior a la casilla final. Además, se deben 
     * indicar los límites del tablero deben especificarse como parámetros 
     * (min, max).
     *
     * @param min Límite inferior (int).
     * @param max Límite superior (int).
     * @return Nuevo objeto Escalera.
     */
    public static Escalera Aleatorio(int min, int max){
        /* La escalera se no se podrá generar en la casilla límite inferior (min)
         * ni podrá empezar en la casilla final (max), ya que en estos casos no
         * se podría generar una escalera.*/
        int inicio = Utiles.NumeroAleatorio(min+1, max-1);
        // Inicio+1 para evitar que el la casilla inicial pueda ser igual a la final.
        int fin = Utiles.NumeroAleatorio(inicio+1, max);
        return new Escalera(inicio, fin);
    }
    
    /**
     * Método que permite generar un nuevo objeto Escalera introduciendo
     * el valor de sus atributos por teclado. Este método no permite 
     * introducir valores que incumplan las reglas de las escaleras y
     * los límites del tablero deben especificarse como parámetros (min, max).
     *
     * @param min Límite inferior (int).
     * @param max Límite superior (int).
     * @return Nuevo objeto Escalera.
     */
    public static Escalera leerEscalera(int min, int max){
        int inicio;
        int fin;
        do { 
            inicio = Teclado.leerEntero("Indique el inicio de la escalera: ");
        } while (inicio <= 1 || inicio >= max);
        do {
            fin = Teclado.leerEntero("Indique el final de la escalera (debe ser mayor que el inicio): ");
        }while (fin <= inicio || fin > max);
        return new Escalera(inicio, fin);
    }
}