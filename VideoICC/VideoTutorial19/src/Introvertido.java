
import javax.swing.JOptionPane;
//subclase
public class Introvertido extends Personalidad{
    @Override
    public void hablar(){
        JOptionPane.showMessageDialog(null, "Hola", "Soy introvertido", 1);
    }
}