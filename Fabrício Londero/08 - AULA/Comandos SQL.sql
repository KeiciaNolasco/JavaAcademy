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

INSERT 

DELETE

UPDATE

select * from cursos