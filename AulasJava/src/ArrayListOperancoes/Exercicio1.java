
package ArrayListOperancoes;

import java.util.*;
//import javax.swing.JOptionPane;

/**
 * Um programa em java que receba dois numeros e exiba o resultado da soma. 
 */
/**
 *
 * @author Gledse Jamisse
 */
public class Exercicio1 {
    
    int numeros[] = new int[2];
    // exercicio 1
    public void lerDados(){
        
        Scanner t = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            
            System.out.println("INTRODUZA " +(i+1)+ " NUMERO INTEIRO: ");
            numeros[i] = t.nextInt();
        }
        
    }
    public void soma(){
        
        int soma;
        soma = numeros[0] + numeros [1];
        
        System.out.println("A SOMA EH: "+ (soma)); 
        //JOptionPane.showMessageDialog(null,(soma));
    }
   
    public static void main(String[] args) {
        
        Exercicio1 x = new Exercicio1();
        x.lerDados();
        x.soma();
    }
}
