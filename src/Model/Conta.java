package Model;

import javax.swing.*;

public abstract class Conta {
    private int numeroConta;
    private double saldoAtual = 0;
    private TipoConta tipoConta;
    private Cliente cliente;
    private double saldoAtualInicial = 0 ;

    public Conta(double saldoAtual, TipoConta tipoConta, Cliente cliente) {
        this.saldoAtual = saldoAtual;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
    }

    public enum TipoConta {
        CORRENTE, POUPANCA
    }

    public TipoConta getTicoConta() {
        return tipoConta;
    }

    public void depositarValor(double valorDeposito){
        if(valorDeposito > 0) {

            this.saldoAtual = (getSaldoAtual() + valorDeposito);

        }
    }

    public void aplicarTaxa(double taxaRendimento, double valorDeposito){
        this.saldoAtual = (getSaldoAtual() + valorDeposito) + (getSaldoAtual() * taxaRendimento);
    }

    public String sacarValor(double valorSacar) {
        if(valorSacar > 0 && saldoAtual >= valorSacar) {
            if(this.saldoAtual >= valorSacar) {
                this.saldoAtual -= valorSacar;
            }
        }else {
            return "Seu é Saldo insuficiente para prosseguir com a operação";
        }
        return "Saldo sacado com sucesso!";
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldoAtual(){
        return saldoAtual;
    }
    public void diminuirSaldo(double valor) {
        saldoAtual -= valor;
    }

    public double getSaldoAtualInicial() {
        return saldoAtualInicial;
    }
}
