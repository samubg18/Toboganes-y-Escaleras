import java.util.Random;
/**
 * Write a description of class test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero {
    /* 
     * Atributos del Tablero
     */
    private int casillas, casillasMin, casillasMax, casillasIntroducidas, n, casillasTobogan;
    
    /*
     * Constructor que genera un objeto llamado casillas partir
     * del valor introducido (Clona las casillas);
     */
    public Tablero (int casillasIntroducidas){
        this.casillas = casillas;
        this.casillasMin = 100;
        this.casillasMax = casillasMax;
        this.casillasIntroducidas = casillasIntroducidas;
        this.casillasTobogan = casillasTobogan;
    }
    /**
     * Método para introducir en número de casillas con el que se va a jugar
     */
    public void CasillasJuego () {
        if (this.casillasIntroducidas <= 200 && this.casillasIntroducidas >=100){
        System.out.println("Tablero válido");
    } else {
        System.out.println("Tablero no válido");
    }
    }
    /**
     * Método para introducir en número de casillas aleatoriamente
     */
    public int casillasJuegoAleatorio (){
       Random casillasAleatoria = new Random();
       int casillasAleatorias = casillasAleatoria.nextInt(200-100+1)+100;
       return casillasAleatorias;
    }
    /**
     * Método para obtener información sobre donde la posicion es la
     * que estas del tablero.
     */
    public String toString(){
        return "Estas en " + this.casillas;
    }
    /** 
     * Método para saber en que casillas estas
     */
    public void posicionCasilla(String mensaje){
        System.out.println( mensaje + this.toString());
    }
    }
 
