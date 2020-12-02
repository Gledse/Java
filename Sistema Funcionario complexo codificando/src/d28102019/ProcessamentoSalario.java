/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d28102019;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
/**
 *
 * @author Gledse
 */
public class ProcessamentoSalario extends JFrame {
    
    public Vector x = new Vector();
    
    public JPanel painel = new JPanel();
    
    public JPanel painelPesquisar = new JPanel();
    public JPanel painelResultado = new JPanel();
    public JPanel painelSalario = new JPanel();
    public JPanel painelOperacao = new JPanel();
    
    JLabel lblCodigo = new JLabel("CODIGO");
    JLabel lblNome = new JLabel("NOME");
    JLabel lblSexo = new JLabel("SEXO");
    JLabel lblEstadoCivil = new JLabel("ESTADO CIVIL");
    JLabel lblMes = new JLabel("MES");
    JLabel lblValor = new JLabel("VALOR");
    
    JTextField txtNome = new JTextField("");
    JTextField txtSexo = new JTextField("");
    JTextField txtEstadoCivil = new JTextField("");
    JTextField txtValor = new JTextField("");
    JTextField txtCodigo = new JTextField("");
    
    public JButton butProcurar = new JButton("POCURAR");
    public JButton butExecutar = new JButton("EXECUTAR");
    public JButton butGuar = new JButton("FICH.Error");
    
    String lista [] = {"","MASCULINO","FEMENINO"};
    public JComboBox cboSexo= new JComboBox(lista);
    
    String mes [] = {"","JANEIRO", "FEVEREIRO", "MARCO", "ABRIL", "MAIO",  "JUNHO", "JULHO",
                            "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"
                    };
    public JComboBox cboMes= new JComboBox(mes);
    
    public ButtonGroup g1 = new ButtonGroup();
    
    public JRadioButton radAtribuir = new JRadioButton("ATRIBUIR");
    public JRadioButton radActualizar = new JRadioButton("ACTUALIZAR");
    public JRadioButton radAnular = new JRadioButton("ANULAR");
    public JRadioButton radoutro = new JRadioButton("OUTRO");
    
    public Container contentor = getContentPane();
     
    public ProcessamentoSalario(){
        
        painel.setLayout(null);
        
        g1.add(radAtribuir);g1.add(radActualizar);g1.add(radAnular);
        
        butProcurar.setBackground(Color.decode("#d7cdc8"));
        butExecutar.setBackground(Color.decode("#d7cdc8"));
        butGuar.setBackground(Color.decode("#d7cdc8"));
        
        painel.add(lblCodigo);          painel.add(txtCodigo);
        painel.add(lblNome);            painel.add(txtNome);
        painel.add(lblSexo);            painel.add(cboSexo);
        painel.add(lblEstadoCivil);     painel.add(txtEstadoCivil);
        painel.add(lblMes);             painel.add(cboMes);
        painel.add(lblValor);           painel.add(txtValor);
        painel.add(radAtribuir);        painel.add(radActualizar);
        painel.add(radoutro);           painel.add(radAnular);
        painel.add(butProcurar);        painel.add(butExecutar);
        painel.add(butGuar);
        painel.add(painelPesquisar);    painel.add(painelResultado);
        painel.add(painelOperacao);     painel.add(painelSalario);
        
        painelPesquisar.setBorder(BorderFactory.createTitledBorder("PESQUISA DADOS"));
        painelResultado.setBorder(BorderFactory.createTitledBorder("RESULTADO"));
        painelSalario.setBorder(BorderFactory.createTitledBorder("DEFINIR SALARIO"));
        painelOperacao.setBorder(BorderFactory.createTitledBorder("OPERACAO"));
        
        lblCodigo.setBounds(60, 50, 80, 30);txtCodigo.setBounds(140, 50, 140, 30);
        lblNome.setBounds(60, 120, 80, 30);txtNome.setBounds(140, 120, 180, 30);
        lblSexo.setBounds(60, 160, 80, 30);cboSexo.setBounds(140, 160, 180, 30);
        lblEstadoCivil.setBounds(60, 200, 80, 30);txtEstadoCivil.setBounds(140, 200, 180, 30);
        lblMes.setBounds(60, 280, 80, 30);cboMes.setBounds(140, 280, 180, 30);
        lblValor.setBounds(60, 320, 80, 30);txtValor.setBounds(140, 320, 180, 30);
            
        painelPesquisar.setBounds(40,30,430,60);         
        painelResultado.setBounds(40,100,430, 150); 
        painelOperacao.setBounds(140,370,180,100);          
        painelSalario.setBounds(40,260,430,280);  
            
        radAtribuir.setBounds(150, 390, 110, 30);
        radActualizar.setBounds(150, 410, 110, 30);        
        radAnular.setBounds(150, 430, 110, 30);  
            
        butProcurar.setBounds(310, 50, 140, 30);butExecutar.setBounds(140, 480, 150, 32);
        butGuar.setBounds(310, 480, 150, 32);
            
        contentor.add(painel);
        
        this.setLocation(250, 190);
        this.setSize(540, 600);
        this.setVisible(true);
        this.setTitle("PROCESSAMENTO DE SALARIO");
        lerFicheiro();
        eventos();
    }
     public void procurar(){
        
        Funcionario f;
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        radAtribuir.setSelected(false);
        radActualizar.setSelected(false);
        radAnular.setSelected(false);
        radoutro.setSelected(false);
        
        int cod = Integer.parseInt(txtCodigo.getText());
        for(int i = 0; i < x.size(); i++){
            f = (Funcionario)x.get(i);
            
            if(f.codigo == cod){
                txtNome.setText(f.nome);
                cboSexo.setSelectedItem(f.sexo);
                txtEstadoCivil.setText(f.estadoCivil);
            }
        }
    }
    public void atribuir(){
        
        Funcionario f;
        
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            
            int cod = Integer.parseInt(txtCodigo.getText());
            if((f.codigo == cod)&&radAtribuir.isSelected()){
                
               int Mes = (int)cboMes.getSelectedIndex();
               f.salario[Mes] = Double.parseDouble(txtValor.getText());
        
               escreverFicheiro(); 
            } 
        }
        
        cboMes.setSelectedIndex(-1);
        txtValor.setText("");
        txtEstadoCivil.setText("");
        txtCodigo.setText("");
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        radAtribuir.setSelected(false);
        radActualizar.setSelected(false);
        radAnular.setSelected(false);
        radoutro.setSelected(true);
        
        JOptionPane.showMessageDialog(null, "ATRIBUIDO COM SUCESSO");
       /* new FolhaSalario();
        dispose();*/
    }
    public void atualizar(){
        
        Funcionario f;
        
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);

            int cod = Integer.parseInt(txtCodigo.getText());
            if((f.codigo == cod)&&radActualizar.isSelected()){
                
                int Mes = (int)cboMes.getSelectedIndex();
                f.salario[Mes] = Double.parseDouble(txtValor.getText());

                escreverFicheiro();
            }
        }  
        
        cboMes.setSelectedIndex(-1);
        txtValor.setText("");
        txtEstadoCivil.setText("");
        txtCodigo.setText("");
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        radAtribuir.setSelected(false);
        radActualizar.setSelected(false);
        radAnular.setSelected(false);
        radoutro.setSelected(true);
        
        JOptionPane.showMessageDialog(this, "ATUALIZADO COM SUCESSO");
       /* new FolhaSalario();
        dispose();*/
    }
    public void anular(){
        
        Funcionario f;
        
        int cod = Integer.parseInt(txtCodigo.getText());
            
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            
            if((f.codigo == cod)&&radAnular.isSelected()){
                int Mes = (int)cboMes.getSelectedIndex();
                
                f.salario[Mes] = 0; 
                escreverFicheiro();
            }
        } 
        cboMes.setSelectedIndex(-1);
        txtValor.setText("");
        txtEstadoCivil.setText("");
        txtCodigo.setText("");
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        radAtribuir.setSelected(false);
        radActualizar.setSelected(false);
        radAnular.setSelected(false);
        radoutro.setSelected(true);
        
        JOptionPane.showMessageDialog(this, "ANULADO  COM SUCESSO");
      /*  new FolhaSalario();
        dispose();*/
       // new MenuSistema();
    }
    public void radios(){
        
        Funcionario f;
                  
        f = new Funcionario();

        if(radAtribuir.isSelected ()){
            atribuir(); 
        }if (radActualizar.isSelected()){
            atualizar();
        }if (radAnular.isSelected()){
            anular();
        }

    }
    public void escreverFicheiro(){
        
        try{
            File f = new File("Projecto.DAT");
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(x);
            oos.close();
            }catch(Exception e){JOptionPane.showMessageDialog(this, "Error");
        }
    }
    public void lerFicheiro(){
        
        try{
            File f = new File("Projecto.DAT");
            FileInputStream fis = new FileInputStream (f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            x=(Vector)ois.readObject();
            ois.close();
            }catch(Exception e){JOptionPane.showMessageDialog(this, "Error");
        }
    }
    public void eventos(){
        
        butGuar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    escreverFicheiro();
                }                
            }
        );
            
        butProcurar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                   procurar();
                }                
            }
        );
            
        butExecutar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    radios();escreverFicheiro();
                }                
            }
        );
        
    }  
    public static void main(String[] args) {
        new ProcessamentoSalario();
    }
}