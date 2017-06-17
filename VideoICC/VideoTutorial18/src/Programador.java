
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author iLuis
 */
public class Programador extends Informaticos{
    //Utilazondo poliforismo de Overload (sobrecarga)
    
    public void sueldo(int horas, double pagoH){
        JOptionPane.showMessageDialog(null, "El pago es: " + (horas*pagoH));
    }
    
    public void datos(String nom, String ape){
        JOptionPane.showMessageDialog(null, "Nombre: " + nom + 
                "\nApellidos" + ape);      
    }
    
    public void labores(String lab){
        JOptionPane.showMessageDialog(null, "Soy programador y me dedico a "
                + lab);
    }
}
