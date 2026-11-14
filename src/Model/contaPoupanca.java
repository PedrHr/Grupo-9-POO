package Model;

public class contaPoupanca extends Conta {

    private double taxaRendimento = 0.010;

    public contaPoupanca(TipoConta tipoConta, Cliente cliente) {
        super(tipoConta, cliente);
    }

    public contaPoupanca(double saldoAtual, TipoConta tipoConta, Cliente cliente) {
        super(saldoAtual, tipoConta, cliente);
    }

    public double getTaxaRendimento() {
        return taxaRendimento;

    }

    @Override
    public String depositarValor(double valorDeposito) {
        if (valorDeposito > 0) {
            aplicarTaxa(taxaRendimento, valorDeposito);
            return "Valor depositado com sucesso";
        }else{
            return "Valor depositado com sucesso";
        }
    }

}