
package exercicios.d090719;

import java.util.*;

/*
* Programa que multiplica os numeros digitados pelo usuario
*/
/**
 *
 * @author Gledse Jamisse
 */
public class Exempos {
    
    public static void leituraDeDados(){
        
        Scanner teclado = new Scanner(System.in);
        int numeros[] = new int[12];  
        
        for(int i = 0; i < numeros.length; i++){ // Entrada de dados
            
            System.out.println("Digite " + (i+1) + " numero inteiro"); // Vai pedir 3.
            numeros[i] = teclado.nextInt();
        } 
    }
    
    public static int  multiplicacao(int numeros[] ){
        
        int y = 0,n = 0;
        for(int i = 0; i <= numeros.length; y++){
            y = y*numeros[i];
            
            System.out.println(n + " * " + numeros[i] + " = " + y);
        }    
         return y;
    }
  
    public static void main(String[] args) {
        
        
        leituraDeDados();

        
    }
}
