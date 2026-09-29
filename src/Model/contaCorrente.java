package Model;

import java.math.BigDecimal;

public class contaCorrente extends Conta {
    private double limiteCredito = getSaldoAtual()/2;
    private long chaveTransacao;

    public contaCorrente(double saldoAtual, String tipoConta, Cliente cliente) {

        super(saldoAtual, tipoConta, cliente);
    }

    @Override
    public void sacarValor(double valorSacar) {

        // Tem dinheiro suficiente no saldo
        if (getSaldoAtual() >= valorSacar) {
            setSaldoAtual(getSaldoAtual() - valorSacar);
        }

        // Não tem saldo suficiente, mas saldo + limite conseguem pagar
        else if (getSaldoAtual() + limiteCredito >= valorSacar) {
            double valorRestante = valorSacar - getSaldoAtual();

            setSaldoAtual(0);
            limiteCredito -= valorRestante;
        }
    }

    public void gerarChaveTransacao() {
        this.chaveTransacao = System.currentTimeMillis();
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}
