/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d28102019;

import java.io.*;
/**
 *
 * @author Gledse
 */
public class Funcionario implements Serializable {
    
    public int codigo;
    public String nome;
    public String sexo;
    public String estadoCivil;
    public double valor;
    public String mes;
    public double salario[] = new double[12];
    public int Mes[] = new int[13];
    public String operacoes;
    
    public Funcionario(){
    
    this.operacoes = "";
    this.mes = "";
    this.codigo = 0;
    this.nome = "";
    this.sexo = "";
    this.estadoCivil = "";
    this.valor = 0.0;
        for (int i = 0; i < salario.length; i++) {
            this.salario[i] = 0.0;
        }
        for (int i = 0; i < Mes.length; i++) {
            this.Mes[i] = 0;
        }
    }
}
