
package classeObjectoArrayListConsole;

/**
 *
 * @author Gledse Jamisse
 */
public class Produto {
    
    
    public int codigo;
    public String designacao;
    private double preco;
    
    public Produto(){
        
        codigo = 0;
        designacao = "";
        preco = 0.0;
    }
    public void setPreco(double p){
        
        preco = p;
    }
    public double getPreco(){
        
        return preco;
    }
}
