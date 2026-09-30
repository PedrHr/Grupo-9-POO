package Controller;
import Model.Cliente;
import Model.Transacao;
import Model.contaCorrente;
import ModelDAO.clienteDAO;
import ModelDAO.contaDAO;
import Model.Conta;

public class contaCorrenteController {
    private contaDAO contaDAO;

public void inserirConta( contaCorrente contaCorrente){
    contaDAO contaDAO = new contaDAO();
    contaDAO.inserirConta(contaCorrente);
}
public String inserirDeposito(contaCorrente ContaCorrente){
    contaDAO contaDAO = new contaDAO();
    return contaDAO.inserirDeposito(ContaCorrente);
}
public String sacarValor(contaCorrente ContaCorrente){
    contaDAO contaDAO = new contaDAO();
    return contaDAO.sacarValor(ContaCorrente);
}
public String adicionarChaveTransacao(contaCorrente ContaCorrente){
    contaDAO contaDAO = new contaDAO();
    return contaDAO.adicionarChaveTransacao(ContaCorrente);
}
public String avisoSaldoInsuficiente(){
    return "Seu saldo é insuficiente para prosseguir com a operação";
}

    public double getSaldoInicial() {
        return 0;
    }
}
