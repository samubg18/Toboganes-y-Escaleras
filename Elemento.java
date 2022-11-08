
/**
 * CLASE ELEMENTO
 * 
 * Clase que contiene los atributos y métodos comunes a los objetos tobogan
 * y escalera.
 * 
 * @author Samuel Borque 
 * @version V01 - 11/22
 */
public abstract class Elemento {
    protected int inicio;
    protected int fin;
    
    protected int CasillaInicial(){
        return this.inicio;
    }
    
    protected int CasillaFinal(){
        return this.fin;
    }
}
