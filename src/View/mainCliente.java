package View;

import javax.swing.*;

public class mainCliente extends JFrame {

    private JTextField nome;
    private JTextField cpf;
    private JTextField telefone;
    private JTextField email;
    private JPasswordField senha;

    //Construtor
    public mainCliente() {
        //tamanho da janela
        setSize(500, 600);
        
        setTitle("Registro");
        //botão de fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //deixar a janela no centro da tela
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        //NOME
            //Texto ao lado da caixa de inserir o Nome
            JLabel labelNome = new JLabel("Nome:");
            //tamanho da caixa
            nome = new JTextField(16);

        //CPF
            //Texto ao lado da caixa de inserir o CPF
            JLabel labelCpf = new JLabel("CPF:");
            //tamanho da caixa
            cpf = new JTextField(16);

        //TELEFONE
            //Texto ao lado da caixa de inserir o Telefone
            JLabel labelTelefone = new JLabel("Telefone:");
            //tamanho da caixa
            telefone = new JTextField(16);


        //adicionar ao painel
            //Nome
            painel.add(labelNome);
            painel.add(nome);

            //CPF
            painel.add(labelCpf);
            painel.add(cpf);

            //Telefone
            painel.add(labelTelefone);
            painel.add(telefone);

        add(painel);

        setVisible(true);

    }

    public static void main(String[] args) {

        new mainCliente();

    }
}
