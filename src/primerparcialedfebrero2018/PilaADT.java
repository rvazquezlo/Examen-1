
package primerparcialedfebrero2018;

/**
 *
 * @author hca
 * @param <T>
 */
public interface PilaADT<T>{
    public T pop();
    public void push (T push);
    public boolean isEmpty();
    public T peek();
}
