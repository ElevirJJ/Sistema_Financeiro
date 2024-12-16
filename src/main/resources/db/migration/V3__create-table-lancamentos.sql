CREATE TABLE lancamentos (
    id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(50) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento DATE,
    valor DECIMAL(10,2) NOT NULL,
    observacao VARCHAR(100),
    tipoLancamento ENUM('RECEITA', 'DESPESA') NOT NULL DEFAULT 'DESPESA',
    categoria BIGINT(20) NOT NULL,
    pessoa BIGINT(20) NOT NULL,
    FOREIGN KEY (categoria) REFERENCES categorias(id),
    FOREIGN KEY (pessoa) REFERENCES pessoas(id)
);

