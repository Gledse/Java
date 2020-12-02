
package exercicios.d090719;

import java.util.*;

/*
* Um programa que divide os numeros pelo numero de ciclos introduzidos pelo usuario. 
*/
/**
 *
 * @author Gledse Jamisse
 */
public class OperacoesMatematicas2 {
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        //Ler o nr.de ciclos
        System.out.println("Digite o numero de ciclos:");
        int totalCiclos = teclado.nextInt();
        
        //Ler o nr. de numeros definidos no numero de ciclos
        int numeros[] = new int[totalCiclos];
        for(int i = 0; i < numeros.length; i++){
        
            System.out.println("Digite o numero: " + (i+1));
            numeros[i] = teclado.nextInt();
            
        }
        
        //Somar os numeros lidos
        int s = 0;
        for(int i = 0; i < numeros.length; i++){
            
        s = s + numeros[i];
        
        }
        System.out.println("Soma = " + (s));
        
        //Dividir a soma dos numeros lidos pelo total de ciclos
        int d = 0;
        d = s / totalCiclos;
        
        System.out.println("A divisao da soma dos numeros pelo numero total de ciclos = " + (d));
        
        
    }
    
}
