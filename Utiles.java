import java.util.Random;

/**
 * Write a description of class Utiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utiles
{
    public static int NumeroAleatorio(int a, int b){
        return new Random().nextInt(b+1-a) + a;
    }
}
