package Model;

import java.time.LocalDateTime;

public class Transacao {
    private int idTransacao;
    private double valor;
    private int contaOrigem;
    private long contaDestino;
    private LocalDateTime dataTransacao;

    public Transacao(double valorTransacao, int contaOrigem, long contaDestino, LocalDateTime dataTransacao) {
        this.valor = valor;
        this.contaDestino = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataTransacao = dataTransacao;
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

    public void transferirValor(double valorTransferencia, Conta contaDestino ) {

    }

}
