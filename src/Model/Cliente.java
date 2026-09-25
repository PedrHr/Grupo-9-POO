package Model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Conta conta;
    private String endereco;

    public Cliente(int idCliente, String nome, String cpf, String email, String senha, Conta conta) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.conta = conta;
    }
}
