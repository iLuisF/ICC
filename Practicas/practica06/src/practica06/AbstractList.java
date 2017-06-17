/**
 * La clase AbstractList implementa la interfaz List e implementa los metodos que 
 * sean iguales para las subcadenas.
 * @author Luis Flores
 * @version 1.0
 */

public abstract class AbstractList<T extends Comparable> implements List<T>{
    protected T head;
    protected AbstractList<T> tail;

    public T getFirst(){
        return head;
    }

    public T removeFirst(){
        T prev = head;
        head = tail.head;
        tail = tail.tail;
        return prev;
    }

    //abstract public List<T> concat(List<T> secondList);                                                                                                               
    //abstract public List<T> reverse();                                                                                                                                
    //abstract public List<T> sort();                                                                                                                                   

}