package View;

import Model.Cliente;
import Model.Conta;
import Model.contaCorrente;

import java.awt.*;
import javax.swing.*;

public class panelConta {

    static JFrame interfaceConta;

    public static void exibir(Cliente cliente, contaCorrente ContaCorrente) {
        if (interfaceConta == null) {
            interfaceConta = new JFrame("Conta Corrente");

            // PAINEL PRINCIPAL
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(new Color(240, 243, 248));

            // INFORMAÇÕES DA CONTA
            JLabel titulo = new JLabel("MINHA CONTA");
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
            campoUsuario.setText(cliente.getNome());
            painel.add(campoUsuario);

            JLabel labelSaldo = new JLabel("Saldo:");
            labelSaldo.setBounds(40, 125, 120, 25);
            labelSaldo.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelSaldo);

            JTextField campoSaldo = new JTextField(String.valueOf(ContaCorrente.getSaldoAtual()));
            campoSaldo.setBounds(160, 123, 250, 30);
            campoSaldo.setEditable(false);
            campoSaldo.setBackground(new Color(225, 230, 238));
            campoSaldo.setFont(new Font("Arial", Font.PLAIN, 14));

            painel.add(campoSaldo);

            JLabel labelLimite = new JLabel("Limite crédito:");
            labelLimite.setBounds(40, 170, 120, 25);
            labelLimite.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelLimite);

            JTextField campoLimiteCredito = new JTextField(String.valueOf(ContaCorrente.getLimiteCredito()));
            campoLimiteCredito.setBounds(160, 168, 250, 30);
            campoLimiteCredito.setEditable(false);
            campoLimiteCredito.setBackground(new Color(225, 230, 238));
            campoLimiteCredito.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoLimiteCredito);

            JLabel labelChave = new JLabel("Chave Transação:");
            labelChave.setBounds(40, 215, 120, 25);
            labelChave.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelChave);

            JTextField campoChaveTransacao = new JTextField();
            campoChaveTransacao.setBounds(160, 213, 250, 30);
            campoChaveTransacao.setEditable(false);
            campoChaveTransacao.setBackground(new Color(225, 230, 238));
            campoChaveTransacao.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoChaveTransacao);

            // OPERAÇÕES
            JLabel tituloOperacoes = new JLabel("OPERAÇÕES");
            tituloOperacoes.setBounds(40, 265, 300, 30);
            tituloOperacoes.setFont(new Font("Arial", Font.BOLD, 18));
            tituloOperacoes.setForeground(new Color(30, 60, 100));
            painel.add(tituloOperacoes);

            JLabel labelDepositar = new JLabel("Depositar:");
            labelDepositar.setBounds(40, 315, 120, 25);
            labelDepositar.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelDepositar);

            JTextField campoDepositar = new JTextField();
            campoDepositar.setBounds(160, 313, 250, 30);
            campoDepositar.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoDepositar);

            JLabel labelSacar = new JLabel("Sacar:");
            labelSacar.setBounds(40, 360, 120, 25);
            labelSacar.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelSacar);

            JTextField campoSacar = new JTextField();
            campoSacar.setBounds(160, 358, 250, 30);
            campoSacar.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoSacar);

            // BOTÕES
            JButton botaoGerarChave = new JButton("Gerar chave transação");
            botaoGerarChave.setBounds(40, 420, 370, 40);
            botaoGerarChave.setFont(new Font("Arial", Font.BOLD, 14));
            botaoGerarChave.setBackground(new Color(20, 55, 100));
            botaoGerarChave.setForeground(Color.WHITE);
            botaoGerarChave.setFocusPainted(false);
            painel.add(botaoGerarChave);

            JButton botaoRealizarTransacao = new JButton("Realizar transação");
            botaoRealizarTransacao.setBounds(40, 470, 370, 40);
            botaoRealizarTransacao.setFont(new Font("Arial", Font.BOLD, 14));
            botaoRealizarTransacao.setBackground(new Color(20, 55, 100));
            botaoRealizarTransacao.setForeground(Color.WHITE);
            botaoRealizarTransacao.setFocusPainted(false);
            painel.add(botaoRealizarTransacao);

            // AÇÃO DO BOTÃO REALIZAR TRANSAÇÃO (Abre a tela mantendo a atual aberta)
            botaoRealizarTransacao.addActionListener(e -> {
                new panelTransacao(interfaceConta).setVisible(true);
            });

            JButton botaoVerExtrato = new JButton("Ver extrato");
            botaoVerExtrato.setBounds(40, 520, 370, 40);
            botaoVerExtrato.setFont(new Font("Arial", Font.BOLD, 14));
            botaoVerExtrato.setBackground(new Color(20, 55, 100));
            botaoVerExtrato.setForeground(Color.WHITE);
            botaoVerExtrato.setFocusPainted(false);
            painel.add(botaoVerExtrato);

            // CONFIGURAÇÃO DA JANELA
            interfaceConta.setContentPane(painel);
            interfaceConta.setSize(480, 630);
            interfaceConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaceConta.setLocationRelativeTo(null);
            interfaceConta.setResizable(false);
        }

        interfaceConta.setVisible(true);
    }


}