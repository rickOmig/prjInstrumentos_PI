/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojainstrumentos.lojainstrumentos;

/**
 *
 * @author mathe
 */
public class Venda {
    
    double precoProdutoVendido;
    int codigoPedido, quantidadeVendida;
    String produtoVendido, nomeCliente;
    
    public Venda() {
        
    }
    
    public Venda(int codigoPedido) {
        //?aplicar informações da venda nas variaveis?
    }
    
    //Acessores
    public String getProdutoVenda() {
        return this.produtoVendido;
    }
    
    public String getNomeComprador() {
        return this.nomeCliente;
    }
    
    public int getCodigoPedido() {
        return this.codigoPedido;
    }
    
    public int getQuantidadeVenda() {
        return this.quantidadeVendida;
    }
    
    public double getPrecoVenda() {
        return this.precoProdutoVendido;
    }
    
    //Modificadores
    
    public void setProdutoVenda(String produto) {
        this.produtoVendido = produto;
    }
    
    public void setNomeComprador(String cliente) {
        this.nomeCliente = cliente;
    }
    
    public void setCodigoPedido(int codigo) {
        this.codigoPedido = codigo;
    }
    
    public void setQuantidadeVenda(int quantidade) {
        this.quantidadeVendida = quantidade;
    }
    
    public void setPrecoVenda(double preco) {
        this.precoProdutoVendido = preco;
    }
    
     //ideias:       
    //metodo para armazenar ficha de venda em um vetor
   //tentar simplicar a classe importando informações de classes ja existentes
    
    
}

