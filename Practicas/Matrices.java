
/*
  * Clase Matrices
  * Extiende de la clase Thread
*/

public class Matrices extends Thread{
  /* matriz A */
  static int a[][];
  /* matriz B */
  static int b[][];
  /* Variable para decir a partir de que punto un thread ejecutara la operacion producto punto*/
  int inicio;
  /* numero de threads */
  int longitud;
  /* matriz resultante */
  static int resultado[][];
  
  /*
    * Metodo constructor de la clase Matrices 
   */
  public Matrices(int[][] a, int[][] b, int[][] resultado, int inicio, int longitud){
    this.a = a;
    this.b = b;
    this.resultado = resultado;
    this.inicio = inicio;
    this.longitud = longitud;
  }
  
  /* 
    * Metodo que realiza el producto punto de vectores, se le pasa la posicion de resultado, osea de que vectores A y de B va a realizar el producto punto
   */
  public void productoPunto(int posa, int posb){
    int resultado = 0;
    for(int i=0; i<this.a[posa].length; i++){
	    resultado += this.a[posa][i]*this.b[i][posb];
    }
    this.resultado[posa][posb] = resultado;
  }

  /* 
    * Metodo que rellena un pedazo de de la matriz resultante 
  */
  public void llenaResultante(){
    for(int i=inicio; i<this.longitud;i++){
      for(int j=0; j<this.resultado[i].length; j++){
	productoPunto(i,j);
      }
    }
  }
  
  /*
    * Sobreescribe el metodo run de la clase Thread
  */
  public void run(){
    llenaResultante();
  }
	
}
