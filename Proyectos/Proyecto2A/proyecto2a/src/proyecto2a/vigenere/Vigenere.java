/*
 * This software is released under the terms of the GNU LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for more information.
 */

package vigenere;
import java.io.*;

/**
* Programa para resolver el problema de cifrado de Vigenere.
* @author Mayra Aceves
* @author Luis Flores
* @version 1.0
*/
public class Vigenere {

    char[][] matriz = new char [26][26];  // La matriz que contiene la Tabla con el alfabeto.
    String criptograma = null;		  //El criptograma a cifrar o descifrar.

    /**
     * Metodo constructor que genera una matriz cuadrada con el alfabeto
     * de 26 caracteres, utilizando Unicode con el alfabeto en mayúsculas.
     * Los caracteres utilizados en Unicode van del 65 al 90.
     */
    public Vigenere() {
	int filas = 65;  // Comienzo del alfabeto en mayúsculas en Unicode
	int columnas = 0;

	for(int i = 0; i < 26; i++) {
	    columnas = filas;  //Debe haber el mismo número de filas como de columnas.
	    for(int j = 0; j < 26; j++) {
		matriz[i][j] = (char)columnas;
		columnas++;
		//Si llegamos a la 'Z' y todavía hay espacios en el arreglo
		// se reinicia el alfabeto.
		if(columnas > 90) {  
		    columnas = 65;
		}
	    }
	    filas++;
	    if(filas > 90) {
		filas = 65;
	    }
	}
    }
    
    /**
     * Completa la longitud de la clave para que sea equivalente a la longitud
     * del mensaje.
     * @param clave La clave.
     * @param longitud Tamaño del mensaje.
     */
    public String completa(String clave, int longitud){
	int diferencia = 0;
	int indice = 0;

	if(clave.length() != longitud) {
	    //Si la clave es menor, se completa con la diferencia
	    //de longitud del mensaje.
	    if(clave.length() < longitud) { 
		diferencia = longitud - clave.length();
		while(diferencia != 0) {
		    clave += clave.charAt(indice);
		    if(indice == (clave.length() - 1)) {
			indice =- 1;
		    }
		    indice++;
		    diferencia--;
		}
	    } else {
		//Si la clave es mayor a la longitud del mensaje,
		//se acorta.
		diferencia = clave.length() - longitud;
		clave = clave.substring(0, clave.length() - diferencia);
	    }
	}
	return clave;
    }

    /**
     * Obtiene la posición del caracter que se encuentra en la intresección
     * del mensaje (columnas) y la clave (filas) en la posición especificada.
     *  @param mensaje El arreglo en la columna donde se encuentra el mensaje.
     *  @param clave El arreglo en la fila donde se encuentra la clave.
     *  @return char El caracter de la intersección entre las columnas y las filas.
     */
    char getCaracter(char mensaje, char clave) {
	int posicionMensaje = 0;
	int posicionClave = 0;
	int indice = 0;
	boolean aparece = false;
	
	while(indice < 26 && aparece == false) {
	    if(matriz[0][indice] == mensaje) {
		aparece = true;
		posicionMensaje = indice;
	    }
	    indice++;
	}
	aparece = false;
	indice = 0;
	while(indice < 26 && aparece == false) {
	    if (matriz[indice][0] == clave) {
		aparece = true;
		posicionClave = indice;
	    }
	    indice++;
	}
	return matriz[posicionClave][posicionMensaje];
    }

    /**
     * Cifra una cadena utilizando el método de Vigenere.
     * Se realiza el cifrado en letras mayúsculas.
     * @param mensaje El mensaje que se va a cifrar.
     * @param clave La palabra clave para cifrar el mensaje.
     * @return String La cadena con el criptograma.
     */
    public String cifrar(String mensaje, String clave) {
	criptograma = "";
	mensaje = mensaje.toUpperCase();
	clave = clave.toUpperCase();

	//Se hace equivalente la longitud de la clave a la del mensaje.
	clave = completa(clave, mensaje.length());
	
	//Se obtiene el caracter a partir de la matriz.
	for(int i = 0; i < mensaje.length(); i++) {
	    criptograma += getCaracter(mensaje.charAt(i), clave.charAt(i));
	}
	return criptograma;
    }

    /**
     * Obtiene la posición del caracter que se encuentra en la intresección
     * del mensaje (columnas) y la clave (filas) en la posición especificada.
     * @param cifrado La letra en la posición dada en el mensaje sobre las columnas.  
     * @param clave La letra en la posición dada en la clave sobre las filas.
     * @return char El caracter de la intersección entre las clumnas y las filas.
     */
    char getCaracterDescifrado(char cifrado, char clave) {
	int posicionMensaje = 0;
	int posicionClave = 0;
	int indice = 0;
	boolean aparece = false;
	
	while(indice < 26 && aparece == false) {
	    if(matriz[0][indice] == clave) {
		aparece = true;
		posicionClave = indice;
	    }
	    indice++;
	}
	aparece = false;
	indice = 0;
	while(indice < 26 && aparece == false) {
	    if (matriz[indice][posicionClave] == cifrado) {
		aparece = true;
		posicionMensaje = indice;
	    }
	    indice++;
	}
	return matriz[0][posicionMensaje];
    }

    /**
     * Descifra una cadena utilizando el método de Vigenere.
     * Se realiza el descifrado en letras mayúsculas.
     * @param mensaje El mensaje que se va a cifrar.
     * @param clave La palabra clave para cifrar el mensaje.
     * @return String La cadena con el criptograma.
     */
    public String descifrar(String mensaje, String clave) {
	criptograma = "";

	mensaje = mensaje.toUpperCase();
	clave = clave.toUpperCase();
	
	//Se hace equivalente la longitud de la clave a la del mensaje.
	clave = completa(clave, mensaje.length());
	
	//Se obtiene el caracter a partir de la matriz.
	for(int i = 0; i < mensaje.length(); i++) {
	    criptograma += getCaracterDescifrado(mensaje.charAt(i), clave.charAt(i));
	}
	return criptograma;
    }
}
