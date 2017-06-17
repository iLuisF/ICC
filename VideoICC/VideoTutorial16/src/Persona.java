//SuperClase
//Una clase abstracta no se puede instanciar.
//Una clase abstracta contiene al menos un metodo que no ha sido especificado, es decir, este sera heredado para sobreescribirse.
//Haciendo la clase abstracta para evitar que sea instanciada.

public abstract class Persona {

    String nombre;
    int edad;

    public Persona(String nom, int ed) {
        this.nombre = nom;
        this.edad = ed;
    }

    //Creando al método abstracto
    abstract public void verDatos();
}
