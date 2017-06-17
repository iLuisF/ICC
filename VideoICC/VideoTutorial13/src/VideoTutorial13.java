/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iLuis
 */
public class VideoTutorial13 {
    public static void main(String[] args){
        Alumno alu1 = new Alumno();
        Alumno alu2 = new Alumno();
        alu1.setNoControl(123456);
        alu1.nombre="Juan";
        alu1.apellidos="Perez López";
        alu1.setEmail("Hola@gmail.com");
        alu1.verDatos();
        System.out.println("No. Control: " +alu1.getNoControl() + " Que es privado");
    }
}
