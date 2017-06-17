/*
 * This software is released under the terms of the GNU LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for more information.
 */

package practica03.geometria;

/**
 * La clase Vector2D hace la operación de suma y resta
 * de vectores, determina la distancia, la magnitud y el
 * producto punto.
 * @author Luis Flores
 * @version 1.0
 */
public class Vector2D{

    private double x; // Eje x
    private double y; // Eje y

    /**
     * Constructor sin parametros.
     * Inicia la coordenada x y la coordenada y.
     */
    public Vector2D(){
	x = 0.0;
	y = 0.0;
    }

    /**
     * Constructor que inicia la coordenada x y la coordenada y.
     * @param x la coordenada x
     * @param y la coordenada y
     */
    public Vector2D(double x, double y){
	this.x = x;
	this.y = y;
    }

    /**
     * Regresa la coordenada en x.
     * @return Coordenada x.
     */
    public double getX(){
	return x;
    }

    /**
     * Regresa la coordenada en y.
     * @return Coordenada y.
     */
    public double getY(){
	return y;
    }

    /**
     * Cambia la coordena x.
     * @param x Nueva coordenada x.
     */
    public void setX(double x){
	this.x = x;
    }   

    /**
     * Cambia la coordena y.
     * @param y Nueva coordenada y.
     */
    public void setY(double y){
	this.y = y;
    }
    
    /**
     * Se suman los vectores
     * @param v El vector que se va sumar.
     */
    public void suma(Vector2D v){
	x = x + v.x;
	y = y + v.y;
    }
    
    /**
     * Desplaza este vector al sumarle el vector v.
     * @param x El vector x.
     * @param y El vector en y.
     */    
    public void Desplaza(double x, double y){
	this.x += x;
	this.y += y;
    }

    /**
     * Regresa la magnitud de la suma de los vectores.
     */
    public double magnitud(){
	return Math.sqrt(x*x + y*y);
    }


    /**
     * Resta a este vector el vector v.
     * @param v El vector.
     */
    public void restaVoid(Vector2D v){
        this.x -= v.x;
        this.y -= v.y;
    }

    /**
     * Devuelve el vector que resulta de restar a este vector v.
     * @param v El vector.
     */
    public Vector2D resta(Vector2D v){
	double xi = this.x - v.x;
	double yi = this.y - v.y;
	Vector2D res = new Vector2D(xi, yi);
	return res;
    }

    /**
     * Devuelve el vector que resulta de restar el vector v2 al vector1
     * @param v1 El vector v1.
     * @param v2 El vector v2.
     */
    public static Vector2D resta(Vector2D v1, Vector2D v2){
	double xo = v1.x - v2.x;
	double yo = v1.y - v2.y;
	Vector2D res = new Vector2D(xo, yo);
	return res;
    }

    /**
     * Devuelve la distancia entre este vector y el vector v.
     * @param v El vector.
     */
    public double distancia(Vector2D v){
	return Math.sqrt((this.x - v.x) * (this.x - v.x) + 
			 (this.y - v.y) * (this.y - v.y));
    }

    /**
     * Devuelve la distancia entre este vector v1 y el vector v2.
     * @param v1 El vector v1.
     * @param v2  El vector v2.
     */
    public double distacia(Vector2D v1, Vector2D v2){
	return Math.sqrt((v1.x - v2.x) * (v1.x - v2.x) + 
			 (v1.y - v2.y) * (v1.y - v2.y));
    }

    /**
     * Devuelve el producto punto de este vector y v.
     * @param v El vector.
     */
    public double punto(Vector2D v){
	return ((this.x * v.x) + (this.y * v.y));
    }

    /**
     * Devuelve el producto punto del vector v1 y el vector v2.
     * @param v1 El vector v1.
     * @param v2 El vector v2.
     */
    public static double punto(Vector2D v1, Vector2D v2){
	return ((v1.x * v2.x) + (v1.y * v2.y));
    }

    /**
     * Determina si este punto es igual a obj.
     * @param obj
     */
    @Override //Verificar si estoy sobrecargando un metodo
    public boolean equals(Object obj){
	Vector2D v = (Vector2D) obj;
	return v.equals(obj);
    }

    /**
     * Regresa la representación en String del vector con el formato (x, y).
     * @return Regresa el vector (x, y).
     */
    @Override
    public String toString(){
	return "(" + x + ", " + y + ")";
    }

    /**
     * Se istancia un nuevo objeto.
     * Se imprimen los datos guardados.
     * @param args No se usa.
     */
    public static void  main(String[] args){
        Vector2D v = new Vector2D(1.0, 1.0);
	System.out.println("x = " + v.getX() + ", y = " + v.getY());
	System.out.println(v.toString());
    }
}
