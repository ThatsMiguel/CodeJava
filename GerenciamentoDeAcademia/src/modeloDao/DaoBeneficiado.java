/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansBeneficiado;



/**
 *
 * @author Miguel
 */
public class DaoBeneficiado {
    
    ConexaoBD conex = new ConexaoBD();
    BeansBeneficiado mod = new BeansBeneficiado();
    
    public void Salvar(BeansBeneficiado mod){
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
    
    public void Editar(BeansBeneficiado mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update beneficiado set nome=?,telefone=?,cpf=?,profissao=?,modalidade=?,email=?,empresa=?,rua=?,numero=?,complemento=?,cep=?,bairro=? where numeromatricula=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getTelefone());
            pst.setString(3, mod.getCpf());
            pst.setString(4, mod.getProfissao());
            //pst.setDate(6, new java.sql.Date(mod.getDatainicio().getTime()));
            pst.setString(5, mod.getModalidade());
            pst.setString(6, mod.getEmail());
            pst.setString(7, mod.getEmpresa());
            pst.setString(8, mod.getRua());
            pst.setString(9, mod.getNumero());
            pst.setString(10, mod.getComplemento());
            pst.setString(11, mod.getCep());
            pst.setString(12, mod.getBairro());
            pst.setInt(13, mod.getNumeromatricula());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Erro na alteração dos dados\n" + ex);
        }
        
        conex.desconecta();
    }
    
    public void Excluir(BeansBeneficiado mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from beneficiado where numeromatricula=?");
            pst.setInt(1, mod.getNumeromatricula());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluídos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null,"Erro ao excluir dados\n" + ex);
        }
        
        
        
        conex.desconecta();
    }
    
    
    public BeansBeneficiado buscaAluno(BeansBeneficiado mod){
        conex.conexao();
        conex.executaSql("select *from beneficiado where nome like '%"+mod.getPesquisa()+"%'");
        
        try {
            conex.rs.first();
            mod.setNumeromatricula(conex.rs.getInt("numeromatricula"));
            mod.setNome(conex.rs.getString("nome"));
            mod.setCpf(conex.rs.getString("cpf"));
            mod.setTelefone(conex.rs.getString("telefone"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setRua(conex.rs.getString("rua"));
            mod.setProfissao(conex.rs.getString("profissao"));
            mod.setModalidade(conex.rs.getString("modalidade"));
            mod.setEmail(conex.rs.getString("email"));
            mod.setEmpresa(conex.rs.getString("empresa"));
            mod.setNumero(conex.rs.getString("numero"));
            mod.setComplemento(conex.rs.getString("complemento"));
            mod.setBairro(conex.rs.getString("bairro"));
            mod.setCep(conex.rs.getString("cep"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar aluno.\n Erro:" + ex.getMessage());
        }
        
        
        conex.desconecta();
        return mod;
    }
}
