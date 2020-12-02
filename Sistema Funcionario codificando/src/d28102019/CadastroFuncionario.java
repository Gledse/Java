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
public class CadastroFuncionario extends JFrame {
    
    public Vector x = new Vector();
    
    public JPanel painel = new JPanel();
    public JPanel painelestado=new JPanel();
    
    public JLabel lblCodigo = new JLabel("C\u00f3digo: ");
    public JLabel lblNome = new JLabel ("Nome: ");
    public JLabel lblSexo = new JLabel ("Sexo: ");
    
    public JTextField txtCodigo = new JTextField ("");
    public JTextField txtNome = new JTextField ("");
    
    public String lista[] = {"","MASCULINO","FEMENINO"};
    public JComboBox cboSexo = new JComboBox(lista);
    
    public JRadioButton radCasado = new JRadioButton("Casado");
    public JRadioButton radSolteiro = new JRadioButton("Solteiro");
    public JRadioButton radoutro = new JRadioButton("");        
    
    public JButton butRegistrar = new JButton("Registrar");
    public JButton butProcurar = new JButton("Procurar");
    public JButton butActualizar = new JButton("Actualizar");
    public JButton butApagar = new JButton("Apagar");
    public JButton butFechar = new JButton("Fechar");
    public JButton butProcSalario = new JButton("Proc.Salario");
    public JButton butError = new JButton("Fich.Error");
    
    
    public ButtonGroup g1=new ButtonGroup();
     
    public Container contentor = getContentPane();
    
     public CadastroFuncionario(){
        
        painel.setLayout(null);
        
        g1.add(radCasado); g1.add(radSolteiro); g1.add(radoutro);
        painelestado.setBorder(BorderFactory.createTitledBorder("Estado Civil"));
        
        butApagar.setBackground(Color.decode("#f29381"));
        butRegistrar.setBackground(Color.decode("#d7cdc8"));
        butProcSalario.setBackground(Color.decode("#d7cdc8"));
        butActualizar.setBackground(Color.decode("#d7cdc8"));
        butProcurar.setBackground(Color.decode("#d7cdc8"));
        butError.setBackground(Color.decode("#d7cdc8"));
        
        painel.add(lblCodigo);          painel.add(txtCodigo);
        painel.add(lblNome);            painel.add(txtNome); 
        painel.add(radCasado);          painel.add(radSolteiro);
        painel.add(cboSexo);            painel.add(lblSexo);
        painelestado.add(radSolteiro);  painel.add(painelestado);
        painel.add(butRegistrar);       painel.add(butProcurar); 
        painel.add(butProcSalario);     painel.add(butApagar);
        painel.add(butActualizar);      painel.add(butError);
        
        painelestado.setBounds(40,180,450,70);
        radCasado.setBounds(350, 200, 80, 30); radSolteiro.setBounds(250, 200, 80, 30);
        
        lblCodigo.setBounds(40, 40, 80, 30); txtCodigo.setBounds(140, 40, 350, 30);
        lblNome.setBounds(40, 90, 60, 30); txtNome.setBounds(140, 90, 350, 30);
        lblSexo.setBounds(40, 140, 60, 30); cboSexo.setBounds(140, 140, 350, 30);
        
       /* 1 lado direito ou esquerdo
        2 pra cima ou para baixo em cima da tabela
        3 tamanho de caracters
        4 pra cima ou para baixo em baixo da tabela */     
        
        butRegistrar.setBounds(90, 270, 140, 30);
        butProcurar.setBounds(90, 310, 140, 30);
        butActualizar.setBounds(90, 350, 140, 30);
        butApagar.setBounds(90, 390, 140, 30);
        butProcSalario.setBounds(90, 430, 140, 30);
        butError.setBounds(90, 470, 140, 32);
        
        contentor.add(painel);
        
        this.setLocation(300, 300);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setTitle("Cadastro de Funcion\u00e1rio");
        lerFicheiroObjecto();
        eventos();
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
    public void registrar(){
        
        Funcionario f;
        
        int cod = Integer.parseInt(txtCodigo.getText());
        if(cod > 0){
            
            if(existe(cod) == false){
                f = new Funcionario();
                f.codigo = cod;
                f.nome = txtNome.getText();
                f.sexo = (String)cboSexo.getSelectedItem();
                
                if(radCasado.isSelected ()){
                    f.estadoCivil = "Casado";
                }else{
                    if (radSolteiro.isSelected()){
                        f.estadoCivil = "Solteiro";
                   }
                }
                
                x.addElement(f);
                
                 txtCodigo.setText("");
                txtNome.setText("");
                cboSexo.setSelectedIndex(-1);
                radCasado.setSelected(false);
                radSolteiro.setSelected(false);
                radoutro.setSelected(true);
                
                JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
                
            }else JOptionPane.showMessageDialog(null, "O c\u00f3digo j\u00e1 existe!");
        }else JOptionPane.showMessageDialog(null, "C\u00f3digo Inv\u00e1lido");
    }
    public void procurar(){
        
        Funcionario f;
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        radCasado.setSelected(false);
        radSolteiro.setSelected(false);
        radoutro.setSelected(false);
        
        for(int i = 0; i < x.size(); i++){
            f = (Funcionario)x.get(i);
            
            if(f.codigo == Integer.parseInt(txtCodigo.getText())){
                txtNome.setText(f.nome);
                cboSexo.setSelectedItem(f.sexo);
                if(f.estadoCivil.equals("Casado")){
                    radCasado.setSelected(true);
                }else if(f.estadoCivil.equals("Solteiro")){
                    radSolteiro.setSelected(true);
                }
            }
        }
    }
    public void actualizar(){
        
        Funcionario f;
        int cod = Integer.parseInt(txtCodigo.getText());
        for(int i = 0; i < x.size(); i++){
            
            f = (Funcionario)x.get(i);
            if(f.codigo == cod){
            /*   int resp = JOptionPane.showConfirmDialog(this, "Deseja relamente atualizar?");
               if(resp==0){ */
                f.nome = txtNome.getText();
                f.sexo = (String)cboSexo.getSelectedItem();
                if(radCasado.isSelected()){
                    f.estadoCivil = "Casado";
                }else if(radSolteiro.isSelected()){
                    f.estadoCivil = "Solteiro";
                }
                x.setElementAt(f, i);
                JOptionPane.showMessageDialog(null, "Actualizado com sucesso!");
                
                txtCodigo.setText("");
                txtNome.setText("");
                cboSexo.setSelectedIndex(-1);
                radCasado.setSelected(false);
                radSolteiro.setSelected(false);
       //        }
            }
        }
        
    }
    
    public void apagar(){
        
        Funcionario f;
        int cod = Integer.parseInt(txtCodigo.getText());
        
        for(int i = 0; i < x.size(); i++){
            
            f =(Funcionario)x.get(i);
            if(cod == f.codigo){
                
                int resp = JOptionPane.showConfirmDialog(this, "Deseja realmente apagar?");
                if(resp == 0){
                    x.removeElementAt(i);
                    JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
                }
                txtCodigo.setText("");
                txtNome.setText("");
                cboSexo.setSelectedIndex(-1);
                radCasado.setSelected(false);
                radSolteiro.setSelected(false);
                radoutro.setSelected(true);
            }
        }
    }
    public void eventos(){
        
         butError.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    escreveFicheiroObjecto();
                }                
            }
        );
        butRegistrar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    registrar();
                    escreveFicheiroObjecto();
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
                        escreveFicheiroObjecto();
                  
                    }
                }
        );
        butApagar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        apagar();
                        escreveFicheiroObjecto();
                    }
                }
        );
        butProcSalario.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        new ProcessamentoSalario();
                        dispose();
                    }
                }
        );
    }
    public void escreveFicheiroObjecto(){
        
        try{ File f = new File("Projecto.DAT");
             FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(x);
             oos.close();
        }catch (Exception e){;
        JOptionPane.showMessageDialog(this, "Error");}
    } 
    public void lerFicheiroObjecto(){
        
        try{ File f = new File("Projecto.DAT");
             FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis);
             x = (Vector)ois.readObject();
             ois.close();
        }catch (Exception e){JOptionPane.showMessageDialog(this, "Error");}
    }
    public static void main(String[] args) {
        new CadastroFuncionario();
        
    }
    
}
