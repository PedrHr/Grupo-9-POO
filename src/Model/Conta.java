package Model;

public abstract class Conta {
    private int numeroConta;
    private double saldoAtual;

    public void depositarValor(double valorDeposito){
        if(valorDeposito > 0) {
            this.saldoAtual = this.saldoAtual + valorDeposito;
        }
    }

    public void sacarValor(double valorSacar) {
        if(valorSacar >= 0) {
            if(this.saldoAtual >= valorSacar) {
                this.saldoAtual = this.saldoAtual - valorSacar;
            }
        }


    }
}
