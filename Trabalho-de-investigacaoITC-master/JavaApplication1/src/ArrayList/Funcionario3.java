
package ArrayList;


import java.util.*;

// programa incompleto
public class Funcionario3 {
    
    public Funcionario[] y= new Funcionario[10];
    public int codigo;
    public String nome;
    public char sexo;
    double salario [] = new double [11];
    
    public void inicializa(){
     
        for(int i = 0; i < y.length; i++){
            y[i] = new Funcionario();
        }
    }
    public Funcionario3(){
        
        this.y[0].codigo = 1001;
        this.y[0].nome ="ANA MARIA";
        this.y[0].sexo = 'F';
        this.y[0].salario[0] = 7000;
        this.y[0].salario[11] = 9500;
    }
    public void duplicaSalario(){
        
        double duplica = 0;
        for(int i = 0; i < this.y[1].salario[11]; i++){
        }
        duplica = this.y[1].salario[10] * 2;
    }
    public void duplicaSalarios(){
        
        double duplica = 0;
        for(int i = 0; i < this.y[1].salario[11]; i++){
            if(this.y[1].salario[i] == this.y[1].salario[11]){
               this.y[1].salario[11]*= 2; 
            }
        }
    }
    public void LerDados(){
        Scanner t=new Scanner(System.in);
        
        for(int i=0;i<y.length;i++){
            
            System.out.println("INTRODUZA O CODIGO: ");
            y[i].codigo=t.nextInt();
            System.out.println("INTRODUZA O SEU NOME: ");
            y[i].nome=t.next();
            System.out.println("INTRUDUZA O SEXO: ");
            y[i].sexo=t.next().charAt(0);
            System.out.println("INTRUDUZA O 1º SALARIO: ");
            y[i].salario[0]=t.nextDouble();
            System.out.println("INTRODUZA O 12º SALARIO: ");
            y[i].salario[11]=t.nextDouble();
            System.out.println();
            System.out.println();
        }      
    }
    public void visualizaNomes(){
        for(int i=0;i<y.length;i++)
        System.out.println(y[i].nome);
    }
    public void visualizaNomesSalarios(){
        System.out.println(y[4].nome+"O salario é: "+Arrays.toString(y[4].salario));
    }
    public void visualizaNomesSalariosAnuais(){
        for(int i=0;i<salario.length;i++)
        System.out.println(y[i].nome+"o salario anual:"+salario[i]);
        
    }
    public void duplicaSalarioMaio(){
    
        double duplica = 0;
        for(int i = 0; i < this.y[i].salario[4]; i++)
        duplica = this.y[i].salario[4] * 2;
     
    }
    public static void main(String[] args) {
        Funcionario3 f = new Funcionario3();
        f.LerDados();
    }
}
