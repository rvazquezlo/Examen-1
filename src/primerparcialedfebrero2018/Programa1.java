/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcialedfebrero2018;

/**
 *
 * @author Regina Vazquez 173803
 */
public class Programa1 {
    
    /**
     * Metodo que determina si un elemento tipo Object unicamente puede ser
     * convertido en String y no en Double o Integer
     * @param elemento
     * @return: true si solo puede ser convertido en String. false si el elemento
     * es tipo Double o Integer o si el elemento es tipo String pero no es solo
     * un numero.
     */
    public static boolean noEsNumerico(Object elemento){
        boolean noEsNumerico;
        
        noEsNumerico = false;
        if(elemento instanceof String)
            try{
                Double.parseDouble((String)elemento);
            }catch(NumberFormatException e){
                noEsNumerico = true;
            }
        return noEsNumerico;
    }
    
    /**
     * Metodo estatico que genera un mensaje a partir de una pila tipo Object
     * que unicamente contiene objetos que pueden ser tipo String, Double o 
     * Integer. El mensaje no contiene elmentos que sean solo numeros.
     * @param pila
     * @return: Si el parametro es null, regresa null, si la pila esta vacia o 
     * contiene puros numeros de cualquier tipo, regresa una cadena vacia. De 
     * otra forma, regresa una cadena con los elementos que solo pueden ser
     * String.
     */
    public static String generaMensaje(PilaADT<Object> pila){
        StringBuilder sb;
        String mensaje;
        PilaADT<Object> pilaAuxiliar;
        Object elemento;
      
        try{
            if(pila.isEmpty())
                mensaje = null;
            else{
                sb = new StringBuilder();
                pilaAuxiliar = new PilaA<Object>();
                while(!pila.isEmpty())
                    pilaAuxiliar.push(pila.pop());
                while(!pilaAuxiliar.isEmpty()){
                    elemento = pilaAuxiliar.pop();
                    if(noEsNumerico(elemento))
                        sb.append(elemento);  
                }//end while
                mensaje = sb.toString();   
            }    
        }catch(NullPointerException e){
            mensaje = null;
        }
        return mensaje;
    }
    
    
    
    public static void main(String[] args) {
        PilaADT<Object> pila1 = new PilaA();
        PilaADT<Object> pila2 = new PilaA();
        PilaADT<Object> pila3 = new PilaA();
        PilaADT<Object> pila4 = new PilaA();
        
        pila1.push(459);
        pila1.push("La llave está");
        pila1.push("125");
        pila1.push(316.5);
        pila1.push(" en la caja 504");
        //Debe imprimir: La llave está en la caja 504
        System.out.println("\nPrueba1: " + generaMensaje(pila1));
              
        pila2.push(916.5);
        pila2.push(new Integer(405));
        pila2.push(600);
        //Debe imprimir: cadena vacía
        System.out.println("\nPrueba2: " + generaMensaje(pila2));      
        
        pila3.push("800");
        pila3.push("905.13");
        pila3.push("120");
        //Debe imprimir: cadena vacía
        System.out.println("\nPrueba3: " + generaMensaje(pila3));
               
        //Debe imprimir: null
        System.out.println("\nPrueba4: " + generaMensaje(pila4)); 
        
        //Debe imprimir: null
        System.out.println("\nPrueba5: " + generaMensaje(null)); 
    }    
}

