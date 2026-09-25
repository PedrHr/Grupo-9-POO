package View;

import javax.swing.*;
import java.awt.*;

public class mainRegistro extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField telefone;
    private JTextField email;
    private JPasswordField senha;

    // Construtor
    public mainRegistro() {

        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel
        JPanel painel = new JPanel(new GridLayout(6, 2, 10, 15));

        // Adiciona margem
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // NOME
        JLabel labelNome = new JLabel("Nome:");
        nome = new JTextField(16);

        // CPF
        JLabel labelCpf = new JLabel("CPF:");
        cpf = new JTextField(16);

        // TELEFONE
        JLabel labelTelefone = new JLabel("Telefone:");
        telefone = new JTextField(16);

        // EMAIL
        JLabel labelEmail = new JLabel("E-mail:");
        email = new JTextField(16);

        // SENHA
        JLabel labelSenha = new JLabel("Senha:");
        senha = new JPasswordField(16);

        // Adicionar ao painel
        painel.add(labelNome);
        painel.add(nome);

        painel.add(labelCpf);
        painel.add(cpf);

        painel.add(labelTelefone);
        painel.add(telefone);

        painel.add(labelEmail);
        painel.add(email);

        painel.add(labelSenha);
        painel.add(senha);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        btnCadastrar.addActionListener(e -> {

            String nomeCliente = nome.getText();

            if (nomeCliente.trim().isEmpty()) {

                JOptionPane.showMessageDialog(this, "Preencha o nome!");

            } else {

                JOptionPane.showMessageDialog(
                    this,
                    "Cliente " + nomeCliente + " cadastrado com sucesso!"
                );
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        painel.add(btnCadastrar);
        painel.add(btnCancelar);

        add(painel);

        // Definir tamanho fixo
        setSize(500, 400);

        // Centralizar a janela
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {

        new mainRegistro();
    }
}