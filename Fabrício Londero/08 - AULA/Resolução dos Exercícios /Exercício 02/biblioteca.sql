create table editoras
(
	id serial primary key,
	nome varchar(60) not null
)
 
create table categorias
(
	id serial primary key,
	nome varchar(60) not null
)
 
create table autores
(
	id serial primary key,
	nome varchar(120) not null,
	nacionalidade varchar(60)
)

