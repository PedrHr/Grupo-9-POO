package View;

import Controller.clienteController;
import Model.Cliente;
import Model.Conta;
import Model.contaCorrente;
import Model.contaPoupanca;
import ModelDAO.contaDAO;

import javax.swing.*;
import java.awt.*;

public class panelRegistro extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField endereco;
    private JTextField email;
    private JPasswordField senha;

    // Avisos de erro em vermelho
    private JLabel erroNome;
    private JLabel erroCpf;
    private JLabel erroEndereco;
    private JLabel erroEmail;
    private JLabel erroSenha;

    // Radio buttons da conta
    private JRadioButton radioCorrente;
    private JRadioButton radioPoupanca;
    private ButtonGroup grupoConta;

    public panelRegistro() {

        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        // Grade dos campos
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 10, 10));

        // Definindo campo nome

        JLabel labelNome = new JLabel("Nome:");
        nome = new JTextField(16);
        erroNome = criarLabelErro();

        JPanel boxNome = criarBoxCampo(nome, erroNome);

        painelCampos.add(labelNome);
        painelCampos.add(boxNome);

        // Definindo campo cpf

        JLabel labelCpf = new JLabel("CPF:");
        cpf = new JTextField(16);
        erroCpf = criarLabelErro();

        JPanel boxCpf = criarBoxCampo(cpf, erroCpf);

        painelCampos.add(labelCpf);
        painelCampos.add(boxCpf);

        // Definindo campo endereco

        JLabel labelEndereco = new JLabel("Endereço:");
        endereco = new JTextField(16);
        erroEndereco = criarLabelErro();

        JPanel boxEndereco = criarBoxCampo(endereco, erroEndereco);

        painelCampos.add(labelEndereco);
        painelCampos.add(boxEndereco);


        // Definindo campo email


        JLabel labelEmail = new JLabel("E-mail:");
        email = new JTextField(16);
        erroEmail = criarLabelErro();

        JPanel boxEmail = criarBoxCampo(email, erroEmail);

        painelCampos.add(labelEmail);
        painelCampos.add(boxEmail);

        JLabel labelSenha = new JLabel("Senha:");

        senha = new JPasswordField(12);

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
        painelSenhaInput.add(senha, BorderLayout.CENTER);
        painelSenhaInput.add(btnMostrarSenha, BorderLayout.EAST);

        erroSenha = criarLabelErro();

        JPanel boxSenha = criarBoxCampo(
                painelSenhaInput,
                erroSenha
        );

        painelCampos.add(labelSenha);
        painelCampos.add(boxSenha);


        // Tipo de conta


        radioCorrente = new JRadioButton(
                "Conta Corrente",
                true
        );

        radioPoupanca = new JRadioButton(
                "Conta Poupança"
        );

        grupoConta = new ButtonGroup();
        grupoConta.add(radioCorrente);
        grupoConta.add(radioPoupanca);

        JPanel painelRadio = new JPanel(
                new FlowLayout(
                        FlowLayout.CENTER,
                        20,
                        5
                )
        );

        painelRadio.add(radioCorrente);
        painelRadio.add(radioPoupanca);

        JPanel painelBotoes = new JPanel(
                new GridLayout(1, 2, 10, 0)
        );

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnCancelar);

        JPanel painelSul = new JPanel(new BorderLayout(0, 10));

        painelSul.add(painelRadio, BorderLayout.NORTH);
        painelSul.add(painelBotoes, BorderLayout.SOUTH);


        // Mntando a tela


        painelPrincipal.add(painelCampos, BorderLayout.NORTH);

        painelPrincipal.add(painelSul, BorderLayout.SOUTH);

      // Ação do contao de cadastrar

        btnCadastrar.addActionListener(e -> {

            // Limpa mensagens antigas
            limparErros();

            // Pega os valores
            String nomeCliente = nome.getText().trim();
            String cpfCliente = cpf.getText().trim();
            String enderecoCliente = endereco.getText().trim();
            String emailCliente = email.getText().trim();
            String senhaCliente = new String(
                    senha.getPassword()
            ).trim();

            boolean temErro = false;

            if (nomeCliente.isEmpty()) {

                erroNome.setText("Preencha o nome");
                temErro = true;

            } else if (nomeCliente.matches(".*\\d.*")) {

                erroNome.setText(
                        "O nome não pode conter números"
                );
                temErro = true;

            } else if (nomeCliente.split("\\s+").length < 2) {

                erroNome.setText(
                        "Informe ao menos nome e sobrenome"
                );
                temErro = true;
            }


            if (cpfCliente.isEmpty()) {

                erroCpf.setText("Preencha o CPF");
                temErro = true;

            } else if (cpfCliente.matches(".*[a-zA-Z].*")) {

                erroCpf.setText(
                        "O CPF não pode conter letras"
                );
                temErro = true;

            } else {

                String cpfApenasNumeros =
                        cpfCliente.replaceAll("[^0-9]", "");

                if (cpfApenasNumeros.length() != 11) {

                    erroCpf.setText(
                            "O CPF deve conter 11 dígitos"
                    );

                    temErro = true;
                }
            }


            if (enderecoCliente.isEmpty()) {

                erroEndereco.setText(
                        "Preencha o endereço"
                );

                temErro = true;
            }


            if (emailCliente.isEmpty()) {

                erroEmail.setText(
                        "Preencha o e-mail"
                );

                temErro = true;
            }


            if (senhaCliente.isEmpty()) {

                erroSenha.setText("Preencha a senha");

                temErro = true;
            }


            if (temErro) {
                return;
            }


            Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente, emailCliente, senhaCliente);

            clienteController cadastrarCliente = new clienteController();

            cadastrarCliente.inserirCliente(cliente);

            if (cliente.getIdCliente() == 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao obter o ID do cliente."
                );

                return;
            }

            // criando conta

            Conta conta;
            String tipoConta;

            if (radioCorrente.isSelected()) {

                contaCorrente corrente =
                        new contaCorrente();

                corrente.setSaldoAtual(0);

                corrente.setLimiteCredito(500);

                conta = corrente;
                tipoConta = "Conta Corrente";

            } else {


            }

        });


        btnCancelar.addActionListener(e -> dispose());


        add(painelPrincipal);

        setSize(500, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private JLabel criarLabelErro() {

        JLabel label = new JLabel(" ");

        label.setForeground(Color.RED);

        label.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        11
                )
        );

        return label;
    }


    private JPanel criarBoxCampo(
            JComponent campo,
            JLabel labelErro
    ) {

        JPanel panel = new JPanel();

        panel.setLayout(
                new BoxLayout(
                        panel,
                        BoxLayout.Y_AXIS
                )
        );

        campo.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        labelErro.setAlignmentX(
                Component.LEFT_ALIGNMENT
        );

        panel.add(campo);
        panel.add(labelErro);

        return panel;
    }


    //cLIMPA ERROS
    private void limparErros() {

        erroNome.setText(" ");
        erroCpf.setText(" ");
        erroEndereco.setText(" ");
        erroEmail.setText(" ");
        erroSenha.setText(" ");
    }



    public static void main(String[] args) {
        new panelRegistro();
    }
}