CREATE DATABASE dinossauros;

CREATE TABLE regioes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(70) NOT NULL
);

CREATE TABLE grupos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL
);

CREATE TABLE eras (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30) NOT NULL,
    ano_inicio INTEGER NOT NULL,
    ano_fim INTEGER NOT NULL
);

CREATE TABLE descobridores (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(80) NOT NULL
);

CREATE TABLE dinossauros (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(70) NOT NULL,
    toneladas INTEGER NOT NULL,
    ano_descoberta INTEGER NOT NULL,
    fk_grupo INTEGER,
    fk_descobridor INTEGER,
    fk_era INTEGER,
    inicio INTEGER,
    fim INTEGER,
    fk_regiao INTEGER,
    FOREIGN KEY (fk_grupo) REFERENCES grupos(id),
    FOREIGN KEY (fk_descobridor) REFERENCES descobridores(id),
    FOREIGN KEY (fk_era) REFERENCES eras(id),
    FOREIGN KEY (fk_regiao) REFERENCES regioes(id)
);
