package Controller;
import Model.Cliente;
import ModelDAO.clienteDAO;

public class clienteController {
    private clienteDAO clienteDAO;

    public clienteController() {
        clienteDAO clienteDAO = new clienteDAO;
    }

    public void inserirCliente(Cliente cliente) {
        clienteDAO.inserirCliente(cliente);
    }

    public void buscarCliente(String emailCliente, String senhaCliente){
        clienteDAO.buscarCliente(emailCliente, senhaCliente);
    }
}
