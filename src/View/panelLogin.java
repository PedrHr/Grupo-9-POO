package View;

import Controller.clienteController;
import Model.Cliente;
import java.awt.*;
import javax.swing.*;

public class panelLogin extends JFrame {

    private JTextField email;
    private JPasswordField senha;

    // avisos de erro em vermelho
    private JLabel erroEmail;
    private JLabel erroSenha;

    public panelLogin() {

        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // painel centralizado pra alinhar os campos verticalmente no meio
        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));

        // email
        JLabel labelEmail = new JLabel("E-mail:");
        labelEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        email = new JTextField(20);
        email.setMaximumSize(new Dimension(160, 30));
        erroEmail = criarLabelErro();
        JPanel boxEmail = criarBoxCampo(labelEmail, email, erroEmail);

        // senha e olho
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

        // espaçador em cima pra empurrar pro centro
        painelCentral.add(Box.createVerticalGlue());
        painelCentral.add(boxEmail);
        painelCentral.add(Box.createRigidArea(new Dimension(0, 10)));
        painelCentral.add(boxSenha);
        painelCentral.add(Box.createVerticalGlue());

        // botoes entrar e cancelar
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        JButton btnEntrar = new JButton("Entrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnEntrar.setPreferredSize(new Dimension(170, 35));
        btnCancelar.setPreferredSize(new Dimension(170, 35));

        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnCancelar);

        // BOTÃO CANCELAR: Atua como o login temporário
        btnCancelar.addActionListener(e -> {
            limparErros();

            String emailLogin = email.getText().trim();
            String senhaLogin = new String(senha.getPassword()).trim();

            // Campos vazios
            if (emailLogin.isEmpty() || senhaLogin.isEmpty()) {
                if (emailLogin.isEmpty()) {
                    erroEmail.setText("Preencha o e-mail");
                }
                if (senhaLogin.isEmpty()) {
                    erroSenha.setText("Preencha a senha");
                }
            } else {
                // Validação temporária das credenciais
                if (emailLogin.equalsIgnoreCase("samuel@gmail.com") && senhaLogin.equals("senhalouca")) {
                    dispose();
                    panelConta.exibir();
                } else {
                    // Exibe a MESMA mensagem genérica embaixo de ambos os campos
                    erroEmail.setText("E-mail ou senha incorretos");
                    erroSenha.setText("E-mail ou senha incorretos");
                }
            }
        });

        // AÇÃO DO BOTÃO ENTRAR (Mantida com a verificação padrão do controller/banco)
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
                clienteController buscarCliente = new clienteController();
                Cliente cliente = buscarCliente.buscarCliente(emailLogin, senhaLogin);
                if (cliente != null) {
                    dispose();
                    panelConta.exibir();
                } else {
                    erroEmail.setText("E-mail ou senha incorretos");
                    erroSenha.setText("E-mail ou senha incorretos");
                }
            }
        });

        painelPrincipal.add(painelCentral, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal);

        setSize(480, 630);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // monta label de erro
    private JLabel criarLabelErro() {
        JLabel label = new JLabel(" ");
        label.setForeground(Color.RED);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        return label;
    }

    // junta label, campo e erro na vertical (tudo centralizado)
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

    // reseta avisos
    private void limparErros() {
        erroEmail.setText(" ");
        erroSenha.setText(" ");
    }

    public static void main(String[] args) {
        new panelLogin();
    }
}