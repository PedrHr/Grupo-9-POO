package View;

import Controller.exceptionsController;
import java.awt.*;
import java.time.LocalDateTime;
import javax.swing.*;

public class panelTransacao extends JDialog {

    private JTextField valor;
    private JTextField chaveTransacao;

    // Construtor recebendo a janela pai (owner)
    public panelTransacao(Frame owner) {
        super(owner, "Realizar Transações", true); // 'true' ativa o modo MODAL

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Apenas fecha essa janela, sem fechar o app

        // Painel
        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 15));

        // Adiciona margem
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // VALOR DEPOSITO
        JLabel labelValor = new JLabel("Valor:");
        valor = new JTextField(16);

        // ADICIONAR CHAVE DE TRANSAÇÃO DA CONTA DESTINATÁRIA
        JLabel labelOrigem = new JLabel("Chave de Transação:");
        chaveTransacao = new JTextField(16);

        // Adicionar ao painel
        painel.add(labelValor);
        painel.add(valor);

        painel.add(labelOrigem);
        painel.add(chaveTransacao);

        // Botões
        JButton btnEnviar = new JButton("Enviar Transação");
        JButton btnCancelar = new JButton("Cancelar");

        btnEnviar.addActionListener(e -> {

            // VERIFICANDO SE OS CAMPOS ESTÃO PREENCHIDOS ANTES DE FAZER PARSE
            if (valor.getText().trim().isEmpty() || chaveTransacao.getText().trim().isEmpty()) {

                // MENSAGEM DE ERRO
                JOptionPane.showMessageDialog(this, exceptionsController.camposVazios());

            } else {

                try {
                    double valorTransacao = Double.parseDouble(valor.getText().replace(",", "."));
                    long contaDestino = Long.parseLong(chaveTransacao.getText().trim());
                    long contaOrigem = 1;
                    LocalDateTime dataTransacao = LocalDateTime.now();

                    // CRIANDO UM NOVO OBJETO TRANSAÇÃO E CHAMANDO O CONTROLLER PARA CADASTRA-LA
                    // Transacao transacao = new Transacao(valorTransacao, contaOrigem, contaDestino, dataTransacao);

                    JOptionPane.showMessageDialog(
                            this,
                            "Valor " + valorTransacao + " enviado com sucesso!"
                    );
                    
                    dispose(); // Fecha a tela após finalizar a transação

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos nos campos.", "Erro de Formatação", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        painel.add(btnEnviar);
        painel.add(btnCancelar);

        add(painel);

        // Definir tamanho fixo
        setSize(500, 400);

        // Centralizar a janela em relação à janela principal (panelConta)
        setLocationRelativeTo(owner);
    }

    // Método estático para ser chamado na panelConta
    public static void exibir(JFrame owner) {
        panelTransacao dialog = new panelTransacao(owner);
        dialog.setVisible(true); // Fica bloqueado aqui até o diálogo ser fechado
    }

    public static void main(String[] args) {
        panelTransacao.exibir(null);
    }
}