package Model;

import java.math.BigDecimal;

public class contaCorrente extends Conta {
    private double limiteCredito;
    private int chaveTransacao;

    public void setChaveTransacao(int chaveTransacao) {
        Random random = new Random();
        this.chaveTransacao = random.nextInt(100);
    }

}
