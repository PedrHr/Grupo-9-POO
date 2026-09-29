package View;

import Controller.exceptionsController;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class panelTransacao extends JDialog {

    private JTextField txtValor;
    private JTextField txtOrigem;
    private JTextField txtDestino;

    // Construtor recebendo a janela pai (owner)
    public panelTransacao(Frame owner) {
        super(owner, "Realizar Transação", true); // Modo MODAL ativado
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Painel Principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Painel Central com GridBagLayout (Centralizado)
        JPanel painelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(8, 0, 8, 0); // Espaçamento vertical entre os elementos

        // 1. VALOR
        JLabel labelValor = new JLabel("Valor:");
        txtValor = new JTextField(16);
        JPanel boxValor = criarBoxCampo(labelValor, txtValor);

        // 2. ORIGEM
        JLabel labelOrigem = new JLabel("Origem:");
        txtOrigem = new JTextField(16);
        JPanel boxOrigem = criarBoxCampo(labelOrigem, txtOrigem);

        // 3. DESTINO
        JLabel labelDestino = new JLabel("Destino:");
        txtDestino = new JTextField(16);
        JPanel boxDestino = criarBoxCampo(labelDestino, txtDestino);

        // ADICIONA OS CAMPOS AO PAINEL CENTRAL
        painelCentral.add(boxValor, gbc);
        painelCentral.add(boxOrigem, gbc);
        painelCentral.add(boxDestino, gbc);

        // BOTÕES ENVIAR E VOLTAR
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton btnEnviar = new JButton("Enviar");
        JButton btnVoltar = new JButton("Voltar");

        btnEnviar.setPreferredSize(new Dimension(150, 35));
        btnVoltar.setPreferredSize(new Dimension(150, 35));

        painelBotoes.add(btnEnviar);
        painelBotoes.add(btnVoltar);

        // AÇÃO DO BOTÃO VOLTAR
        btnVoltar.addActionListener(e -> dispose());

        // AÇÃO DO BOTÃO ENVIAR
        btnEnviar.addActionListener(e -> {
            String strValor = txtValor.getText().trim();
            String strOrigem = txtOrigem.getText().trim();
            String strDestino = txtDestino.getText().trim();

            // VERIFICAÇÃO DE CAMPOS VAZIOS
            if (strValor.isEmpty() || strOrigem.isEmpty() || strDestino.isEmpty()) {
                JOptionPane.showMessageDialog(this, exceptionsController.camposVazios(), "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    double valorTransacao = Double.parseDouble(strValor.replace(",", "."));
                    long contaOrigem = Long.parseLong(strOrigem);
                    long contaDestino = Long.parseLong(strDestino);

                    // MOMENTO EM QUE A TRANSAÇÃO FOI EFETUADA
                    LocalDateTime dataTransacao = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                    String dataFormatada = dataTransacao.format(formatter);

                    // AQUI VOCÊ PODE INSTANCIAR O SEU CONTROLLER / MODELO:
                    // Transacao transacao = new Transacao(valorTransacao, contaOrigem, contaDestino, dataTransacao);

                    JOptionPane.showMessageDialog(
                            this,
                            "Transação efetuada com sucesso!\n\n"
                            + "Valor: R$ " + String.format("%.2f", valorTransacao) + "\n"
                            + "Origem: " + contaOrigem + "\n"
                            + "Destino: " + contaDestino + "\n"
                            + "Data/Hora: " + dataFormatada,
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    dispose(); // Fecha o diálogo após o envio

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Por favor, insira números válidos nos campos de Valor, Origem e Destino.",
                            "Erro de Formatação",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setSize(480, 520);
        setLocationRelativeTo(owner);
    }

    // Método auxiliar para criar campos centralizados na vertical
    private JPanel criarBoxCampo(JLabel label, JComponent campo) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        campo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(campo);

        return panel;
    }

    // Método estático para ser chamado na panelConta
    public static void exibir(JFrame owner) {
        panelTransacao dialog = new panelTransacao(owner);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        panelTransacao.exibir(null);
    }
}