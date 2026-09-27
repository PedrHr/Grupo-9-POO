package Model;

import java.time.LocalDateTime;

public class Transacao {
    private int idTransacao;
    private double valor;
    private int contaOrigem;
    private int contaDestino;
    private LocalDateTime dataTransacao;

    public Transacao(double valorTransacao, int contaOrigem, int contaDesitno, LocalDateTime dataTransacao) {
        this.valor = valor;
        this.contaOrigem = this.contaOrigem;
        this.contaDestino = contaDestino;
        this.dataTransacao = this.dataTransacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public void getValor(double valor) {
        this.valor = valor;
    }
    public void setContaOrigem(int contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public void getContaOrigem(int contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }
    public void getContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }
    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    public void getDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

}
