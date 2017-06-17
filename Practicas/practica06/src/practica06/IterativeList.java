/**
 * La clase IterativeList extiende la clase abstracta AbstractList
 * e implementa los metodos abstractos declarados en la interfaz
 *  y en la clase abstracta de forma iterativa.
 * @author Luis Flores
 * @version 1.0
 */

public class IterativeList<T extends Comparable<T>> extends AbstractList<T>{

	/**
	 * Metodo para construir una lista vacia.
	 */
    public IterativeList(){
        head = null;
        tail = null;
    }

    /**
     * Metodo para obtener el tamaño.
     */
    public int size(){
        //Se declaran e inicializan dos referencias para recorrer la lista.                                                                                             
        T actHead = this.head;
        IterativeList<T> actTail = (IterativeList<T>) this.tail;
        int size = 0;
        while(actHead != null){ //Si la lista actual no es la lista vacía, obtengo el siguente elemento.                                                                
            actHead = actTail.head;
            actTail = (IterativeList<T>) actTail.tail;
            size++;
        }
        return size;
    }

    /**
     * Metodo para instertar el primer elemento de la lista.
     * @param  element - El elemenento que se agregara.
     */
    public void addFirst(T element){
    	IterativeList<T> listold = new IterativeList<T>();
    	listold.head = this.head;
    	listold.tail = this.tail;
    	this.head = element;
    	this.tail = listold;
    }
    
    /**
     * Metodo para insertar el ultimo elemento de la lista.
     * @param element - El elemento que se agregara.
     */
    public void addLast(T element){
    }
    
    /**
     * Metodo para eliminar el primer elemento de una lista.
     */
    public T removeFirst(){
    	T newList = head;
    	head = tail.head;
    	tail = tail.tail;
    	return newList;
    }	
    
    /**
     * Metodo para regresar el elemento del indice especificado.
     */
    public T get(int index){
		if(index < 0 || size() <= index){
			return null;
		}
		IterativeList<T> t = this;
		for(int i = 0; i<index; i++){
			t = (IterativeList<T>)t.tail;
		}
		return t.head;
	}
    
    @Override
	public String toString(){
		IterativeList<T> t = this;
		String r = "";
		while(t.head != null){
			r += t.head.toString() + " ";
			t = (IterativeList<T>) t.tail;
		}
		return r;
	}
    
    /**
     * @param args - no se usa. 
     */
    public static void main(String[] args){
        IterativeList<Integer> lista = new IterativeList<>();

        System.out.println(lista.size());

        lista.head = new Integer(1);
        lista.tail = new IterativeList<>();

        System.out.println(lista.size());

    }

}