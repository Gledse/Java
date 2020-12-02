/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d02102019;

import java.io.*;
/**
 *
 * @author Gledse Jamisse
 */
public class Funcionario implements Serializable{
    
    public int codigo;
    public String nome;
    public String sexo;
    public String categoria;
    public String estadoCivil;
    public double salario;
    public String resposta;
    
    public Funcionario(){
        
        this.codigo = 0;
        this.nome = "";
        this.sexo = "";
        this.categoria = "";
        this.estadoCivil = "";
        this.salario = 0.0;
        this.resposta = "";
    }
    
}
