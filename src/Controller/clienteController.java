package Controller;
import Model.Cliente;
import ModelDAO.clienteDAO;
import ModelDAO.ClienteRepository;

public class clienteController {
    private final ClienteRepository clienteRepository;

    public clienteController() {
        this.clienteRepository = new clienteDAO();
    }

    public clienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void inserirCliente(Cliente cliente) {
       clienteRepository.inserirCliente(cliente);
    }

    public Cliente buscarCliente(String emailCliente, String senhaCliente){
     return clienteRepository.buscarCliente(emailCliente, senhaCliente);

    }
}
