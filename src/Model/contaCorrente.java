package Model;

import Controller.contaCorrenteController;

import java.math.BigDecimal;

public class contaCorrente extends Conta {
    private double limiteCredito;
    private long chaveTransacao;


    public contaCorrente(TipoConta tipoConta, Cliente cliente) {
        super(tipoConta, cliente);
    }

    public contaCorrente(double saldoAtual, TipoConta tipoConta, Cliente cliente) {
        super(saldoAtual, tipoConta, cliente);
    }

    // GETTERS E SETTERS

    public long gerarChaveTransacao() {
        return this.chaveTransacao = System.currentTimeMillis();
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public long getChaveTransacao() {
        return chaveTransacao;
    }

    // METODOS DE DOMINIO

    @Override
    public String sacarValor(double valorSacar) {

        if (valorSacar > 0) {
            if (getSaldoAtual() >= valorSacar) {
                diminuirSaldo(valorSacar);
            } else if (getSaldoAtual() + limiteCredito >= valorSacar) {
                double credRestante = valorSacar - getSaldoAtual();
                limiteCredito -= credRestante;
                diminuirSaldo(getSaldoAtual());
            } else {
                return "Saldo insuficiente";
            }
            return "O valor foi sacado com sucesso";
        } else {
            return "Não é possivel sacar valor nulos ou negativos";
        }
    }

    @Override
    public String depositarValor(double valorDeposito) {
        if (valorDeposito > 0) {
            limiteCredito += valorDeposito /2;
            aumentarSaldo(valorDeposito);
            return "Você não pode depositar valores nulos ou negativos";
        }else{
            return "Você não pode depositar valores nulos ou negativos";
        }
    }
}
