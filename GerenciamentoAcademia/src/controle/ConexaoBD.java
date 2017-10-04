/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class ConexaoBD {
    
    public Statement stm; // responsável pela pesquisa no banco de dados
    public ResultSet rs; // responsável por guardar as pesquisas
    private String Driver = "org.postgresql.Driver";
    private String Caminho = "jdbc:postgresql://localhost:5432/gerenciamentoacad";
    private String Usuario = "postgres"; // usuário do banco de dados
    private String Senha = "miguel19"; // senha definida no banco de dados
    public Connection con; // responsável pela conexão
        
    public void conexao(){ // método responsável pela conexão com banco de dados
        
        try {
            System.setProperty("jdbc.Drivers", Driver);
            con = DriverManager.getConnection(Caminho, Usuario, Senha);
            //JOptionPane.showMessageDialog(null, "Conexão com o banco de dados realizada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se conectar com o banco de dados:\n" + ex.getMessage());
        }
        
    }
    
    public void desconecta(){ // método responsável por desconectar o banco de dados
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Banco de dados desconectado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao parar conexão com banco de dados:\n" + ex.getMessage());
        }
    }
}
