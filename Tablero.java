
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
    private int casillas, casillasMin, casillasMax;
    
    /*
     * Constructor que genera un objeto llamado casillas partir
     * del valor introducido (Clona las casillas);
     */
    public Tablero (int casillas){
        this.casillas = casillas;
        this.casillasMin = 100;
        this.casillasMax = casillasMax;
    }
    /**
     * Método para introducir en número de casillas con el que se va a jugar
     */
    public boolean CasillasJuego () {
        if ((this.casillasMax == 200) && (this.casillasMin == 100)){
        System.out.println("Tablero válido");
    } else {
        System.out.println("Tablero no válido");
    }
    return true;
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
 
