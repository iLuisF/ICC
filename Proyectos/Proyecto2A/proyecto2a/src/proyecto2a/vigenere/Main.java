/*
 * This software is released under the terms of the GNU LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for more information.
 */

package vigenere;
import java.io.*;

/**
 * Programa principal.
 * @param args deben ser el especificador de la operación a realizar:
 * cifrar o descifrar; una palabra clave, el nombre del archivo de 
 * texto al que se le realizará la operación y el nombre del archivo
 * de texto donde se escribirá la salida del proceso.
 */
public class Main {

    public static void main(String[] args)  throws IOException {
	int op = 0;
	String opcion = args[0];
	if(opcion.equals("cifrar")){
	    op = 1;
	}
	if(opcion.equals("descifrar")){
	    op = 2;
	}
	String palabraClave = args[1];
	String archivoEntrada = args[2];
	String archivoSalida = args[3];
	
	BufferedReader lector = null;
	PrintWriter escritor = null;
	
	switch(op){
	case(1):
	    try{
		String mensaje = "";
		lector = new BufferedReader(new FileReader(archivoEntrada));
		while(op != -1){
		    op = lector.read();
		    if(op != -1){
			mensaje = mensaje + (char)op;
		    }
		}
		Vigenere metodo=new Vigenere();
		String criptograma = metodo.cifrar(mensaje, palabraClave);
		escritor = new PrintWriter(new BufferedWriter(new FileWriter(archivoSalida)));
		for(int i = 0; i < criptograma.length(); i++){
		    op = criptograma.charAt(i);
		    escritor.write(op);
		}
		// Por si falla la lectura de caracteres en el archivo.    
            } catch (IOException e){
                System.out.println("Hubo un error en la lectura el archivo.");
	    }
	    finally{
		if(lector != null){
		    lector.close();
		}
		if(escritor != null){
		    escritor.close();
		}
	    }
	    break; 
	    
	case 2: 
	    try{
		String criptograma = "";
		lector = new BufferedReader(new FileReader(archivoEntrada));
		while(op != -1){
		    op = lector.read();
		    if(op != -1){
			criptograma = criptograma + (char)op;
		    }
		}
		Vigenere metodo=new Vigenere();
                String mensaje = metodo.descifrar(criptograma, palabraClave);
                escritor = new PrintWriter(new BufferedWriter(new FileWriter(archivoSalida)));
                for(int i = 0; i < criptograma.length(); i++){
                    op = mensaje.charAt(i);
                    escritor.write(op);
                }
           // Por si falla la lectura de caracteres en el archivo. 
	    } catch (IOException e){
		System.out.println("Hubo un error en la lectura del archivo.");
	    }
	    finally{
		if(lector != null){
		    lector.close();
		}
		if(escritor != null){
		    escritor.close();
		}
	    }
            break;

	default:
	    System.out.print("Elección incorrecta.");	    
	}
    }
}
