/*
 * This software is released under the terms of the GNU LGPL license. 
 * See http://www.gnu.org/licenses/lgpl.html for more information.
 */
/**
 * En la clase ArrayString se implementan estructuas de control ademas de diversos metodos String.
 * @author Luis Flores
 * @version 1.0
 */

public class ArrayString{

    private char[] string;

    /**
     * Constructor que inicia una cadena vacia.
     */
    public ArrayString(){
	string = new char[0];
    }

    /**
     * Constructor que convierte un arreglo en caracteres.
     * @param str Cadena de texto.
     */
    public ArrayString(String str){
	string = str.toCharArray();
    }

    /**
     * Contructor que copia los caracteres de un arreglo a otro y no
     * la referencia.
     * @param str Arreglo de caracteres.
     */
    public ArrayString(char[] str){
	string = new char[str.length];
	System.arraycopy(str, 0, string, 0, str.length);
    }

    /**
     * Se extrae caracter por caracter de un arreglo, nunca va ser null.
     * @param index El numero del indice.
     * @return Caracter que se encuentra en el indice.
     */
    public char charAt(int index){
	return string[index]; 
    }

    /**
     * Muestra la informacion completa de un objeto, es decir, el valor de sus atributos.
     * @return Arreglo en cadena.
     */
    public String toString(){
	String r = "";
	for(int i = 0; i < string.length  ; i++){
	    r += string[i];
	}
	return r;
    }

    /**
     * Sustituye todas las ocurrencias de un caracter por otro.
     * @param oldChar Caracter antiguo.
     * @param newChar Caracter nuevo.
     */
    public ArrayString replace(char oldChar, char newChar){
        char[] s = new char[this.string.length];

	for(int i = 0; i<this.string.length; i++){
            s[i] = this.string[i];
            if( s[i] == oldChar){
                s[i] = newChar;
            }
        }
        return new ArrayString(s);
    }

    /**
     * Localiza la primera ocurrencia del argumento en la cadena.
     * @param ch Es un caracter.
     * @return Regresa -1 si no se encuentra el caracter.
     */
    public int indexOf(char ch){
        int r = 0;
        for(int i = 0; i<this.string.length; i++){
	    r = i;
            if( string[i] == ch){
                break;
            }
        }
        return r;
    }

    /**
     * Localiza la primera ocurrencia del argumento en la cadena.
     * @param ch Caracter que va localizar.
     * @param int Inicia la busqueda apartir de otra posion.
     * @return Regresa -1 si no se encuentra el caracter.
     */
    public int indexOf(char ch, int fromIndex){
        int r = 0;
        for(int i = 0; i<this.string.length; i++){
            r = i;
            if(i >= fromIndex){
                if( string[i] == ch){
		    break;
                }
            }
        }
        return r;
    }

    /**
     * Localiza la ultima ocurrencia del caracter.
     * @param ch Caracter que va localizar.
     * @return regresa -1 si el caracter no se encuentra.
     */
    public int lastIndexOf(char ch){
	int ind = -1;
	for (int i = this.string.length - 1; i >= 0; i--) {
	    if (this.string[i] == ch) {
		ind = i;
		i = -1;
	    }
	}
	return ind;	
    }
    /**
     * Localiza la ultima ocurrencia de un caracter.
     * @param ch Caracter
     * @param fromIndex Argumento con que inicia la posicion la busqueda.
     * @return Regresa -1 si el caracter no se encuentra.
     */
    public int lastIndexOf(char ch, int fromIndex){
	int r = 0;
        for(int i = (this.string.length -1); i<this.string.length; i--){
            r = i;
            if(i <= fromIndex){
                if(string[i] == ch){
                    break;
                }
            }
        }
        return r;
    }

    /**
     * Calcula el numero de caracteres.
     * @return Regresa la longitud.
     */
    public int length(){
	return string.length;
    }


    /**
     *Comprueba si la cadena termina con el sufijo pasado como parámetro
     * @param suffix 
     * @return True si ArrasString termina con el sufijo y False en otro caso.
     */
    public boolean endsWith(ArrayString sufix) {
        int j = this.string.length - 1;
        int k = 0;
        for (int i = sufix.string.length - 1; i >= 0; i--) {
            if (this.string[j] == sufix.string[i]) {
                k++;
                j--;
            }
        }
        return(k == sufix.string.length);
    }

    /**
     * Se revisa si dos cadenas son alfabeticamente iguales y devuelve un valor boolean.
     * @param 
     * @return True si son iguales y False de lo contrario.
     */
    public boolean equals(Object obj){
	int j = 0;
        if (obj == null) {
            return false;
        }
        ArrayString d = (ArrayString)obj;
        if (obj instanceof ArrayString) {
            if (this.string.length == d.string.length) {
                for (int i = 0; i < this.string.length; i++) {
                    if(this.string[i] == d.string[i]) {
                        j++;
                    }
                }
            }
        } else {
            return false;
        }
        return j == this.string.length;
    }

    /**
     * Devuelve verdadero si la longitud es 0 y falso si no.
     * @return True si la longitud es 0.
     */
    public boolean isEmpty(){ 
	return (string == null || string.length == 0);
    }

    public boolean startsWith(ArrayString prefix){  
	for(int i = 0; i < prefix.length(); i ++){
	    if(prefix.charAt(i) != string[i]){
		return false;
	    }
	}
	return true;
    }

    /**
     * Devuelve una cadena en la que se han eliminado esos espacios que tenia.
     * @return  Nuevo ArrayString sin espacios.
     */
    public ArrayString trim(){   
	int k = 0;
        int j = 0;
        for (int i = 0; i < this.string.length; i++) {
            if (this.string[i] == ' ') {
                k++;
            } else {
                i = this.string.length;
            }
        }
        for (int i = this.string.length - 1; i >= 0; i--) {
            if (this.string[i] == ' ') {
                j++;
            } else {
                i = -1;
            }
        }
        char[] ar = new char[this.string.length - k -j];
        System.arraycopy(this.string, 0 + k, ar, 0, ar.length);
        return new ArrayString(ar);
    }


    /**
     * Concatena dos cadenas
     * @param str Arreglo 
     * @return Nueva cadena que aparece de concatenar cadenas.
     */
    public ArrayString concat(ArrayString str){
        int tmt = this.string.length + str.string.length; //Suma del tamaño total del arreglo;
		char[] arrto = new char[tmt];  
	for(int i = 0; i < this.string.length ; i++){ //copia la primera
		    arrto[i] = this.string[i];
	 }
	for(int j = 0; j < str.string.length; j++ ){
	  arrto[this.string.length + j] = str.string[j];
		}
	return new ArrayString(arrto);
    }
 
    /**
     * Se obtiene una subcadena de la original y se devuelve como otra cadena.
     * @param beginIndex posicion inicial
     * @param endIndex posicion final
     * @return Nueva cadena de la original.
     */
      public ArrayString substring(int beginIndex, int endIndex){
    	char[] s = new char[endIndex - beginIndex];	
     	for(int i = 0; i<(endIndex-beginIndex); i++){
          s[i] = this.string[i + beginIndex];
    	}
    	     	return new ArrayString(s);
     }

}
