# Sistema de Biblioteca

Sistema de gerenciamento de livros desenvolvido em Java com Spring Boot para a empresa fictícia CloudTech Solutions.

## Tecnologias utilizadas

- Java 25
- Spring Boot 4.1.2
- Maven
- JUnit 5
- Thunder Client
- Git e GitHub

## Funcionalidades

- Página inicial com mensagem de boas-vindas
- Cadastro de livros
- Listagem de livros cadastrados
- Consulta de livros por ID
- Alteração dos dados de livros
- Tratamento de erro para livros não encontrados

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/` | Página inicial |
| GET | `/livros` | Listar livros |
| POST | `/livros/cadastrar` | Cadastrar livro |
| GET | `/livros/{id}` | Consultar livro por ID |
| PUT | `/livros/alterar/{id}` | Alterar livro |

## Como executar

Com Java 25 e Maven instalados, execute na pasta do projeto:

`mvn spring-boot:run`

A aplicação estará disponível em `http://localhost:8080`.

## Testes automatizados

Para executar os testes:

`mvn clean test`

Os testes verificam o cadastro, a listagem, a consulta, a alteração e o tratamento de livros inexistentes.

## Observações

Os dados são armazenados temporariamente em memória. Ao reiniciar a aplicação, os registros cadastrados são perdidos.

## Projeto acadêmico

Disciplina: Desenvolvimento Backend

Aula 11 — Exercício 2