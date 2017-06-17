/**
 * La clase RecursiveList implementa metodos de forma recursiva
 * y extiende la clase abstracta AbstractList.
 * @author Luis Flores
 * @version 1.0
 */

public class RecursiveList<T extends Comparable<T>> extends AbstractList<T>{

	/**
	 * Metodo que construye una lista vacia.
	 */
    public RecursiveList(){
        head = null;
        tail = null;
    }

    /**
     * Metodo para obtener el tamaño.
     */
    public int size(){
        return this.head == null ? 0: tail.size() + 1;
    }

    /**
     * Metodo para pasar a cadena.
     */
    public String toString(){
		if(head == null){
			return "";
		}
		return head.toString() + " " + ((RecursiveList<T>)tail).toString(); 
	}

    /**
     * Metodo para regresar el elemento del indice especificado.
     */
	public T get(int index){
		RecursiveList<T> tail = this;
		if(index == 0){
			return head;
		}
		return tail.get(index-1);
	}

    /**
     * @param args - no se usa
     */
    public static void main(String[] args){
        RecursiveList<Integer> lista = new RecursiveList<>();

        System.out.println(lista.size());

        lista.head = new Integer(1);
        lista.tail = new RecursiveList<>();

	System.out.println(lista.size());

    }

}