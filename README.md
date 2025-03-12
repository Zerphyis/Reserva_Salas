# Sistema de Reserva de salas

## Descrição

Este é um sistema de gerenciamento de reservas de salas de reunião, construído usando o framework **Spring Boot**. O projeto permite que os usuários façam o registro de novas salas, realizem reservas e façam o gerenciamento dessas reservas. Além disso, a aplicação inclui a autenticação de usuários via JWT (JSON Web Token) para garantir a segurança das interações.

## Tecnologias Utilizadas

- **Spring Boot** (Framework principal)
- **Spring Security** (Segurança e autenticação)
- **JWT** (Autenticação baseada em token)
- **Spring Data JPA** (Persistência de dados)
- **MySQL** (Banco de dados)
- **BCryptPasswordEncoder** (Criptografia de senhas)

## Funcionalidades

- **Registro de usuários**: Usuários podem se registrar no sistema com um nome de usuário e senha.
- **Autenticação via JWT**: A autenticação é feita com JWT, garantindo que somente usuários autenticados possam acessar recursos protegidos.
- **Gerenciamento de salas**: Usuários autenticados podem adicionar, editar, excluir e listar salas de reunião.
- **Reservas de salas**: Usuários autenticados podem realizar reservas de salas para datas e horários específicos.
- **Controle de acesso por papéis**: Existem diferentes papéis no sistema, com permissões específicas para `ADMIN` e `USER`.

## Endpoints da API

### Autenticação e Registro

#### **POST** `/login/register`
Registra um novo usuário.
<br>

![Image](https://github.com/user-attachments/assets/4ee17348-0d20-472a-9442-ddb60629cbdd)
<br>
#### POST /login/auth
Autentica um usuário e retorna um token JWT.
<br>

![Image](https://github.com/user-attachments/assets/31dc7471-a1e3-4553-af31-13a178383632)
<br>

### Gestão de Salas
#### POST /salas
Cria uma nova sala.
<br>

![Image](https://github.com/user-attachments/assets/5e3047ec-bb8c-439f-a813-c48d681ce8e3)
<br>
#### PUT /salas/{id}
Atualiza os dados de uma sala existente.
<br>

![Image](https://github.com/user-attachments/assets/8e5e696f-29f1-46ad-a3c8-58362afee89a)
<br>
#### DELETE /salas/{id}
Exclui uma sala.
<br>

![Image](https://github.com/user-attachments/assets/e5e7e7a4-21a1-4cc0-a82c-643fec6115de)
<br>
#### GET /salas
listar todas as salas
<br>

![Image](https://github.com/user-attachments/assets/ecd29a85-e733-4beb-a2d3-3a761567e6a1)
<br>
#### GET /salas/buscar?recurso={recurso}
<br>

![Image](https://github.com/user-attachments/assets/2576a3ff-e8c1-4a96-a14c-d012243d646a)
<br>
### Reservas de Salas
#### POST /reservas
Cria uma nova reserva para uma sala.
<br>

![Image](https://github.com/user-attachments/assets/1c3bc97a-af9c-4e36-b960-0c692886c9be)
<br>
#### PUT /reservas/{id}
Atualiza uma  reserva existente .
<br>

![Image](https://github.com/user-attachments/assets/edf313c6-ec2f-4871-aeb0-0d510e61afaa)
<br>

#### GET /reservas/{id}
Obtém os detalhes de uma reserva.
<br>
![Image](https://github.com/user-attachments/assets/ad9f4155-ec39-45fc-9b1d-e75ae0b4c8a6)
<br>
#### GET /reservas
Lista todas as reservas realizadas.
<br>

![Image](https://github.com/user-attachments/assets/901a82fe-6a9e-4c4f-9ce1-7ac7fce6028a)
<br>
#### DELETE /reservas/{id}
Exclui uma reserva.
<br>

![Image](https://github.com/user-attachments/assets/aab219f6-6491-4541-8ef4-6600c4339340)
<br>

## Estrutura do Projeto

- **Controller:** Contém os endpoints da API.
- **Service:** Lógica de negócios e processamento das requisições.
- **Entity:** Representações das entidades no banco de dados.
- **Security:** Configurações de segurança e autenticação.

## Como Rodar o Projeto

1. **Clone o repositório:**

```bash
git clone https://github.com/seu-usuario/Reserva_Salas-reservation.git
cd Reserva_Salas-reservation

properties
Copiar
Editar
spring.datasource.url=jdbc:mysql://localhost:3306/{UrlBanco}
spring.datasource.username={NomelUsuario}
spring.datasource.password={SenhaUsuario}
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
Execute o projeto:
Execute o seguinte comando para rodar a aplicação:

bash
Copiar
Editar
mvn spring-boot:run
O servidor estará rodando na URL http://localhost:8080.
