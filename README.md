# Sistema de Biblioteca em Java

Este foi meu primeiro contato com um projeto mais completo em Java.

A ideia principal foi praticar a linguagem criando um sistema simples de biblioteca, usando conceitos como classes, objetos, listas, menus no terminal, validacoes, excecoes personalizadas e salvamento de dados em arquivos `.txt`.

O projeto ainda esta em desenvolvimento e foi feito com foco em aprendizado.

## Objetivo do projeto

Criar um sistema de biblioteca pelo terminal, onde seja possivel cadastrar usuarios, cadastrar livros, fazer login, realizar emprestimos, devolver livros e consultar historicos.

## Funcionalidades

- Login de usuario e administrador
- Cadastro de usuarios
- Cadastro de livros
- Listagem de livros disponiveis
- Listagem de usuarios
- Emprestimo de livros
- Devolucao de livros
- Historico de emprestimos por usuario
- Salvamento e carregamento dos dados em arquivos `.txt`

## Conceitos praticados

- Programacao Orientada a Objetos
- Classes e objetos
- Encapsulamento
- Enums
- ArrayList
- Menus com `while` e `switch`
- Tratamento de erros com `try/catch`
- Excecoes personalizadas
- Separacao em camadas
- Leitura e escrita em arquivos `.txt`
- Sobrescrita do metodo `toString()`

## Estrutura do projeto

```txt
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

## Organizacao

- `model`: classes principais do sistema, como `Livro`, `Usuario` e `Emprestimo`.
- `service`: regras de negocio do sistema.
- `repository`: leitura e escrita dos arquivos `.txt`.
- `menu`: menus interativos exibidos no terminal.
- `validacao`: validacoes de dados.
- `exception`: excecoes personalizadas.
- `util`: classes auxiliares.

## Como executar

No Windows PowerShell, dentro da pasta do projeto:

```powershell
$files = Get-ChildItem -LiteralPath 'src\main\java' -Recurse -Filter '*.java'
javac -encoding UTF-8 -d out $files.FullName
java -cp out br.com.biblioteca.Main
```

Tambem e possivel abrir o projeto em uma IDE Java e executar a classe `Main`.

## Dados de teste

Administrador:

```txt
Login: admin.teste
Senha: SenhaAdmin123
```

Usuario:

```txt
Login: usuario.teste
Senha: SenhaUser123
```

## Observacoes

Este projeto foi feito para estudo, entao algumas partes ainda podem ser melhoradas.

Pontos que pretendo melhorar futuramente:

- Nao mostrar senha nas listagens
- Melhorar a seguranca das senhas
- Criar testes automatizados
- Melhorar a leitura e escrita dos arquivos
- Organizar melhor alguns fluxos internos

## Status

Projeto em desenvolvimento.
