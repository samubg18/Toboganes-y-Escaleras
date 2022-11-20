
/**
 * Esta es una clase heredada de la clase abstracta Elemento que permite
 * generar objetos Tobogán y operar con ellos utilizando los métodos de
 * esta misma clase y de la clase Elemento.
 * 
 * @author Samuel Borque.
 * @version V01 - 11/22. 
 */
public class Tobogan extends Elemento {
    public Tobogan(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public Tobogan(){
        this.inicio = 0;
        this.fin = 0;
    }
    
    public Tobogan(Tobogan t){
        this.inicio = t.inicio;
        this.fin = t.fin;
    }
    
    public String toString(){
        return "Tobogán [ " + this.inicio + " -> " + this.fin + " ]";
    }
    
    public void escribirElemento(String msg){
        System.out.println(msg + "un tobogán que BAJA hasta la casilla " + this.fin);
    }
    
    public static Tobogan Aleatorio(int min, int max){
        int inicio = Utiles.NumeroAleatorio(min+10, max-1);
        int fin = Utiles.NumeroAleatorio(min, inicio);
        return new Tobogan(inicio, fin);
    }
    
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
