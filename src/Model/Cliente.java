package Model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String senha;

    public Cliente(String nome, String cpf, String endereco, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        if (idCliente <= 0) {
            System.out.println("Não foi possivel gerar sua conta");
        } else {
            this.idCliente = idCliente;
        }
    }


    public String getNome() {

        return nome;
    }


    public String getCpf() {

        return cpf;
    }


    public String getEmail() {

        return email;
    }

    public String getSenha() {

        return senha;
    }


    public String getEndereco() {

        return endereco;
    }

}
