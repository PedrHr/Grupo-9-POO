package Model;

public class contaPoupanca extends Conta {

    private double taxaRendimento;

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