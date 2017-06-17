public class Operaciones {
    
   //int x, y; todavia no se utilizan
   
   int suma(int x, int y) {
       return (x+y);
   }
    
   int resta(int x, int y){
       return (x-y);
   }
   
   double areaCirculo(int radio){
       return (3.1416*radio*radio);
   }

   boolean estado(int tequilas){
       boolean e = false;
       if(tequilas>=5){
           e = true;
       }else{
           e = false;
       }
       return e;
   }
   
   public static void main(String[] args){
       int resultado;
       int r=5;
       boolean estadoValor;
       Operaciones op1 = new Operaciones();
       resultado = op1.suma(5, 30);
       System.out.println(resultado);
       System.out.println("La resta es: " + op1.resta(60, 28));
       System.out.println("El area del circulo con radio " +r+ " es " + op1.areaCirculo(r));
       estadoValor = op1.estado(7);
       //System.out.println(estadoValor);
       if(estadoValor==true){
           System.out.println("Que mal amigo, estas borracho");
       }else{
           System.out.printf("Que bien amigo, estas sobrio.");
       }
   }
}
