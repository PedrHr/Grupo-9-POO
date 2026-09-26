package Model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String senha;

    public Cliente(String nome, String cpf, String email, String endereco, String senha ){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }


    public  int getIdCliente()
    {
        return idCliente;
    }

    public  String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {

        this.senha = senha;
    }
    public String getEndereco() {

        return endereco;
    }

    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }



}
