# Sistema Bancário — Grupo 9

## 1. Descrição do Sistema

O projeto consiste em um sistema bancário desenvolvido em Java, utilizando
Programação Orientada a Objetos, interface gráfica com Java Swing e persistência
de dados em banco de dados MySQL.

O sistema permite o cadastro de clientes, criação e gerenciamento de contas
bancárias e realização de operações como depósitos, saques e transações.

Existem diferentes tipos de conta, como Conta Corrente e Conta Poupança,
cada uma com características e comportamentos específicos.

---
## 2. Instruções para Executar o Projeto

### Requisitos

- Java
- MySQL
- IDE Java, como IntelliJ IDEA

### Banco de Dados

O projeto utiliza um banco MySQL chamado `systemBank`.

Antes de executar o sistema:

1. Inicie o servidor MySQL.
2. Crie/configure o banco de dados utilizado pelo projeto.
3. Verifique as configurações de conexão presentes em `conexaoDAO`.
4. Confirme usuário, senha, porta e URL do banco.
5. Execute a classe principal do projeto.

---

## 3. Classes Principais

### Cliente
Representa um cliente do sistema bancário e armazena informações como nome,
CPF, endereço, e-mail e senha.

### Conta
Classe abstrata que representa as características e comportamentos comuns
das contas bancárias, como saldo, número da conta, depósito e saque.

### contaCorrente
Especialização de `Conta`. Representa uma conta corrente e adiciona
características específicas, como limite de crédito e chave de transação.

### contaPoupanca
Especialização de `Conta`. Representa uma conta poupança e possui uma
taxa de rendimento.

### Transacao
Representa uma transação realizada no sistema, armazenando informações
sobre valor, conta de origem, conta de destino e data/hora.

### Classes DAO
As classes DAO são responsáveis pela comunicação entre o sistema e o
banco de dados, realizando operações de consulta, inserção e atualização.

### Controllers
Realizam a intermediação das operações entre a interface do sistema,
as entidades e a camada de persistência.

### Views
Contêm as interfaces gráficas desenvolvidas com Java Swing.

---

## 4. Regras de Negócio

- Cada conta bancária está associada a um cliente.
- O sistema possui diferentes tipos de conta.
- Depósitos devem possuir valores válidos.
- Saques seguem as regras definidas pelo tipo de conta.
- A Conta Corrente possui limite de crédito.
- A Conta Poupança possui taxa de rendimento.
- As transações registram a conta de origem, conta de destino, valor e
  data/hora da operação.
- As alterações de saldo são realizadas por operações controladas pelo sistema.

---

## 5. Checklist de Programação Orientada a Objetos

| Conceito | Onde foi utilizado                                                                             |
|---|------------------------------------------------------------------------------------------------|
| Classes e Objetos | Classes `Cliente`, `Conta`, `Transacao`, `contaCorrente` e `contaPoupanca`, com instanciação de objetos durante a execução |
| Atributos | Atributos das entidades, como `saldoAtual`, `numeroConta`, `nome`, `cpf` e `dataTransacao`     |
| Métodos | Métodos como `depositarValor()`, `sacarValor()` e `aplicarRendimento()`                        |
| Construtores | Construtores das classes `Cliente`, `Conta`, `contaCorrente`, `contaPoupanca` e `Transacao`    |
| `this` | Utilizado nos construtores e métodos para referenciar atributos do objeto atual                |
| Modificadores | Uso de `private` para atributos e `public` para operações disponibilizadas pelas classes       |
| Encapsulamento | Atributos privados, como `saldoAtual`, com alterações realizadas através de métodos controlados |
| Pacotes | Organização do projeto nos pacotes `Model`, `ModelDAO`, `Controller` e `View`                  |
| Herança | `contaCorrente` e `contaPoupanca` herdam de `Conta` utilizando `extends`                       |
| Polimorfismo | Uso de `Conta` como tipo geral para manipular objetos de `contaCorrente` e `contaPoupanca`     |
| `super` | Utilizado nos construtores das subclasses para chamar o construtor de `Conta`                  |
| Abstração | `Conta` foi definida como classe abstrata através de `abstract`                                |
| Interfaces | Não foram utilizadas interfaces, pois os comportamentos comuns foram centralizados na classe abstrata `Conta`, utilizando herança e abstração.                                                                                               |
| Enum | Uso de `enum` na `conta` para definir o conjunto fechado de valores possíveis                  |
| Tratamento de Exceções | Uso de `try/catch` nas classes DAO para tratar `SQLException` durante operações com o banco de dados |
| Swing | Interfaces gráficas desenvolvidas com componentes como `JFrame`, `JDialog`, `JButton`, `JTextField` e `JOptionPane` |
| Data e Hora | Uso de `LocalDateTime` para registrar a data e hora das transações                             |

