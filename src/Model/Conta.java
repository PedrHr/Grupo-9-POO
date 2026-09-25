package Model;

public class Conta {
    private int numeroConta;
    private double saldoAtual;
    private float valorDepositado;
    private float valorRetirado;
    private String dataDeposito;
    private String dataRetirada;



    public Conta(int numero, double saldo, double limiteCredito) {
        this.numero = numero;
        this.saldo = saldo;
    }
}
