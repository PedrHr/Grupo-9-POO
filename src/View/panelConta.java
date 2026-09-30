package View;

import Controller.contaCorrenteController;
import Model.Cliente;
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

            JTextField campoChaveTransacao = new JTextField(String.valueOf(ContaCorrente.getChaveTransacao()));
            campoChaveTransacao.setBounds(160, 213, 250, 30);
            campoChaveTransacao.setEditable(false);
            campoChaveTransacao.setBackground(new Color(225, 230, 238));
            campoChaveTransacao.setFont(new Font("Arial", Font.PLAIN, 14));
            campoSaldo.setEditable(false);
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


            JButton botaoEnviarDeposito = new JButton("Enviar deposito");
            botaoEnviarDeposito.setBounds(40, 360, 250, 20);
            botaoEnviarDeposito.setFont(new Font("Arial", Font.BOLD, 14));
            botaoEnviarDeposito.setBackground(new Color(20, 55, 100));
            botaoEnviarDeposito.setForeground(Color.WHITE);
            botaoEnviarDeposito.setFocusPainted(false);
            painel.add(botaoEnviarDeposito);


            JLabel labelSacar = new JLabel("Sacar:");
            labelSacar.setBounds(40, 420, 120, 25);
            labelSacar.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelSacar);

            JTextField campoSacar = new JTextField();
            campoSacar.setBounds(160, 418, 250, 30);
            campoSacar.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoSacar);

            // BOTÕES

            JButton btnSacar = new JButton("Sacar Valor");
            btnSacar.setBounds(40, 460, 250, 20);
            btnSacar.setFont(new Font("Arial", Font.BOLD, 14));
            btnSacar.setBackground(new Color(20, 55, 100));
            btnSacar.setForeground(Color.WHITE);
            btnSacar.setFocusPainted(false);
            painel.add(btnSacar);

            JLabel tituloOpcoes = new JLabel("OPÇÕES");
            tituloOpcoes.setBounds(40, 530, 200, 30);
            tituloOpcoes.setFont(new Font("Arial", Font.BOLD, 18));
            tituloOpcoes.setForeground(new Color(30, 60, 100));
            painel.add(tituloOpcoes);

            JButton botaoGerarChave = new JButton("Gerar Chave Transação");
            botaoGerarChave.setBounds(40, 570, 370, 40);
            botaoGerarChave.setFont(new Font("Arial", Font.BOLD, 14));
            botaoGerarChave.setBackground(new Color(20, 55, 100));
            botaoGerarChave.setForeground(Color.WHITE);
            botaoGerarChave.setFocusPainted(false);
            painel.add(botaoGerarChave);

            JButton botaoRealizarTransacao = new JButton("Realizar Transação");
            botaoRealizarTransacao.setBounds(40, 620, 370, 40);
            botaoRealizarTransacao.setFont(new Font("Arial", Font.BOLD, 14));
            botaoRealizarTransacao.setBackground(new Color(20, 55, 100));
            botaoRealizarTransacao.setForeground(Color.WHITE);
            botaoRealizarTransacao.setFocusPainted(false);
            painel.add(botaoRealizarTransacao);

            JButton botaoVerExtrato = new JButton("Ver Extrato");
            botaoVerExtrato.setBounds(40, 680, 370, 40);
            botaoVerExtrato.setFont(new Font("Arial", Font.BOLD, 14));
            botaoVerExtrato.setBackground(new Color(20, 55, 100));
            botaoVerExtrato.setForeground(Color.WHITE);
            botaoVerExtrato.setFocusPainted(false);
            painel.add(botaoVerExtrato);

            //AÇÔES DE BOTÕES
            // AÇÃO DO BOTÃO REALIZAR TRANSAÇÃO (Abre a tela mantendo a atual aberta)
            botaoRealizarTransacao.addActionListener(e -> {
                new panelTransacao(interfaceConta, ContaCorrente).setVisible(true);


            });

            botaoEnviarDeposito.addActionListener(e -> {
                double Deposito = Double.parseDouble(campoDepositar.getText());
                ContaCorrente.depositarValor(Deposito);

                contaCorrenteController controllCorrente = new contaCorrenteController();
                String mensagemSucess = controllCorrente.inserirDeposito(ContaCorrente);

                JOptionPane.showMessageDialog(null, mensagemSucess);

                interfaceConta.dispose();
                interfaceConta = null;
                exibir(cliente, ContaCorrente);
            });

            btnSacar.addActionListener(e -> {
                double Saque = Double.parseDouble(campoSacar.getText());
                String msgSaque = ContaCorrente.sacarValor(Saque);
                contaCorrenteController controllCorrente = new contaCorrenteController();
                String mensagemSaque = controllCorrente.sacarValor(ContaCorrente);

                JOptionPane.showMessageDialog(null, msgSaque);

                interfaceConta.dispose();
                interfaceConta = null;
                exibir(cliente, ContaCorrente);
            });

            botaoGerarChave.addActionListener(e -> {

                long chave = ContaCorrente.gerarChaveTransacao();
                contaCorrenteController controllerCorrente = new contaCorrenteController();
                String msgChave = controllerCorrente.adicionarChaveTransacao(ContaCorrente);

                JOptionPane.showMessageDialog(null, msgChave);

                interfaceConta.dispose();
                interfaceConta = null;
                exibir(cliente, ContaCorrente);
            });


            // CONFIGURAÇÃO DA JANELA
            interfaceConta.setContentPane(painel);
            interfaceConta.setSize(580, 820);
            interfaceConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaceConta.setLocationRelativeTo(null);
            interfaceConta.setResizable(false);
        }

        interfaceConta.setVisible(true);
    }


}