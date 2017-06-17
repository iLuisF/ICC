/*
  * This software is released under the terms of the GNU LGPL license. 
  * See http://www.gnu.org/licenses/lgpl.html for more information.
  */

package practica02;

/**
 * La clase Mascota extrae los datos de  un perro que muestra su raza, edad y genero.
 * @author Luis Flores
 * @version 1.0
 */

public class Mascota{

    private String raza; //La raza del perro
    private int edad; //La edad del perro
    private String genero; //El genero del perro

    /**
     * Metodo constructor que asigna las variables raza, edad y genero.
     * @param raza del perro.
     * @param edad del perro.
     * @param genero del perro.
     */

    public Mascota(String ra, int ed, String gen){
	raza = ra; //Asignación de variable para la raza
	edad = ed; //Asignación de variable para la edad
	genero = gen; //Asignación de variable para el genero
    }

    /**
     * Regresa la raza del perro.
     * @return La raza.
     */
    public String getRaza(){
	return raza;
    }

    /**
     * Cambia la raza del perro.
     * @param la raza del perro.
     */
    public void setRaza(String ra){
	raza = ra;
    }

    /**
     * Regresa la edad del perro.
     * @return la edad.
     */
    public int getEdad(){
	return edad;
    }

    /**
     * Cambia la edad del perro.
     * @param la edad del perro.
     */
    public void setEdad(int ed){
	edad = ed;
    }
    /**
     * Regresa el genero del perro.
     * @return el genero.
     */
    public String getGenero(){
	return genero;
    }

    /**
     * Cambia el genero del perro.
     * @param el genero.
     */
    public void setGenero(String gen){
	genero = gen;
    }

    /**
     * Se instancian tres objetos de la clase Mascota y se imprimen
     * los datos guardados en ellos.
     * @param args - no se usa.
     */
    public static void main(String[] args){
	Mascota Perro;
	Perro = new Mascota("Pastor Aleman", 5, "Macho");
	System.out.println(Perro.getRaza()); //Muestra la raza
	System.out.println(Perro.getEdad()); //Muestra la Edad
	System.out.println(Perro.getGenero()); //Muestra el genero
    }
    
}
