package Model;

public class contaPoupanca extends Conta {

    private double taxaRendimento;

    public contaPoupanca(double saldoAtual, String tipoConta, Cliente cliente) {

        super(saldoAtual, tipoConta, cliente);

    }

    public void aplicarRendimento() {
        double rendimento = getSaldoAtual() * taxaRendimento;
        setSaldoAtual(rendimento);
    }

    public double getTaxaRendimento() {
        return taxaRendimento;

    }
}