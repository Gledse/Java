/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLivro;

import java.io.*;
/**
 *
 * @author Gledse Jamisse
 */
public class Livro implements Serializable {
    
    public int codigo;
    public String titulo;
    public String autor;
    public double preco;
    
    public Livro(){
        
        this.codigo = 0;
        this.titulo = "";
        this.autor = "";
        this.preco = 0.0;
    }
}
