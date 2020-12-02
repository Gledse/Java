package funcionario;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class SistemaFuncionario extends JFrame {
    public Vector x = new Vector();
    
    public JPanel painel = new JPanel();
    
    public JLabel lblCodigo = new JLabel("C\u00f3digo: ");
    public JLabel lblNome = new JLabel ("Nome: ");
    public JLabel lblSexo = new JLabel ("Sexo: ");
    
    public JTextField txtCodigo = new JTextField ("");
    public JTextField txtNome = new JTextField ("");
    
    public String lista[] = {"","Masculino", "Feminino"};
    public JComboBox cboSexo = new JComboBox(lista);
    
    public JRadioButton radCasado = new JRadioButton("Casado");
    public JRadioButton radSolteiro = new JRadioButton("Solteiro");
    
    public JButton botaoRegistrar = new JButton("Registrar");
    public JButton botaoProcurar = new JButton("Procurar");
    public JButton botaoActualizar = new JButton("Actualizar");
    public JButton botaoApagar = new JButton("Apagar");
    public JButton botaoFechar = new JButton("Fechar");
    
    public ButtonGroup g1=new ButtonGroup(); 
    
    JMenuBar barra = new JMenuBar();
    
    JMenu mFile = new JMenu("Ficheiro");
    JMenu mEdit = new JMenu("Editar");
    JMenu mExit = new JMenu("Sair");
    
    JMenuItem iOpen = new JMenuItem ("Abrir");
    JMenuItem iSave = new JMenuItem ("Guardar");
    JMenuItem iCopy = new JMenuItem ("Copiar");
    JMenuItem iPaste = new JMenuItem ("Colar");
    JMenuItem iHelp = new JMenu ("Ajuda");
    JMenuItem iExit = new JMenuItem ("Sair");
    JMenuItem iA1 = new JMenuItem ("A1");
    JMenuItem iA2 = new JMenuItem ("A2");
    
    public Container contentor = getContentPane();
    
    public boolean existe(int cod){
        Funcionario k;
        boolean y = false;
        for(int i = 0; i < x.size(); i++){
            k = (Funcionario)x.get(i);
            if(k.codigo == cod){
                y = true;
                i = x.size();
            }
        }
        return y;
    }
  
    public void registrar(){
        Funcionario k;
        int cod = Integer.parseInt(txtCodigo.getText());
        if(cod > 0){
            
            if(existe(cod) == false){
                k = new Funcionario();
                k.codigo = cod;
                k.nome = txtNome.getText();
                k.sexo = (String)cboSexo.getSelectedItem();
                
                if(radCasado.isSelected ()){
                k.estadocivil = "Casado";
                }else if (radSolteiro.isSelected()){
                k.estadocivil = "Solteiro";
                }
                
                x.addElement(k);
                JOptionPane.showMessageDialog(null, "Registrado com sucesso!");
                
                txtCodigo.setText("");
                txtNome.setText("");
                cboSexo.setSelectedIndex(-1);
                radCasado.setSelected(false);
                radSolteiro.setSelected(false);
                
            }else JOptionPane.showMessageDialog(null, "O c\u00f3digo j\u00e1 existe!");
        }else JOptionPane.showMessageDialog(null, "C\u00f3digo Inv\u00e1lido");
    }
    
    public void procurar(){
        Funcionario k;
        txtNome.setText("");
        cboSexo.setSelectedIndex(-1);
        radCasado.setSelected(false);
        radSolteiro.setSelected(false);
        for(int i = 0; i < x.size(); i++){
            k = (Funcionario)x.get(i);
            if(k.codigo == Integer.parseInt(txtCodigo.getText())){
                txtNome.setText(k.nome);
                cboSexo.setSelectedItem(k.sexo);
                if(k.estadocivil.equals("Casado")){
                    radCasado.setSelected(true);
                }else if(k.estadocivil.equals("Solteiro")){
                    radSolteiro.setSelected(true);
                }
            }
        }
    }
    
    public void Actualizar(){
        Funcionario f;
        int cod = Integer.parseInt(txtCodigo.getText());
        for(int i = 0; i < x.size(); i++){
            f = (Funcionario)x.get(i);
            if(f.codigo == cod){
                f.nome = txtNome.getText();
                f.sexo = (String)cboSexo.getSelectedItem();
                if(radCasado.isSelected()){
                    f.estadocivil = "Casado";
                }else if(radSolteiro.isSelected()){
                    f.estadocivil = "Solteiro";
                }
                x.setElementAt(f, i);
                JOptionPane.showMessageDialog(null, "Actualizado com sucesso!");
            }
        }
    }
    
    public void apagar(){
        
        int cod;
        Funcionario k;
        cod = Integer.parseInt(txtCodigo.getText());
        for(int i = 0; i < x.size(); i++){
            k =(Funcionario)x.get(i);
            if(cod == k.codigo){
                x.removeElementAt(i);
                JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
                txtCodigo.setText("");
                txtNome.setText("");
                cboSexo.setSelectedIndex(-1);
                radCasado.setSelected(false);
                radSolteiro.setSelected(false);
            }
        }
    }
    
    public void eventos(){
        botaoRegistrar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    registrar();
                    escreveFicheiroObjecto();
                }
            }
        );
        
        botaoProcurar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        procurar();

                    }
                }
        );
        
        botaoActualizar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        Actualizar();
                        escreveFicheiroObjecto();
                  
                    }
                }
        );
        
        botaoApagar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        apagar();
                        escreveFicheiroObjecto();
                    }
                }
        );
        
        iExit.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        System.exit(0);
                    }
                }
        );
    }
    
    public void escreveFicheiroObjecto(){
        try{ File f = new File("ProgramacaoJava.DAT");
             FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             oos.writeObject(x);
             oos.close();
        }catch (Exception e){System.out.println("Erro!");}
    }
    
    public SistemaFuncionario(){
        painel.setLayout(null);
        
        g1.add(radCasado);
        g1.add(radSolteiro);
        
        barra.add(mFile); barra.add(mEdit); barra.add(mExit);
        mFile.add(iOpen); mFile.add(iSave);
        mEdit.add(iCopy); mEdit.add(iPaste); mEdit.add(iHelp); 
        mExit.add(iExit); 
        iHelp.add(iA1); iHelp.add(iA2);
        
        painel.add(lblCodigo); painel.add(lblNome); painel.add(cboSexo); painel.add(radCasado);
        painel.add(txtCodigo); painel.add(txtNome); painel.add(radSolteiro); painel.add(lblSexo);
        painel.add(botaoRegistrar); painel.add(botaoProcurar); painel.add(botaoActualizar); painel.add(botaoApagar);
        
        lblCodigo.setBounds(20, 40, 80, 30); txtCodigo.setBounds(140, 40, 350, 30);
        lblNome.setBounds(20, 90, 60, 30); txtNome.setBounds(140, 90, 350, 30);
        lblSexo.setBounds(20, 140, 60, 30); cboSexo.setBounds(140, 140, 350, 30);
        radCasado.setBounds(20, 190, 100, 30); radSolteiro.setBounds(140, 190, 350, 30);
        
        botaoRegistrar.setBounds(80, 250, 100, 30);
        botaoProcurar.setBounds(220, 250, 100, 30);
        botaoActualizar.setBounds(80, 300, 100, 30);
        botaoApagar.setBounds(220, 300, 100, 30);
        botaoFechar.setBounds(80, 350, 240, 30);
        
        contentor.add(painel);
        
        this.setJMenuBar(barra);
        this.setLocation(300, 300);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setTitle("Cadastro de Funcion\u00e1rio");
        lerFicheiroObjecto();
        eventos();
    }
    
    public void lerFicheiroObjecto(){
        try{ File f = new File("ProgramacaoJava.DAT");
             FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis);
             x = (Vector)ois.readObject();
             ois.close();
        }catch (Exception e){System.out.println("Erro!");}
    }
    
    public static void main(String[] args) {
        new SistemaFuncionario();
    }
}
