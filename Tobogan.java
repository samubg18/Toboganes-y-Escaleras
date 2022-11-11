
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
    
    public void Aleatorio(int min, int max){
        this.inicio = Utiles.NumeroAleatorio(min+10, max-1);
        this.fin = Utiles.NumeroAleatorio(min, inicio);
    }
    
    public boolean EsValido(){
        if (this.inicio > this.fin)
            return true;
        else
            return false;
    }
}
