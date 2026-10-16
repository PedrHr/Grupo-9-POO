package Model;

import javax.swing.*;

public abstract class Conta {
    private int numeroConta;
    private double saldoAtual = 0;
    private TipoConta tipoConta;
    private Cliente cliente;
    private double saldoAtualInicial = 0;

    // CONSTRUTOR

    public Conta(TipoConta tipoConta, Cliente cliente) {
        this.saldoAtual = 0;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
    }

    public enum TipoConta {
        CORRENTE, POUPANCA
    }

    // GETTERS E SETTERS

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public int getNumeroConta() {

        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public double getSaldoAtualInicial() {
        return saldoAtualInicial;
    }

    public int getIdCliente() {
        return cliente.getIdCliente();
    }

    // METODOS DE DOMINIO

    public void depositarValor(double valorDeposito) {
        if (valorDeposito > 0) {

            this.saldoAtual = (getSaldoAtual() + valorDeposito);

        }
    }

    public void aplicarTaxa(double taxaRendimento, double valorDeposito) {
        this.saldoAtual = (getSaldoAtual() + valorDeposito) + (getSaldoAtual() * taxaRendimento);
    }

    public String sacarValor(double valorSacar) {
        if (valorSacar > 0 && saldoAtual >= valorSacar) {
            if (this.saldoAtual >= valorSacar) {
                this.saldoAtual -= valorSacar;
            }
        } else {
            return "Seu é Saldo insuficiente para prosseguir com a operação";
        }
        return "Saldo sacado com sucesso!";
    }
}
