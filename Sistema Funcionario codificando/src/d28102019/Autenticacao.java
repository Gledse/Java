/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d28102019;

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author Gledse
 */
public class Autenticacao extends JFrame {
    
    public Vector x = new Vector();
    
    JPanel painel = new JPanel();
    
    JLabel lblNome = new JLabel("NOME");
    JLabel lblSenha = new JLabel("SENHA");
    
    JTextField txtNome = new JTextField("");
    JTextField txtSenha = new JTextField("");
    
    JButton butOk = new JButton("Ok");
    JButton butCancel = new JButton("CANCEL");
    
    public Container contentor = getContentPane();
    
   
    public void registar(){
        
        Funcionario f;
        
        f = new Funcionario();
        int cod = Integer.parseInt(txtSenha.getText());
        
        if(cod > 0){
            f.nome = txtNome.getText();
            new MenuSistema();dispose();
            x.addElement(f); 
            escreveFicheiroObjecto();
        }
      //  JOptionPane.showMessageDialog(null,"Senha Invalida");
    }
    public void escreveFicheiroObjecto(){
        try{ File f = new File("Projecto.DAT");
             FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(x);
             oos.close();
        }catch (Exception e){System.out.println("Erro!");}
    }
    public boolean existe(int cod){
        
        Funcionario f;
        
        boolean y = false;
        for(int i = 0; i < x.size(); i++){
            f = (Funcionario)x.get(i);
            if(f.codigo == cod){
                y = true;
                i = x.size();
            }
        }
        return y;
    }
    public void eventos(){
        butOk.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                       registar();
                    }
            }
        );
        butCancel.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            }
        );
    }
    
    public Autenticacao(){
        
        painel.setLayout(null);
        
        butOk.setBackground(Color.decode("#d7cdc8"));
        butCancel.setBackground(Color.decode("#d7cdc8"));
        
        painel.add(lblSenha); painel.add(txtSenha);
        painel.add(lblNome); painel.add(txtNome);
        painel.add(butOk); painel.add(butCancel);
        
        lblNome.setBounds(20,20,100,25); txtNome.setBounds(100,20,225,25);
        lblSenha.setBounds(20,65,100,25); txtSenha.setBounds(100,65,225,25);
        butOk.setBounds(100,110,100,30); butCancel.setBounds(220,110,100,30);
        contentor.add(painel);
        
        contentor.add(painel);
        
        this.setLocation(450, 190);
        this.setSize(400, 200);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("AUTENTICACAO");
        lerFicheiroObjecto();
        eventos();
    }
    public void lerFicheiroObjecto(){
        try{ File f = new File("Projecto.DAT");
             FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis);
             x = (Vector)ois.readObject();
             ois.close();
        }catch (Exception e){System.out.println("Erro!");}
    }
    public static void main(String[] args) {
        new Autenticacao();
    }
}
