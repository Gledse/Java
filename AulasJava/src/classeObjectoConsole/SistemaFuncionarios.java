
package classeObjectoConsole;

import java.util.*;



/**
 *
 * @author Gledse Jamisse
 */
public class SistemaFuncionarios {
    
    public Vector<Funcionarios> v;
    
    public SistemaFuncionarios(){
        
    }
    public void registarFuncionarios(){
       
        this.v = new Vector();
        Scanner t = new Scanner(System.in);
        Funcionarios f = new Funcionarios();
        
        int cod = 0;
        String categoria0 = "Gestor",categoria1 = "Caixa", categoria2 = "Faxineiro";
                
        System.out.println("-----------------------------------");
        System.out.println(" INTRODUZA OS DADOS DO FUNCIONARIO ");
        System.out.println("-----------------------------------");
        do {
            System.out.println("INTODUZA O CODIGO: ");
            cod = t.nextInt();
            f.setCodigo(cod);
         
            if(f.getCodigo()> 0){
                
                System.out.println("INTRODUZA O NOME: ");
                f.nome = t.next();
     
                System.out.println(" INTRODUZA O SALARIO: ");
                f.setSalario(t.nextDouble());
            
                System.out.println("INTRODUZA A DATA DE INGRESSO: ");   
                f.dataDeIngresso = t.next();
                
                boolean categoriaValida = false;
                
                do {
                    
                    System.out.println("INTRODUZA A CATEGORIA: ");
                    f.categoria = t.next();
                    
                    categoriaValida = f.categoria.equalsIgnoreCase(categoria0) || f.categoria.equalsIgnoreCase(categoria1) || f.categoria.equalsIgnoreCase(categoria2);
                    
                    if (!categoriaValida) 
                        System.err.println("Digite categoria valida: Gestor/Caixa/Faxineiro.");

                    
                } while (!categoriaValida);
                
                
                
                System.out.println("INTRODUZA A DATA DE REGISTO");
                f.setDataDeRegisto(t.next());
                v.addElement(f);
            }
            else {
                System.err.println("Salario invalido,...");
            }
                
        } while(f.getCodigo() > 0);
       
    }
    public void removeFuncionario(){
        
        Scanner t = new Scanner(System.in);
        
        Funcionarios x;
        int cod = 0;
        
        System.out.println("INTRODUZA O CODIGO: ");
        cod = t.nextInt();
        
        x = new Funcionarios();
        if(cod == x.getCodigo()){
            for (int i = 0; i < v.size(); i++) {
                x = (Funcionarios)v.get(i);
                int index = v.indexOf(i);
                v.removeElementAt(index);
            }
        }
        
        //for (int i = 0; i < v.size(); i++) {
        //    x = (Funcionarios)v.getkjh(i);
        //  int index = v.indexOf(i);
        //  v.removeElementAt(index);
       // }
    }
    public void ListarFuncionarios(){
        
        Scanner t = new Scanner(System.in);
        
        Funcionarios x;
        int cod = 0;
    
        System.out.println("-------------------------------");
        System.out.println("LISTAR DADOS DO FUNCIONARIO OU FUNCIONARIOS");
        System.out.println("-------------------------------");
        System.out.println("UM FUNCIONARIO DIGETE O CODIGO, PARA TODOS DIGETE ESSE CODIGO: 91");
        do{ System.out.println("DIGITE O CODIGO DO FUNCIONARIOS OU FUNCIONARIOS");
            cod = t.nextInt();
            
            x = new Funcionarios();
            String categoria0 = "Gestor",categoria1 = "Caixa", categoria2 = "Faxineiro";
            
            if(cod == x.getCodigo()){
                for (int i = 0; i < v.size(); i++) {
                    x = (Funcionarios)v.get(i);
                    System.out.print("INTRODUZA O NOME: "+ x.nome);
                    System.out.print(" INTRODUZA O SALARIO: "+ x.getSalrio());
                    System.out.print("INTRODUZA A DATA DE INGRESSO: "+ x.dataDeIngresso);  
                
                    if( x.categoria.equalsIgnoreCase(categoria0)) {
                        x.setSalario(x.getSalrio() + x.getSalrio() * 0.03);
                    } else if( x.categoria.equalsIgnoreCase(categoria1)) {
                        x.setSalario(x.getSalrio() + x.getSalrio() * 0.05);
                    } else if( x.categoria.equalsIgnoreCase(categoria2)) {
                             x.setSalario(x.getSalrio() + x.getSalrio() * 0.02);
                            }
                    System.out.println("INTRODUZA A DATA DE REGISTO"+ x.getDataDeRegisto());
                }    
            }    
        }while(cod == x.getCodigo());
        
    }
    public void menu(){
      
        Scanner t = new Scanner(System.in);
        int escolha ;
     
        do{System.out.println("-----------------------------------");
            System.out.println("Menu Do Sist");
            System.out.println("----------------------------------");
            System.out.println("1.Registar Funcionarios");
            System.out.println("2.Remove Funcionario");
            System.out.println("3.Listar Funcionarios");
            System.out.println("4.Exit");
            System.out.println("Opcao[1/2/3/4/]: ");
            
            escolha = t.nextInt();
            switch (escolha){
                case 1: registarFuncionarios(); break;
                case 2: removeFuncionario(); break;
                case 3: ListarFuncionarios(); break;
                case 4: System.exit(0); break;
            }
        }while(true);
    }
    public static void main(String[] args) {
    
        SistemaFuncionarios x = new SistemaFuncionarios();
        x.menu();
    }
}
