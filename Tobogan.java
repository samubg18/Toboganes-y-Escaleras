
/**
 * Esta es una clase heredada de la clase abstracta Elemento que permite
 * generar objetos Tobogán y operar con ellos utilizando los métodos de
 * esta misma clase y de la clase Elemento.
 * 
 * @author Samuel Borque.
 * @version V01 - 11/22. 
 */
public class Tobogan extends Elemento {
    /**
     * Constructor de objeto Tobogan que permite la introducción de los
     * valores de sus atributos como argumentos.
     *
     * @param inicio Casilla de inicio (int).
     * @param fin Casilla final (int).
     */
    public Tobogan(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
    }
    
    /**
     * Constructor de objeto Tobogan que genera que inicializa los 
     * atributos de este a 0.
     */
    public Tobogan(){
        this.inicio = 0;
        this.fin = 0;
    }
    
    /**
     * Constructor que clona un objeto Tobogan.
     *
     * @param t Objeto Tobogan a clonar.
     */
    public Tobogan(Tobogan t){
        this.inicio = t.inicio;
        this.fin = t.fin;
    }
    
    /**
     * Método que devuelve una representación textual de los atributos del 
     * objeto Tobogan.
     *
     * @return Representación textual (String).
     */
    public String toString(){
        return "Tobogán [ " + this.inicio + " -> " + this.fin + " ]";
    }
    
    /**
     * Este método escribe por pantalla una descripción del objeto 
     * tobogán concatenada con un mensaje introducido como parámetro.
     *
     * @param msg Mensaje a concatenar (String).
     */
    public void escribirElemento(String msg){
        System.out.println(msg + "un tobogán que BAJA hasta la casilla " + this.fin);
    }
    
    /**
     * Método que gener un objeto Tobogan de forma aleatoria. El objeto
     * generado respeta las reglas de los toboganes, es decir, la casilla
     * inical debe ser superior a la casilla final. Además, se deben 
     * indicar los límites del tablero deben especificarse como parámetros 
     * (min, max).
     *
     * @param min Límite inferior (int).
     * @param max Límite superior (int).
     * @return Nuevo objeto Tobogan.
     */
    public static Tobogan Aleatorio(int min, int max){
        /* El tobogán no se podrá generar en la casilla límite inferior (min)
         * ni podrá empezar en la casilla final (max), ya que en estos casos no
         * se podría generar un tobogán.*/
        int inicio = Utiles.NumeroAleatorio(min+1, max-1);
        // Inicio-1 para evitar que el la casilla inicial sea igual a la final.
        int fin = Utiles.NumeroAleatorio(min, inicio-1);
        return new Tobogan(inicio, fin);
    }
    
    /**
     * Método que permite generar un nuevo objeto Tobogan introduciendo
     * el valor de sus atributos por teclado. Este método no permite 
     * introducir valores que incumplan las reglas de los toboganes y
     * los límites del tablero deben especificarse como parámetros (min, max).
     *
     * @param min Límite inferior (int).
     * @param max Límite superior (int).
     * @return Nuevo objeto Tobogan.
     */
    public static Tobogan leerTobogan(int min, int max){
        int inicio;
        int fin;
        do { 
            inicio = Teclado.leerEntero("Indique el inicio del tobogán: ");
        } while (inicio <= 1 || inicio >= max);
        do {
            fin = Teclado.leerEntero("Indique el final del tobogán (debe ser menor que el inicio): ");
        }while (fin < 1 || fin >= inicio);
        return new Tobogan(inicio, fin);
    }

}
