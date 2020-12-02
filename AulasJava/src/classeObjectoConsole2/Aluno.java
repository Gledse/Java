/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeObjectoConsole2;

/**
 *
 * @author Gledse Jamisse
 */
public class Aluno {
    
    private int codigo;
    private String nome;
    private double notaAluno;
    
    public Aluno(){
        
        this.codigo = 0;
        this.nome = "";
        this.notaAluno = 0.0;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNotaAluno(double notaAluno){
        this.notaAluno = notaAluno;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getNome(){
        return nome;
    }
    public double getNotaAluno(){
        return notaAluno;
    }
}
