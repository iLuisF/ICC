
//VideoTutorial12
public class Alumnos {
    //atributos
    int noControl;
    String nombre, apellidos;
    
    //Creando metodo contructor
    Alumnos(int nC, String nom, String ape){
        this.noControl = nC;
        this.nombre = nom;
        this.apellidos = ape;
    }
    
    //Metodos
    void verDatos(){
        System.out.println("No. Control: " + noControl);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
    }
    
    //Creando los comentarios get and set
    int getControl(){
       return this.noControl; 
    }
    
    String getNombre(){
        return this.nombre;
    }
    
    void setControl(int NC){
        this.noControl = NC;
    }
    
    void setNombre(String NOM){
        this.nombre = NOM;  
    }
    
    public static void main(String[] args){
        Alumnos alu1 = new Alumnos(12345678, "Pepe", "Pepito");
        Alumnos alu2 = new Alumnos(123, "Pedro", "Pepito");
        System.out.println("Obteniendo el nombre de alumno 2: " +alu2.getNombre());
        //Asignando un nombre al que antes era Rutil
        alu2.setNombre("Julian");
        System.out.println("Obteniendo el nuevo nombre de alumno 2: "+alu2.getNombre());
    }
}
