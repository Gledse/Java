
package metodos.d190719;

import java.util.Scanner;

/* Enuciado:
*  Um programa que receba a hora e comprimente a pessoa, mostrando a hora e nome.
/**
 *
 * @author Gledse Jamisse
 */
public class Saudacoes {
    
    public static void preenche(){
        
        Scanner teclado = new Scanner (System.in);
       
       int hora = 0;
       String nome = null;
      
       System.out.println("Digite o nome");
       nome = teclado.nextLine();
       
        System.out.println("Digite a hora:");
        hora = teclado.nextInt();
        
        if (hora >= 1 && hora < 12) {
            System.out.println("Bom dia, " + nome);
        }
        if (hora >= 12 && hora < 18) {
            System.out.println("Boa tarde, " + nome);
        }
        if (hora >= 18 && hora < 24) {
            System.out.println("Boa noite, " + nome);
        }
    }
    
    public static void main(String[] args) {
        
        preenche();
    }
    
}
