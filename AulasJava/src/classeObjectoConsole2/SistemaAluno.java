/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeObjectoConsole2;

import java.util.*;

/**
 * Exercicio5 
 * Escreva um programa em java que leia o nome de um aluno e as notas de tres provas
 * que ele obteve no semestre. No final informar o nome do aluno e a sua media(artimetica)
*/
/**
 *
 * @author Gledse Jamisse
 */
public class SistemaAluno {

    public Vector x = new Vector();
    double notas [] = new double[3];
    
    public void lerDados(){
        
        Scanner t = new Scanner(System.in);
        
        Aluno a;
        int cod;
        double soma = 0.0;
        
        System.out.println("-----------------------------------");
        System.out.println(" INTRODUZA OS DADOS DO ALUNO");
        System.out.println("-----------------------------------");
        do{System.out.println("INTRODUZA O CODIGO: ");
           cod = t.nextInt();
           if((cod > 0 )&&(existeAluno(cod)== false)){
               a = new Aluno();
               a.setCodigo(cod);
               System.out.println("INTRODUZA O NOME DO ALUNO: ");
               a.setNome(t.next());
               
               for (int i = 0; i < notas.length; i++) {
                   soma =+ notas[i];
                   System.out.println("INTRODUZA A NOTA: ");
                   soma = t.nextDouble();
                } // double soma = soma(notas);
               a.setNotaAluno(soma);
               x.addElement(a);
           }
        }while(cod > 0);
    }
    public double media(double[] notas){
        
        int contagem = 0;
        double soma, media = 0.0;
        
        
        for (int i = 0; i < notas.length; i++) {
            contagem =+ 1;
            soma =+ notas[i];
            media = soma/contagem;
        }
        return media;
    }
    public boolean existeAluno(int cod){
        
        boolean v = false;
        Aluno a;
        for (int i = 0; i < x.size(); i++) {
            a = (Aluno)x.get(i);
            if(a.getCodigo()== cod){
                v = true;
            }
        }
        return v;
    }
    
    public void imprime(){
        
        Scanner t = new Scanner(System.in);
        
        Aluno a;
        int cod;
        
        System.out.println("INTRODUZA O CODIGO: ");
        cod = t.nextInt();
        
        for (int i = 0; i < x.size(); i++) {
            a = (Aluno)x.get(i);
        
            if(a.getCodigo()== cod){
                System.out.println("NOME DO ALUNO: " + a.getNome());
                System.out.println("MEDIA DO ALUNO: "+media(notas));
            }
        }
    }
    public void menuSistema(){
        
        Scanner t = new Scanner(System.in);
        int escolha ;
     
        do{ System.out.println("-----------------------------------");
            System.out.println("Menu Do Aluno");
            System.out.println("-----------------------------------");
            System.out.println("1.Introduz dados do Aluno");
            System.out.println("2.Imprime Dados");
            System.out.println("4.Exit");
            System.out.println("Opcao[1/2/3]: ");
            
            escolha = t.nextInt();
            switch (escolha){
                case 1: lerDados();break;
                case 2: imprime();break;
                case 3: System.exit(0);break;

            }
        }while(true);
    }
    public static void main(String[] args) {
        SistemaAluno b = new SistemaAluno();
        b.menuSistema();
    }
}
