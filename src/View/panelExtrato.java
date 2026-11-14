package View;

import Controller.transacaoController;
import Model.Cliente;
import Model.Conta;
import Model.Transacao;
import Model.contaCorrente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class panelExtrato {

    static JFrame interfaceExtrato;

    public static void exibir(contaCorrente conta, Cliente cliente) {

        if (interfaceExtrato != null) {
            interfaceExtrato.dispose();
        }

        interfaceExtrato = new JFrame("Extrato");

        // PAINEL PRINCIPAL
        JPanel painel = new JPanel();
        painel.setLayout(null);
        painel.setBackground(new Color(240, 243, 248));

        // TÍTULO
        JLabel titulo = new JLabel("EXTRATO");
        titulo.setBounds(30, 20, 400, 35);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(30, 60, 100));
        painel.add(titulo);

        // USUÁRIO
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(40, 80, 120, 25);
        labelUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(labelUsuario);

        JTextField campoUsuario = new JTextField(cliente.getNome());
        campoUsuario.setBounds(160, 78, 250, 30);
        campoUsuario.setEditable(false);
        campoUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        painel.add(campoUsuario);

        // CONTA
        JLabel labelConta = new JLabel("Conta:");
        labelConta.setBounds(40, 125, 120, 25);
        labelConta.setFont(new Font("Arial", Font.BOLD, 14));
        painel.add(labelConta);

        JTextField campoConta = new JTextField(String.valueOf(conta.getNumeroConta()));

        campoConta.setBounds(160, 123, 250, 30);
        campoConta.setEditable(false);
        campoConta.setFont(new Font("Arial", Font.PLAIN, 14));
        painel.add(campoConta);

        JLabel tituloOperacoes = new JLabel("MOVIMENTAÇÕES");
        tituloOperacoes.setBounds(40, 175, 300, 30);
        tituloOperacoes.setFont(new Font("Arial", Font.BOLD, 18));
        tituloOperacoes.setForeground(new Color(30, 60, 100));
        painel.add(tituloOperacoes);

        String[] colunas = {"Data", "Tipo", "Valor", "De", "Para"};

        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

        JTable tabela = new JTable(modelo);

        tabela.setFont(new Font("Arial", Font.PLAIN, 13));
        tabela.setRowHeight(25);
        tabela.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 13)
        );

        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBounds(40, 220, 370, 230);

        painel.add(scrollPane);

        // Bucar tramsações
        transacaoController controller = new transacaoController();

        List<Transacao> transacoes = controller.buscarExtrato(conta.getNumeroConta());

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        for (Transacao transacao : transacoes) {

            String tipo;

            if (transacao.getContaOrigem() == conta.getNumeroConta()) {
                tipo = "SAÍDA";
            } else {
                tipo = "ENTRADA";
            }

            modelo.addRow(new Object[]{transacao.getDataTransacao().format(formatter), tipo, String.format("R$ %.2f", transacao.getValor()), transacao.getContaOrigem(), transacao.getContaDestino()});
        }

        // Caso nao exista transações

        if (transacoes.isEmpty()) {

            JOptionPane.showMessageDialog(interfaceExtrato, "Nenhuma transação encontrada para esta conta.", "Extrato", JOptionPane.INFORMATION_MESSAGE);
        }

        // BOTÃO FECHAR
        JButton botaoFechar = new JButton("Fechar");
        botaoFechar.setBounds(40, 470, 370, 40);
        botaoFechar.setFont(new Font("Arial", Font.BOLD, 14));
        botaoFechar.setBackground(new Color(20, 55, 100));
        botaoFechar.setForeground(Color.WHITE);
        botaoFechar.setFocusPainted(false);

        botaoFechar.addActionListener(e -> {
            interfaceExtrato.dispose();
            interfaceExtrato = null;
        });

        painel.add(botaoFechar);

        // CONFIGURAÇÃO DA JANELA
        interfaceExtrato.setContentPane(painel);
        interfaceExtrato.setSize(480, 570);
        interfaceExtrato.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        interfaceExtrato.setLocationRelativeTo(null);
        interfaceExtrato.setResizable(false);
        interfaceExtrato.setVisible(true);
    }
}