package lojainstrumentos.model;


/**
 * @author Matheus Henrique da Costa
 */

public class Cliente {
    
    String nomeCliente, endereco, email, genero, estadoCivil, cpf, telefone, dataNasc;
    int IdCliente;
    
    
    //Construtores
    public Cliente(){
        
    }
    
    public Cliente(String nome,
            String endereco,    
            String email,
            String dataNasc,
            String telefone,
            String cpf,
            int idCliente) {
        
    }
    
    //Acessores

    public int getIdCliente() {
        return IdCliente;
    }
    
    public String getNome(){
        return this.nomeCliente;
    }
    
    public String getEndereco() {
        return this.endereco;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getGenero() {
        return this.genero;
    }
    
    public String getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public String getDataNasc() {
        return this.dataNasc;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    //Modificadores

    public void setIdCliente(int idCliente) {
        this.IdCliente = idCliente;
    }
    
    public void setNome(String nome) {
        this.nomeCliente = nome;
    }
    
    public void setEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }
    
    public void setEmail(String novoEmail) {
        this.email = novoEmail;
    }
    
    public void setGenero(String novoGenero) {
        this.genero = novoGenero;
    }
    
    public void setEstadoCivil(String novoEstadoCivil) {
        this.estadoCivil = novoEstadoCivil;
    }
    
    public void setDataNasc(String novaDataNasc) {
        this.dataNasc = novaDataNasc;
    }
    
    public void setTelefone(String novoTelefone) {
        this.telefone =  novoTelefone;
    }
    
    public void setCpf(String novoCpf) {
        this.cpf = novoCpf;
    }
    
    //metodos
    
    public void comprarProduto() {
        
    }
    
    //criar um getVenda e colocar as vendas do cliente em um array
    
}
