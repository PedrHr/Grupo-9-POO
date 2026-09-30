package View;

import Model.Cliente;
import Model.Conta;

import java.awt.*;
import javax.swing.*;

public class panelExtrato {

    static JFrame interfaceExtrato;

    public static void exibir(Cliente cliente, Conta conta) {
        if (interfaceExtrato == null) {
            interfaceExtrato = new JFrame("Extrato");

            // PAINEL PRINCIPAL
            JPanel painel = new JPanel();
            painel.setLayout(null);
            painel.setBackground(new Color(240, 243, 248));

            // INFORMAÇÕES DO EXTRATO
            JLabel titulo = new JLabel("EXTRATO");
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

            // OPERAÇÕES
            JLabel tituloOperacoes = new JLabel("MOVIMENTAÇÕES");
            tituloOperacoes.setBounds(40, 125, 300, 30);
            tituloOperacoes.setFont(new Font("Arial", Font.BOLD, 18));
            tituloOperacoes.setForeground(new Color(30, 60, 100));
            painel.add(tituloOperacoes);

            JLabel labelValor = new JLabel("Valor:");
            labelValor.setBounds(40, 175, 120, 25);
            labelValor.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelValor);

            JTextField campoValor = new JTextField();
            campoValor.setBounds(160, 173, 250, 30);
            campoValor.setEditable(false);
            campoValor.setBackground(new Color(225, 230, 238));
            campoValor.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoValor);

            JLabel labelDe = new JLabel("De:");
            labelDe.setBounds(40, 220, 120, 25);
            labelDe.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelDe);

            JTextField campoDe = new JTextField();
            campoDe.setBounds(160, 218, 250, 30);
            campoDe.setEditable(false);
            campoDe.setBackground(new Color(225, 230, 238));
            campoDe.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoDe);

            JLabel labelPara = new JLabel("Para:");
            labelPara.setBounds(40, 265, 120, 25);
            labelPara.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelPara);

            JTextField campoPara = new JTextField();
            campoPara.setBounds(160, 263, 250, 30);
            campoPara.setEditable(false);
            campoPara.setBackground(new Color(225, 230, 238));
            campoPara.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoPara);

            JLabel labelData = new JLabel("Data:");
            labelData.setBounds(40, 310, 120, 25);
            labelData.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelData);

            JTextField campoData = new JTextField();
            campoData.setBounds(160, 308, 250, 30);
            campoData.setEditable(false);
            campoData.setBackground(new Color(225, 230, 238));
            campoData.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoData);

            JLabel labelStatus = new JLabel("Status:");
            labelStatus.setBounds(40, 355, 120, 25);
            labelStatus.setFont(new Font("Arial", Font.BOLD, 14));
            painel.add(labelStatus);

            JTextField campoStatus = new JTextField();
            campoStatus.setBounds(160, 353, 250, 30);
            campoStatus.setEditable(false);
            campoStatus.setBackground(new Color(225, 230, 238));
            campoStatus.setFont(new Font("Arial", Font.PLAIN, 14));
            painel.add(campoStatus);

            // CONFIGURAÇÃO DA JANELA
            interfaceExtrato.setContentPane(painel);
            interfaceExtrato.setSize(480, 470);
            interfaceExtrato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            interfaceExtrato.setLocationRelativeTo(null);
            interfaceExtrato.setResizable(false);
        }

        interfaceExtrato.setVisible(true);
    }

}
