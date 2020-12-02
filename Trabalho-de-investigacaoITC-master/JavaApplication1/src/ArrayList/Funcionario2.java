
package ArrayList;

public class Funcionario2 {
    
    // programa incompleto
    public Funcionario x= new Funcionario();
    
    public int codigo;
    public String nome;
    public char sexo;
    double salario[] = new double [11];
    
    public Funcionario2(){
     
        this.x.codigo = 1001;
        this.x.nome ="ANA MARIA";
        this.x.sexo = 'F';
        this.x.salario[0] = 7000;
        this.x.salario[11] = 9500;
    }
    public void duplicaSalario(){
        
        double duplica = 0;
        for(int i = 0; i < this.salario[11]; i++)
         duplica = this.x.salario[11] * 2;   
    }
    public void duplicaSalarios(){
        
        double duplica = 0;
        for(int i = 0; i < this.x.salario.length; i++)
            duplica=this.x.salario[i]*2;
    }
    public void visualizaNome(){
        
        System.out.println("Nome: "+this.x.nome);
    }
    public void visualizaSalario(){
    
        double media = 0,soma = 0;
        int contagem = 0;
        for(int i = 0; i < this.x.salario.length; i++){  
            soma += this.x.salario.length;
            contagem ++;
        }
        if(contagem!=0){
            media = soma/contagem;
            System.out.println("Salario Medio : "+media);
        }
    }
    public void visualizaSalarioAbril(){
    
        System.out.println("Salario do mes de ABril: "+this.x.salario[3]);  
    }
    public double k(){
        
        double k = 0;
        for(int i = 0; i < this.x.salario.length; i++){
            k += this.x.salario[i];   
        }
        return k;
    }
}
