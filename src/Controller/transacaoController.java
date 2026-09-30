package Controller;

import Model.Transacao;
import ModelDAO.transacaoDAO;

public class transacaoController {
    public String adicionarTransacao(Transacao transacao){
    transacaoDAO transacaoDAO = new transacaoDAO();
    return transacaoDAO.inserirTransacao(transacao);
    }
}
