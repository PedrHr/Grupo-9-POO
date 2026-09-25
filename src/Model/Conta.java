package Model;

import java.math.BigDecimal;

public abstract class Conta {
    private int numeroConta;
    private BigDecimal saldoAtual;
    int contadorDeposito = 0;
    int ListaDeposito = new int[]

    public int getSaldoAutual(){
        return this.saldoAtual;
    }


    public double depositarValor(double valorDeposito) {
        if(valorDeposito >= 0) {
            contadorDeposito++;
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
