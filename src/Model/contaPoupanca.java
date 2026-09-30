package Model;

public class contaPoupanca extends Conta {

    private double taxaRendimento = 0.010;

    public contaPoupanca(double saldoAtual, String tipoConta, Cliente cliente) {

        super(saldoAtual ,tipoConta, cliente);

    }

    public double getTaxaRendimento() {
        return taxaRendimento;

    }
    @Override
    public void depositarValor(double valorDeposito){
        if(valorDeposito > 0) {

             aplicarTaxa(taxaRendimento, valorDeposito);

        }
    }

}