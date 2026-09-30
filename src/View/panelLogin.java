package View;

import Controller.clienteController;
import Model.Cliente;
import Model.Conta;
import Model.contaCorrente;
import Model.contaPoupanca;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class panelLogin extends JFrame {

    private JTextField email;
    private JPasswordField senha;

    //avisos de erro
    private JLabel erroEmail;
    private JLabel erroSenha;

    public panelLogin() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        //titulo da tela
        JLabel tituloLogin = new JLabel("LOGIN");
        tituloLogin.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLogin.setForeground(new Color(20, 55, 100));
        tituloLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        //painel do centro
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));

        //campo email
        JLabel labelEmail = new JLabel("E-mail:");
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        email = new JTextField(20);
        email.setMaximumSize(new Dimension(160, 30));
        erroEmail = criarLabelErro();
        JPanel boxEmail = criarBoxCampo(labelEmail, email, erroEmail);

        //campo senha
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
        senha = new JPasswordField(16);
        senha.setMaximumSize(new Dimension(300, 30));

        char echoCharPadrao = senha.getEchoChar();
        JToggleButton btnMostrarSenha = new JToggleButton("👁");
        btnMostrarSenha.setToolTipText("Mostrar/Ocultar Senha");
        btnMostrarSenha.setFocusable(false);
        btnMostrarSenha.setMargin(new Insets(2, 5, 2, 5));

        btnMostrarSenha.addActionListener(e -> {
            if (btnMostrarSenha.isSelected()) {
                senha.setEchoChar((char) 0);
            } else {
                senha.setEchoChar(echoCharPadrao);
            }
        });

        JPanel painelSenhaInput = new JPanel(new BorderLayout(5, 0));
        painelSenhaInput.setMaximumSize(new Dimension(160, 30));
        painelSenhaInput.add(senha, BorderLayout.CENTER);
        painelSenhaInput.add(btnMostrarSenha, BorderLayout.EAST);

        erroSenha = criarLabelErro();
        JPanel boxSenha = criarBoxCampo(labelSenha, painelSenhaInput, erroSenha);

        //link de registro
        JLabel lblRegistro = new JLabel("<html><u>Não tem conta? Crie a sua aqui.</u></html>", SwingConstants.CENTER);
        lblRegistro.setForeground(new Color(0, 102, 204));
        lblRegistro.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblRegistro.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                //abre tela de registro
                new panelRegistro();
            }
        });


        //espaçadores e organizacao dos campos
        painelCentral.add(Box.createVerticalGlue());
        painelCentral.add(tituloLogin);
        painelCentral.add(Box.createRigidArea(new Dimension(0, 20)));
        painelCentral.add(boxEmail);
        painelCentral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelCentral.add(boxSenha);
        painelCentral.add(Box.createVerticalGlue());

        //botoes
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton btnEntrar = new JButton("Entrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnEntrar.setPreferredSize(new Dimension(170, 35));
        btnCancelar.setPreferredSize(new Dimension(170, 35));

        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnCancelar);

        //painel inferior agrupando link e botoes
        JPanel painelSul = new JPanel(new BorderLayout(0, 10));
        painelSul.add(lblRegistro, BorderLayout.NORTH);
        painelSul.add(painelBotoes, BorderLayout.SOUTH);

        //acao do botao cancelar
        btnCancelar.addActionListener(e -> System.exit(0));

        //acao do botao entrar
        btnEntrar.addActionListener(e -> {
            limparErros();

            String emailLogin = email.getText().trim();
            String senhaLogin = new String(senha.getPassword()).trim();

            if (emailLogin.isEmpty() || senhaLogin.isEmpty()) {
                if (emailLogin.isEmpty()) {
                    erroEmail.setText("Preencha o e-mail");
                }
                if (senhaLogin.isEmpty()) {
                    erroSenha.setText("Preencha a senha");
                }
            } else {
                //validacao no banco
                clienteController controllCliente = new clienteController();
                Cliente cliente = controllCliente.buscarCliente(emailLogin, senhaLogin);

                if (cliente == null) {
                    JOptionPane.showMessageDialog(null, "Senha ou email incorretos");
                } else {
                    Conta conta = controllCliente.buscarContaCliente(cliente);

                    if (cliente != null && conta.getTipoConta() == Conta.TipoConta.CORRENTE) {
                        dispose();
                        contaCorrente contaC = (contaCorrente) conta;
                        panelConta.exibir(cliente, contaC);
                        JOptionPane.showMessageDialog(null, "Seja bem vindo a sua conta");
                    } else if (cliente != null && conta.getTipoConta() == Conta.TipoConta.POUPANCA) {
                        contaPoupanca contaP = (contaPoupanca) conta;
                        setVisible(false);

                        panelPoupanca.exibir(cliente, contaP);
                        JOptionPane.showMessageDialog(null, "Seja bem vindo a sua conta");
                    }
                }
            }
        });

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        painelPrincipal.add(painelSul, BorderLayout.SOUTH);

        add(painelPrincipal);

        setSize(480, 630);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //monta label de erro
    private JLabel criarLabelErro() {
        JLabel label = new JLabel(" ");
        label.setForeground(Color.RED);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    //junta componentes do campo
    private JPanel criarBoxCampo(JLabel label, JComponent campo, JLabel labelErro) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        campo.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelErro.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(label);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(campo);
        panel.add(labelErro);

        return panel;
    }

    //reseta mensagens de erro
    private void limparErros() {
        erroEmail.setText(" ");
        erroSenha.setText(" ");
    }

    public static void main(String[] args) {
        new panelLogin();
    }
}