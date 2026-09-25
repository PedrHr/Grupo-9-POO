package Model;

public abstract class Conta {
    private int numeroConta;
    private double saldoAtual;




    public double depositarValor(double valorDeposito){
        if(valorDeposito >= 0) {
            this.saldoAtual = this.saldoAtual + valorDeposito;
        }
    }

    public double sacarValor(double valorSacar) {
        if(valorSacar >= 0) {
            if(this.saldoAtual >= valorSacar) {
                this.saldoAtual = this.saldoAtual - valorSacar;
            }
        }


    }
}
