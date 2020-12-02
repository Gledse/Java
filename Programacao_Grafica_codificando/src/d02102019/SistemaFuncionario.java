
package d02102019;

import javax.swing.*;
import java.util.*;
import java.awt.*;

// Esse programa nao foi concluido
public class SistemaFuncionario extends JFrame {

    Vector x = new Vector();
    
    JPanel painel = new JPanel();
    
    JLabel lblCodigo = new JLabel("Codigo");
    JLabel lblNome = new JLabel("Nome");
    JLabel lblSalario = new JLabel("Salario");
    
    JTextField txtCodigo = new JTextField("");
    JTextField txtNome = new JTextField("");
    JTextField txtSalario = new JTextField("");
    JTextField txtResposta = new JTextField("");
    
    JRadioButton radCasado = new JRadioButton("Casado");
    JRadioButton radSolteiro = new JRadioButton("Solteiro");
    
    public String lista1[] = {"","Masculino","Femenino"};
    JComboBox cboSexo = new JComboBox(lista1);
    
    public String lista[] = {"","Gestor","Caixa","Faxineiro"};
    JComboBox cboCategoria = new JComboBox(lista);
    
    JButton butRegistar = new JButton("Gravar");
    JButton butRemover = new JButton("Remover");
            
    JMenuBar barra = new JMenuBar();
    
    JMenu mFicheiro = new JMenu("Ficheiro");
    JMenu mEditar = new JMenu("Editar");
    
    JMenuItem iAbir = new JMenuItem("Abrir");
    JMenuItem iGravar = new JMenuItem("Gravar");
    JMenuItem iProcurar = new JMenuItem("Procurar");
    JMenuItem iAtualizar = new JMenuItem("Atualizar");
    JMenuItem iRemover = new JMenuItem("Remover");
    JMenuItem iSair = new JMenuItem("Sair");
    
    public Container contentor = getContentPane();
    
    public Boolean existeFuncionario(int cod){
       
        Funcionario f;
        Boolean y = false;
        
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            if(f.codigo == cod){
                y = true;
                i = x.size();
            }
        }
        return y;
    }
    public void Registar(){
        
        Funcionario f;
        
        int cod = Integer.parseInt(txtCodigo.getText());
        
        if((cod > 0)&&(existeFuncionario(cod)== false)){
            f = new Funcionario();
            f.codigo = Integer.parseInt(txtCodigo.getText());
            f.nome = txtNome.getText();
            f.salario = Double.parseDouble(txtSalario.getText());
            f.categoria = (String)cboCategoria.getSelectedItem();
            f.sexo = (String)cboSexo.getSelectedItem();
            
            if(radCasado.isSelected()){
               f.estadoCivil = "Casado"; 
            }else if(radSolteiro.isSelected()){
               f.estadoCivil = "Solteiro";
            }
            x.addElement(f);
            JOptionPane.showMessageDialog(null,"Registado com sucesso");
            
            txtCodigo.setText("");
            txtNome.setText("");
            txtSalario.setText("");
            cboSexo.setSelectedIndex(-1);
        }
    }
    public void atualizar(){
        
        Funcionario f;
        int cod = Integer.parseInt(txtCodigo.getText());
        
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            if(f.codigo == cod){
                f.nome = txtNome.getText();
                f.salario = Double.parseDouble(txtSalario.getText());
                f.categoria = (String)cboCategoria.getSelectedItem();
                f.sexo = (String)cboSexo.getSelectedItem();
            
                if(radCasado.isSelected()){
                   f.estadoCivil = "Casado"; 
                }else if(radSolteiro.isSelected()){
                    f.estadoCivil = "Solteiro";
                }
                x.addElement(f);
                JOptionPane.showMessageDialog(null,"Atualizado com sucesso");
                
                txtCodigo.setText("");
                txtNome.setText("");
                txtSalario.setText("");
                cboSexo.setSelectedIndex(-1);
            }
        }
    }
    public void remover(){
        
        Funcionario f;
        String escolha = "Sim",escola1 = "Nao",resposta;
        int cod = Integer.parseInt(txtCodigo.getText());
        
        for (int i = 0; i < x.size(); i++) {
            f = (Funcionario)x.get(i);
            if(f.codigo == cod){
                
                boolean escolhaValida = false;
                do{ resposta = txtResposta.getText();
                    escolhaValida = f.resposta.equalsIgnoreCase("Sim")||f.resposta.equalsIgnoreCase("nao");
                    
                }while(escolhaValida);
               x.removeElementAt(i);
               JOptionPane.showMessageDialog(null,"Removido com sucesso");
               
               txtCodigo.setText("");
               txtNome.setText("");
               txtSalario.setText("");
               cboSexo.setSelectedIndex(-1);
            }
        }
    }
    public void limpar(){
        
        txtCodigo.setText("");
        txtNome.setText("");
        txtSalario.setText("");
        cboSexo.setSelectedIndex(-1);
    }
    public static void main(String[] args) {
        new SistemaFuncionario();
    }
}
