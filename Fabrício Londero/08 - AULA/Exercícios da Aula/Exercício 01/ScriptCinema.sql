-- Criando banco de dados cinema:

CREATE DATABASE cinema;

-- Criando tabela TIPO_EVENTO:
CREATE TABLE TIPO_EVENTO (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL
);

select * from TIPO_EVENTO

-- Criando tabela EVENTOS:
CREATE TABLE EVENTOS (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_ini DATE NOT NULL,
    data_fim DATE NOT NULL,
    localizacao VARCHAR(200) NOT NULL,
    fk_tipo INTEGER NOT NULL,
    FOREIGN KEY (fk_tipo) REFERENCES TIPO_EVENTO(id)
);

select * from EVENTOS

-- Criando tabela PESSOAS:
CREATE TABLE PESSOAS (
    cpf CHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    fone VARCHAR(15) NOT NULL
);

select * from PESSOAS

-- Criando tabela INGRESSOS:
CREATE TABLE INGRESSOS (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    lugar VARCHAR(200) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade INTEGER NOT NULL,
    fk_evento INTEGER NOT NULL,
    FOREIGN KEY (fk_evento) REFERENCES EVENTOS(id)
);

select * from INGRESSOS

-- Criando tabela COMPRA:
CREATE TABLE COMPRA (
    id SERIAL PRIMARY KEY,
    fk_pessoa CHAR(11) NOT NULL,
    fk_ingresso INTEGER NOT NULL,
    quantidade INTEGER NOT NULL,
    FOREIGN KEY (fk_pessoa) REFERENCES PESSOAS(cpf),
    FOREIGN KEY (fk_ingresso) REFERENCES INGRESSOS(id)
);

select * from COMPRA

-- Criando tabela PROGRAMACAO:
CREATE TABLE PROGRAMACAO (
    id SERIAL PRIMARY KEY,
    fk_evento INTEGER NOT NULL,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT NOT NULL,
    data_ini TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    lugar VARCHAR(200) NOT NULL,
    responsavel VARCHAR(200) NOT NULL,
    FOREIGN KEY (fk_evento) REFERENCES EVENTOS(id)
);

select * from PROGRAMACAO
