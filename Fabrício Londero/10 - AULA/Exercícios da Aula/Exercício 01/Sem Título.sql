-- Ciando Banco de Dados Biblioteca:
CREATE DATABASE Biblioteca;

-- Criando a Tabela Categoria:
CREATE TABLE Categoria 
(
    ID SERIAL PRIMARY KEY,
    tipo_categoria VARCHAR(100) NOT NULL
);

-- Criando a Tabela Editora:
CREATE TABLE Editora 
(
    ID SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Criando a Tabela Autor:
CREATE TABLE Autor 
(
    ID SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nacionalidade VARCHAR(100) NOT NULL
);

-- Criando a Tabela Livro:
CREATE TABLE Livro 
(
    isbn VARCHAR(30) PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano_publicacao INT NOT NULL,
    fk_editora INT NOT NULL,
    fk_categoria INT NOT NULL,
    FOREIGN KEY (fk_editora) REFERENCES Editora(ID),
    FOREIGN KEY (fk_categoria) REFERENCES Categoria(ID)
);

-- Criando a Tabela LivroAutor:
CREATE TABLE LivroAutor 
(
    ID SERIAL PRIMARY KEY,
    fk_livro VARCHAR(13) NOT NULL,
    fk_author INT NOT NULL,
    FOREIGN KEY (fk_livro) REFERENCES Livro(isbn),
    FOREIGN KEY (fk_author) REFERENCES Autor(ID)
);

-- Inserindo Dados na Tabela Categoria:
INSERT INTO Categoria (tipo_categoria) 
VALUES ('Literatura Juvenil'), ('Ficção Científica'), ('Humor');

-- Inserindo Dados na Tabela Editora:
INSERT INTO Editora (nome) 
VALUES ('Rocco'), ('Wmf Martins Fontes'), ('Casa da Palavra'), ('Belas Letras'), ('Matrix');

-- Inserindo Dados na Tabela Autor:
INSERT INTO Autor (nome, nacionalidade) 
VALUES ('J. K. Rowling', 'Inglaterra'), ('Clive Staples Lewis', 'Inglaterra'), ('Affonso Solano', 'Brasil'), ('Marcos Piangers', 'Brasil'), ('Ciro Botelho – Tiririca', 'Brasil'), ('Bianca Mól', 'Brasil');

-- Inserindo Dados na Tabela Livro:
INSERT INTO Livro (isbn, titulo, ano_publicacao, fk_editora, fk_categoria) 
VALUES ('8532511015', 'Harry Potter e A Pedra Filosofal', 2000, 1, 1), ('9788578270698', 'As Crônicas de Nárnia', 2009, 2, 1), ('9788577343348', 'O Espadachim de Carvão', 2013, 3, 2), ('9788581742458', 'O Papai É Pop', 2015, 4, 3), ('9788582302026', 'Pior Que Tá Não Fica', 2015, 5, 3), ('9788577345670', 'Garota Desdobrável', 2015, 3, 1), ('8532512062', 'Harry Potter e o prisioneiro de Azkaban', 2000, 1, 1);

-- Inserindo Dados na Tabela LivroAutor:
INSERT INTO LivroAutor (fk_livro, fk_author)
VALUES ('8532511015', 1), ('9788578270698', 2), ('9788577343348', 3), ('9788581742458', 4), ('9788582302026', 5), ('9788577345670', 6), ('8532512062', 1);
