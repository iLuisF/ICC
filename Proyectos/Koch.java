import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
* @author Mayra Aceves
* @author Luis Flores
*/
public class Koch extends JPanel {

	int nivel;
   double sin60=Math.sin(3.14/3.);

	public Koch(int n) {
      nivel = n;
      setPreferredSize(new Dimension(800, 800));
   }

   public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D)g;
      Dimension  tam = getSize();
      g2d.setColor(Color.BLACK);
      g2d.fill(new Rectangle(0, 0, tam.width, tam.height));
      g2d.setColor(Color.CYAN);

      double ladov  = Math.min((double)tam.width, (double)tam.height);

      double xp1=ladov - 50;
      double yp1=ladov / 2;
      double xp2=50;
      double yp2=ladov / 2;

      paintRecursivo(g,nivel,xp1,yp1,xp2,yp2);

      }

 	private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22 ) {
 		double dx = (xp22 - xp12) / 3.0;
 		double dy = (yp22 - yp12) / 3.0;
 		double xx = xp12 + 3 * dx / 2.0 - dy * sin60;
 		double yy = yp12 + 3 * dy / 2.0 + dx * sin60;
 		if(i <= 0){
    	  g.drawLine((int)xp12, (int)yp12, (int)xp22, (int)yp22);
 		} else {
     		paintRecursivo(g, i - 1, xp12, yp12, xp12 + dx, yp12 + dy);
     		paintRecursivo(g, i - 1, xp12 + dx, yp12 + dy, xx, yy);
     		paintRecursivo(g, i - 1, xx, yy, xp22 - dx, yp22 - dy);
     		paintRecursivo(g, i - 1, xp22 - dx, yp22 - dy, xp22, yp22);
 		}
 	}

 	public static void uso() {
      System.err.println("Programa para trazar ...");
      System.err.println("Uso: java XYZ <nivel>");
      System.err.println("nivel es un entero no negativo,");
      System.err.println ("indica el nivel de construccion.");
   }

	public static void main(String[] args){
      if (args.length == 1) {
         try {
         int niv = Integer.parseInt(args[0]);
         JFrame frame = new JFrame("Koch");
         frame.getContentPane().add(new Koch(niv), BorderLayout.CENTER);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
         }
         catch (NumberFormatException nfe) {
            uso();
         }
      }
      else {
         uso();
      }
	}

}