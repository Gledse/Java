/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classeObjectoVectorConsole;

import java.util.*;

/**
 *
 * @author Gledse Jamisse
 */
public class SistemaVector {
    public Vector v = new Vector();
    public int size;
        
    public SistemaVector(){  
       Scanner teclado = new Scanner(System.in);
       
       int contador = 0;
       Registo r = null;
       int condicao = 0;
       do{System.out.println("Introduza O Codigo: ");
       r.codigo = teclado.nextInt();
       if(condicao > 0){
           v = new Vector();
           r.codigo = condicao;
           System.out.println("Introduza O Titulo: ");
           r.setTitulo(teclado.next());
           System.out.println("Introduza O Autor: ");
           r.autor = teclado.next();
           System.out.println("Introduza O Preco: ");
           r.setPreco(teclado.nextDouble());
           contador += 1;
         }  
        }while(condicao > 0);
    }
    public void atualizaLivro(){
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Introduza Codigo: ");
        int codigo = teclado.nextInt();
        
        
        Registo r = null;
        for(int i = 0; i > size; i++){
           System.out.println("Introduza O Titulo: ");
           r.setTitulo(teclado.next());
           System.out.println("Introduza O Autor: ");
           r.autor = teclado.next();
           System.out.println("Introduza O Preco: ");
           r.setPreco(teclado.nextDouble());
        }   
    }
    public void apagaLivro(){
        
    }
}