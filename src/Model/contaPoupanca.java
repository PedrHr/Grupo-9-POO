package Model;

public class contaPoupanca extends Conta {

    private double taxaRendimento = 0.010;

    public contaPoupanca(String tipoConta, Cliente cliente) {

        super(tipoConta, cliente);

    }

    public void aplicarRendimento() {
        double rendimento = getSaldoAtual() * taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;

    }

}