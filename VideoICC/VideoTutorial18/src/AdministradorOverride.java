
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
public class AdministradorOverride extends InformativosOverride{
        @Override
    public void sueldo(double pago){
        JOptionPane.showMessageDialog(null, "El pago de un administrador es $" +pago);
    }
    @Override
    public void datos(String nombre){
        JOptionPane.showMessageDialog(null, "El nombre del administrador es " +nombre);
    }
    @Override
    public void labores(String labor){
        JOptionPane.showMessageDialog(null, "Las labores del administrador son" +labor);
    }
}
