package Model;

public abstract class Conta {
    private int numeroConta;
    private double saldoAtual;
    private String tipoConta;


    public Conta(double saldoAtual, String tipoConta) {
        this.numeroConta = numeroConta;
        this.saldoAtual = saldoAtual;
    }

    public void depositarValor(double valorDeposito){
        if(valorDeposito > 0) {

            this.saldoAtual += valorDeposito;

            setSaldoAtual(getSaldoAtual() + valorDeposito);

        }
    }

    public void sacarValor(double valorSacar) {
        if(valorSacar > 0 && saldoAtual >= valorSacar) {
            if(this.saldoAtual >= valorSacar) {
                this.saldoAtual -= valorSacar;
            }
        }
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(double saldoAtual) {
        this.saldoAtual = saldoAtual;
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
}
