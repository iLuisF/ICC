
import javax.swing.JOptionPane;

public class Analista extends Informaticos{
    //Utilazondo poliforismo de Overload (sobrecarga)
    
    public void sueldo(int horas, double pagoH, double incen){
        JOptionPane.showMessageDialog(null, "El pago es: " + ((horas*pagoH)+incen));
    }
    
    public void datos(String nom, String ape, String dir){
        JOptionPane.showMessageDialog(null, "Nombre: " + nom + 
                "\nApellidos" + ape + "\nDireccion" + dir);      
    }
    
    public void labores(String lab, int horas){
        JOptionPane.showMessageDialog(null, "Soy analista y me dedico a "
                + lab + " " + horas + " Horas");
    }
}
