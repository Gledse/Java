
package classeObjectoArrayListConsole;

import java.util.Scanner;

/**
 *
 * @author Elton Jamisse
 */
public class SistemaProduto {
    
    public Produto p[] = new Produto[1000];
    public int size = 0;
    public SistemaProduto(){
        
    }
    public void lerDados(){
        
        Scanner t = new Scanner(System.in);
        int cod;
        do{ System.out.print("Introduza Codigo: ");
        cod = t.nextInt();
        if(cod > 0){
            p[size] = new Produto();
            p[size].codigo = cod;
            System.out.println("Introduza Designacao: ");
            p[size].designacao = t.next();
            System.out.println("Introduza Preco: ");
            p[size].setPreco(t.nextDouble());
            size += 1;
        }   
        }while(cod > 0);
    }
    public void imprimeTodosDados(){
        
        for(int i = 0; i < size; i++){
            System.out.println(p[i].codigo + " " + p[i].designacao + " " + p[i].getPreco());
        }
    }
    public void ordemCrescenteCodigo(){
        
        Produto ajuda;
        int i,j; 
        for(i = 0; i < size - 1; i++){
            for(j = i+1; j < size; j++){
                if(p[i].codigo > p[j].codigo){
                    ajuda = p[j];
                    p[j] = ajuda;
                         
                }
            }
        }
    }
    public double pmedio(){
        
        double soma = 0, med = 0;
        for(int i = 0; i < size; i++){
            soma += + p[i].getPreco();
        }
        if(size > 0){
            med = soma / size;
        }
        return med;
    }
    public void visualiza(){
        
        Scanner t = new Scanner(System.in);
        System.out.println("Introduza o Codigo: ");
        int cod = t.nextInt();
        
        for (int i = 0; i < size; i++) {
            if(p[i].codigo == cod){
            System.out.println("Codigo: " + p[i].codigo);
            System.out.println("Designacao: " + p[i].designacao);
            System.out.println("Preco: " + p[i].getPreco());
        }
            
        }
    }
    public void atualiza(){
        
        Scanner t = new Scanner(System.in);
        System.out.println("Introduza Codigo: ");
        int cod = t.nextInt();
        
        for (int i = 0; i < size; i++) {
            if(p[i].codigo == cod){
                System.out.println("Introduza Designacao: ");
                p[i].designacao = t.next();
                System.out.println("Introduza Preco: ");
                p[i].setPreco(t.nextDouble());
            }
            
        }
    }
  
    public void menu(){
        
        Scanner t = new Scanner(System.in);
        int escolha ;
     
        do{System.out.println("-----------------------------------");
            System.out.println("Menu Do Sist");
            System.out.println("----------------------------------");
            System.out.println("1.Ler Dados dos produtos");
            System.out.println("2.Imprimir todos os dados");
            System.out.println("3.Ordenar produtos");
            System.out.println("4.Imprimir Preco Medio dos produtos");
            System.out.println("5.Aatualizar dados de um produtos");
            System.out.println("6.Visualiza dados de um produto");
            System.out.println("9.Exit");
            System.out.println("Opcao[1/2/3/4/5/6/7]: ");
            
            escolha = t.nextInt();
            switch (escolha){
                case 1: lerDados(); break;
                case 2: imprimeTodosDados(); break;
                case 3: ordemCrescenteCodigo(); break;
                case 4: System.out.println();
                    System.out.println();
                    System.out.println("PRECO MEDIO DOS PRODUTOS");
                    System.out.println("-------------------------");
                    System.out.println("Preco MEDIO: " + pmedio());break;
                    case 5: atualiza(); break;
                    case 6: visualiza();break;
                    
                    case 7: System.exit(0); break;
            }
        }while(true);
    }
    public static void main(String[] args) {
        
        SistemaProduto k = new SistemaProduto();
        k.menu();
    }
} // Fim da classe SistemaProduto
