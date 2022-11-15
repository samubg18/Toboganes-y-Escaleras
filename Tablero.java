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
    private int n_toboganes, n_escaleras;
    
    /**
     * Constructor que genera un objeto llamado casillas partir
     * del valor introducido (Clona las casillas);
     */
    public Tablero (int casillas, Tobogan t1, Tobogan t2, Tobogan t3, Escalera e1,
    Escalera e2, Escalera e3, int n_tob, int n_esc){
        this.casillas = casillas;
        this.tobogan1 = t1;
        this.tobogan2 = t2;
        this.tobogan3 = t3;
        this.escalera1 = e1;
        this.escalera2 = e2;
        this.escalera3 = e3;
        this.n_toboganes = n_tob;
        this.n_escaleras = n_esc;
    }
    
    /**
     * Constructor para generar un tablero aleatorio.
     */
    public Tablero (int min, int max){
        this.casillas = Utiles.NumeroAleatorio(min, max);
        this.n_toboganes = Utiles.NumeroAleatorio(2,3);
        this.n_escaleras = Utiles.NumeroAleatorio(2,3);
        if (n_toboganes == 2){
            this.tobogan1 = Tobogan.Aleatorio(1, casillas);
            this.tobogan2 = Tobogan.Aleatorio(1, casillas);
        }
        else {
            this.tobogan1 = Tobogan.Aleatorio(1, casillas);
            this.tobogan2 = Tobogan.Aleatorio(1, casillas);
            this.tobogan3 = Tobogan.Aleatorio(1, casillas);
        }
        if (n_escaleras == 2){
            this.escalera1 = Escalera.Aleatorio(1, casillas);
            this.escalera2 = Escalera.Aleatorio(1, casillas);
        }
        else {
            this.escalera1 = Escalera.Aleatorio(1, casillas);
            this.escalera2 = Escalera.Aleatorio(1, casillas);
            this.escalera3 = Escalera.Aleatorio(1, casillas);
        }
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
        } 
        else {
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
        Elemento t = null; // Tobogan en el que ha caido el jugador.
        if(this.tobogan1.casillaEsInicio(casilla)){
            t = new Tobogan(this.tobogan1);
        }
        if(this.tobogan2.casillaEsInicio(casilla)){
            t = new Tobogan(this.tobogan2);
        }
        if(this.tobogan3.casillaEsInicio(casilla)){
            t = new Tobogan(this.tobogan3);
        }
        
        if(this.escalera1.casillaEsInicio(casilla)){
            t = new Escalera(this.escalera1);
        }
        
        return t;
    }
    
    public static Tablero leerTablero(int max, int min){
        int casillas;
        Tobogan t1, t2,t3;
        Escalera e1,e2,e3;
        char res1 = Teclado.leerCaracter("¿Quieres configurar el tablero? (s | n)");
        if (res1 == 's'){
            char res9 = Teclado.leerCaracter("¿Quieres introducir el número de casillas de forma manual? (s | n)");
            if (res9 == 's'){
                do{ 
                    casillas = Teclado.leerEntero("Indique un número de casillas deseado entre " 
                    + min + " y " + max + ": ");
                } while(casillas > max || casillas < min);
            }
            else casillas = Utiles.NumeroAleatorio(min, max);
            
            int res2 = Teclado.leerEntero("\n¿Quieres generar 2 o 3 toboganes?");
            if (res2== 2){
                char res4 = Teclado.leerCaracter("¿Quieres configurar los toboganes? (s | n)");
                if (res4 == 's'){
                    System.out.println("Los toboganes deben estar entre la casilla 1 y la " + casillas + ". ");
                    System.out.println("\nPrimer tobogán: ");
                    t1 = Tobogan.leerTobogan(1, casillas);
                    System.out.println("\nSegundo tobogán: ");
                    t2 = Tobogan.leerTobogan(1, casillas);
                    t3 = null;
                }
                else{
                    t1 = Tobogan.Aleatorio(1, casillas);
                    t2 = Tobogan.Aleatorio(1, casillas);
                    t3 = null;
                }
            }
            else{
                char res5 = Teclado.leerCaracter("¿Quieres configurar los toboganes? (s | n)");
                if (res5 == 's'){
                    System.out.println("Los toboganes deben estar entre la casilla 1 y la " + casillas + ". ");
                    System.out.println("\nPrimer tobogán: ");
                    t1 = Tobogan.leerTobogan(1, casillas);
                    System.out.println("\nSegundo tobogán: ");
                    t2 = Tobogan.leerTobogan(1, casillas);
                    System.out.println("\nTercer tobogán: ");
                    t3 = Tobogan.leerTobogan(1, casillas);
                }
                else{
                    t1 = Tobogan.Aleatorio(1, casillas);
                    t2 = Tobogan.Aleatorio(1, casillas);
                    t3 = Tobogan.Aleatorio(1, casillas);
                }
            }
            int res6 = Teclado.leerEntero("\n¿Quieres generar 2 o 3 escaleras?");
            if (res6== 2){
                char res7 = Teclado.leerCaracter("¿Quieres configurar los escaleras? (s | n)");
                if (res7 == 's'){
                    System.out.println("Las escaleras deben estar entre la casilla 1 y la " + casillas + ". ");
                    System.out.println("\nPrimera escalera: ");
                    e1 = Escalera.leerEscalera(1, casillas);
                    System.out.println("\nSegunda escalera: ");
                    e2 = Escalera.leerEscalera(1, casillas);
                    e3 = null;
                }
                else{
                    e1 = Escalera.Aleatorio(1, casillas);
                    e2 = Escalera.Aleatorio(1, casillas);
                    e3 = null;
                }
            }
            else{
                char res8 = Teclado.leerCaracter("¿Quieres configurar los escalera? (s | n)");
                if (res8 == 's'){
                    System.out.println("\nPrimera escalera: ");
                    e1 = Escalera.leerEscalera(1, casillas);
                    System.out.println("\nSegunda escalera: ");
                    e2 = Escalera.leerEscalera(1, casillas);
                    System.out.println("\nTercera escalera: ");
                    e3 = Escalera.leerEscalera(1, casillas);
                }
                else{
                    e1 = Escalera.Aleatorio(1, casillas);
                    e2 = Escalera.Aleatorio(1, casillas);
                    e3 = Escalera.Aleatorio(1, casillas);
                }
            }
            return new Tablero(casillas,t1,t2,t3,e1,e2,e3,res2,res6);
        }
        else{
            return new Tablero(min, max);
        }
    }
}
