/* -------------------------------------------------------------------
 * Sierpinsky.java
 * versiÃ³n 1.0
 * Copyright (C) 2007  JosÃ© Galaviz Casas,
 * Facultad de Ciencias,
 * Universidad Nacional AutÃ³noma de MÃ©xico, Mexico.
 *
 * Este programa es software libre; se puede redistribuir
 * y/o modificar en los tÃ©rminos establecidos por la
 * Licencia PÃºblica General de GNU tal como fue publicada
 * por la Free Software Foundation en la versiÃ³n 2 o
 * superior.
 *
 * Este programa es distribuido con la esperanza de que
 * resulte de utilidad, pero SIN GARANTÃ�A ALGUNA; de hecho
 * sin la garantÃ­a implÃ­cita de COMERCIALIZACIÃ“N o
 * ADECUACIÃ“N PARA PROPÃ“SITOS PARTICULARES. VÃ©ase la
 * Licencia PÃºblica General de GNU para mayores detalles.
 *
 * Con este programa se debe haber recibido una copia de la
 * Licencia PÃºblica General de GNU, de no ser asÃ­, visite el
 * siguiente URL:
 * http://www.gnu.org/licenses/gpl.html
 * o escriba a la Free Software Foundation Inc.,
 * 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * -------------------------------------------------------------------
 */
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
 * Esquema general para generar el triángulo de Sierpiski
 * de n-ésima generación.
 *
 * @author Mayra Aceves
 * @author Luis Flores
 * @version 1.0<br>
 * abril 2007
 */
public class Sierpinsky extends JPanel {

   /*
    Nivel de recusiÃ³n requerido.
   */
   int nivel;


   /**
    * Construye una instancia de la clase encargada del trazado.
    * SÃ³lo establece el tamaÃ±o preferido de la ventana de trazado.
    * @param n es el nivel de construcciÃ³n requerido para
    */
   public Sierpinsky(int n) {
      nivel = n;
      setPreferredSize(new Dimension(400, 400));
   }

   /**
    * Pinta el objeto en la ventana de trazado.
    * @param g es el objeto grÃ¡fico usado para la operaciÃ³n de trazado.
    */
   public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D)g;
      Dimension  tam = getSize();
      g2d.setColor(Color.BLACK);
      g2d.fill(new Rectangle(0, 0, tam.width, tam.height));
      g2d.setColor(Color.GREEN);

      double ladov  = Math.min((double)tam.width, (double)tam.height);
      int    x1, y1, x2, y2, x3, y3;
      // AquÃ­ van los calculos necesarios para determinar los puntos iniciales
      // con base en las dimensiones de la ventana. ladov contiene la mÃ­nima
      // longitud disponible tanto en X como en Y

      x1 = (((int)ladov-10)/2);
      y1 = 20;  
      x2 = (int)ladov-40;
      y2 = ((int)ladov-20);
      x3 = 40;
      y3 = ((int)ladov-20);

      trazaTriangulo(g2d,
                     new Point(x1, y1), new Point(x2, y2), new Point(x3, y3),
                     nivel);
   }

   
   private static Point puntoMedio(Point v1, Point v2){
    int p1x = v1.x;
    int p2x = v2.x;
    int p1y = v1.y;
    int p2y = v2.y;
    int px = (p1x + p2x)/2;
    int py = (p1y + p2y)/2;
    return new Point(px, py);
   }
   
   /**
    * Traza el triÃ¡ngulo de Sierpinsky del nivel especificado.
    * @param g2 es el objeto grÃ¡fico con el que se trazarÃ¡ la curva.
    * @param v1 primer vÃ©rtice del triÃ¡ngulo.
    * @param v2 segundo vÃ©rtice del triÃ¡ngulo.
    * @param v3 tercer vÃ©rtice del triÃ¡ngulo.
    * @param n es el nivel de recursiÃ³n requerido.
    */
   public static void trazaTriangulo(Graphics2D g2,
                                     Point v1,
                                     Point v2,
                                     Point v3,
                                     int   n) {
      if (n == 0) {
         // trazo del objeto de nivel 0        
        g2.drawLine(v1.x, v1.y, v2.x, v2.y);
        g2.drawLine(v1.x, v1.y, v3.x, v3.y);
        g2.drawLine(v2.x, v2.y, v3.x, v3.y);
      } else {
        int x1 = v1.x;
        int y1 = v1.y;
        int x2 = v2.x;
        int y2 = v2.y;
        int x3 = v3.x;
        int y3 = v3.y;
        g2.drawLine(x1, y1, x2, y2);
        g2.drawLine(x2, y2, x3, y3);
        g2.drawLine(x3, y3, x1, y1);
        Point p1 = puntoMedio(v2, v3);
        Point p2 = puntoMedio(v1, v3);
        Point p3 = puntoMedio(v1, v2);
        trazaTriangulo(g2, v1, p3, p2, n-1);
        trazaTriangulo(g2, v2, p3, p1, n-1);
        trazaTriangulo(g2, v3, p1, p2, n-1);
      }
   }

   /**
    * Despliega el mensaje de uso del programa.
    */
   public static void uso() {
      System.err.println("Programa para trazar ...");
      System.err.println("Uso: java XYZ <nivel>");
      System.err.println("nivel es un entero no negativo,");
      System.err.println ("indica el nivel de construccion.");
   }

   /**
    * Programa principal, recibe el nivel de iteraciÃ³n de la curva.
    * @param args son los argumentos dados en la lÃ­nea de llamada al programa.
    * En este caso el argumento debe ser sÃ³lo el nivel de iteraciÃ³n de
    * la curva.
    */
   public static void main(String[] args){
      if (args.length == 1) {
         try {
         int niv = Integer.parseInt(args[0]);
         JFrame frame = new JFrame("TriÃ¡ngulo de Sierpinsky");
         frame.getContentPane().add(new Sierpinsky(niv), BorderLayout.CENTER);
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
} // Fin de Sierpinsky.java
