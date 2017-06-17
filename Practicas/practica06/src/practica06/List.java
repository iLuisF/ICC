/**
 * En la clase List se usa Generics de java y se usan diferentes metodos sobre listas.
 * @author Luis Flores
 * @version 1.0
 */

public interface List<T>{
    T getFirst();
    //T getLast();                                                                                                                                                      
    //T get(int index);                                                                                                                                                 
    T removeFirst();
    //T removeLast();                                                                                                                                                   
    //T remove(int index);                                                                                                                                              
    //void addFirst(T element);                                                                                                                                         
    //void addLast(T element);                                                                                                                                          
    //void add(int index);                                                                                                                                              
    int size();

}
