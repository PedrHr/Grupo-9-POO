package View;

import Controller.clienteController;
import Controller.exceptionsController;
import Model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Controller.exceptionsController;
import Model.Cliente;
import Controller.clienteController;
import Model.Transacao;


public class panelTransacao extends JFrame {

        static private JTextField valor;
        static private JTextField origem;
        static private JTextField destino;

        // Construtor
        public panelTransacao() {

            setTitle("Realizar Transações");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Painel
            JPanel painel = new JPanel(new GridLayout(6, 2, 10, 15));

            // Adiciona margem
            painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // VALOR DEPOSITO
            JLabel labelValor = new JLabel("Valor:");
            valor = new JTextField(16);

            // CONTA ORIGEM
            JLabel labelOrigem = new JLabel("Origem:");
            origem = new JTextField(16);

            // CONTA DESTINO
            JLabel labelDestino = new JLabel("Destino:");
            destino = new JTextField(16);

            // SENHA

            // Adicionar ao painel
            painel.add(labelValor);
            painel.add(valor);

            painel.add(labelOrigem);
            painel.add(origem);

            painel.add(labelDestino);
            painel.add(destino);


            // Botões
            JButton btnEnviar = new JButton("Enviar Transação");
            JButton btnCancelar = new JButton("Cancelar");


            btnEnviar.addActionListener(e -> {

                double valorTransacao =  Double.parseDouble(valor.getText().replace(",", "."));
                int contaOrigem = Integer.parseInt(origem.getText());
                int contaDesitno = Integer.parseInt(destino.getText());
                LocalDateTime dataTransacao = LocalDateTime.now();

                // VERFICANDO SE OS CAMPOS ESTÃO PREENCHIDOS
                if (valor.getText().trim().isEmpty() || origem.getText().trim().isEmpty() || destino.getText().trim().isEmpty()) {

                    // CHAAMANDO A CLASSE DE EXCEÇÕES DE CAMPOS VAZIOS COM SUA MENSAGEM
                    JOptionPane.showMessageDialog(this, exceptionsController.camposVazios());

                } else {

                    // CRIANDO UM NOVO OBJETO CLIENTE E CHAMANDO O CONTROLLER PARA CADASTRA-LO
                    Transacao transacao = new Transacao(valorTransacao, contaOrigem, contaDesitno, dataTransacao);
                    clienteController cadastrarCliente = new clienteController();
                    cadastrarCliente.inserirCliente(cliente);

                    JOptionPane.showMessageDialog(
                            this,
                            "Cliente " + nomeCliente + " cadastrado com sucesso!"
                    );

                }
            });

            btnCancelar.addActionListener(e -> dispose());

            painel.add(btnEnviar);
            painel.add(btnCancelar);

            add(painel);

            // Definir tamanho fixo
            setSize(500, 400);

            // Centralizar a janela
            setLocationRelativeTo(null);

            setVisible(true);


        }
        public static void main(String[] args) {

            new View.panelRegistro();




        }


    }
}
