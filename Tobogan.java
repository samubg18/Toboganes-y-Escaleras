
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public static Tobogan Aleatorio(int min, int max){
        int inicio = Utiles.NumeroAleatorio(min+10, max-1);
        int fin = Utiles.NumeroAleatorio(min, inicio);
        return new Tobogan(inicio, fin);
    }
    
    public boolean EsValido(int min, int max){
        if (this.inicio > this.fin)
            return true;
        else
            return false;
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
