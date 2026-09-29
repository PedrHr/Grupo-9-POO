package Model;

public class contaPoupanca extends Conta {

    private double taxaRendimento;

    public contaCorrente(double saldoAtual, String tipoConta, Cliente cliente) {

        super(saldoAtual, tipoConta, Cliente cliente);
    }

    public contaPoupanca() {
        this.taxaRendimento = 0.001;
    }

    public void aplicarRendimento() {
        double rendimento = getSaldoAtual() * taxaRendimento;
        setSaldoAtual(rendimento);
    }

    public double getTaxaRendimento() {
        return taxaRendimento;

    }
}