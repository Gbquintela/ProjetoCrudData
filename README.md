# CRUD com Spring Data e Controle de Acesso

Este projeto é um sistema CRUD (Create, Read, Update, Delete) desenvolvido utilizando Spring Data, com uma tela de login e diferentes níveis de acesso para administrador, funcionário e cliente. O sistema permite gerenciar usuários e suas permissões de acordo com o tipo de usuário logado.

## Funcionalidades

### Administrador
- **Criar usuários**: Pode criar novos administradores, funcionários e clientes.
- **Listar todos os usuários**: Visualiza todos os usuários cadastrados no sistema.
- **Buscar usuário por ID**: Visualiza detalhes de um usuário específico.
- **Atualizar usuário**: Atualiza informações de um usuário existente.
- **Deletar usuário**: Remove um usuário do sistema.

### Funcionário
- **Criar clientes**: Pode criar novos clientes.
- **Listar clientes**: Visualiza todos os clientes cadastrados.
- **Atualizar clientes**: Atualiza informações de clientes existentes.
- **Deletar clientes**: Remove clientes do sistema.

### Cliente
- **Visualizar informações**: Pode visualizar suas informações sobre oque e o projeto.
- **Sair do sistema**: Encerra a sessão do usuário.

## Tecnologias Utilizadas

- **Spring Data**: Facilita a integração com banco de dados e operações CRUD.
- **Banco de Dados**: MySQL
- **Maven/Gradle**: Gerenciamento de dependências e build do projeto.

## Autor
- **Este projeto foi desenvolvido por:
- **Gabriel De Martinho Quintela

## Como Executar o Projeto

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git
