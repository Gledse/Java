
package metodos.d190719;

import java.util.Scanner;

import jdk.management.resource.internal.TotalResourceContext;

/*
* Um programa que divide os numeros pelo numero de ciclos introduzidos pelo usuario.
/**
 *
 * @author Elton Jamisse
 */
public class OperacoesMatematicas2 {
    
    public static int[] lerDados () {
        Scanner teclado = new Scanner(System.in);
        
        //Ler o nr.de ciclos
        System.out.println("Digite o numero de ciclos:");
        int TotalCiclos = teclado.nextInt();
        
        //Ler o nr. de numeros definidos no numero de ciclos
        int numeros[] = new int[TotalCiclos];
        for(int i = 0; i < numeros.length; i++){
        
            System.out.println("Digite o numero: " + (i+1));
            numeros[i] = teclado.nextInt();
            
        }
        return numeros;
    }
    
    public static int soma(int[] numeros){
        
        //Somar os numeros lidos
        int soma = 0;
        for(int i = 0; i < numeros.length; i++){
            
        soma = soma + numeros[i];
        
        }
        System.out.println("Soma = " + (soma));
        return soma;
    }
    
    public static void divisao(int soma, int totalCiclos){
        
         //Dividir a soma dos numeros lidos pelo total de ciclos
        double divisao = soma / totalCiclos;
        System.out.println("A divisao da soma dos numeros pelo numero total de ciclos = " + (divisao));
    }
    
    public static void main(String[] args) {
        int[] numeros = lerDados();
        
        //
        lerDados();
        int soma = soma(numeros);
        divisao(soma, numeros.length);
        
    }
}
