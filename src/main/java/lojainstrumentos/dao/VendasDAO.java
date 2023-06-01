/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojainstrumentos.dao;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                    "INSERT INTO venda (CodigoProduto, nome_produto, quantidade, valorTotal, descricao, ClienteID)" + "VALUES(?, ?, ?, ?, ?, ?)");

            PreparedStatement comandoSQL2 = conexao.prepareStatement(
                    "UPDATE PRODUTOS set Quantidade = Quantidade - " + pObj.getQuantidadeVenda()
                            + "WHERE CodigoProduto = " + pObj.getidProd());

            comandoSQL.setInt(1, pObj.getidProd());
            comandoSQL.setString(2, pObj.getProdutoVendido());
            comandoSQL.setDouble(3, pObj.getQuantidadeVenda());
            comandoSQL.setDouble(4, pObj.getValorTotal());
            comandoSQL.setString(5, pObj.getDescricaoProd());
            comandoSQL.setInt(6, pObj.getIdCliente());

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

    public static ArrayList<Venda> listarVenda(Venda venda) {
        ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
        Connection conexao = null;
        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT venda.quantidade, venda.valorTotal, produtos.NomeProduto "
                    + "FROM venda "
                    + "inner join produtos ON venda.CodigoProduto = produtos.CodigoProduto "
                    + "inner join clientes ON clientes.ClienteID = venda.ClienteID "
                    + "WHERE CPF = ? && DATE(dataCompra) = ?;");

            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //String dataStr = df.format(venda.getData());
            comandoSQL.setString(1, venda.getCpfCli());
            comandoSQL.setString(2, venda.getData());
            //comandoSQL.setDate(2, new java.sql.Date(venda.getData().getTime()));

            //4- Executar comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    //Passa dados do result set para obj
                    Venda obj = new Venda();
                    obj.setQuantidadeVenda(rs.getInt("venda.quantidade"));
                    obj.setValorTotal(rs.getInt("venda.valorTotal"));
                    obj.setProdutoVendido(rs.getString("produtos.NomeProduto"));
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

        public static ArrayList<Venda> listarVendaPeriodo(Venda venda) {
        ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
        Connection conexao = null;
        try {
            //1- Carregar o Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2- Abrir conexão
            String url = "jdbc:mysql://localhost:3306/lojainstrumentos";
            conexao = DriverManager.getConnection(url, "root", "");

            //3- Preparar comando SQL
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT produtos.NomeProduto, venda.dataCompra, clientes.NomeCompleto, venda.valorTotal  "
                    + "FROM venda "
                    + "inner join produtos ON venda.CodigoProduto = produtos.CodigoProduto "
                    + "inner join clientes ON clientes.ClienteID = venda.ClienteID "
                    + "WHERE DATE(dataCompra) BETWEEN ? AND ?");

            //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            comandoSQL.setString(1, venda.getDataInicio());
            comandoSQL.setString(2, venda.getDataFim());

            //4- Executar comando
            ResultSet rs = comandoSQL.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    //Passa dados do result set para obj
                    Venda obj = new Venda();
                    obj.setProdutoVendido(rs.getString("produtos.NomeProduto"));
                    obj.setData(rs.getString("venda.dataCompra"));
                    obj.setNomeCliente(rs.getString("clientes.NomeCompleto"));
                    obj.setValorTotal(rs.getDouble("venda.valorTotal"));
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
    
}
