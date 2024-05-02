# Projeto de Gerenciamento de Estudantes

### Descrição
Uma aplicação monolítica desenvolvida em Java Spring para gerenciar informações de estudantes, seguindo o padrão de arquitetura Modelo-Visão-Controlador (MVC).

### Tecnologias Utilizadas
- Linguagem de Programação: Java
- Framework: Spring Framework
- Banco de Dados: PostgreSQL
- Orquestração de Contêineres: Docker Compose

### Arquitetura
Este projeto segue uma arquitetura monolítica, onde todas as funcionalidades e componentes estão integrados dentro da mesma aplicação. A organização do código segue o padrão MVC, que inclui:

- Modelo: Classes que representam as entidades de dados (Entities) e interagem com o banco de dados através de repositórios (Repositories).
- Visão: Interfaces de estudantes (controllers) que lidam com as solicitações dos estudantes e renderizam as respostas correspondentes.
- Controlador: Classes que coordenam as interações entre o modelo e a visão, implementando a lógica de negócios e o roteamento das solicitações.

### Funcionalidades
- Cadastro de estudantes
- Visualização de estudantes e visualização por id
- Atualização de estudantes
- Exclusão de estudantes

### Layout 
![post-student](https://github.com/marclipe/api-student-spring/blob/main/github/student-post.png?raw=true)

![post-student](https://github.com/marclipe/api-student-spring/blob/main/github/student-ide.png?raw=true)
