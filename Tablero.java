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
    private int casillas;
    private Tobogan tobogan1,tobogan2,tobogan3;
    private Escalera escalera1, escalera2, escalera3;
    
    /**
     * Constructor que genera un objeto llamado casillas partir
     * del valor introducido (Clona las casillas);
     */
    public Tablero (int casillas, Tobogan t1, Tobogan t2, Tobogan t3, Escalera e1,
    Escalera e2, Escalera e3){
        this.casillas = casillas;
        this.tobogan1 = t1;
        this.tobogan2 = t2;
        this.tobogan3 = t3;
        this.escalera1 = e1;
        this.escalera2 = e2;
        this.escalera3 = e3;
    }
    /**
     * Constructor para generar un tablero aleatorio.
     */
    public Tablero (int min, int max){
        this.casillas = Utiles.NumeroAleatorio(min, max);
        this.tobogan1 = new Tobogan();
        this.tobogan1.Aleatorio(1, casillas);
        this.tobogan2 = new Tobogan();
        this.tobogan2.Aleatorio(1, casillas);
        this.tobogan3 = new Tobogan();
        this.tobogan3.Aleatorio(1, casillas);
        this.escalera1 = new Escalera();
        this.escalera1.Aleatorio(1, casillas);
        this.escalera2 = new Escalera();
        this.escalera2.Aleatorio(1, casillas);
        this.escalera3 = new Escalera();
        this.escalera3.Aleatorio(1, casillas);
    }
    
    
    public int CasillaFinal(){
        return this.casillas;
    }
    
    
    /**
     * Método para saber si el tablero es válido
     */
    public boolean CasillasJuego (int min, int max) {
        if (this.casillas <= max && this.casillas>= min){
            return true;
    } else {
            return false;
    }
    }
    /**
     * Método para obtener información sobre el numero de casillas que tiene
     */
    public String toString(){
        return "El tablero tiene " + this.casillas + "casillas" ;
    }
    public Elemento haCaido(int casilla){
        if(this.tobogan1.casillaEsInicio(casilla)){
            
        }
    }
    public static Tablero leerTablero(int max, int min){
        int casillas;
        Tobogan t1, t2,t3;
        Escalera e1,e2,e3;
        char res1 = Teclado.leerCaracter("¿Quieres configurar el tablero? (s | n)");
        if (res1 == 's'){
            do{ 
                casillas = Teclado.leerEntero("Indique un número de casillas deseado entre " 
                + min + " y " + max + ": ");
            } while(casillas > max || casillas < min);
            int res2 = Teclado.leerEntero("¿Quieres generar 2 o 3 toboganes?");
            if (res2== 2){
                char res4 = Teclado.leerCaracter("¿Quieres configurar los toboganes? (s | n)");
                if (res4 == 's'){
                    System.out.println("Los toboganes deben estar entre la casilla 1 y la "
                    + casillas);
                    int inicio = Teclado.leerEntero("Indique el inicio del primer tobogán: ");
                    int fin = Teclado.leerEntero("Indique el final del primer tobogán: ");
                    t1 = new Tobogan(inicio, fin);
                    inicio = Teclado.leerEntero("Indique el inicio del segundo tobogán: ");
                    fin = Teclado.leerEntero("Indique el final del segundo tobogán: ");
                    t2 = new Tobogan(inicio, fin);
                    t3 = null;
                }
                else{
                    t1 = new Tobogan();
                    t1.Aleatorio(1, casillas);
                    t2 = new Tobogan();
                    t2.Aleatorio(1, casillas);
                    t3 = null;
                }
            }
            else{
                char res5 = Teclado.leerCaracter("¿Quieres configurar los toboganes? (s | n)");
                if (res5 == 's'){
                    int inicio = Teclado.leerEntero("Indique el inicio del primer tobogán: ");
                    int fin = Teclado.leerEntero("Indique el final del primer tobogán: ");
                    t1 = new Tobogan(inicio, fin);
                    inicio = Teclado.leerEntero("Indique el inicio del segundo tobogán: ");
                    fin = Teclado.leerEntero("Indique el final del segundo tobogán: ");
                    t2 = new Tobogan(inicio, fin);
                    inicio = Teclado.leerEntero("Indique el inicio del tercer tobogán: ");
                    fin = Teclado.leerEntero("Indique el final del tercer tobogán: ");
                    t3 = new Tobogan(inicio, fin);
                }
                else{
                    t1 = new Tobogan();
                    t1.Aleatorio(1, casillas);
                    t2 = new Tobogan();
                    t2.Aleatorio(1, casillas);
                    t3 = new Tobogan();
                    t3.Aleatorio(1, casillas);
                }
            }
            int res6 = Teclado.leerEntero("¿Quieres generar 2 o 3 escaleras?");
            if (res6== 2){
                char res7 = Teclado.leerCaracter("¿Quieres configurar los escaleras? (s | n)");
                if (res7 == 's'){
                    int inicio = Teclado.leerEntero("Indique el inicio del primer escalera: ");
                    int fin = Teclado.leerEntero("Indique el final del primer escalera: ");
                    e1 = new Escalera(inicio, fin);
                    inicio = Teclado.leerEntero("Indique el inicio del segundo escalera: ");
                    fin = Teclado.leerEntero("Indique el final del segundo escalera: ");
                    e2 = new Escalera(inicio, fin);
                    e3 = null;
                }
                else{
                    e1 = new Escalera();
                    e1.Aleatorio(1, casillas);
                    e2 = new Escalera();
                    e2.Aleatorio(1, casillas);
                    e3 = null;
                }
            }
            else{
                char res8 = Teclado.leerCaracter("¿Quieres configurar los escalera? (s | n)");
                if (res8 == 's'){
                    int inicio = Teclado.leerEntero("Indique el inicio de la primera escalera: ");
                    int fin = Teclado.leerEntero("Indique el final de la primera escalera: ");
                    e1 = new Escalera(inicio, fin);
                    inicio = Teclado.leerEntero("Indique el inicio de la segunda escalera: ");
                    fin = Teclado.leerEntero("Indique el final del segundo escalera: ");
                    e2 = new Escalera(inicio, fin);
                    inicio = Teclado.leerEntero("Indique el inicio de la tercera escalera: ");
                    fin = Teclado.leerEntero("Indique el final de la tercera escalera: ");
                    e3 = new Escalera(inicio, fin);
                }
                else{
                    e1 = new Escalera();
                    e1.Aleatorio(1, casillas);
                    e2 = new Escalera();
                    e2.Aleatorio(1, casillas);
                    e3 = new Escalera();
                    e3.Aleatorio(1, casillas);
                }
            }
            return new Tablero(casillas,t1,t2,t3,e1,e2,e3);
        }
        else{
            return new Tablero(min, max);
        }
    }
}
