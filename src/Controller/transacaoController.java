package Controller;

import Model.Transacao;
import ModelDAO.transacaoDAO;

import java.util.List;

public class transacaoController {
    public String adicionarTransacao(Transacao transacao){
    transacaoDAO transacaoDAO = new transacaoDAO();
    return transacaoDAO.inserirTransacao(transacao);
    }

    public List<Transacao> buscarExtrato(int numeroConta) {
         transacaoDAO transacaoDAO = new transacaoDAO();
        return transacaoDAO.buscarExtrato(numeroConta);
    }
}
