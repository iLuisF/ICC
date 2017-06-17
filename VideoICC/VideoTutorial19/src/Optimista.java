
import javax.swing.JOptionPane;


public class Optimista extends Personalidad{
    @Override
    public void hablar(){
        JOptionPane.showMessageDialog(null, "Seguro que hoy tendre un gran dria", "Que optimista soy", 1);
    }
}
