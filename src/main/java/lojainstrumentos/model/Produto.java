/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojainstrumentos.model;

/**
 *
 * @author mathe
 */
public class Produto {
    
    String nomeProd, descricaoProd;
    double precoProd;
    int quantidadeProd, codigoProd;
    
    
    //Construtores
    public Produto() {
        
    }
    
    public Produto(String nomeProd,
            String descricaoProd,
            double precoProd,
            int quantidadeProd) {       
    }
    
    //Acessores
    public String getNomeProd() {
        return this.nomeProd;
    }
    
    public String getDescricaoProd() {
        return this.descricaoProd;
    }
    
    public double getPrecoProd() {
        return this.precoProd;
    }
    
    public int getQuantidadeProd() {
        return this.quantidadeProd;
    }
    
    public int getCodigoProd() {
        return this.codigoProd;
    }
    
    //Modificadores
    public void setNomeProduto(String novoNome) {
        this.nomeProd = novoNome;
    }
    
    public void setDescricaoProd(String novaDescricao) {
        this.descricaoProd = novaDescricao;
    }
    
    public void setPreco(double novoPreco) {
        this.precoProd = novoPreco;
    }
    
    public void setQuantidadeProduto(int novaQtd) {
        this.quantidadeProd = novaQtd;
    }
    
    public void setCodigoProduto(int novoCodigoProd) {
        this.codigoProd = novoCodigoProd;
    }
            
    //possivel variavel tipo produto, categoria, cor, tamanho..
    
}

