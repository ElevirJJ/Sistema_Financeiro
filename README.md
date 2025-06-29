No P3, desenvolvi meu primeiro projeto utilizando o framework Spring, com foco na criação de APIs REST que implementam os principais CRUDs (Create, Read, Update, Delete).
Esse projeto foi construído como parte da disciplina de Back-End, em conjunto com um projeto de extensão.

🔐 Funcionalidades principais:
API protegida com Spring Security utilizando JWT (JSON Web Token) para autenticação e autorização.

Integração com o front-end React para:

Cadastro de um novo usuário (caso ainda não exista login).

Login seguro com geração e uso do token JWT.

Cadastro de categorias após o login.

Exibição dos dados em um Dashboard final.

Deploy da aplicação realizado via build JAR com Spring Boot.

📚 Documentação interativa da API com Swagger, facilitando testes e entendimento das rotas disponíveis.

IMPORTANTE!!!
Não tenho o deploy dessa API, mas para facilitar, deixei o Front end no deploy, então só basta rodar a API localmente que ela já faz a conexação com o Front end

https://full-stack-authentication-login-sen-theta.vercel.app/login


Como rodar:

Front end:
Clone esse repositorio na sua maquina:
git clone https://github.com/ElevirJJ/FullStack_authentication_login_senha.git
instale as dependecias:
npm install
Rode a aplicação:
npm run dev

Como rodar:

Back end:
Clone esse repositorio na sua maquina:
git clone https://github.com/ElevirJJ/Sistema_Financeiro.git
Altere a senha e configure o banco de dados


