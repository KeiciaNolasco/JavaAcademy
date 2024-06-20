create database dinossauros;

create table regioes
(
	id serial primary key,
	nome varchar(70) not null
)
 
create table grupos
(
	id serial primary key,
	nome varchar(30) not null
)
 
create table eras
(
	id serial primary key,
	nome varchar(30) not null
)
 
create table descobridores
(
	id serial primary key,
	nome varchar(80) not null
)
 
create table dinossauros
(
	id serial primary key,
	nome varchar(70) not null,
	toneladas integer not null,
	ano_descoberta integer not null,
	fk_grupo integer,
	fk_descobridor integer,
	fk_era integer,
	inicio integer,
	fim integer,
	fk_regiao integer,
	foreign key (fk_grupo) references grupos(id),
	foreign key (fk_descobridor) references descobridores(id),
	foreign key (fk_era) references eras(id),
	foreign key (fk_regiao) references regioes(id)
)

INSERT INTO regioes (nome) VALUES ('Mongólia');
INSERT INTO regioes (nome) VALUES ('Canadá');
INSERT INTO regioes (nome) VALUES ('Tanzânia');
INSERT INTO regioes (nome) VALUES ('China');
INSERT INTO regioes (nome) VALUES ('América do Norte');
INSERT INTO regioes (nome) VALUES ('USA');

INSERT INTO grupos (nome) VALUES ('Anquilossauros');
INSERT INTO grupos (nome) VALUES ('Ceratopsídeos');
INSERT INTO grupos (nome) VALUES ('Estegossauros');
INSERT INTO grupos (nome) VALUES ('Terópodes');

INSERT INTO eras (nome) VALUES ('Cretáceo');
INSERT INTO eras (nome) VALUES ('Jurássico');

INSERT INTO descobridores (nome) VALUES ('Maryanska');
INSERT INTO descobridores (nome) VALUES ('John Bell Hatcher');
INSERT INTO descobridores (nome) VALUES ('Cientistas Alemães');
INSERT INTO descobridores (nome) VALUES ('Museu Americano de História Natural');
INSERT INTO descobridores (nome) VALUES ('Othniel Charles Marsh');
INSERT INTO descobridores (nome) VALUES ('Barnum Brown');

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Saichania', 4, 1977, (SELECT id FROM grupos WHERE nome = 'Anquilossauros'), (SELECT id FROM descobridores WHERE nome = 'Maryanska'), (SELECT id FROM eras WHERE nome = 'Cretáceo'), 145, 66, (SELECT id FROM regioes WHERE nome = 'Mongólia'));
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Tricerátops', 6, 1887, (SELECT id FROM grupos WHERE nome = 'Ceratopsídeos'), (SELECT id FROM descobridores WHERE nome = 'John Bell Hatcher'), (SELECT id FROM eras WHERE nome = 'Cretáceo'), 70, 66, (SELECT id FROM regioes WHERE nome = 'Canadá'));
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Kentrossauro', 2, 1909, (SELECT id FROM grupos WHERE nome = 'Estegossauros'), (SELECT id FROM descobridores WHERE nome = 'Cientistas Alemães'), (SELECT id FROM eras WHERE nome = 'Jurássico'), 201, 145, (SELECT id FROM regioes WHERE nome = 'Tanzânia'));
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Pinacossauro', 6, 1999, (SELECT id FROM grupos WHERE nome = 'Anquilossauros'), (SELECT id FROM descobridores WHERE nome = 'Museu Americano de História Natural'), (SELECT id FROM eras WHERE nome = 'Cretáceo'), 85, 75, (SELECT id FROM regioes WHERE nome = 'China'));
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Alossauro', 3, 1877, (SELECT id FROM grupos WHERE nome = 'Terópodes'), (SELECT id FROM descobridores WHERE nome = 'Othniel Charles Marsh'), (SELECT id FROM eras WHERE nome = 'Jurássico'), 155, 150, (SELECT id FROM regioes WHERE nome = 'América do Norte'));
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Torossauro', 8, 1891, (SELECT id FROM grupos WHERE nome = 'Ceratopsídeos'), (SELECT id FROM descobridores WHERE nome = 'John Bell Hatcher'), (SELECT id FROM eras WHERE nome = 'Cretáceo'), 67, 65, (SELECT id FROM regioes WHERE nome = 'USA'));
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Anquilossauro', 6, 1906, (SELECT id FROM grupos WHERE nome = 'Anquilossauros'), (SELECT id FROM descobridores WHERE nome = 'Barnum Brown'), (SELECT id FROM eras WHERE nome = 'Cretáceo'), 66, 63, (SELECT id FROM regioes WHERE nome = 'América do Norte'));

-- Selecão da Tabela de Dinossauros:
SELECT * FROM dinossauros;

-- Selecão da Tabela de Dinossauros por Nome:
SELECT * FROM dinossauros d
ORDER BY nome;

-- Selecão da Tabela de Dinossauros por Nome:
SELECT nome FROM dinossauros;

-- Selecão da Tabela de Dinossauros por Toneladas maior que 4:
SELECT * FROM dinossauros
WHERE toneladas > 4;

-- Selecão da Tabela de Dinossauros por Ano da Descoberta:
SELECT * FROM dinossauros
WHERE ano_descoberta = 1909;

-- Selecão da Tabela de Dinossauros por Ano da Descoberta:
SELECT * FROM dinossauros d
JOIN grupos g ON d.fk_grupo = g.id
WHERE g.nome = 'Anquilossauros'
ORDER BY d.ano_descoberta;

-- Selecão da Tabela de Dinossauros por Descobridor:
SELECT * FROM dinossauros
JOIN descobridores des ON d.fk_descobridor = des.id
ORDER BY des.nome;

-- Selecão da Tabela de Dinossauros por Ano da Descoberta e Toneladas:
SELECT * FROM dinossauros
WHERE ano_descoberta = 1909 AND toneladas > 4;

-- Selecão da Tabela de Dinossauros por Ceratopsídeos ou Anquilossauros entre 1900 e 1999:
SELECT * FROM dinossauros d
JOIN grupos g ON d.fk_grupo = g.id
WHERE (g.nome = 'Ceratopsídeos' OR g.nome = 'Anquilossauros') 
AND d.ano_descoberta BETWEEN 1900 AND 1999;

-- Selecão da Tabela de Dinossauros por Ordem de Nome:
SELECT nome, toneladas FROM dinossauros
ORDER BY nome;

-- Selecão das Tabelas de Todos os Dinossauros e Todos os Grupos (Forma Errada):
SELECT * FROM dinossauros, grupos; 

-- Selecão das Tabelas de Dinossauros e de Grupos com Todas as Informações:
SELECT * FROM dinossauros, grupos
WHERE dinossauros.fk_grupo = grupos.id;
      -- Com uso de Inner Join: 
select * from dinossauros
inner join grupos
on dinossauros.fk_grupo = grupos.id

-- Selecão das Tabelas de Dinossauros e de Grupos Somente os Nomes:
SELECT dinossauros.nome, grupos.nome FROM dinossauros, grupos
WHERE dinossauros.fk_grupo = grupos.id;

-- Selecão das Tabelas de Dinossauros e de Grupos Somente os Nomes Ordenados:
SELECT * FROM dinossauros, grupos
WHERE dinossauros.fk_grupo = grupos.id
ORDER BY dinossauros.nome

-- Selecão das Tabelas de Dinossauros, de Grupos e de Descobridores Somente os Nomes Ordenados:
SELECT * FROM dinossauros, grupos, descobridores
WHERE dinossauros.fk_grupo = grupos.id and dinossauros.fk_descobridor = descobridores.id
ORDER BY dinossauros.nome

-- Selecão das Tabelas de Dinossauros, de Grupos, de Descobridores e de Eras Somente os Nomes Ordenados:
SELECT * FROM dinossauros, grupos, descobridores, eras
WHERE dinossauros.fk_grupo = grupos.id and dinossauros.fk_descobridor = descobridores.id AND dinossauros.fk_era = eras.id
ORDER BY dinossauros.nome

-- Selecão das Tabelas de Dinossauros, de Grupos, de Descobridores, de Eras e de Regiões Somente os Nomes Ordenados:
SELECT * FROM dinossauros, grupos, descobridores, eras, regioes
WHERE dinossauros.fk_grupo = grupos.id and dinossauros.fk_descobridor = descobridores.id AND dinossauros.fk_era = eras.id AND dinossauros.fk_regiao = regioes.id
ORDER BY dinossauros.nome

-- Select (o que quero selecionar), From (de onde quero selecionar, tabelas mães), Where (de onde quero selecionar, mistura as chaves), Order By (a ordem de selecão dos dados) e As (Como vai aparecer a seleção):
select dinossauros.id, dinossauros.nome, dinossauros.toneladas, dinossauros.ano_descoberta, grupos.nome, descobridores.nome, eras.nome, dinossauros.inicio, dinossauros.fim, regioes.nome
from dinossauros, grupos, descobridores, eras, regioes
where dinossauros.fk_grupo = grupos.id and dinossauros.fk_descobridor = descobridores.id and dinossauros.fk_era = eras.id and dinossauros.fk_regiao = regioes.id
order by dinossauros.nome
      -- Com uso de Join: 
select dinossauros.nome, dinossauros.toneladas, dinossauros.ano_descoberta, grupos.nome as Grupo, descobridores.nome as Descobridor, eras.nome as Era, dinossauros.inicio, dinossauros.fim, regioes.nome as Região
from dinossauros
join grupos on dinossauros.fk_grupo = grupos.id
join descobridores on dinossauros.fk_descobridor = descobridores.id
join eras on dinossauros.fk_era = eras.id
join regioes on dinossauros.fk_regiao = regioes.id
order by dinossauros.nome

