/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package primerparcialedfebrero2018;

/**
 *
 * @author SG
 */
public class PilaA <T> implements PilaADT <T>{
    private T pila[];
    private int tope;
    private final int MAX = 20;
  
    public PilaA(){
        pila = (T[]) new Object [MAX];
        tope = -1; //INDICA QUE LA PILA ESTA VACIA
    }
    public boolean isEmpty(){
        return tope == -1;
    }
    public T peek(){
        if(isEmpty())
            throw new EmptyCollectionException();
        else
            return pila [tope];
    }
    public T pop(){
        if(!isEmpty()){
            T dato;
            dato = pila[tope];
            pila[tope] = null;
            tope = tope-1;
            return dato; 
        }
        else 
            throw new EmptyCollectionException();
    }

    public void push(T dato){
        if (tope + 1 == pila.length)// o tope==pila.length-1
            expandCapacity();
        tope++;
        pila[tope] = dato;
    }

    private void expandCapacity(){
        T nuevo[] = (T [])new Object[pila.length*2];
        int i;
        for(i= 0;i <= tope;i++)
            nuevo[i] = pila[i];
        pila = nuevo;
    }
}
