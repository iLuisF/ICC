
import javax.swing.JOptionPane;
//Subclase
public class Extrovertido extends Personalidad{
    @Override
    public void hablar(){
        JOptionPane.showMessageDialog(null, "Hola que gusto verte, ya te extrañaba", "Que extrovertido soy", 1);
    }
}