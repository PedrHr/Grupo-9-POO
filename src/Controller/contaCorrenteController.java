package Controller;
import Model.Cliente;
import Model.contaCorrente;
import ModelDAO.clienteDAO;
import ModelDAO.contaDAO;
import Model.Conta;

public class contaCorrenteController {
    private contaDAO contaDAO;

public void inserirConta( contaCorrente contaCorrente, Cliente cliente){
    contaDAO contaDAO = new contaDAO();
    contaDAO.inserirConta(cliente, contaCorrente);
}

}
