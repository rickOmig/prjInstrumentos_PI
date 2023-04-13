package lojainstrumentos.lojainstrumentos;


/**
 * @author Matheus Henrique da Costa
 */

public class Cliente {
    
    String nomeCliente, endereco, email, genero, estadoCivil;
    int dataNasc, telefone, cpf;
    
    
    //Construtores
    public Cliente(){
        
    }
    
    public Cliente(String nome, String endereco, String email,
            String genero, String estadoCivil, int dataNasc,
            int telefone, int cpf) {
        
    }
    
    //Acessores
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
    
    public String estadoCivil() {
        return this.estadoCivil;
    }
    
    public int getDataNasc() {
        return this.dataNasc;
    }
    
    public int getTelefone() {
        return this.telefone;
    }
    
    public int getCpf() {
        return this.cpf;
    }
    
    //Modificadores
    
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
    
    public void setDataNasc(int novaDataNasc) {
        this.dataNasc = novaDataNasc;
    }
    
    public void setTelefone(int novoTelefone) {
        this.telefone =  novoTelefone;
    }
    
    public void setCpf(int novoCpf) {
        this.cpf = novoCpf;
    }
    
    //metodos
    
    public void comprarProduto() {
        
    }
    
    //criar um getVenda e colocar as vendas do cliente em um array
    
}
