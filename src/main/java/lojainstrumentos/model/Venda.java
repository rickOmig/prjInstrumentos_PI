/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojainstrumentos.model;

import com.toedter.calendar.JDateChooser;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class Venda {
    
    double valorTotal, quantidadeVenda;
    int idProd, idCliente;
    String produtoVendido, descricaoProd, cpfCli, nomeCliente;
    String data, dataInicio, dataFim;
    
    public Venda() {
        
    }
    
    public Venda(int codigoPedido) {
        //?aplicar informações da venda nas variaveis?
    }
    

     //ideias:       
    //metodo para armazenar ficha de venda em um vetor
   //tentar simplicar a classe importando informações de classes ja existentes

    public String getNomeCliente() {
        return nomeCliente;
    }
    
    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }
    
    public String getData() {
        return data;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public int getidProd() {
        return idProd;
    }

    public double getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public String getProdutoVendido() {
        return produtoVendido;
    }

    public String getDescricaoProd() {
        return descricaoProd;
    }

    public String getCpfCli() {
        return cpfCli;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setidProd(int idProd) {
        this.idProd = idProd;
    }

    public void setQuantidadeVenda(double quantidadeVenda) {
        this.quantidadeVenda = quantidadeVenda;
    }

    public void setProdutoVendido(String produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public void setDescricaoProd(String descricaoProd) {
        this.descricaoProd = descricaoProd;
    }

    public void setCpfCli(String cpfCli) {
        this.cpfCli = cpfCli;
    }
    
    
    
}

