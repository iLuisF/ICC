
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
public class VideoTutorial18 {
    public static void main(String[] args){
        Programador p1 = new Programador();
        Analista an1 = new Analista();
        AdministradorBD adm1 = new AdministradorBD();
        ProgramadorOverride p2 = new ProgramadorOverride();
        AnalistaOverride an2 = new AnalistaOverride();
        AdministradorOverride adm2 = new AdministradorOverride();
        JOptionPane.showMessageDialog(null, "Aqui comienza Polimorfismo Overload");
        p1.datos("Juan", "Perez");
        p1.sueldo(24, 100);
        p1.labores("Programar");
        an1.datos("Julian", "Lopez", "El capulin");
        an1.sueldo(24, 100, 100);
        an1.labores("Analizar datos", 8);
        adm1.sueldo(4500);
        adm1.datos("Jose");
        adm1.labores("Administrador de BD");
        JOptionPane.showMessageDialog(null, "Aqui comienza Polimorfismo Override");
        p2.datos("Pedro");
        p2.sueldo(2500);
        p2.labores("Programar en serio");
        an2.datos("Panfilá");
        an2.sueldo(40000);
        an2.labores("Analizar datos en serio");
        adm2.datos("Gelacio");
        adm2.labores("Administrar la BD en serio");
        adm2.sueldo(28000);
    }
}
