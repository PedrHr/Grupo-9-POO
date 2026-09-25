package Model;

import java.math.BigDecimal;

public class contaCorrente extends Conta {
    private double limiteCredito;
    private long chaveTransacao;

    public void gerarChaveTransacao() {
        this.chaveTransacao = System.currentTimeMillis();
    }

}
