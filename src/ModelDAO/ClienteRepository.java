package ModelDAO;

import Model.Cliente;

public interface ClienteRepository {

    String inserirCliente(Cliente cliente);

    Cliente buscarCliente(String email, String senha);
}