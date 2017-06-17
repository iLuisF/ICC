/*
 * Copyright (C) 2013 Roberto Monroy Argumedo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

/**
 * Clase para realizar prueba de métodos de clases. A través de un ojeto dado
 * de la clase, se realizan pruebas de los métodos con ciertas entradas y con la
 * salida esperada. Esta clase es útil cuando los métodos pueden no estar 
 * implementados.
 * @author Roberto Monroy Argumedo
 * @version 0.2
 */
public class Test{
    
    private final Class<?> cl;
    private final static String tab = "\t";  

    /**
     * Crea un probador para la clase e instancia de clase dados.
     * @param clase Clase de la cuál se desean probar los métodos.
     * @param instancia Con la que se probaran los métodos.
     */
    public Test(Class<?> cl) {;
        this.cl = cl;
    }
    
    /**
     * Evalua si al invocar el método, entrega la salida esperada.
     * @param instancia La instacia con la que se invocará el método.
     * @param retorno Valor de retorno esperado.
     * @param metodo Método a probar.
     * @param tiposArgs Tipos de los parámetros.
     * @param args Parámetros del método.
     * @return <code>true</code> si el método entregó la salida esperada, 
     * <code>false</code> en otro caso.
     */
    public boolean evaluaMetodo(Object instancia, String metodo, 
				Class<?>[] tiposArgs, Object[] args,
				String[] campos, Object[] valoresCampos,
				Object retorno) {
        try {
	    System.out.print(metodo + "(");
	    if(tiposArgs != null){
		for(int i = 0; i < tiposArgs.length - 1; i++){
		    System.out.print(tiposArgs[i] + ", ");
		}
		if(tiposArgs.length > 0){
		    System.out.print(tiposArgs[tiposArgs.length-1]);
		}
	    }
            Method m = cl.getDeclaredMethod(metodo, tiposArgs);
            Object r = m.invoke(instancia, args);	    
	    if(!(retorno == null ^ r == null)){
		if(retorno != null && ! retorno.equals(r)){
		    System.out.println(")" + tab + "no regresa el valor esperado.");
		    return false;
		}
		if(campos != null){
		    for(int i = 0; i < campos.length; i++){
			Field f = cl.getDeclaredField(campos[i]);
			if(! f.get(instancia).equals(valoresCampos[i])){
			    System.out.println(") " + tab + "el objeto no se modificó correctamente.");
			    return false;
			}
		    }
		}
		System.out.println(")" + tab + "OK");
		return true;
	    }
	    System.out.println(")" + tab + "no regresa el valor esperado.");
	    return false;
        } catch(NoSuchMethodException ex) {
	    System.out.println(")" + tab + "no implementado.");
            return false;
        } catch(IllegalAccessException ex) {
	    System.out.println(")" + tab + "no es publico.");
	    return false;
	} catch(InvocationTargetException ex) {
	    System.out.println(")" + tab + "termina con errores.");
            return false;
	} catch(NoSuchFieldException ex){
	    System.out.println(")" + tab + "algún campo no existe.");
            return false;
	}
    }

    /**
     * Método main que califica la clase MyString.
     * @param args No se usa.
     */
    public static void main(String[] args) {

        float cal = 0;

        ArrayString cadena = new ArrayString("   Cadena 1 ");
        ArrayString otraCad = new ArrayString("123");

        Test t = new Test(ArrayString.class);

        cal += t.evaluaMetodo(cadena, "charAt", 
			      new Class<?>[]{int.class}, new Object[]{10}, 
			      null, null, 
			      '1') ? 0.5 : 0;

        cal += t.evaluaMetodo(otraCad, "toString", 
			      null, null, 
			      null, null, 
			      "123") ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "indexOf", 
			      new Class<?>[]{char.class}, new Object[]{'a'}, 
			      null, null, 
			      4) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "indexOf", 
			      new Class<?>[]{char.class, int.class}, new Object[]{'a', 5}, 
			      null, null, 
			      8) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "lastIndexOf", 
			      new Class<?>[]{char.class}, new Object[]{'a'}, 
			      null, null, 
			      8) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "lastIndexOf", 
			      new Class<?>[]{char.class, int.class}, new Object[]{'a', 5}, 
			      null, null, 
			      4) ? 0.5 : 0;
       
        cal += t.evaluaMetodo(otraCad, "length", 
			      null, null, 
			      null, null, 
			      3) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "endsWith", 
			      new Class<?>[]{ArrayString.class}, new ArrayString[]{new ArrayString("1 ")}, 
			      null, null, 
			      true) ? 0.25 : 0;

        cal += t.evaluaMetodo(cadena, "endsWith", 
			      new Class<?>[]{ArrayString.class}, new ArrayString[]{new ArrayString("1")}, 
			      null, null, 
			      false) ? 0.25 : 0;

        cal += t.evaluaMetodo(cadena, "isEmpty", 
			      null, null, 
			      null, null, 
			      false) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "startsWith", 
			      new Class<?>[]{ArrayString.class}, new ArrayString[]{new ArrayString("   C")}, 
			      null, null, 
			      true) ? 0.25 : 0;

        cal += t.evaluaMetodo(cadena, "startsWith", 
			      new Class<?>[]{ArrayString.class}, new ArrayString[]{new ArrayString("C")}, 
			      null, null, 
			      false) ? 0.25 : 0;

        cal += t.evaluaMetodo(cadena, "trim", 
			      null, null,
			      null, null, 
			      new ArrayString("Cadena 1")) ? 1 : 0;

        cal += t.evaluaMetodo(cadena, "concat", 
			      new Class<?>[]{ArrayString.class}, new ArrayString[]{otraCad},
			      null, null, 
			      new ArrayString("   Cadena 1 123")) ? 1 : 0;

        cal += t.evaluaMetodo(cadena, "substring", 
			      new Class<?>[]{int.class, int.class}, new Object[]{3, 11},
			      null, null, 
			      new ArrayString("Cadena 1")) ? 1 : 0;

        cal += t.evaluaMetodo(cadena, "equals", 
			      new Class<?>[]{Object.class}, new Object[]{cadena},
			      null, null, 
			      true) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "equals", 
			      new Class<?>[]{Object.class}, new Object[]{otraCad},
			      null, null, 
			      false) ? 0.5 : 0;

        cal += t.evaluaMetodo(cadena, "replace", 
			      new Class<?>[]{char.class, char.class}, new Object[]{'a', 'b'},
			      null, null, 
			      new ArrayString("   Cbdenb 1 ")) ? 1 : 0;

        System.out.println("\n Calificación :" + cal + "\n");
    }

}
