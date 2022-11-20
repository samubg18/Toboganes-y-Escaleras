
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
    // Atributos
    protected int inicio;
    protected int fin;
    
    // Métodos
    
    /**
     * Método observador que devuelve el valor de la casilla de inicio
     * del objeto Elemento.
     *
     * @return casilla inicio (int).
     */
    protected int CasillaInicial(){
        return this.inicio;
    }
    
    /**
     * Método observador que devuelve el valor de la casilla final
     * del objeto Elemento.
     *
     * @return casilla final (int).
     */
    protected int CasillaFinal(){
        return this.fin;
    }
    
    /**
     * Método que comprueba si una casilla introducida como argumento
     * coincide con la casilla de inicio del objeto dueño.
     *
     * @param casilla casilla a comprobar (int).
     * @return Resultado de la comprobación (boolean).
     */
    public boolean casillaEsInicio(int casilla){
        return casilla == this.inicio;
    }
    
    /**
     * Este método abstracto devuelve una representación textual de
     * los atributos de el objeto heredado de la clase Elemento.
     * Este método se sobreescribe con los declarados en las clases 
     * heredadas de esta.
     *
     * @return Representación textual (String).
     */
    public abstract String toString();
    
    /**
     * Este método abstracto escribe por pantalla un mensaje introducido
     * como parámetro concatenado con la representación textual del objeto
     * dueño.
     * Este método se sobreescribe con los declarados en las clases 
     * heredadas de esta.
     *
     * @param msg Mensaje a concatenar (String).
     */
    public abstract void escribirElemento(String msg);
}
