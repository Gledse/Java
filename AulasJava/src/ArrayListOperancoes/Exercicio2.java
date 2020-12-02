
package ArrayListOperancoes;

import java.util.Scanner;

/**
 * Um programa em java que receba dois numeros e ao final mostre a soma, subtracao,
 * multiplicacao e adivisao dos numeros lidos.
 */
/**
 *
 * @author Gledse Jamisse
 */
public class Exercicio2 {
    
    int numeros[] = new int[2];

    public void lerDados(){
        
        Scanner t = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            
            System.out.println("INTRODUZA " +(i+1)+ " NUMERO INTEIRO: ");
            numeros[i] = t.nextInt();
        }  
    }   
    public void operacoes(){
       
       
       int soma, multiplicacao, subtracao;
       double divisao;
       
       soma = numeros[0] + numeros [1];
       multiplicacao = numeros[0] * numeros [1];
       subtracao = numeros[0] - numeros [1];
       divisao = numeros[0] / numeros [1];
       
       System.out.print("A soma eh: "+ (soma)+",");
       System.out.print(" A subtracao eh: "+(subtracao)+",");
       System.out.print(" A multiplicacao eh: "+(multiplicacao)+",");
       System.out.println(" A divisao eh: "+(divisao)+".");
    }
    public static void main(String[] args) {
        
        Exercicio2 x = new Exercicio2();
        x.lerDados();
        x.operacoes();
    }
}
