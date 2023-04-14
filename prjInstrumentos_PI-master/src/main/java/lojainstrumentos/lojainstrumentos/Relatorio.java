package lojainstrumentos.lojainstrumentos;

/**
 *
 * @author matheus.hcosta6
 */

public class Relatorio {
    
    String produtoVenda, nomeComprador;
    int quantidadeProduto, dataCompra;
    double valorTotalVenda;
    
    public Relatorio() {
        
    }   
    
    //Acessores
    public String getProdutoVenda() {
        return this.produtoVenda;
    }
    
    public String getNomeComprador() {
        return this.nomeComprador;
    }
    
    public int getQuantidadeProduto() {
        return this.quantidadeProduto;
    }
    
    public int getDataCompra() {
        return this.dataCompra;
    }
    
    public double getValorTotalVenda() {
        return this.valorTotalVenda
    } 
    
    //Modificadores
    public void setProdutoVenda(String novoProduto) {
        this.produtoVenda = novoProduto;
    }
    
    public void setNomeComprador(String novoComprador){
        this.nomeComprador = novoComprador;
    }
        
    public void setQuantidadeProduto(int novaQuantidade) {
        this.quantidadeProduto = novaQuantidade;
    }
    
    public void setDataCompra(int novaDataCompra) {
        this.dataCompra = novaDataCompra;
    }
    
    public void setValorTotalVenda(double novoValorTotal) {
        this.valorTotalVenda = novoValorTotal;
    }
    
            
            
            
            /*o relatorio pode ser visto como um conjunto
            de informações sobre venda, produto e cliente*/
            
            
}