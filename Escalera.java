
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
    
    public void Aleatorio(int min, int max){
        this.inicio = Utiles.NumeroAleatorio(min+1, max+10);
        this.fin = Utiles.NumeroAleatorio(inicio, max);
    }
    
    public boolean EsValido(){
        if (this.inicio < this.fin)
            return true;
        else
            return false;
    }
}

