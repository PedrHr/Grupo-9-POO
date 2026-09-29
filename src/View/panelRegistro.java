package View;

import Controller.clienteController;
<<<<<<< Updated upstream
import Model.contaCorrente;

import javax.swing.*;
=======
import Model.Cliente;
>>>>>>> Stashed changes
import java.awt.*;
import javax.swing.*;

public class panelRegistro extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField endereco;
    private JTextField email;
    private JPasswordField senha;
    
    //avisos de erro em vermelho
    private JLabel erroNome;
    private JLabel erroCpf;
    private JLabel erroEndereco;
    private JLabel erroEmail;
    private JLabel erroSenha;

    //radio botões da conta
    private JRadioButton radioCorrente;
    private JRadioButton radioPoupanca;
    private ButtonGroup grupoConta;

    public panelRegistro() {

        setTitle("Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

<<<<<<< Updated upstream
        // Painel
        JPanel painel = new JPanel(new GridLayout(8, 2, 10, 15));
=======
        //painel principal
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
>>>>>>> Stashed changes

        //grade dos campos
        JPanel painelCampos = new JPanel(new GridLayout(5, 2, 10, 10));

        //nome
        JLabel labelNome = new JLabel("Nome:");
        nome = new JTextField(16);
        erroNome = criarLabelErro();
        JPanel boxNome = criarBoxCampo(nome, erroNome);

        //cpf
        JLabel labelCpf = new JLabel("CPF:");
        cpf = new JTextField(16);
        erroCpf = criarLabelErro();
        JPanel boxCpf = criarBoxCampo(cpf, erroCpf);

        //endereço
        JLabel labelEndereco = new JLabel("Endereço:");
        endereco = new JTextField(16);
        erroEndereco = criarLabelErro();
        JPanel boxEndereco = criarBoxCampo(endereco, erroEndereco);

        //email
        JLabel labelEmail = new JLabel("E-mail:");
        email = new JTextField(16);
        erroEmail = criarLabelErro();
        JPanel boxEmail = criarBoxCampo(email, erroEmail);

        //senha e botao do olho
        JLabel labelSenha = new JLabel("Senha:");
        senha = new JPasswordField(12);
        
        char echoCharPadrao = senha.getEchoChar();
        JToggleButton btnMostrarSenha = new JToggleButton("👁");
        btnMostrarSenha.setToolTipText("Mostrar/Ocultar Senha");
        btnMostrarSenha.setFocusable(false);
        btnMostrarSenha.setMargin(new Insets(2, 5, 2, 5));

<<<<<<< Updated upstream
        // Label tipo conta
        JLabel labelTipoConta = new JLabel("Tipo de conta:");

        JLabel labelVazio = new JLabel("");

        JRadioButton contaCorrente = new JRadioButton("Conta Corrente");
        JRadioButton contaPoupanca = new JRadioButton("Conta Poupança");


        // Grupo para permitir apenas uma opção
        ButtonGroup grupoConta = new ButtonGroup();
        grupoConta.add(contaCorrente);
        grupoConta.add(contaPoupanca);

        // Adicionar ao painel
        painel.add(labelNome);
        painel.add(nome);
=======
        btnMostrarSenha.addActionListener(e -> {
            if (btnMostrarSenha.isSelected()) {
                senha.setEchoChar((char) 0);
            } else {
                senha.setEchoChar(echoCharPadrao);
            }
        });
>>>>>>> Stashed changes

        JPanel painelSenhaInput = new JPanel(new BorderLayout(5, 0));
        painelSenhaInput.add(senha, BorderLayout.CENTER);
        painelSenhaInput.add(btnMostrarSenha, BorderLayout.EAST);

        erroSenha = criarLabelErro();
        JPanel boxSenha = criarBoxCampo(painelSenhaInput, erroSenha);

        //joga na tela
        painelCampos.add(labelNome);
        painelCampos.add(boxNome);

        painelCampos.add(labelCpf);
        painelCampos.add(boxCpf);

<<<<<<< Updated upstream
        painel.add(labelTipoConta);
        painel.add(contaCorrente);

        painel.add(labelVazio);
        painel.add(contaPoupanca);

        // Botões
=======
        painelCampos.add(labelEndereco);
        painelCampos.add(boxEndereco);

        painelCampos.add(labelEmail);
        painelCampos.add(boxEmail);

        painelCampos.add(labelSenha);
        painelCampos.add(boxSenha);

        //opçoes de conta
        radioCorrente = new JRadioButton("Conta Corrente", true);
        radioPoupanca = new JRadioButton("Conta Poupança");

        grupoConta = new ButtonGroup();
        grupoConta.add(radioCorrente);
        grupoConta.add(radioPoupanca);

        JPanel painelRadio = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        painelRadio.add(radioCorrente);
        painelRadio.add(radioPoupanca);

        //botoes cadastrar/cancelar
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 10, 0));
>>>>>>> Stashed changes
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnCancelar = new JButton("Cancelar");
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnCancelar);

        //junta tudo embaixo
        JPanel painelSul = new JPanel(new BorderLayout(0, 10));
        painelSul.add(painelRadio, BorderLayout.NORTH);
        painelSul.add(painelBotoes, BorderLayout.SOUTH);

        painelPrincipal.add(painelCampos, BorderLayout.NORTH);
        painelPrincipal.add(painelSul, BorderLayout.SOUTH);

        //clique do cadastrar
        btnCadastrar.addActionListener(e -> {

<<<<<<< Updated upstream
            String nomeCliente = nome.getText();
            String cpfCliente = cpf.getText();
            String enderecoCliente = endereco.getText();
            String emailCliente = email.getText();
            String senhaCliente = new String(senha.getPassword());

            // PEGANDO O TIPO DE CONTA
            String tipoConta = "";

            if (contaCorrente.isSelected()) {
                tipoConta = "corrente";
            } else if (contaPoupanca.isSelected()) {
                tipoConta = "poupanca";
            }

            // VERFICANDO SE OS CAMPOS ESTÃO PREENCHIDOS
            if (nomeCliente.trim().isEmpty() || cpfCliente.trim().isEmpty() || enderecoCliente.trim().isEmpty() || emailCliente.trim().isEmpty() || senhaCliente.trim().isEmpty()) || tipoConta.trim().isEmpty() ){
=======
            //limpa erros velhos
            limparErros();

            String nomeCliente = nome.getText().trim();
            String cpfCliente = cpf.getText().trim();
            String enderecoCliente = endereco.getText().trim();
            String emailCliente = email.getText().trim();
            
            char[] senhaChars = senha.getPassword();
            String senhaCliente = new String(senhaChars).trim();
            
            boolean temErro = false;
>>>>>>> Stashed changes

            //valida nome
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

            //valida cpf
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

            //valida endereço
            if (enderecoCliente.isEmpty()) {
                erroEndereco.setText("Preencha o endereço");
                temErro = true;
            }

            //valida email
            if (emailCliente.isEmpty()) {
                erroEmail.setText("Preencha o e-mail");
                temErro = true;
            }

            //valida senha
            if (senhaCliente.isEmpty()) {
                erroSenha.setText("Preencha a senha");
                temErro = true;
            }

            //se passar por tudo cadastra
            if (!temErro) {
                String tipoConta = radioCorrente.isSelected() ? "Corrente" : "Poupança";

                Cliente cliente = new Cliente(nomeCliente, cpfCliente, enderecoCliente, emailCliente, senhaCliente);
                clienteController cadastrarCliente = new clienteController();
                cadastrarCliente.inserirCliente(cliente);

                if(tipoConta.equals("corrente")){
                    contaCorrente contaCorrenteUsuario = new contaCorrente();

                }

                JOptionPane.showMessageDialog(
<<<<<<< Updated upstream
                        this,
                        "Cliente " + nomeCliente + " cadastrado com sucesso!"
=======
                    this,
                    "Cliente " + nomeCliente + " cadastrado com sucesso na conta " + tipoConta + "!"
>>>>>>> Stashed changes
                );
            }
        });

        btnCancelar.addActionListener(e -> dispose());

        add(painelPrincipal);

        setSize(500, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

<<<<<<< Updated upstream
=======
    //monta label de erro
    private JLabel criarLabelErro() {
        JLabel label = new JLabel(" ");
        label.setForeground(Color.RED);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        return label;
    }

    //junta campo e erro na vertical
    private JPanel criarBoxCampo(JComponent campo, JLabel labelErro) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        campo.setAlignmentX(Component.LEFT_ALIGNMENT);
        labelErro.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(campo);
        panel.add(labelErro);
        return panel;
    }

    //reseta avisos
    private void limparErros() {
        erroNome.setText(" ");
        erroCpf.setText(" ");
        erroEndereco.setText(" ");
        erroEmail.setText(" ");
        erroSenha.setText(" ");
    }

>>>>>>> Stashed changes
    public static void main(String[] args) {
        new panelRegistro();
<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
    }
}