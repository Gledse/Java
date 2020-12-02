package funcionario;
import java.io.*;

public class Funcionario implements Serializable {
    public int codigo;
    public String nome;
    public String sexo;
    public String estadocivil;
    
    public Funcionario(){
        codigo = 0;
        nome = "";
        sexo = "";
    }
}
