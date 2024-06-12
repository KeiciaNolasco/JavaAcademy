create table editoras
(
	id serial primary key,
	nome varchar(60) not null
);
 
create table categorias
(
	id serial primary key,
	nome varchar(60) not null
);
 
create table autores
(
	id serial primary key,
	nome varchar(120) not null,
	nacionalidade varchar(60)
);
 
create table livros
(
	ISBN varchar(22) primary key,
	titulo varchar(40) not null,
	ano_publicacao integer not null,
	fk_editora integer,
	fk_categoria integer,
	foreign key (fk_editora) references editoras(id),
	foreign key (fk_categoria) references categorias(id)
);
 
create table livro_autor
(
	id serial primary key,
	fk_livro varchar(22),
	fk_autor integer,
	foreign key (fk_livro) references livros(isbn),
	foreign key (fk_autor) references autores(id)
);