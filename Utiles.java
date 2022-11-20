import java.util.Random;

/**
 * Clase que contiene métodos estáticos varios que son
 * útiles para la ejecución del programa.
 * 
 * @author Samuel Borque.
 * @version V01 - 11/22
 */
public class Utiles
{
    /**
     * Método que devuelve un número aleatorio entre los
     * números introducidos como argumentos (incluidos).
     *
     * @param a Número límite inferior (int).
     * @param b Número límite superior (int).
     * @return Número aleatorio (int).
     */
    public static int NumeroAleatorio(int a, int b){
        return new Random().nextInt(b+1-a) + a;
    }
    
    /**
     * Método que muestra preguntas de respuesta sí o no 
     * por pantalla y permite al usuario responder utilizando
     * las letras 's' para sí o 'n' para no.
     *
     * @param texto Pregunta o texto a mostrar por pantalla (String).
     * @return respuesta del usuario (char) siempre 's' o 'n'.
     */
    public static char respuesta_SN(String texto){
        char resp;
        do {
            resp = Teclado.leerCaracter(texto);
        }while(resp != 's' && resp != 'n');
        return resp;
    }
}
