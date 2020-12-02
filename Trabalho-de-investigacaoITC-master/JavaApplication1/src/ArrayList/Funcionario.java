
package ArrayList;

// programa incompleto

public class Funcionario {
    
    public int codigo;
    public String nome;
    public char sexo;
    public double salario[] = new double[12];
    
    public Funcionario(){
        
        this.codigo = 0;
        this.nome = "";
        this.sexo = '*';
        
        for(int i = 0; i < this.salario.length; i++){
            this.salario[i] = 0.0;
        }
    }
    public double getSomaSalarios(){
        
        double soma = 0.0;
        for(int i = 0; i < this.salario.length; i++){
            soma += this.salario.length;
        }
        return soma;
    }
    public double getMediaSalarios(){
 
        double media = 0, soma = 0;
        int contagem = 0;
        for(int i = 0; i < this.salario.length; i++){  
            soma += this.salario.length;
            contagem ++;
        }
        media = soma/contagem;
        return media;
    }
    public void imprimeFuncionario(){
        
        System.out.println("Codigo: "+this.codigo + " Nome: " + this.nome +" Sexo: "+this.sexo + " Salario: " + this.salario.length);
    }
    public void duplicaSalario(int m){
        
        double duplica = 0;
        for(int i = 0; i < this.salario.length; i++){
            duplica = this.salario[i] * 2;
        }
            this.salario[m] = duplica;
    }
    
    
}
