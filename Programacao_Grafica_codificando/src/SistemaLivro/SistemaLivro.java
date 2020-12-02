/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLivro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Gledse Jamisse
 */
public class SistemaLivro extends JFrame {
   
    Vector x = new Vector();
    
    public JPanel painel = new JPanel();
    public JLabel lblCodigo = new JLabel("C\u00d3DIGO: ");
    public JLabel lblTitulo = new JLabel("T\u00edTULO: ");
    public JLabel lblAutor = new JLabel("AUTOR: ");
    public JLabel lblPreco = new JLabel("PRE\u00c7O :");
    public JLabel lblIform = new JLabel("INTRODUZA OS DADOS DO LIVRO");
    
    public JTextField txtCodigo= new JTextField("");
    public JTextField txtTitulo =  new JTextField("");
    public JTextField txtAutor = new JTextField("");
    public JTextField txtPreco = new JTextField("");
    
    public JButton butRegistar=new JButton("Registar O Livro");
    public JButton butProcurar=new JButton("Procurar O Livro");
    public JButton butAtualizar = new JButton("Atualizar O Livro");
    public JButton butRemover = new JButton("Remover O Livro");
    public JButton butClose = new JButton("CLOSE"); 
    public Container contentor = getContentPane();
    
    public void registar(){
        
        Livro a = new Livro();
        
        a.codigo = Integer.parseInt(txtCodigo.getText());
        a.titulo = txtTitulo.getText();
        a.autor = txtAutor.getText();
        a.preco = Double.parseDouble(txtPreco.getText());
        x.addElement(a);
        JOptionPane.showMessageDialog(null,"SUCESSO");
        
        txtCodigo.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtPreco.setText("");
    }
    public void remover(){
        
        Livro a;
        int cod = 0;
        
        cod = Integer.parseInt(txtCodigo.getText());
        
        for (int i = 0; i < x.size(); i++) {
            a = (Livro)x.get(i);
            
            if(cod == a.codigo){
               x.removeElementAt(i);
                txtCodigo.setText("");
                txtTitulo.setText("");
                txtAutor.setText("");
                txtPreco.setText("");
               JOptionPane.showMessageDialog(null,"SUCESSO");
            }
        }  
    }
    public void atualizar(){
       
        Livro a;
        int cod = 0;
        
        cod = Integer.parseInt(txtCodigo.getText());
        
        for (int i = 0; i < x.size(); i++) {
            a = (Livro)x.get(i);
            
            if(cod == a.codigo){
               a.titulo = txtTitulo.getText();
               a.autor = txtTitulo.getText();
               a.preco = Double.parseDouble(txtPreco.getText());
               x.setElementAt(a,i);
               JOptionPane.showMessageDialog(null,"SUCESSO"); 
            }
        }
    }
    public void procurar(){
        
        Livro a;
        int cod;
        
        cod=Integer.parseInt(txtCodigo.getText());
        
        for(int i=0; i<x.size(); i++){
            a = (Livro)x.get(i);
            
            if(a.codigo==cod){
                txtTitulo.setText(a.titulo);
                txtAutor.setText(a.autor);
                txtPreco.setText(a.preco+"");
            }    
        }
    }
    public boolean existeBola(int cod){
        
        boolean v = false;
        Livro a;
        for (int i = 0; i < x.size(); i++) {
            a = (Livro)x.get(i);
            if(a.codigo==cod){
                v = true;
                System.err.println("CODIGO EXISTENTE, POR FAVOR DIGITE UM OUTRO");
            }
        }
        return v;
    }
    public void escreveFicheiroObjecto(){
        
         try{File f = new File("Bola.Dat");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos= new ObjectOutputStream(fos);
            oos.writeObject(x);
            oos.close();
        }
        catch(Exception e){System.out.println("ERRO");
        }  
    }
    public void lerFicheiroObjecto(){
        
        try{
            File f= new File("Bola.DAT");
            FileInputStream fis= new FileInputStream(f);
            ObjectInputStream ois= new ObjectInputStream(fis);
            x=(Vector)ois.readObject();
            ois.close();
        }
        catch(Exception e){System.out.println("ERRO");}
    }
    public void eventos(){
        
        butRegistar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    registar();
                }
            }
        );
        butProcurar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    procurar();
                }
            }
        );
        butRemover.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    remover();
                } 
            }
        );
        butAtualizar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    atualizar();
                }
            }
        );
    /*    butClose.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            }
        );*/
    }    
    public SistemaLivro(){
        
        painel.setLayout(null);
        painel.add(lblCodigo);
        painel.add(lblTitulo);
        painel.add(lblAutor);
        painel.add(lblPreco);
        painel.add(lblIform);

        painel.add(txtCodigo);
        painel.add(txtTitulo);
        painel.add(txtAutor);
        painel.add(txtPreco);

        painel.add(butRegistar);
        painel.add(butProcurar);
        painel.add(butRemover);
        painel.add(butAtualizar);
    //    painel.add(butClose);
        
        /*(Eh onde ajustamos pra esquerda ou direita,
           Eh onde ajustamos pra cima ou pra baixo,
           Eh onde ajustamos pra minimizamos ou maximizamos,
           Eh onde ajustamos pra cima ou pra baixo )
  
        */
        lblIform.setBounds(100,20,300,30);
        
        lblCodigo.setBounds(20,70,100,30);
        txtCodigo.setBounds(100,70,200,30);
        
        lblTitulo.setBounds(20,110,100,30);
        txtTitulo.setBounds(100,110,200,30);
        
        lblAutor.setBounds(20,150,100,30);
        txtAutor.setBounds(100,150,200,30);
        
        lblPreco.setBounds(20,190,100,30);
        txtPreco.setBounds(100,190,200,30);
        
        butRegistar.setBounds(60,230,130,35);
        butProcurar.setBounds(200,230,130,35);
        butAtualizar.setBounds(60,270,130,35);
        butRemover.setBounds(200,270,130,35); 
     //   butClose.setBounds(270,315,100,35);
        
        contentor.add(painel);
        
        this.setLocation(200,200);
        this.setSize(400,400);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Funcion\u00e1rio");
        eventos();
    }
    public static void main(String[] args) {
        new SistemaLivro();
    }
}
