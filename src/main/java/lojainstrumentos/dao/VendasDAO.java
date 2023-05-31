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
import lojainstrumentos.model.Venda;

/**
 *
 * @author mathe
 */
public class VendasDAO {

    public static boolean salvarVenda(Venda pObj) throws Exception {
        boolean retorno = false;
        Connection conexao = null;

        try {
            ResultSet rs;
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement(
                    "INSERT INTO venda (nome_produto, quantidade, valorTotal, descricao, ClienteID)" + "VALUES(?, ?, ?, ?, ?)");

            PreparedStatement comandoSQL2 = conexao.prepareStatement(
                    "UPDATE PRODUTOS set Quantidade = Quantidade - " + pObj.getQuantidadeVenda());

            comandoSQL.setString(1, pObj.getProdutoVendido());
            comandoSQL.setDouble(2, pObj.getQuantidadeVenda());
            comandoSQL.setDouble(3, pObj.getValorTotal());
            comandoSQL.setString(4, pObj.getDescricaoProd());
            comandoSQL.setInt(5, pObj.getIdCliente());

            //4- Executar comando
            rs = comandoSQL.executeQuery("select Quantidade from Produtos");
            rs.next();
            if (rs.getInt(1) < pObj.getQuantidadeVenda()) {
                JOptionPane.showMessageDialog(null, "Quantidade de venda excede ao estoque");
            } else {
                int linhasAfetadas = comandoSQL.executeUpdate();
                int linhasAfetadas2 = comandoSQL2.executeUpdate();
                if (linhasAfetadas > 0 && linhasAfetadas2 > 0) {
                    retorno = true;
                }
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

    public static ArrayList<Venda> listarProduto() {
        ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
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
                    Venda obj = new Venda();
                    //obj.setCodigoProduto(rs.getInt("CodigoProduto"));
                    //obj.setNomeProduto(rs.getString("NomeProduto"));
                    //obj.setQuantidadeProduto(rs.getInt("Quantidade"));
                    //obj.setPreco(rs.getDouble("Preco"));
                    //obj.setDescricaoProd(rs.getString("DescricaoProduto"));

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

    public static boolean atualizarProduto(Venda pObj) {
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

            //comandoSQL.setString(1, pObj.getNomeProd());
            //comandoSQL.setString(2, pObj.getDescricaoProd());
            //comandoSQL.setInt(3, pObj.getQuantidadeProd());
            //comandoSQL.setDouble(4, pObj.getPrecoProd());
            //comandoSQL.setInt(5, pObj.getCodigoProd());
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
