package Controller;
import Model.Cliente;
import Model.contaCorrente;
import Model.contaPoupanca;
import ModelDAO.clienteDAO;
import ModelDAO.contaDAO;
import Model.Conta;

public class contaPoupancaController {
    private contaDAO contaDAO;

   public void inserirConta(contaPoupanca contaPoupanca){
        contaDAO contaDAO = new contaDAO();
        contaDAO.inserirConta(contaPoupanca);
    }
    public String inserirDeposito(contaPoupanca ContaP){
        contaDAO contaDAO = new contaDAO();
        return contaDAO.inserirDeposito(ContaP);
    }
    public String sacarValor(contaPoupanca ContaP){
        contaDAO contaDAO = new contaDAO();
        return contaDAO.sacarValor(ContaP);
    }
    public String avisoSaldoInsuficiente(){
        return "Seu saldo é insuficiente para prosseguir com a operação";
    }

    public double getSaldoInicial() {
        return 0;
    }

}

