# Sistema de Biblioteca em Java

Sistema de biblioteca desenvolvido em Java com foco em praticar Programação Orientada a Objetos, organização em pacotes, tratamento de erros e persistência de dados em arquivos `.txt`.

## Objetivo

O projeto simula um sistema simples de biblioteca, permitindo cadastro de livros, cadastro de usuários, login, empréstimos, devoluções e histórico de ações.

## Funcionalidades

* Login de administrador e usuário
* Cadastro e listagem de livros
* Cadastro e listagem de usuários
* Empréstimo de livros
* Devolução de livros
* Histórico de ações
* Salvamento dos dados em arquivos `.txt`

## Conceitos praticados

* Classes e objetos
* Encapsulamento
* Herança
* Enums
* ArrayList
* Tratamento de erros com `try/catch`
* Exceções personalizadas
* Leitura e escrita em arquivos
* Separação de responsabilidades

## Estrutura do projeto

```txt
sistema-biblioteca-java/
│
├── data/
│   ├── livros.txt
│   ├── usuarios.txt
│   ├── admins.txt
│   ├── emprestimos.txt
│   └── historico.txt
│
└── src/
    └── main/
        └── java/
            └── br/com/biblioteca/
                ├── Main.java
                ├── model/
                ├── service/
                ├── repository/
                ├── menu/
                ├── exception/
                └── util/
```

## Organização

* `model`: classes principais do sistema, como Livro, Usuario, Admin e Emprestimo.
* `service`: regras de negócio.
* `repository`: leitura e escrita dos arquivos `.txt`.
* `menu`: menus interativos no terminal.
* `exception`: exceções personalizadas.
* `util`: classes auxiliares.

## Como executar

1. Clone o repositório.
2. Abra o projeto em uma IDE Java.
3. Execute a classe `Main.java`.

## Status do projeto

Em desenvolvimento.
