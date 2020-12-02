/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaFuncionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author Gledse Jamisse
 */
public class SistemaFuncionario extends JFrame {
    
    Vector x=new Vector();
    
    public JPanel painel=new JPanel();
    public JLabel lblCodigo=new JLabel("Codigo: ");
    public JLabel lblNome=new JLabel("Nome: ");
    public JLabel lblSexo = new JLabel ("Sexo: ");
    public JLabel lblSalario=new JLabel("Salario: "); 
    
    public JTextField txtCodigo=new JTextField("");
    public JTextField txtNome=new JTextField("");
    public String lista[] = {"MACULINO","FEMENINO", ""};
    public JTextField txtSalario=new JTextField(""); 
    
    public JComboBox cboSexo = new JComboBox(lista);
    
    public JRadioButton radCasado = new JRadioButton("CASADO");
    public JRadioButton radSolteiro = new JRadioButton("SOLTEIRO");
    public JButton butRegistar=new JButton("Registar");
    public JButton butProcurar=new JButton("Procurar");
    public JButton butActualizar=new JButton("Actualizar");
    public JButton butApagar=new JButton("Apagar");
    public JButton butClose=new JButton("Close");
    public Container contentor= getContentPane();
    
    public void Registar(){
        
        Funcionario f =new Funcionario();
        
        f.codigo=Integer.parseInt(txtCodigo.getText());
        f.nome=txtNome.getText();
        f.salario=Double.parseDouble(txtSalario.getText());
        x.addElement(f);
        JOptionPane.showMessageDialog(null,"Sucesso");
    }
    
    public void procurar(){
        
        Funcionario f;
        int cod;
        
        cod=Integer.parseInt(txtCodigo.getText());
        
        for(int i=0; i<x.size(); i++){
            f=(Funcionario)x.get(i);
            
            if(f.codigo==cod){
                txtNome.setText(  f.nome);
                txtSalario.setText(f.salario+"");
            }    
        }
    }
    
    public void actualizar(){
        
        Funcionario f;
        int cod;
        
        cod=Integer.parseInt(txtCodigo.getText());
        
        for(int i=0; i<x.size(); i++){
            f=(Funcionario)x.get(i);
            
            if(f.codigo==cod){
                f.nome=txtNome.getText();
                f.salario=Double.parseDouble(txtSalario.getText());
           //     f.sexo = (String) cboSexo.getSelectedItem();
                
                x.setElementAt(f, i);
                JOptionPane.showMessageDialog(null,"Sucesso");  
            }
        }
    } 
    public void apagar(){
        
        int cod;
        Funcionario f;
        
        cod=Integer.parseInt(txtCodigo.getText());
        
        for(int i=0; i<x.size(); i++){
        f=(Funcionario)x.get(i);
        
            if(cod==f.codigo){
                x.removeElementAt(i);
                JOptionPane.showMessageDialog(null,"Sucesso"); 
            }   
        }
    }
    
    public void eventos(){
        
        butRegistar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Registar();
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
        butActualizar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        actualizar();
                    }
                }
        );
        butApagar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        apagar();
                    }
                }
        );
        butClose.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                }
        );    
    }
    public SistemaFuncionario(){
        
        painel.setLayout(null);
        painel.add(lblCodigo);
        painel.add(lblNome);
        painel.add(lblSalario);
        
        painel.add(txtCodigo);
        painel.add(txtNome);
        painel.add(txtSalario);
        
        painel.add(butClose);
        painel.add(butRegistar);
        painel.add(butProcurar);
        painel.add(butActualizar);
        painel.add(butApagar);
        
        cboSexo.getSelectedItem();
        
        lblCodigo.setBounds(20,40,100,30);
        txtCodigo.setBounds(140,40,100,30);
        
        lblNome.setBounds(20,90,100,30);
        txtNome.setBounds(140,90,200,30);
        
        lblSalario.setBounds(20,140,100,30);
        txtSalario.setBounds(140,140,100,30);
        
        butRegistar.setBounds(20,190,100,30);
        butProcurar.setBounds(140,190,100,30);
        butActualizar.setBounds(20,240,100,30);
        butApagar.setBounds(140,240,100,30);
        butClose.setBounds(20,290,220,30);
        
        contentor.add(painel);
        
        this.setLocation(200,200);
        this.setSize(400,400);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Funcionario");
        eventos();
    }
    
    public static void main(String[]args){
        new SistemaFuncionario();
    }
}

