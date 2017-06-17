/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iLuis
 */
public class Alumno {
    //Atributos
    private int noControl;
    private String email;
    public String nombre, apellidos;
    
    //Creando los metodos get y set para poder acceder a nuestros atributos.
    
    void setNoControl(int NC){
        this.noControl=NC;
    }
    
    int getNoControl(){
        return noControl;
    }
    
    void setEmail(String EM){
        this.email=EM;
    }
    
    String getEmail(){
        return email;
    }
    //Creando el metodo para mostrar los datos
    void verDatos(){
        System.out.println("No. de Control: " + noControl);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellidos: " + apellidos);
        System.out.println("Correo: " + email);
    }
}
