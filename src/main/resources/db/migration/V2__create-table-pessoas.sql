	CREATE TABLE pessoas (
        id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(50) NOT NULL,
        logradouro VARCHAR(30),
        numero VARCHAR(30),
        complemento VARCHAR(30),
        bairro VARCHAR(30),
        cep VARCHAR(30),
        cidade VARCHAR(30),
        estado VARCHAR(30),
        ativo BOOLEAN NOT NULL
    );