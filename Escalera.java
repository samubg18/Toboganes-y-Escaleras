
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Escalera extends Elemento {
    public Escalera(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public Escalera(){
        this.inicio = 0;
        this.fin = 0;
    }
    
    public Escalera(Escalera t){
        this.inicio = t.inicio;
        this.fin = t.fin;
    }
    
    public static Escalera Aleatorio(int min, int max){
        int inicio = Utiles.NumeroAleatorio(min+1, max+10);
        int fin = Utiles.NumeroAleatorio(inicio, max);
        return new Escalera(inicio, fin);
    }
    
    public boolean EsValido(){
        if (this.inicio < this.fin)
            return true;
        else
            return false;
    }
    
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

