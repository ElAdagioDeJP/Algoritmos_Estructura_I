package evaluacion_i;

import java.math.BigInteger;
public class Recursividad {
    
//int dprincipal,cont,sumapos,n,promsuc,max;
    
    /*public void Matriz(int matriz [][],int i, int j){
       
        if (i < matriz.length) {
            if (j< matriz.length) {
                
                matriz[i][j] = (int)(Math.random()*1999)-999;
                System.out.print(matriz[i][j] + "");
                
                
                Matriz(matriz,i,j+1);
            }
            else{
                
                System.out.println("");
                
                Matriz(matriz, i+1, 0 );
            }
        }
    }*/
    public static BigInteger factoRecur(BigInteger factorialmax) {

        if (factorialmax.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return factorialmax.multiply(factoRecur(factorialmax.subtract(BigInteger.ONE)));
        }
    }
      
        
            
        
       
           
}