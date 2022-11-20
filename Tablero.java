/**
 * Esta clase permite generar objetos Tablero que representan el tablero de
 * una partida del juego Toboganes y Escaleras. Además en esta clase se encuentran
 * también todos los métodos necesarios para poder operar con este objeto y simular
 * el funcionamiento de un tablero.
 * 
 * @author Juan Miguel, Samuel Borque. 
 * @version V01 - 11/22.
 */
public class Tablero {
    // Atributos
    private int casillas;
    private Tobogan tobogan1,tobogan2,tobogan3;
    private Escalera escalera1, escalera2, escalera3;
    private int n_toboganes, n_escaleras;
    
    
    /**
     * Constructor privado que genera un objeto Tablero con todos sus
     * argumentos introducidos como parámetros.
     *
     * @param casillas  Número de casillas (int).
     * @param t1        Objeto Tobogán.
     * @param t2        Objeto Tobogán.
     * @param t3        Objeto Tobogán.
     * @param e1        Objeto Escalera.
     * @param e2        Objeto Escalera.
     * @param e3        Objeto Escalera.
     * @param n_tob     Número de toboganes generados (int).
     * @param n_esc     Número de escaleras generadas (int).
     */
    private Tablero (int casillas, Tobogan t1, Tobogan t2, Tobogan t3, Escalera e1,
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
     * Constructor privado para generar un tablero aleatorio, especificando 
     * como parámetros el número máximo y mínimo de casillas que puede tener
     * este.
     * 
     * @ param mínimo de casillas (int).
     * @ param máximo de casillas (int).
     */
    private Tablero (int min, int max){
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
    
    
    /**
     * Método observador que devuelve el valor de la casilla final
     * del Objeto tablero.
     *
     * @return Casilla final (int).
     */
    public int CasillaFinal(){
        return this.casillas;
    }
    
    
    /**
     * Método para saber si el núemro de casillas del tablero se encuentra
     * entre un mínimo y un máximo.
     * 
     * @ param min Número de casillas mínimo (int).
     * @ param max Número de casillas máximo (int).
     * @ return Resultado de la comprobación (boolean).
     */
    public boolean esValido (int min, int max) {
        return this.casillas <= max && this.casillas>= min;
    }
    
    
    /**
     * Método que comprueba si existe un tobogán o una escalera en unca
     * casilla introducida como parámetro y devuelve dicho elemento en 
     * caso de existir. Si no existe nigún elemento en la casilla el 
     * método devuelve null.
     *
     * @param casilla Casilla a comprobar.
     * @return Objeto Elemento (tobogán o escalera).
     */
    public Elemento ElementoEn(int casilla){
        Elemento e = null; // Tobogan o escalera en el que ha caido el jugador.
        if(this.tobogan1.casillaEsInicio(casilla)){
            e = new Tobogan(this.tobogan1);
        }
        else if(this.tobogan2.casillaEsInicio(casilla)){
            e = new Tobogan(this.tobogan2);
        }
        else if(this.escalera1.casillaEsInicio(casilla)){
            e = new Escalera(this.escalera1);
        }
        else if(this.escalera2.casillaEsInicio(casilla)){
            e = new Escalera(this.escalera2);
        }
        
        // Si n_toboganes == 3 el tercer tobogán existe.
        if(this.n_toboganes == 3){
            if(this.tobogan3.casillaEsInicio(casilla)){
                e = new Tobogan(this.tobogan3);
            }
        }
        
        // Si n_escaleras == 3 la tercera escalera existe.
        if(this.n_escaleras == 3){
            if(this.escalera3.casillaEsInicio(casilla)){
                e = new Escalera(this.escalera3);
            }
        }
        
        return e;
    }
    
    /**
     * Método que devuelve una representación textual del objeto
     * dueño.
     *
     * @return Representación textual (String).
     */
    public String toString(){
        String c = "  Numero de casillas: " + this.casillas;
        String t1 = "\n  Tobogán 1: " + this.tobogan1.toString();
        String t2 = "\n  Tobogán 2: " + this.tobogan2.toString();
        String e1 = "\n  Escalera 1: " + this.escalera1.toString();
        String e2 = "\n  Escalera 2: " + this.escalera2.toString();
        
        /* 
         * Dado que estos elementos pueden no existir se tratan en función de los
         * atributos n_toboganes y n_escaleras.
         */
        String t3;
        String e3;
        if (this.n_toboganes == 2)
            t3 = "\n  Tobogán 3: No generado";
        else
            t3 = "\n  Tobogán 3: " + this.tobogan3.toString();
        
        if (this.n_escaleras == 2)
            e3 = "\n  Tobogán 3: No generada";
        else
            e3 = "\n  Escalera 3: " + this.tobogan3.toString();
            
        return c+t1+t2+t3+e1+e2+e3;
    }
    
    /**
     * Este método abstracto escribe por pantalla un mensaje introducido
     * como parámetro concatenado con la representación textual del objeto
     * dueño.
     *
     * @param msg Mensaje (String).
     */
    public void escribirTablero(String msg){
        System.out.println(msg + this.toString());
    }
    
    /**
     * Este método genera un objeto tablero con permitiendo al usuario configurar
     * cada uno de sus atributos mediante la introducción de valores por pantalla.
     * Además, permite la generación de ciertos parámetros de forma aleatoria o 
     * incluso la generación completamente aleatoria del tablero.
     *
     * @param min Mínimo número de casillas del tablero (int).
     * @param max Máximo número de casillas del tablero (int).
     * @return Objeto Tablero generado.
     */
    public static Tablero leerTablero(int min, int max){
        int casillas;
        Tobogan t1, t2,t3;
        Escalera e1,e2,e3;
        char res1 = Utiles.respuesta_SN("¿Quieres configurar el tablero? (s | n)");
        if (res1 == 's'){
            char res9 = Utiles.respuesta_SN("¿Quieres introducir el número de casillas de forma manual? (s | n) ");
            if (res9 == 's'){
                do{ 
                    casillas = Teclado.leerEntero("Indique un número de casillas deseado entre " 
                    + min + " y " + max + ": ");
                } while(casillas > max || casillas < min);
            }
            else casillas = Utiles.NumeroAleatorio(min, max);
            
            int res2;
            do{ 
                res2 = Teclado.leerEntero("\n¿Quieres generar 2 o 3 toboganes?");
            }while(res2 != 2 && res2 != 3);
            if (res2== 2){
                char res4 = Utiles.respuesta_SN("¿Quieres configurar los toboganes? (s | n)");
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
                char res5 = Utiles.respuesta_SN("¿Quieres configurar los toboganes? (s | n)");
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
            
            int res6;
            do{ 
                res6 = Teclado.leerEntero("\n¿Quieres generar 2 o 3 escaleras?");
            }while(res6 != 2 && res6 != 3);
            if (res6== 2){
                char res7 = Utiles.respuesta_SN("¿Quieres configurar las escaleras? (s | n)");
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
                char res8 = Utiles.respuesta_SN("¿Quieres configurar los escalera? (s | n)");
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
