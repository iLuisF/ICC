/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iLuis
 */
public class Auto {
 
    String marca, color;
    int modelo;
    double precio;
    
    void arrancarAuto(String marca){
        System.out.println("El auto " + marca + " arranco");
    }
 
    void apagarAuto(String marca){
        System.out.println("El auto " + marca + "se apago");
    }
    
    public static void main(String[] args){
        //Creando objetos
        Auto primerAuto = new Auto();
        Auto segundoAuto = new Auto();
        primerAuto.arrancarAuto("Platina");
        primerAuto.arrancarAuto("Sentra");
    }
}
