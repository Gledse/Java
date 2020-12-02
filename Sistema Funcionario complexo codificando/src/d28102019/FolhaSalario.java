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
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gledse
 */
public class FolhaSalario extends JFrame {
    
    public Vector x = new Vector();
    
    public JPanel painel = new JPanel();
    public JFrame frame = new JFrame();
    
    public JLabel lblTotal = new JLabel("TOTAL");
    public JLabel lblInss = new JLabel("INSS(3%)");
    public JLabel lblMes = new JLabel("MES");
    
    public JTextField txtCodigo = new JTextField("");
    public JTextField txtNome = new JTextField("");
    public JTextField txtSalario = new JTextField("");
    public JTextField txtTotal = new JTextField("");
    public JTextField txtInss = new JTextField("");
    
    String mes [] = {"","JANEIRO", "FEVEREIRO", "MARCO", "ABRIL", "MAIO",  "JUNHO", "JULHO",
                            "AGOSTO", "SETEMBRO", "OUTUBRO", "NOVEMBRO", "DEZEMBRO"
                    };
    public JComboBox cboMes= new JComboBox(mes);
    
    public JButton butVisualizar = new JButton("VISUALIZAR");
    public JButton butFich = new JButton("FICH.TEXTO");
    public JButton butError = new JButton("Fich.Error");
    public JButton butREMOVE = new JButton("REMOVER");
    
    String dados[] = {"CODIGO","NOME","SALARIO"
            
                    };
    
    Object colunas [][];
    DefaultTableModel modelo = new DefaultTableModel(colunas,dados);
    JTable tabela = new JTable (modelo);
    JScrollPane scrol = new JScrollPane(tabela);
    
    public Container contentor = getContentPane();
    
    public FolhaSalario(){
        
        painel.setLayout(null);
        
        painel.add(lblTotal);
        painel.add(lblInss);
        painel.add(lblMes);
        painel.add(txtTotal);
        painel.add(txtInss);
        painel.add(cboMes);
        painel.add(butVisualizar);
        painel.add(butFich);
       // painel.add(butREMOVE);
       // painel.add(butError);
        painel.add(scrol);
        
        butFich.setBackground(Color.decode("#d7cdc8"));
        butVisualizar.setBackground(Color.decode("#d7cdc8"));
        butError.setBackground(Color.decode("#d7cdc8"));
        butREMOVE.setBackground(Color.decode("#d7cdc8"));
        
        lblTotal.setBounds(325, 390, 100, 30);     txtTotal.setBounds(410, 390, 150, 30);
        lblInss.setBounds(325, 430, 100, 30);      txtInss.setBounds(410, 430, 150, 30);
        lblMes.setBounds(180, 470, 80, 30);       cboMes.setBounds(230, 470, 150, 30);
        butFich.setBounds(410, 510, 150, 30);    butVisualizar.setBounds(410, 470, 150, 30);
        scrol.setBounds(30, 30, 530, 350); 
        butError.setBounds(230, 510, 15^0, 30);
        butREMOVE.setBounds(230, 510, 150, 30);
        contentor.add(painel);
        
        this.setLocation(300, 300);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setTitle("FOLHA DE SALARIO");
        lerFicheiro();
        eventos();
    }
    public void eventos(){
        
        butError.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    escreverFicheiro();
                }                
            }
        );
        butVisualizar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    visualizar();
                }                
            }
        );
        butFich.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    escreverFicheiro();
                }                
            }
        );
        butREMOVE.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    remove();
                    escreverFicheiro();
                }                
            }
        );
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
    public void operacoes(){
        
        Funcionario f;
        
        double percentagem = 0.0, Total = 0.0;
        
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            
            int Mes = (int)cboMes.getSelectedIndex();
            
            Total += f.salario[Mes];
            percentagem = Total * 0.03;
   
            txtTotal.setText(Total + "");
            txtInss.setText(percentagem + "");
        }
    }
   public void visualizar(){
        
        Funcionario f;
        
        while(modelo.getRowCount()>0){
             modelo.removeRow(0);
        }
        String y[] = new String[3];
        int Mes = 0;
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            
            Mes = (int)cboMes.getSelectedIndex();
                y[0] = f.codigo + "";
                y[1] = f.nome + "";
                y[2] = f.salario[Mes] + ""
                        ;
           this.setTitle("Folha De Salario - "+""+cboMes.getSelectedItem());
           if(f.salario[Mes]>0){
              modelo.addRow(y); operacoes(); 
           }
       }
    }
    public void remove(){   
        
        Funcionario f;
        
        String cod = txtCodigo.getText();
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            
            if((f.codigo + "").equals(modelo.getValueAt(i, 0))){
                
                int resp = JOptionPane.showConfirmDialog(this,"DESEJA REALMENTE REMOVER");
                modelo.removeRow(i);
                escreverFicheiro();
            }
            
        }
    }
    public static void main(String[] args) {
        new FolhaSalario();
    }
}
