/*                                                                                                   
 * This software is released under the terms of the GNU LGPL license.                               
 * See http://www.gnu.org/licenses/lgpl.html for more information.                                   
 */

package practica01;

/**
 *La clase TiposPrimitivos se practican conceptos básicos del diseño, implementación y
 *documentación de clases
 *@author Luis Flores
 *@version 1.0
 */

public class TiposPrimitivos{

    /**
     *Atributos constantes para literales
     */
     final static double PI = 3.1415;
     final static String CADENA = "El resultado de la operación";
     final static String CARACTER = " es ";
     
    /**
     *Declaracion de 8 variables de instancia para la clase, cada uno perteneciente a
     *los datos primitivos
     */
    byte unocero;
    short peque;
    int ent;
    long lar;
    float flot;
    double doble; 
    boolean sino;
    char letras;

    /**
     *Primer constructor sin parámetros, el cual asignara valor a las variables. 
     */
    TiposPrimitivos(){
        unocero = 0110;
        ent = 21;
        lar = 2154;
        flot = 21.12f;
        doble = 12.24;
        sino = true;
        peque = 1;
        letras = 'l';
    }

    /**
     *Segundo constructor, con parametros mismos que se usaran para inicializar 
     *variables de instancia de la clase.
     *@param hola  Es la asignación de variable short
     */
    TiposPrimitivos(short hola){
	unocero = 0110;  
	ent = 21;
	lar = 2154;
	flot = 21.12f;
	doble = 12.24;
	sino = true;
	peque = hola;
	letras = 'l';
    }

    /**
     *Tercer constructor, con dos 2 parametros mismos que se usaran para inicializar 
     *2 variables de instancia de la clase.
     *@param decimaldoble Es la asignación de la variable double
     *@param deciaml Es la asignación de la variable float
     */
    TiposPrimitivos(double decimaldoble, float decimal){
	doble = decimaldoble;
	flot = decimal;
	unocero = 0110;
	ent = 15;
	lar = 2115;
	flot = 15.21f;
	doble = 21.15;
	sino = false;
	letras = 'n';
    }   

    /**
     *Metodo de modificacion para cambiar alguna variable de instancia.
     *@param nuepq El nuevo valor de la variable peque.
     */
    void setPeque(short nuepq){
	this.peque = nuepq;
    }


    /**
     *Metodo de acceso para obtener el valor de alguna variable de instancia .
     *@return Valor de la variable peque.
     */    
    short getPeque(){
	return peque;
    }

    /**
     *Metodo main para la clase "Tipos primitivos" ademas se instancian 3 nuevos objetos de la
     *la misma clase. Y se imprime el resultado de las operaciones.
     */
    public static void main(String[] args){
	TiposPrimitivos p1 = new TiposPrimitivos();
	TiposPrimitivos p2 = new TiposPrimitivos((short)35);
	TiposPrimitivos p3 = new TiposPrimitivos(12, 13.12f);
	long lar = 7L * p1.peque;
	double doble = p2.flot * 7.0 - p3.ent;
	char ch = (char)(p1.letras - p3.peque);
	short sh = (short)(7L * p3.peque);
	int ent = (int)(p1.flot * 7.0 - p3.ent);
	System.out.println(CADENA + " 7L*s " + CARACTER + lar);
	System.out.println(CADENA + " f* 7.0 - i " + CARACTER + doble);
        System.out.println(CADENA + " c - s " + CARACTER + ch);
        System.out.println(CADENA + " 7l * s " + CARACTER + sh);
        System.out.println(CADENA + " f * 7.0 -i " + CARACTER + ent);

    }
} 

