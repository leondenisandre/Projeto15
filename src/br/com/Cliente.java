package br.com;

public class Cliente {
	private long rg;
    private String nome;
    private String telefone;
    private String endereco;
    
    public Cliente(){
        this.setRg(rg);
        this.setNome(nome);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
    }
    

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
