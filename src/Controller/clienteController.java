package Controller;
import Model.Cliente;
import Model.Conta;
import ModelDAO.clienteDAO;

public class clienteController {
    private clienteDAO clienteDAO;

    public clienteController() {
        clienteDAO = new clienteDAO();
    }

    public void inserirCliente(Cliente cliente) {
      clienteDAO.inserirCliente(cliente);

    }

    public Cliente buscarCliente(String emailCliente, String senhaCliente){
     return clienteDAO.buscarCliente(emailCliente, senhaCliente);

    }

    public Conta buscarContaCliente(Cliente cliente){

      return clienteDAO.buscarContaCliente(cliente);

    }

}
