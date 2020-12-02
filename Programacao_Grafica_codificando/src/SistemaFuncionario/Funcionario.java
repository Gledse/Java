/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaFuncionario;

import java.io.*;

/**
 *
 * @author Gledse Jamisse
 */
public class Funcionario implements Serializable {
        
    public int codigo;
    public String nome;
    public double salario;
    public char sexo;

    public Funcionario(){
        codigo=0;
        nome="";
        salario=0.0;
    }
    /*public void setSexo(char sexo){
        this.sexo = sexo;
    }
    public char getSexo(){
        return sexo;
   }*/
}
