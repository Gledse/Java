/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeObjectoVectorConsole;

/**
 *
 * @author Gledse Jamisse
 */
public class Registo {
    
    public int codigo;
    private String titulo;
    public String autor;
    private double preco;
    
    public Registo(){
        
        this.codigo = 0;
        this.titulo = "";
        this.autor = "";
        this.preco = 0.0;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public void setTitulo(String titulo ){
        this.titulo = titulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    private void setUtor(String autor){
        this.autor = autor;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    public double getPreco(){
        return this.preco;
    }

    
}
