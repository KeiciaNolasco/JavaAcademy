CREATE DATABASE joins;

CREATE TABLE java
(
	professor varchar(20) NULL
);

CREATE TABLE dotnet
(
	professor varchar(20) NULL
);

INSERT INTO java VALUES ('Fabricio'), ('Lucas'), ('Reiner');

INSERT INTO dotnet VALUES ('Fabricio'), ('Ricardo');

SELECT * FROM java;

SELECT * FROM dotnet;

-- Usando o Inner Join para Junção de Tabelas:
SELECT * FROM java
INNER JOIN dotnet
ON java.professor = dotnet.professor
