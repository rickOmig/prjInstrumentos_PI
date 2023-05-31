package lojainstrumentos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lojainstrumentos.model.Produto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mathe
 */
public class ProdutosDAO {

    public static boolean salvarProduto(Produto pObj) {
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
                    "INSERT INTO Produtos (CodigoProduto, NomeProduto, DescricaoProduto, Quantidade, Preco)" + "VALUES(?, ?, ?, ?, ?)");

            comandoSQL.setInt(1, pObj.getCodigoProd());
            comandoSQL.setString(2, pObj.getNomeProd());
            comandoSQL.setString(3, pObj.getDescricaoProd());
            comandoSQL.setInt(4, pObj.getQuantidadeProd());
            comandoSQL.setDouble(5, pObj.getPrecoProd());

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

    public static ArrayList<Produto> listarProduto() {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
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
                    Produto obj = new Produto();
                    obj.setCodigoProduto(rs.getInt("CodigoProduto"));
                    obj.setNomeProduto(rs.getString("NomeProduto"));
                    obj.setQuantidadeProduto(rs.getInt("Quantidade"));
                    obj.setPreco(rs.getDouble("Preco"));
                    obj.setDescricaoProd(rs.getString("DescricaoProduto"));

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

    public static boolean atualizarProduto(Produto pObj) {
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
                    "UPDATE Produtos SET NomeProduto =?, DescricaoProduto =?, Quantidade =?, Preco =? WHERE CodigoProduto =?");

            comandoSQL.setString(1, pObj.getNomeProd());
            comandoSQL.setString(2, pObj.getDescricaoProd());
            comandoSQL.setInt(3, pObj.getQuantidadeProd());
            comandoSQL.setDouble(4, pObj.getPrecoProd());
            comandoSQL.setInt(5, pObj.getCodigoProd());
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

    public static boolean deletarProduto(int cod) {
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
                    "DELETE FROM Produtos WHERE CodigoProduto =?");
            
            comandoSQL.setInt(1, cod);
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
