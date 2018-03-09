package primerparcialedfebrero2018;






/**
 *
 * @author Regina Vazquez 173803
 */
public class Programa2 {
    
    
    /**
     * Metodo estatico generico que intercambia el contenido de p1 y p2 respetando el 
     * orden inicial de ambas pilas. 
     * Si cualquiera de los dos parametros son null, no modifica nada de los
     * mismos.
     * Si alguna p1 o p2 estan vacias, realiza el cambio de la llena a la vacia, 
     * dejando vacia a la que estaba llena.
     * @param <T>: Tipo de PilaADT 
     * @param p1: pila 1
     * @param p2: pila 2 
     */
    public static<T> void intercambiaContenido(PilaADT<T> p1, PilaADT<T> p2){
        PilaADT<T> auxiliar;
        int contador1, contador2, i;
        
        if(p1 != null && p2 != null){
            auxiliar = new PilaA<T>();
            contador1 = 0;
            while(!p1.isEmpty()){
                auxiliar.push(p1.pop());
                contador1++;
            }//end while
            contador2 = 0;    
            while(!p2.isEmpty()){
                auxiliar.push(p2.pop());
                contador2++;
            }//end while
            for(i = 0; i < contador2; i++)
                p1.push(auxiliar.pop());
            for(i = 0; i < contador1; i++)
                p2.push(auxiliar.pop());  
        }
    }
    
    /**
     * Metodo estatico generico que guarda en una cadena el contenido de una 
     * pila en el orden que fue guardada la informacion.
     * @param <T>: tipo de la pila
     * @param pila: objeto que se quiere imprimir
     * @return: informacion de la pila. Si el paratro es null, se regresa null 
     */
    public static<T> String imprimePila(PilaADT<T> pila){
        StringBuilder sb;
        PilaADT<T> auxiliar;
        T elemento;
        String mensaje;
        
        try{
            auxiliar = new PilaA<T>();
            while(!pila.isEmpty())
                auxiliar.push(pila.pop());
            sb = new StringBuilder();
            while(!auxiliar.isEmpty()){
                elemento = auxiliar.pop();
                sb.append(elemento + "  ");
                pila.push(elemento);
            }
            mensaje = sb.toString();
        }catch(NullPointerException e){
            mensaje = null;
        }
        return mensaje;
    }
    
    public static void main(String[] args) {
        PilaADT<String> colores = new PilaA();
        PilaADT<String> diasSemana = new PilaA();
        PilaADT<Integer> edades = new PilaA();
        PilaADT<Integer> asistentes = new PilaA();
        PilaADT<Integer> diasVacaciones;
        
        colores.push("rojo");
        colores.push("verde");
        colores.push("azul");
        colores.push("gris");
        diasSemana.push("lunes");
        diasSemana.push("martes");
        diasSemana.push("miércoles");
        diasSemana.push("jueves");
        diasSemana.push("viernes");  
        System.out.println("\nPrueba 1 - antes de intercambiar");
        System.out.println("Pila1: " + imprimePila(colores) + "\nPila2: " + imprimePila(diasSemana));
        intercambiaContenido(colores, diasSemana);
        System.out.println("\nPrueba 1 - después de intercambiar");
        System.out.println("Pila1: " + imprimePila(colores) + "\nPila2: " + imprimePila(diasSemana));
        
        edades.push(3);
        edades.push(4);
        edades.push(5);
        edades.push(3);
        System.out.println("\nPrueba 2 - antes de intercambiar");      
        System.out.println("Pila1: " + imprimePila(edades) + "\nPila2: " + imprimePila(asistentes));
        intercambiaContenido(edades, asistentes);
        System.out.println("\nPrueba 2 - después de intercambiar");      
        System.out.println("Pila1: " + imprimePila(edades) + "\nPila2: " + imprimePila(asistentes));
        
        diasVacaciones = null;
        System.out.println("\nPrueba 3 - antes de intercambiar");      
        System.out.println("Pila1: " + imprimePila(asistentes) + "\nPila2: " + imprimePila(diasVacaciones));
        intercambiaContenido(asistentes, diasVacaciones);
        System.out.println("\nPrueba 3 - después de intercambiar");      
        System.out.println("Pila1: " + imprimePila(asistentes) + "\nPila2: " + imprimePila(diasVacaciones));
        
        diasVacaciones = null;
        asistentes = null;
        System.out.println("\nPrueba 4 - antes de intercambiar");      
        System.out.println("Pila1: " + imprimePila(diasVacaciones) + "\nPila2: " + imprimePila(asistentes));
        intercambiaContenido(diasVacaciones, asistentes);
        System.out.println("\nPrueba 4 - después de intercambiar");      
        System.out.println("Pila1: " + imprimePila(diasVacaciones) + "\nPila2: " + imprimePila(asistentes));
        
    }    
}

