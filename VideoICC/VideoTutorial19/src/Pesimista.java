
import javax.swing.JOptionPane;

//subclase
public class Pesimista extends Personalidad{
    @Override
    public void hablar(){
        JOptionPane.showMessageDialog(null, "Seguro que hoy tendre un pesimo dia", "Que pesimo soy", 1);
    }
}