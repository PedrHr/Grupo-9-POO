package Model;

import Controller.contaCorrenteController;

import java.math.BigDecimal;

public class contaCorrente extends Conta {
    private double limiteCredito;
    private long chaveTransacao;

    public contaCorrente(double saldoAtual, TipoConta tipoConta, Cliente cliente) {
        super(saldoAtual, tipoConta, cliente);
    }

    @Override
    public String sacarValor(double valorSacar) {

        if (getSaldoAtual() >= valorSacar) {
            diminuirSaldo(valorSacar);
            gerarLimiteCredito();
        } else if (getSaldoAtual() + limiteCredito >= valorSacar) {
            double valorRestante = valorSacar - getSaldoAtual();

            diminuirSaldo(getSaldoAtual());
            limiteCredito -= valorRestante;
        }else{
            contaCorrenteController contaController  = new contaCorrenteController();
            return contaController.avisoSaldoInsuficiente();
        }
        return "O valor foi descontado do seu credito";
    }


    public long gerarChaveTransacao() {
        return  this.chaveTransacao = System.currentTimeMillis();
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void gerarLimiteCredito() {
        this.limiteCredito = getSaldoAtual() / 2;
    }

    public long getChaveTransacao() {
        return chaveTransacao;
    }

}
