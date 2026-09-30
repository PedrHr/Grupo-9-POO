package View;

import Controller.contaCorrenteController;
import Controller.contaPoupancaController;
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

            JTextField campoTaxaRendimento = new JTextField(String.valueOf(contaP.getTaxaRendimento()));
            campoTaxaRendimento.setBounds(160, 168, 250, 30);
            campoTaxaRendimento.setEditable(false);
            campoTaxaRendimento.setBackground(new Color(225, 230, 238));
            campoTaxaRendimento.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoTaxaRendimento);

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

            JButton btnSacar = new JButton("Sacar Valor");
            btnSacar.setBounds(40, 460, 250, 20);
            btnSacar.setFont(new Font("Arial", Font.BOLD, 14));
            btnSacar.setBackground(new Color(20, 55, 100));
            btnSacar.setForeground(Color.WHITE);
            btnSacar.setFocusPainted(false);
            painel.add(btnSacar);


            botaoEnviarDeposito.addActionListener(e -> {
                double Deposito = Double.parseDouble(campoDepositar.getText());
                contaP.depositarValor(Deposito);

                contaPoupancaController controllPoupanca = new contaPoupancaController();
                String mensagemSucess = controllPoupanca.inserirDeposito(contaP);

                JOptionPane.showMessageDialog(null, mensagemSucess);

                interfaceConta.dispose();
                interfaceConta = null;
                exibir(cliente, contaP);
            });

            btnSacar.addActionListener(e -> {
                double Saque = Double.parseDouble(campoSacar.getText());
                String msgSaque = contaP.sacarValor(Saque);

                contaPoupancaController controllP = new contaPoupancaController();
                String mensagemSaque = controllP.sacarValor(contaP);

                JOptionPane.showMessageDialog(null, msgSaque);

                interfaceConta.dispose();
                interfaceConta = null;
                exibir(cliente, contaP);
            });


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
