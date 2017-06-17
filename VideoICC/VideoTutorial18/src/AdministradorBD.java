
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
public class AdministradorBD extends Informaticos{
    //Utilazondo poliforismo de Overload (sobrecarga)
    
    public void sueldo(double pago){
        JOptionPane.showMessageDialog(null, "El pago es: " + pago);
    }
    
    public void datos(String nom){
        JOptionPane.showMessageDialog(null, "Nombre: " + nom);      
    }
    
    public void labores(String lab){
        JOptionPane.showMessageDialog(null, "Soy AdministradorBD y me dedico a "
                + lab);
    }
}
