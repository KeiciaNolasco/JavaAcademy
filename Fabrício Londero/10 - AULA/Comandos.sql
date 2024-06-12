--DDL -> Data Definition Language

CREATE DATABASE aula

DROP DATABASE aula; 

CREATE TABLE cursos
(
	id integer,
	nome varchar(50),
	ch integer
)

create table pessoas
(
	CPF varchar(11) primary key,
	RG varchar(10) unique,
)

ALTER

ALTER TABLE cursos
add column coordenador varchar(120)

ALTER TABLE cursos
drop column coordenador

alter table cursos
alter column coordenador type varchar(100)

-- Banco de Dados Matricula

create database matriculas

create table alunos
	(
	id serial primary key,
	nome varchar(100) not null
	)

select * from alunos

create table professores
(
	id serial primary key,
	nome varchar(100) not null
)

select * from professores

create table cursos
(
	id serial primary key,
	nome varchar(60) not null,
	fk_coodenador INTEGER not null,
	constraint fk_coordenador_constraint
	foreign key (fk_coordenador) references professores(id)
)

select * from cursos

create table matriculas
(
	id serial primary key,
	fk_aluno integer not null,
	fk_curso integer not null,
	foreign key (fk_aluno) references alunos(id),
	foreign key (fk_curso) references cursos(id),
	
)

select * from matriculas

--DML -> Data Manipulation Language

SELECT

-- Selecionando a tabela matriculas:
select * from matriculas
	
INSERT 

-- Inserindo Valores nas tabelas:	
insert into categorias(nome) values ('Horror');

-- Inserindo Valores nas tabela livros:	
insert into livros(isbn, titulo, ano_publicacao, fk_editora, fk_categoria)
values ('561654641', 'Harry Potter', 1920, 5, 4)

DELETE

-- Deletando todos os valores da tabela editora:
delete from editoras;

-- Deletando o valor da tabela editora com id = 3:
delete from editoras where id = 3;

-- Deletando o valor da tabela editora com nome = Sextante:
delete from editoras where nome = 'Sextante';

UPDATE

-- Atualizando o valor nome da tabela editora:
update editoras set nome = 'Sextante';

-- Atualizando o valor nome da tabela editora, onde o id = 6:
update editoras set nome = 'Sextante' where id = 6;

update livros set fk_categoria = 1 where titulo = 'Cthulhu'
