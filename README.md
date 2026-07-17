# Sistema de Biblioteca em Java

Este foi meu primeiro contato com um projeto mais completo em Java.

A ideia principal foi praticar a linguagem criando um sistema simples de biblioteca, utilizando conceitos como classes, objetos, listas, menus no terminal, validações, exceções personalizadas e persistência de dados em arquivos `.txt`.

O projeto foi desenvolvido com foco no aprendizado e na aplicação prática dos conceitos que venho estudando em Java.

## Objetivo do projeto

Criar um sistema de biblioteca pelo terminal, onde seja possível cadastrar usuários e livros, realizar login, controlar empréstimos e devoluções e consultar históricos.

## Funcionalidades

- Login de usuário e administrador
- Cadastro de usuários
- Cadastro de livros
- Listagem de livros disponíveis
- Listagem de usuários
- Empréstimo de livros
- Devolução de livros
- Histórico de empréstimos por usuário
- Salvamento e carregamento dos dados em arquivos `.txt`

## Conceitos praticados

- Programação Orientada a Objetos (POO)
- Classes e objetos
- Encapsulamento
- Enums
- ArrayList
- Menus com `while` e `switch`
- Tratamento de erros com `try/catch`
- Exceções personalizadas
- Separação de responsabilidades em camadas
- Leitura e escrita em arquivos `.txt`
- Sobrescrita do método `toString()`

## Estrutura do projeto

```text
src/main/java/br/com/biblioteca/
  Main.java
  enums/
  exception/
  menu/
  model/
  repository/
  service/
  util/
  validacao/

data/
  usuarios.txt
  livros.txt
  emprestimos.txt
```

## Organização

- `model`: classes principais do sistema, como `Livro`, `Usuario` e `Emprestimo`.
- `service`: regras de negócio do sistema.
- `repository`: leitura e escrita dos arquivos `.txt`.
- `menu`: menus interativos exibidos no terminal.
- `validacao`: validações dos dados do sistema.
- `exception`: exceções personalizadas.
- `util`: classes e métodos auxiliares.

## Como executar

No Windows PowerShell, primeiro acesse a pasta onde o projeto está localizado:

```powershell
cd "CAMINHO DO PROJETO NO SEU COMPUTADOR"
```

Exemplo:

```powershell
cd "C:\Users\SeuUsuario\Documents\sistema-biblioteca-java"
```

Depois, compile e execute o projeto:

```powershell
$files = Get-ChildItem -LiteralPath 'src\main\java' -Recurse -Filter '*.java'
javac -encoding UTF-8 -d out $files.FullName
java -cp out br.com.biblioteca.Main
```

Também é possível abrir o projeto em uma IDE Java e executar diretamente a classe `Main`.
## Dados de teste

### Administrador

```text
Login: admin.teste
Senha: SenhaAdmin123
```

### Usuário

```text
Login: usuario.teste
Senha: SenhaUser123
```

## Observações

Este projeto foi desenvolvido para fins de estudo e representa meu primeiro contato com uma aplicação Java mais completa e organizada em diferentes camadas.

Durante o desenvolvimento, busquei aplicar os conhecimentos que adquiri estudando Java e Programação Orientada a Objetos, além de pesquisar e aprender novos conceitos conforme surgiam desafios durante a construção do sistema.

Como é um projeto de aprendizado, algumas partes ainda podem ser aprimoradas e novas funcionalidades podem ser adicionadas futuramente.

## Status

Versão inicial finalizada.
