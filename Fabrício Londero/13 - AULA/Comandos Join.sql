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

-- Usando o Left Join para Junção de Tabelas (Java vai aparecer do lado Esquerdo com Todos os Dados) (Os Dados de Dotnet vão ser Somente os que são Iguais ao do Lado Esquerdo Java):
SELECT * FROM java
LEFT JOIN dotnet
ON java.professor = dotnet.professor

-- Usando o Left Join Exclusivo para Junção de Tabelas (Deixa Somentes os Dados do Lado Esquerdo Java) (Apaga os Dados de Java que se Repetem em Dotnet):
SELECT * FROM java
LEFT JOIN dotnet
ON java.professor = dotnet.professor
WHERE dotnet.professor IS NULL

-- Usando o Right Join para Junção de Tabelas (Dotnet vai aparecer do Lado Direito com todos os Dados) (Os Dados de Java vão ser Somente os que são Iguais ao do Lado Direito Dotnet):
SELECT * FROM java
RIGHT JOIN dotnet
ON java.professor = dotnet.professor

-- Usando o Right Join Exclusivo para Junção de Tabelas (Deixa Somentes os Dados do Lado Direito Dotnet) (Apaga os Dados de Dotnet que se Repetem em Java):
SELECT * FROM java
RIGHT JOIN dotnet
ON java.professor = dotnet.professor
WHERE dotnet.professor IS NULL

-- Full Outer Join, Fornece todos os dados das Tabelas:
SELECT * FROM java
FULL OUTER JOIN dotnet
ON java.professor = dotnet.professor

-- Full Outer Join Exclusivo:
SELECT * FROM java
FULL OUTER JOIN dotnet
ON java.professor = dotnet.professor
WHERE java.professor IS NULL OR dotnet.professor IS NULL