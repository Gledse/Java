
package exercicios.d090719;

import java.util.*;

import javax.swing.JOptionPane;

/* Enuciado:
*  Criar um programa que receba 10 cores do usuario e imprima as cores na ordem do usuario.
*  Mostrar as cores em ordem decrescente e depois mostrar as cores que estao nas posicoes pares
*/
/**
 *
 * @author Gledse Jamisse
 */
public class Cores {
    
    public static void main (String [] args){
        
        crescente();
        decrescente();
           
    }
    
    public static void crescente(){
         
        Scanner teclado = new Scanner(System.in);
        String[] cores = new String[4];
        
         
        for(int x = 0; x < cores.length; x++){ // Entrada de dados
            
            System.out.println("Digete uma cor");
            cores[x] = teclado.nextLine();
        }
        // Saida de dados
        for(int i = 0; i < cores.length; i++){
        
           System.out.println("Cor " + (i+1) + ": " + (cores[i]));
        }
        
    }
    
    public static void decrescente(){
         
        Scanner teclado = new Scanner(System.in);
        String[] cores = new String[4];
        
         
        for(int x = 0; x < cores.length; x++){ // Entrada de dados
            
            System.out.println("Digete uma cor");
            cores[x] = teclado.nextLine();
        }
        // Saida de dados
        for(int x = cores.length - 1; x >= 0; x--){
            
            System.out.println("Digete " + (x+1) + ": " + (cores[x]));
        }
        
    }
    
}
