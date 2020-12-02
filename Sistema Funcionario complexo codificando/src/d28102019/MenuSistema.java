/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d28102019;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Gledse
 */
public class MenuSistema extends JFrame {
    
    public JPanel painel = new JPanel();
    
    public JMenuBar barra = new JMenuBar();
    
    public JMenu mCadastro = new JMenu("Cadastro");
    public JMenu mProcessoSalario = new JMenu("Processo Salario");
    public JMenu mExit = new JMenu("Exit");
    
    public JMenuItem iCadastro = new JMenuItem ("Cadastro");
    public JMenuItem iProcessar = new JMenuItem ("Processar");
    public JMenuItem iVisualizar = new JMenuItem ("Visualizar");
    public JMenuItem iExit = new JMenuItem ("Exit");
    
    public Container contentor = getContentPane();
    
    public void eventos(){
        iCadastro.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        new CadastroFuncionario();
                    }
                }
        );
        iProcessar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                       new ProcessamentoSalario(); 
                    }
                }
        );
        iVisualizar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        new FolhaSalario();
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
    public MenuSistema(){
        
        painel.setLayout(null);
       
        barra.add(mCadastro); barra.add(mProcessoSalario); barra.add(mExit);
        mCadastro.add(iCadastro); mProcessoSalario.add(iProcessar); mProcessoSalario.add(iVisualizar);
        mExit.add(iExit);
        
        contentor.add(painel);
        
        this.setJMenuBar(barra);
        this.setLocation(450, 190);
        this.setSize(400, 200);
        this.setVisible(true);
        this.setTitle("Menu Do Sistema");
        eventos();
    }
    public static void main(String[] args) {
        new MenuSistema();
    }
}    
