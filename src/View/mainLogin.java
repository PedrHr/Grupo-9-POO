package View;

import Model.Cliente;
import Controller.clienteController;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class mainLogin extends JFrame {

    private JTextField email;
    private JPasswordField senha;

    public mainLogin() {

        setTitle("Login");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 15));

        painel.setBorder(
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // EMAIL
        JLabel labelEmail = new JLabel("E-mail:");
        email = new JTextField(16);

        // SENHA
        JLabel labelSenha = new JLabel("Senha:");
        senha = new JPasswordField(16);

        // PAINEL
        painel.add(labelEmail);
        painel.add(email);

        painel.add(labelSenha);
        painel.add(senha);

        // BOTÕES
        JButton btnEntrar = new JButton("Entrar");
        JButton btnCancelar = new JButton("Cancelar");

        // BOTÃO CANCELAR
        btnCancelar.addActionListener(e -> dispose());

        // BOTÃO ENTRAR
        btnEntrar.addActionListener(e -> {

            String emailLogin = email.getText();


            String senhaLogin = new String(senha.getPassword());
            if (emailLogin.trim().isEmpty() || senhaLogin.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Preencha os devidos campos para realizar o login"
                );

            } else {

                clienteController buscarCliente = new clienteController();

                Cliente cliente = buscarCliente.buscarCliente(emailLogin, senhaLogin);

                JOptionPane.showMessageDialog(
                    this, "Usuario: "+cliente.getNome() +" Logado com sucesso!"

                );

            }
        });


        painel.add(btnEntrar);
        painel.add(btnCancelar);

        add(painel);

        setSize(500, 300);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {


        new mainLogin();
    }
}