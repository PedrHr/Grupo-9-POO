package Model;

public class Transacao {
    private int idTransacao;
    private int valor;
    private int contaOrigem;
    private int contaDestino;
    private int dataTransacao;

    public Transacao() {
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.dataTransacao = dataTransacao;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    public void getValor(int valor) {
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
    public void setDataTransacao(int dataTransacao) {
        this.dataTransacao = dataTransacao;
    }
    public void getDataTransacao(int dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

}
