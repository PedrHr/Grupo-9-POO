package View;

import Model.Cliente;
import Model.Conta;
import Model.contaPoupanca;

import java.awt.*;
import javax.swing.*;

public class panelPoupanca {

    static JFrame interfaceConta;

    public static void exibir(Cliente cliente, contaPoupanca contaP) {
        if (interfaceConta == null) {
            interfaceConta = new JFrame("Conta Poupança");

            // PAINEL PRINCIPAL
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(new Color(240, 243, 248));

            // INFORMAÇÕES DA CONTA
            JLabel titulo = new JLabel("CONTA POUPANÇA");
            titulo.setBounds(30, 20, 400, 35);
            titulo.setFont(new Font("Arial", Font.BOLD, 24));
            titulo.setForeground(new Color(30, 60, 100));
            painel.add(titulo);

            JLabel labelUsuario = new JLabel("Usuário:");
            labelUsuario.setBounds(40, 80, 120, 25);
            labelUsuario.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelUsuario);

            JTextField campoUsuario = new JTextField(cliente.getNome());
            campoUsuario.setBounds(160, 78, 250, 30);
            campoUsuario.setEditable(false);
            campoUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoUsuario);

            JLabel labelSaldo = new JLabel("Saldo:");
            labelSaldo.setBounds(40, 125, 120, 25);
            labelSaldo.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelSaldo);

            JTextField campoSaldo = new JTextField(String.valueOf(contaP.getSaldoAtual()));
            campoSaldo.setBounds(160, 123, 250, 30);
            campoSaldo.setEditable(false);
            campoSaldo.setBackground(new Color(225, 230, 238));
            campoSaldo.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoSaldo);

            JLabel labelTaxaRendimento = new JLabel("Taxa rendimento:");
            labelTaxaRendimento.setBounds(40, 170, 120, 25);
            labelTaxaRendimento.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelTaxaRendimento);

            JTextField campoTaxaRendimento = new JTextField(String.valueOf(contaP.getTaxaRendimento())+"(10% ao mês)");
            campoTaxaRendimento.setBounds(160, 168, 250, 30);
            campoTaxaRendimento.setEditable(false);
            campoTaxaRendimento.setBackground(new Color(225, 230, 238));
            campoTaxaRendimento.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoTaxaRendimento);

            // OPERAÇÕES
            JLabel tituloOperacoes = new JLabel("OPERAÇÕES");
            tituloOperacoes.setBounds(40, 215, 300, 30);
            tituloOperacoes.setFont(new Font("Arial", Font.BOLD, 18));
            tituloOperacoes.setForeground(new Color(30, 60, 100));
            painel.add(tituloOperacoes);

            JLabel labelDepositar = new JLabel("Depositar:");
            labelDepositar.setBounds(40, 265, 120, 25);
            labelDepositar.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelDepositar);

            JTextField campoDepositar = new JTextField();
            campoDepositar.setBounds(160, 263, 250, 30);
            campoDepositar.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoDepositar);

            JLabel labelSacar = new JLabel("Sacar:");
            labelSacar.setBounds(40, 310, 120, 25);
            labelSacar.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelSacar);

            JTextField campoSacar = new JTextField();
            campoSacar.setBounds(160, 308, 250, 30);
            campoSacar.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoSacar);

            // BOTÕES
            JButton botaoDepositar = new JButton("Depositar");
            botaoDepositar.setBounds(40, 360, 370, 40);
            botaoDepositar.setFont(new Font("Arial", Font.BOLD, 14));
            botaoDepositar.setBackground(new Color(20, 55, 100));
            botaoDepositar.setForeground(Color.WHITE);
            botaoDepositar.setFocusPainted(false);
            painel.add(botaoDepositar);

            JButton botaoSacar = new JButton("Sacar");
            botaoSacar.setBounds(40, 410, 370, 40);
            botaoSacar.setFont(new Font("Arial", Font.BOLD, 14));
            botaoSacar.setBackground(new Color(20, 55, 100));
            botaoSacar.setForeground(Color.WHITE);
            botaoSacar.setFocusPainted(false);
            painel.add(botaoSacar);


            // CONFIGURAÇÃO DA JANELA
            interfaceConta.setContentPane(painel);
            interfaceConta.setSize(480, 570);
            interfaceConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaceConta.setLocationRelativeTo(null);
            interfaceConta.setResizable(false);
        }

        interfaceConta.setVisible(true);
    }

}
