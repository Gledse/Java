
package metodos.d190719;

import java.util.Arrays;
import java.util.Scanner;

/*
* Enunciado:
* Cria um programa que receba 3 numeros do teclado, e faca a soma, subtracao, divisao e multiplicacao.
/**
 *
 * @author Gledse Jamisse
 */
public class OperacoesMatematicas {
    
    public static void preenche(){
        
        Scanner teclado = new Scanner(System.in);
        
        int numeros[] = new int[3];
        for(int i = 0; i < numeros.length; i++){ // Entrada de dados
            
            System.out.println("Digite " + (i+1) + " numero inteiro"); // Vai pedir 3.
            numeros[i] = teclado.nextInt(); // Idetificador do Arry.
        }
        System.out.println("Numeros lidos: " + Arrays.toString(numeros));
        
         //Soma
        int s = 0;
        for(int i = 0; i < numeros.length; i++){
            s = s + numeros[i];
        }
        System.out.println("Soma = " + (s));

        //Subtracao versao 1
       // int subtracao = numeros[0] - numeros[1] - numeros[2]; 
        //System.out.println("Subtracao: " + subtracao);
        
        // Subtracao versao 2
        int subtracao = numeros[0];
        for (int i = 0; i < numeros.length; i = i+2) {
            subtracao -= numeros[i];
            subtracao = subtracao - numeros[i];
        }
        
        System.out.println("Subtracao = " + subtracao);
        
        //Divisao
        int d = 0;
        for(int i = 0; d < numeros.length; d++){
           d = numeros[i] / 3; 
            
        }
        System.out.println("Divisao = " + (d));
        
        //Multiplicacao
        int m = 0;
        for(int i = 0; m < 3; m++){
            m = m * numeros[i];
        }
        System.out.println("Multiplicacao = " + (m));
    }
    public static void main(String[] args) {
     
        
        preenche();
    
    }        
}
