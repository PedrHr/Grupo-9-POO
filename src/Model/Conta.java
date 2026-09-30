package Model;

import javax.swing.*;

public abstract class Conta {
    private int numeroConta;
    private double saldoAtual = 0;
    private String tipoConta;
    private Cliente cliente;
    private double saldoAtualInicial =0 ;

    public Conta(double saldoAtual, String tipoConta, Cliente cliente) {
        this.saldoAtual = saldoAtual;
        this.tipoConta = tipoConta;
        this.cliente = cliente;
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

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
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
