/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojainstrumentos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lojainstrumentos.model.Cliente;

/**
 *
 * @author mathe
 */
public class ClientesDAO {

    public static boolean salvarCliente(Cliente pObj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "INSERT INTO Clientes (NomeCompleto, CPF, Endereco, Telefone, Email, Genero, EstadoCivil, DataNascimento)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)");

            comandoSQL.setString(1, pObj.getNome());
            comandoSQL.setString(2, pObj.getCpf());
            comandoSQL.setString(3, pObj.getEndereco());
            comandoSQL.setString(4, pObj.getTelefone());
            comandoSQL.setString(5, pObj.getEmail());
            comandoSQL.setString(6, pObj.getGenero());
            comandoSQL.setString(7, pObj.getEstadoCivil());
            comandoSQL.setString(8, pObj.getDataNasc());

            //4- Executar comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

            //FIM DO TRY
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o Driver: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o servidor: " + ex);
        }

        return retorno;
        //FIM DO METODO SALVAR
    }

    public static ArrayList<Cliente> listarProduto() {
        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        Connection conexao = null;
        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos");

            //4- Executar comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    //Passa dados do result set para obj
                    Cliente obj = new Cliente();
                    obj.setNome(rs.getString("NomeCompleto"));
                    obj.setCpf(rs.getString("CPF"));
                    obj.setEndereco(rs.getString("Endereco"));
                    obj.setTelefone(rs.getString("Telefone"));
                    obj.setEmail(rs.getString("Email"));
                    obj.setGenero(rs.getString("Genero"));
                    obj.setEstadoCivil(rs.getString("EstadoCivil"));
                    obj.setDataNasc(rs.getString("DataNascimento"));

                    //passa obj para lista de retorno
                    listaRetorno.add(obj);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o servidor: " + ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o Driver: " + ex);
        }
        return listaRetorno;
    }

    public static ArrayList<Cliente> pesquisarCliente(String cpf) {
        ArrayList<Cliente> listaRetorno = new ArrayList<Cliente>();
        Connection conexao = null;
        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Clientes WHERE CPF = ?");
            //PreparedStatement comandoSQL = conexao.prepareStatement("SELECT * FROM Produtos WHERE CPF LIKE ?")
            //comandoSQL.setString(1, "%"+CPF"%");
            comandoSQL.setString(1, cpf);
            //% no inicio da palavra vai procurar strings que começam com CPF e percentual no final são palavras que terminam com CPF

            //4- Executar comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    //Passa dados do result set para obj
                    Cliente obj = new Cliente();
                    
                    obj.setIdCliente(rs.getInt("ClienteID"));
                    obj.setNome(rs.getString("NomeCompleto"));
                    obj.setCpf(rs.getString("CPF"));
                    obj.setEndereco(rs.getString("Endereco"));
                    obj.setTelefone(rs.getString("Telefone"));
                    obj.setEmail(rs.getString("Email"));
                    obj.setGenero(rs.getString("Genero"));
                    obj.setEstadoCivil(rs.getString("EstadoCivil"));
                    obj.setDataNasc(rs.getString("DataNascimento"));
                    //passa obj para lista de retorno
                    listaRetorno.add(obj);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o servidor: " + ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o Driver: " + ex);
        }
        return listaRetorno;
    }

    public static boolean atualizarCliente(Cliente pObj) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "UPDATE Clientes SET NomeCompleto=?, CPF=?, Endereco=?, Telefone=?, Email=?, Genero=?, EstadoCivil=?, DataNascimento=? WHERE ClienteID =?");

            comandoSQL.setString(1, pObj.getNome());
            comandoSQL.setString(2, pObj.getCpf());
            comandoSQL.setString(3, pObj.getEndereco());
            comandoSQL.setString(4, pObj.getTelefone());
            comandoSQL.setString(5, pObj.getEmail());
            comandoSQL.setString(6, pObj.getGenero());
            comandoSQL.setString(7, pObj.getEstadoCivil());
            comandoSQL.setString(8, pObj.getDataNasc());
            comandoSQL.setInt(9, pObj.getIdCliente());
            //4- Executar comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

            //FIM DO TRY
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o Driver: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o servidor: " + ex);
        }

        return retorno;

        //FIM DO METODO ATUALIZAR
    }

    public static boolean deletarCliente(String cpf) {
        boolean retorno = false;
        Connection conexao = null;

        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "DELETE FROM Clientes WHERE CPF =?");

            comandoSQL.setString(1, cpf);
            //4- Executar comando
            int linhasAfetadas = comandoSQL.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            }

            //FIM DO TRY
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o Driver: " + ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao estabelecer conexão com o servidor: " + ex);
        }

        return retorno;

        //FIM DO METODO ATUALIZAR
    }

}
