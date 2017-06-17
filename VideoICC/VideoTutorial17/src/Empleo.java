//Subclase

import javax.swing.JOptionPane;

public class Empleo extends Persona implements Enfermo{

    double sueldo;
    String telefono, direccion;

    public Empleo(String nom, int ed, double suel, String tel, String dir) {
        super(nom, ed);
        this.direccion = dir;
        this.sueldo = suel;
        this.telefono = tel;
    }

    @Override
    public void verDatos() {
        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nEdad: " + edad
                + "\nSueldo: " + sueldo + "Telefono: " + telefono + "\nDirección: " + direccion, "Datos del empleado :)", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void tos(){
        JOptionPane.showMessageDialog(null, "Hola, estoy enfermo de tos, cof cof D:");
    }
    
    @Override
    public void diarrea(){
        JOptionPane.showMessageDialog(null, "Hola, estoy enfermo de diarrea, snif snif :'(");
    }
}   
