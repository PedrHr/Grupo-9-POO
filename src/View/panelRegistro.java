package View;

import Controller.exceptionsController;
import Model.Cliente;
import Controller.clienteController;
import javax.swing.*;
import java.awt.*;

public class panelRegistro extends JFrame {

    static private JTextField nome;
    static private JTextField cpf;
    static private JTextField endereco;
    static private JTextField email;
    static private JPasswordField senha;


    // Construtor
    public panelRegistro() {

        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel
        JPanel painel = new JPanel(new GridLayout(8, 2, 10, 15));

        // Adiciona margem
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // NOME
        JLabel labelNome = new JLabel("Nome:");
        nome = new JTextField(16);

        // CPF
        JLabel labelCpf = new JLabel("CPF:");
        cpf = new JTextField(16);

        // ENDEREÇO
        JLabel labelEndereco = new JLabel("Endereço:");
        endereco = new JTextField(16);

        // EMAIL
        JLabel labelEmail = new JLabel("E-mail:");
        email = new JTextField(16);

        // SENHA
        JLabel labelSenha = new JLabel("Senha:");
        senha = new JPasswordField(16);

        JLabel labelVazio = new JLabel("");
        // Label tipo conta
        JLabel labelTipoConta = new JLabel("Tipo de conta:");

        JRadioButton contaCorrente = new JRadioButton("Conta Corrente");
        JRadioButton contaPoupanca = new JRadioButton("Conta Poupança");


        // Grupo para permitir apenas uma opção
        ButtonGroup grupoConta = new ButtonGroup();
        grupoConta.add(contaCorrente);
        grupoConta.add(contaPoupanca);

        // Adicionar ao painel
        painel.add(labelNome);
        painel.add(nome);

        painel.add(labelCpf);
        painel.add(cpf);

        painel.add(labelEndereco);
        painel.add(endereco);

        painel.add(labelEmail);
        painel.add(email);

        painel.add(labelSenha);
        painel.add(senha);

        painel.add(labelTipoConta);
        painel.add(contaCorrente);

        painel.add(labelVazio);
        painel.add(contaPoupanca);

        // Botões
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");


        btnCadastrar.addActionListener(e -> {

                    String nomeCliente = nome.getText();
                    String cpfCliente = cpf.getText();
                    String enderecoCliente = endereco.getText();
                    String emailCliente = email.getText();
                    String senhaCliente = new String(senha.getPassword());

                // VERFICANDO SE OS CAMPOS ESTÃO PREENCHIDOS
            if (nomeCliente.trim().isEmpty() || cpfCliente.trim().isEmpty() || enderecoCliente.trim().isEmpty() || emailCliente.trim().isEmpty() || senhaCliente.trim().isEmpty()) {

                // CHAAMANDO A CLASSE DE EXCEÇÕES DE CAMPOS VAZIOS COM SUA MENSAGEM
                JOptionPane.showMessageDialog(this, exceptionsController.camposVazios());

            } else {

                // CRIANDO UM NOVO OBJETO CLIENTE E CHAMANDO O CONTROLLER PARA CADASTRA-LO
                Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente, emailCliente, senhaCliente);
                clienteController cadastrarCliente = new clienteController();
                cadastrarCliente.inserirCliente(cliente);

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

        new panelRegistro();




    }


}