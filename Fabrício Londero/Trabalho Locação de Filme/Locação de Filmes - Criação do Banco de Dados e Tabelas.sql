-- Criação do Banco de Dados Locação de Filmes:
create database LocacaoFilme;

-- Criação da Tabela GENEROS:
create table GENEROS
(
    COD_GEN serial primary key not null,
    NOME varchar(60)
);

-- Criação da Tabela CATEGORIAS:
create table CATEGORIAS 
(
    COD_CAT serial primary key not null,
    NOME varchar(60),
    VALOR numeric(15,2)
);

-- Criação da Tabela FILMES:
create table FILMES 
(
    COD_FILME serial primary key not null,
    TITULO_ORIGINAL varchar(100),
    TITULO varchar(100),
    QUANTIDADE integer,
    FK_COD_CAT integer not null,
    FK_COD_GEN integer not null,
    foreign key (FK_COD_CAT) references CATEGORIAS (COD_CAT),
    foreign key (FK_COD_GEN) references GENEROS (COD_GEN)
);

-- Criação da Tabela ATORES:
create table ATORES 
(
    COD_ATOR serial primary key not null,
    NOME varchar(60)
);

-- Criação da Tabela FILMES_ATORES:
create table FILMES_ATORES 
(
    FK_COD_ATOR integer not null,
    FK_COD_FILME integer not null,
	ATOR varchar(1),
    DIRETOR varchar(1),
    primary key (FK_COD_ATOR, FK_COD_FILME),
    foreign key (FK_COD_ATOR) references ATORES (COD_ATOR),
    foreign key (FK_COD_FILME) references FILMES (COD_FILME)
);

-- Criação da Tabela ENDERECOS:
create table ENDERECOS 
(
    COD_END serial primary key not null,
    LOGRADOURO varchar(40),
    TIPO_LOG varchar(40),
    COMPLEMENTO varchar(20),
    CIDADE varchar(60),
    UF varchar(2),
    CEP varchar(8),
    NUMERO varchar(10),
    BAIRRO varchar(60)
);

-- Criação da Tabela PROFISSÕES:
create table PROFISSOES 
(
    COD_PROF serial primary key not null,
    NOME varchar(60)
);

-- Criação da Tabela CLIENTES:
create table CLIENTES 
(
    COD_CLI serial primary key not null,
    CPF varchar(11),
    NOME varchar(60),
    TELEFONE varchar(11),
    FK_COD_PROF integer,
	foreign key (FK_COD_PROF) references PROFISSOES (COD_PROF)
);

-- Criação da Tabela DEPENDENTES:
create table DEPENDENTES 
(
    FK_COD_CLI integer not null,
    FK_COD_DEP integer not null,
    PARENTESCO varchar(20),
    primary key (FK_COD_CLI, FK_COD_DEP),
    foreign key (FK_COD_CLI) references CLIENTES (COD_CLI),
	foreign key (FK_COD_DEP) references CLIENTES (COD_CLI)
);

-- Criação da Tabela CLIENTES_ENDERECOS:
create table CLIENTES_ENDERECOS 
(
    FK_COD_END integer not null,
    FK_COD_CLI integer not null,
    primary key (FK_COD_END, FK_COD_CLI),
    foreign key (FK_COD_END) references ENDERECOS (COD_END),
    foreign key (FK_COD_CLI) references CLIENTES (COD_CLI)
);

-- Criação da Tabela LOCACOES:
create table LOCACOES 
(
    COD_LOC serial primary key not null,
    DATA_LOC date,
    DESCONTO numeric(15,2),
    MULTA numeric(15,2),
    SUB_TOTAL numeric(15,2),
    FK_COD_CLI integer not null,
    foreign key (FK_COD_CLI) references CLIENTES (COD_CLI)
);

-- Criação da Tabela LOCACOES_FILMES:
create table LOCACOES_FILMES 
(
    FK_COD_LOC integer not null,
    FK_COD_FILME integer not null,
    VALOR numeric(15,2),
    NUM_DIAS integer,
    DATA_DEVOL date,
    primary key (FK_COD_LOC, FK_COD_FILME),
    foreign key (FK_COD_LOC) references LOCACOES (COD_LOC),
    foreign key (FK_COD_FILME) references FILMES (COD_FILME)
);
