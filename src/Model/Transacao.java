package Model;

import java.time.LocalDateTime;

public class Transacao {
    private int idTransacao;
    private double valor;
    private int contaOrigem;
    private long contaDestino;
    private LocalDateTime dataTransacao;
    private String status;


    public Transacao(double valorTransacao, int contaOrigem, long contaDestino, LocalDateTime dataTransacao) {
        this.valor = valorTransacao;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataTransacao = dataTransacao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setContaOrigem(int contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public int getContaOrigem() {
        return contaOrigem;
    }

    public void setContaDestino(int contaDestino) {
        this.contaDestino = contaDestino;
    }

    public long getContaDestino() {
        return contaDestino;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String gerarRelatorio() {
        return "Codigo: " + getIdTransacao() +
                "Valor: " + getValor() +
                "ContaOrigem: " + getContaOrigem() +
                "ContaDestino: " + getContaDestino() +
                "Data: " + getDataTransacao();

    }

}
