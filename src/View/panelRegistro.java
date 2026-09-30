package View;

import Controller.clienteController;
import Controller.contaCorrenteController;
import Controller.contaPoupancaController;
import Model.Cliente;
import Model.Conta;
import Model.contaCorrente;
import Model.contaPoupanca;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class panelRegistro extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField endereco;
    private JTextField email;
    private JPasswordField senha;

    //avisos de erro
    private JLabel erroNome;
    private JLabel erroCpf;
    private JLabel erroEndereco;
    private JLabel erroEmail;
    private JLabel erroSenha;

    //radio buttons da conta
    private JRadioButton radioCorrente;
    private JRadioButton radioPoupanca;
    private ButtonGroup grupoConta;

    public panelRegistro() {

        setTitle("Registro");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        //titulo da tela
        JLabel tituloCadastro = new JLabel("CADASTRO", SwingConstants.CENTER);
        tituloCadastro.setFont(new Font("Arial", Font.BOLD, 32));
        tituloCadastro.setForeground(new Color(20, 55, 100));

        //grade dos campos
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 10, 10));

        //campo nome
        JLabel labelNome = new JLabel("Nome:");
        nome = new JTextField(16);
        erroNome = criarLabelErro();
        JPanel boxNome = criarBoxCampo(nome, erroNome);
        painelCampos.add(labelNome);
        painelCampos.add(boxNome);

        //campo cpf
        JLabel labelCpf = new JLabel("CPF:");
        cpf = new JTextField(16);
        erroCpf = criarLabelErro();
        JPanel boxCpf = criarBoxCampo(cpf, erroCpf);
        painelCampos.add(labelCpf);
        painelCampos.add(boxCpf);

        //campo endereco
        JLabel labelEndereco = new JLabel("Endereço:");
        endereco = new JTextField(16);
        erroEndereco = criarLabelErro();
        JPanel boxEndereco = criarBoxCampo(endereco, erroEndereco);
        painelCampos.add(labelEndereco);
        painelCampos.add(boxEndereco);

        //campo email
        JLabel labelEmail = new JLabel("E-mail:");
        email = new JTextField(16);
        erroEmail = criarLabelErro();
        JPanel boxEmail = criarBoxCampo(email, erroEmail);
        painelCampos.add(labelEmail);
        painelCampos.add(boxEmail);

        //campo senha
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
        JPanel boxSenha = criarBoxCampo(painelSenhaInput, erroSenha);
        painelCampos.add(labelSenha);
        painelCampos.add(boxSenha);

        //painel superior
        JPanel painelNorte = new JPanel(new BorderLayout(0, 15));
        painelNorte.add(tituloCadastro, BorderLayout.NORTH);
        painelNorte.add(painelCampos, BorderLayout.SOUTH);

        //tipo de conta
        radioCorrente = new JRadioButton("Conta Corrente", true);
        radioPoupanca = new JRadioButton("Conta Poupança");

        grupoConta = new ButtonGroup();
        grupoConta.add(radioCorrente);
        grupoConta.add(radioPoupanca);

        JPanel painelRadio = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        painelRadio.add(radioCorrente);
        painelRadio.add(radioPoupanca);

        //botoes
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnCancelar);

        //link de login
        JLabel lblLogin = new JLabel("<html><u>Já possui uma conta? Faça login aqui.</u></html>", SwingConstants.CENTER);
        lblLogin.setForeground(new Color(0, 102, 204));
        lblLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));

        lblLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                
                SwingUtilities.invokeLater(() -> {
                    panelLogin login = new panelLogin();
                    login.toFront();
                    login.requestFocus();
                });
            }
        });

        //painel inferior
        JPanel painelSul = new JPanel(new BorderLayout(0, 10));
        painelSul.add(painelRadio, BorderLayout.NORTH);
        painelSul.add(painelBotoes, BorderLayout.CENTER);
        painelSul.add(lblLogin, BorderLayout.SOUTH);

        //monta a tela
        painelPrincipal.add(painelNorte, BorderLayout.NORTH);
        painelPrincipal.add(painelSul, BorderLayout.SOUTH);

        //acao do botao cadastrar
        btnCadastrar.addActionListener(e -> {

            limparErros();

            String nomeCliente = nome.getText().trim();
            String cpfCliente = cpf.getText().trim();
            String enderecoCliente = endereco.getText().trim();
            String emailCliente = email.getText().trim();
            String senhaCliente = new String(senha.getPassword()).trim();

            boolean temErro = false;

            if (nomeCliente.isEmpty()) {
                erroNome.setText("Preencha o nome");
                temErro = true;
            } else if (nomeCliente.matches(".*\\d.*")) {
                erroNome.setText("O nome não pode conter números");
                temErro = true;
            } else if (nomeCliente.split("\\s+").length < 2) {
                erroNome.setText("Informe ao menos nome e sobrenome");
                temErro = true;
            }

            if (cpfCliente.isEmpty()) {
                erroCpf.setText("Preencha o CPF");
                temErro = true;
            } else if (cpfCliente.matches(".*[a-zA-Z].*")) {
                erroCpf.setText("O CPF não pode conter letras");
                temErro = true;
            } else {
                String cpfApenasNumeros = cpfCliente.replaceAll("[^0-9]", "");
                if (cpfApenasNumeros.length() != 11) {
                    erroCpf.setText("O CPF deve conter 11 dígitos");
                    temErro = true;
                }
            }

            if (enderecoCliente.isEmpty()) {
                erroEndereco.setText("Preencha o endereço");
                temErro = true;
            }

            if (emailCliente.isEmpty()) {
                erroEmail.setText("Preencha o e-mail");
                temErro = true;
            }

            if (senhaCliente.isEmpty()) {
                erroSenha.setText("Preencha a senha");
                temErro = true;
            }

            if (temErro) {
                return;
            }

            try {
                //salva cliente no banco
                Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente, emailCliente, senhaCliente);
                clienteController cadastrarCliente = new clienteController();
                cadastrarCliente.inserirCliente(cliente);

                //salva conta no banco
                if (radioCorrente.isSelected()) {
                    contaCorrenteController contaCorrente = new contaCorrenteController();
                    contaCorrente corrente = new contaCorrente(contaCorrente.getSaldoInicial(),"CORRENTE", cliente);

                    contaCorrenteController inserirCorrente = new contaCorrenteController();
                    inserirCorrente.inserirConta(corrente);
                } else {
                    contaPoupancaController contaPoupanca = new contaPoupancaController();
                    contaPoupanca poupanca = new contaPoupanca(contaPoupanca.getSaldoInicial(), "POUPANCA", cliente);
                    contaPoupancaController inserirPoupanca = new contaPoupancaController();
                    inserirPoupanca.inserirConta(poupanca);
                }

                //redireciona para o login
                dispose();
                
                SwingUtilities.invokeLater(() -> {
                    panelLogin login = new panelLogin();
                    login.toFront();
                    login.requestFocus();
                });

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao realizar cadastro: " + ex.getMessage());
            }
        });

        //acao do botao cancelar
        btnCancelar.addActionListener(e -> dispose());

        add(painelPrincipal);

        setSize(500, 570);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //cria label de erro
    private JLabel criarLabelErro() {
        JLabel label = new JLabel(" ");
        label.setForeground(Color.RED);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        return label;
    }

    //junta componentes do campo
    private JPanel criarBoxCampo(JComponent campo, JLabel labelErro) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelErro.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(campo);
        panel.add(labelErro);

        return panel;
    }

    //limpa mensagens de erro
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