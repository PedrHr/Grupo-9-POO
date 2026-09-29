package Controller;
import Model.Cliente;
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
}
