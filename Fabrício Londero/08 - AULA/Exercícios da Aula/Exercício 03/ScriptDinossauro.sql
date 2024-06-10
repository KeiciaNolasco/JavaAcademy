-- Criando Banco de Dados Paleontologia

CREATE DATABASE paleontologia;

-- Criando da tabela ERA
CREATE TABLE ERA (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    inicio_milhoes_anos INT NOT NULL,
    fim_milhoes_anos INT NOT NULL
);

select * from ERA

-- Criando da tabela GRUPO
CREATE TABLE GRUPO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

select * from GRUPO

-- Criando da tabela DESCOBRIDOR
CREATE TABLE DESCOBRIDOR 
(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

select * from DESCOBRIDOR

-- Criando da tabela PAIS
CREATE TABLE PAIS 
(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

select * from PAIS

-- Criando da tabela DINOSSAURO
CREATE TABLE DINOSSAURO 
(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    fk_grupo INT REFERENCES GRUPO(id),
    toneladas INT,
    ano_descoberta INT,
    fk_descobridor INT REFERENCES DESCOBRIDOR(id),
    fk_era INT REFERENCES ERA(id),
    fk_pais INT REFERENCES PAIS(id)
);

select * from DINOSSAURO