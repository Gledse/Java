
package classeObjectoConsole;

/**
 *
 * @author Gledse Jamisse
 */
public class Funcionarios {
    
    public String dataDeIngresso;
    public String categoria;
    private String dataDeRegisto;
    private double salario;
    private int codigo;
    public String nome;
    
    public Funcionarios(){
        
        this.dataDeIngresso = "";
        this.categoria = "";
        this.dataDeRegisto = "";
        this.salario = 0.0;
        this.codigo = 0;
        this.nome = "";
    }
    public void setSalario( double slario){
         this.salario = slario;
    }
    public double getSalrio(){
        return salario;
    }
    public void setDataDeRegisto(String dataDeRegisto){
        this.dataDeRegisto = dataDeRegisto;
    }
    public String getDataDeRegisto(){
        return dataDeRegisto;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
}
