# Voll Med - API Rest

Este projeto foi desenvolvido como parte dos seguintes cursos da Alura:

- **Spring Boot 3: desenvolva uma API Rest em Java**
- **Spring Boot 3: aplique boas práticas e proteja uma API Rest**
- **Spring Boot 3: documente, teste e prepare uma API para o deploy**

A API Voll Med é uma aplicação Restful para gerenciamento de clínicas médicas. Permite funcionalidades como cadastro de médicos e pacientes, agendamento e cancelamento de consultas, e gerenciamento de dados.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **PostgreSQL**
- **JWT (JSON Web Token)** para autenticação
- **Hibernate** para ORM
- **Insomnia** para testes de endpoints

## Funcionalidades

### Endpoints Principais

- **Autenticação:**
  - `POST /login`: Autenticação de usuários e geração de token JWT.

- **Médicos:**
  - `POST /medicos`: Cadastro de médicos.
  - `GET /medicos`: Listagem de médicos ativos.
  - `GET /medicos/{id}`: Detalhamento de um médico específico.
  - `PUT /medicos`: Atualização de dados de um médico.
  - `DELETE /medicos/{id}`: Exclusão lógica de um médico.

- **Pacientes:**
  - `POST /pacientes`: Cadastro de pacientes.
  - `GET /pacientes`: Listagem de pacientes ativos.
  - `GET /pacientes/{id}`: Detalhamento de um paciente específico.
  - `PUT /pacientes`: Atualização de dados de um paciente.
  - `DELETE /pacientes/{id}`: Exclusão lógica de um paciente.

- **Consultas:**
  - `POST /consultas`: Agendamento de consultas.
  - `POST /cancelar`: Cancelamento de consultas com validações específicas.

## Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/voll-med-api.git
   cd voll-med-api
   ```

2. **Configure o banco de dados PostgreSQL:**
   - Crie um banco de dados chamado `vollmed_api`.
   - Atualize as credenciais no arquivo `application.properties`.

3. **Execute as migrações:**
   - Certifique-se de que as migrações em `src/main/resources/db/migration` estejam configuradas.

4. **Inicie a aplicação:**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Testes dos endpoints:**
   - Utilize o Insomnia ou outra ferramenta similar para testar os endpoints disponíveis.

---

Desenvolvido por João Vitor Brandão durante os cursos da Alura.
