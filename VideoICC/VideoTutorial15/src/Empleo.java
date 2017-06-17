//Subclase
import javax.swing.JOptionPane;

public class Empleo extends Persona{
    double sueldo;
    String telefono, direccion;
    
    public Empleo(String nom, int ed, double suel, String tel, String dir){
        super(nom, ed);
                this.direccion=dir;
                this.sueldo=suel;
                this.telefono=tel;
    }
    
    @Override
    public void verDatos(){
        JOptionPane.showMessageDialog(null, "Nombre: " +nombre+ "\nEdad: " +edad+
                "\nSueldo: " +sueldo+ "Telefono: " +telefono+ "\nDirección: "+ direccion
                ,"Datos del empleado :)", JOptionPane.INFORMATION_MESSAGE);
    }
}
