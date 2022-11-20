import java.util.Random;

/**
 * Esta clase genera un objeto dado con el número de caras que el
 * usuario desee. 
 * 
 * @author Samuel Borque. 
 * @version V01 - 11/22.
 */
public class Dado {
    // Atributos
    private Random gen;
    private int caras;
    
    /**
     * Constructor de objeto de clase dado.
     *
     * @param nCaras Número de caras del dado.
     */
    public Dado (int nCaras){
        // Se utiliza un objeto Random para la generación de números aleatorios.
        this.gen = new Random();
        this.caras = nCaras;
    }
    
    /**
     * Método tirar. Permite simular la tirada de un dado y obtener un
     * número aleatorio dentro de los valores posibles del dado, en función
     * de su número de caras.
     *
     * @return Resultado de la tirada.
     */
    public int tirar(){
        // Número aleatorio entre 1 y el número de caras.
        return this.gen.nextInt(this.caras)+1;
    }
}
