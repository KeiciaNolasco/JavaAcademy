-- Criando Banco de Dados Biblioteca

CREATE DATABASE biblioteca;

-- Criando da tabela EDITORA
CREATE TABLE EDITORA (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

select * from EDITORA

-- Criando da tabela CATEGORIA
CREATE TABLE CATEGORIA (
    id SERIAL PRIMARY KEY,
    tipo_categoria VARCHAR(100) NOT NULL
);

select * from CATEGORIA

-- Criando da tabela AUTOR
CREATE TABLE AUTOR (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(100)
);

select * from AUTOR

-- Criando da tabela LIVRO
CREATE TABLE LIVRO (
    isbn VARCHAR(22) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano_publicacao INT,
    fk_editora INT REFERENCES EDITORA(id),
    fk_categoria INT REFERENCES CATEGORIA(id)
);

select * from LIVRO

-- Criando da tabela LIVROAUTOR
CREATE TABLE LIVROAUTOR (
    id SERIAL PRIMARY KEY,
    fk_livro VARCHAR(22) REFERENCES LIVRO(isbn),
    fk_autor INT REFERENCES AUTOR(id)
);

select * from LIVROAUTOR
