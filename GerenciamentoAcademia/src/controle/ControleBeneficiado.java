/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.ModeloBeneficiado;



/**
 *
 * @author Miguel
 */
public class ControleBeneficiado {
    
    ConexaoBD conex = new ConexaoBD();
    ModeloBeneficiado mod = new ModeloBeneficiado();
    
    public void Salvar(ModeloBeneficiado mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into beneficiado(numeromatricula, nome, telefone, cpf, profissao,"
                    + "modalidade, email, empresa, rua, numero, complemento, cep, bairro) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, mod.getNumeromatricula());
            pst.setString(2, mod.getNome());
            pst.setString(3, mod.getTelefone());
            pst.setString(4, mod.getCpf());
            pst.setString(5, mod.getProfissao());
            //pst.setDate(6, new java.sql.Date(mod.getDatainicio().getTime()));
            pst.setString(6, mod.getModalidade());
            pst.setString(7, mod.getEmail());
            pst.setString(8, mod.getEmpresa());
            pst.setString(9, mod.getRua());
            pst.setString(10, mod.getNumero());
            pst.setString(11, mod.getComplemento());
            pst.setString(12, mod.getCep());
            pst.setString(13, mod.getBairro());  
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Erro ao inserir dados no banco de dados\n" + ex);
        }
        
        
        conex.desconecta();
        
    }
    
}
