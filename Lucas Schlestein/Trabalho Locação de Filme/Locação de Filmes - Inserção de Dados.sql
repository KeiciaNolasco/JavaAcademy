-- Inserindo Dados na Tabela GENEROS:
insert into GENEROS (NOME) values
('Ação'),
('Aventura'),
('Comédia'),
('Drama'),
('Fantasia'),
('Ficção Científica'),
('Super-herói');

-- Inserindo Dados na Tabela CATEGORIAS:
insert into CATEGORIAS (NOME, VALOR) values
('Lançamento', 5.00),
('Padrão', 2.50),
('Clássico', 1.00);

-- Inserindo Dados na Tabela FILMES:
insert into FILMES (TITULO_ORIGINAL, TITULO, QUANTIDADE, FK_COD_CAT, FK_COD_GEN) values
('Homem de Ferro', 'Homem de Ferro', 5, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('O Incrível Hulk', 'O Incrível Hulk', 3, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('Homem de Ferro 2', 'Homem de Ferro 2', 4, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('Thor', 'Thor', 4, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('Capitão América: O Primeiro Vingador', 'Capitão América: O Primeiro Vingador', 4, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('Os Vingadores', 'Os Vingadores', 6, (select COD_CAT from CATEGORIAS where NOME = 'Padrão'), (select COD_GEN from GENEROS where NOME= 'Fantasia')),
('Homem de Ferro 3', 'Homem de Ferro 3', 4, (select COD_CAT from CATEGORIAS where NOME = 'Padrão'), (select COD_GEN from GENEROS where NOME = 'Fantasia')),
('Thor: O Mundo Sombrio', 'Thor: O Mundo Sombrio', 3, (select COD_CAT from CATEGORIAS where NOME = 'Padrão'), (select COD_GEN from GENEROS where NOME = 'Fantasia')),
('Capitão América: O Soldado Invernal', 'Capitão América: O Soldado Invernal', 4, (select COD_CAT from CATEGORIAS where NOME = 'Clássico'), (select COD_GEN from GENEROS where NOME = 'Ficção Científica')),
('Guardiões da Galáxia', 'Guardiões da Galáxia', 5, (select COD_CAT from CATEGORIAS where NOME = 'Clássico'), (select COD_GEN from GENEROS where NOME = 'Ficção Científica')),
('Vingadores: Era de Ultron', 'Vingadores: Era de Ultron', 6, (select COD_CAT from CATEGORIAS where NOME = 'Clássico'), (select COD_GEN from GENEROS where NOME = 'Ficção Científica')),
('Homem-Formiga', 'Homem-Formiga', 3, (select COD_CAT from CATEGORIAS where NOME = 'Clássico'), (select COD_GEN from GENEROS where NOME = 'Ficção Científica')),
('Capitão América: Guerra Civil', 'Capitão América: Guerra Civil', 5, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('Doutor Estranho', 'Doutor Estranho', 4, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação')),
('Guardiões da Galáxia Vol. 2', 'Guardiões da Galáxia Vol. 2', 5, (select COD_CAT from CATEGORIAS where NOME = 'Lançamento'), (select COD_GEN from GENEROS where NOME = 'Ação'));

-- Inserindo Dados na Tabela ATORES:
insert into ATORES (NOME) values
('Robert Downey Jr.'),
('Chris Evans'),
('Chris Hemsworth'),
('Mark Ruffalo'),
('Scarlett Johansson'),
('Jeremy Renner'),
('Tom Holland'),
('Chadwick Boseman'),
('Benedict Cumberbatch'),
('Paul Rudd'),
('Brie Larson'),
('Chris Pratt'),
('Zoe Saldana'),
('Dave Bautista'),
('Josh Brolin');

-- Inserindo Dados na Tabela FILMES_ATORES:
insert into FILMES_ATORES (FK_COD_ATOR, FK_COD_FILME, ATOR, DIRETOR) values
((select COD_ATOR from ATORES where NOME = 'Robert Downey Jr.'), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Mark Ruffalo'), (select COD_FILME from FILMES where TITULO = 'O Incrível Hulk'), 'S', 'S'),
((select COD_ATOR from ATORES where NOME = 'Robert Downey Jr.'), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro 2'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Hemsworth'), (select COD_FILME from FILMES where TITULO = 'Thor'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Evans'), (select COD_FILME from FILMES where TITULO = 'Capitão América: O Primeiro Vingador'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Robert Downey Jr.'), (select COD_FILME from FILMES where TITULO = 'Os Vingadores'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Mark Ruffalo'), (select COD_FILME from FILMES where TITULO = 'Os Vingadores'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Evans'), (select COD_FILME from FILMES where TITULO = 'Os Vingadores'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Scarlett Johansson'), (select COD_FILME from FILMES where TITULO = 'Os Vingadores'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Jeremy Renner'), (select COD_FILME from FILMES where TITULO = 'Os Vingadores'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Robert Downey Jr.'), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro 3'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Hemsworth'), (select COD_FILME from FILMES where TITULO = 'Thor: O Mundo Sombrio'), 'S', 'S'),
((select COD_ATOR from ATORES where NOME = 'Chris Evans'), (select COD_FILME from FILMES where TITULO = 'Capitão América: O Soldado Invernal'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Pratt'), (select COD_FILME from FILMES where TITULO = 'Guardiões da Galáxia'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Robert Downey Jr.'), (select COD_FILME from FILMES where TITULO = 'Vingadores: Era de Ultron'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Evans'), (select COD_FILME from FILMES where TITULO = 'Vingadores: Era de Ultron'), 'S', 'S'),
((select COD_ATOR from ATORES where NOME = 'Chris Hemsworth'), (select COD_FILME from FILMES where TITULO = 'Vingadores: Era de Ultron'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Mark Ruffalo'), (select COD_FILME from FILMES where TITULO = 'Vingadores: Era de Ultron'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Jeremy Renner'), (select COD_FILME from FILMES where TITULO = 'Vingadores: Era de Ultron'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Benedict Cumberbatch'), (select COD_FILME from FILMES where TITULO = 'Doutor Estranho'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Chris Pratt'), (select COD_FILME from FILMES where TITULO = 'Guardiões da Galáxia Vol. 2'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Zoe Saldana'), (select COD_FILME from FILMES where TITULO = 'Guardiões da Galáxia Vol. 2'), 'S', 'N'),
((select COD_ATOR from ATORES where NOME = 'Dave Bautista'), (select COD_FILME from FILMES where TITULO = 'Guardiões da Galáxia Vol. 2'), 'S', 'N');

-- Inserindo Dados na Tabela ENDERECOS:
insert into ENDERECOS (LOGRADOURO, TIPO_LOG, COMPLEMENTO, CIDADE, UF, CEP, NUMERO, BAIRRO) values
('Rua das Flores', 'Rua', 'Apto 101', 'São Paulo', 'SP', '01001000', '100', 'Centro'),
('Avenida Paulista', 'Avenida', 'Conj. 200', 'São Paulo', 'SP', '01311200', '2000', 'Bela Vista'),
('Rua Augusta', 'Rua', 'Casa', 'São Paulo', 'SP', '01412100', '300', 'Consolação'),
('Rua da Consolação', 'Rua', 'Apto 202', 'São Paulo', 'SP', '01303000', '400', 'Consolação'),
('Rua Vergueiro', 'Rua', 'Bloco A', 'São Paulo', 'SP', '01504000', '500', 'Liberdade'),
('Avenida Faria Lima', 'Avenida', 'Conj. 300', 'São Paulo', 'SP', '01451001', '6000', 'Itaim Bibi'),
('Rua 25 de Março', 'Rua', 'Loja 10', 'São Paulo', 'SP', '01001010', '700', 'Centro'),
('Avenida Ipiranga', 'Avenida', 'Sala 500', 'São Paulo', 'SP', '01002000', '800', 'República'),
('Rua Oscar Freire', 'Rua', 'Casa', 'São Paulo', 'SP', '01426000', '900', 'Jardins'),
('Rua Haddock Lobo', 'Rua', 'Apto 303', 'São Paulo', 'SP', '01414001', '1000', 'Cerqueira César');

-- Inserindo Dados na Tabela PROFISSOES:
insert into PROFISSOES (NOME) values
('Engenheiro'),
('Médico'),
('Professor'),
('Advogado'),
('Arquiteto'),
('Programador'),
('Enfermeiro'),
('Farmacêutico'),
('Dentista'),
('Jornalista');

-- Inserindo Dados na Tabela CLIENTES:
insert into CLIENTES (CPF, NOME, TELEFONE, FK_COD_PROF) values
('12345678901', 'João Silva', '11987654321', (select COD_PROF from PROFISSOES where NOME = 'Engenheiro')),
('23456789012', 'Maria Souza', '11976543210', (select COD_PROF from PROFISSOES where NOME = 'Médico')),
('34567890123', 'José Santos', '11965432109', (select COD_PROF from PROFISSOES where NOME = 'Professor')),
('45678901234', 'Ana Oliveira', '11954321098', (select COD_PROF from PROFISSOES where NOME = 'Advogado')),
('56789012345', 'Carlos Pereira', '11943210987', (select COD_PROF from PROFISSOES where NOME = 'Arquiteto')),
('67890123456', 'Paula Lima', '11932109876', (select COD_PROF from PROFISSOES where NOME = 'Programador')),
('78901234567', 'Rafael Costa', '11921098765', (select COD_PROF from PROFISSOES where NOME = 'Enfermeiro')),
('89012345678', 'Fernanda Alves', '11910987654', (select COD_PROF from PROFISSOES where NOME = 'Farmacêutico')),
('90123456789', 'Lucas Rodrigues', '11909876543', (select COD_PROF from PROFISSOES where NOME = 'Dentista')),
('01234567890', 'Juliana Fernandes', '11998765432', (select COD_PROF from PROFISSOES where NOME = 'Jornalista'));

-- Inserindo Dados na Tabela DEPENDENTES:
insert into DEPENDENTES (FK_COD_CLI, FK_COD_DEP, PARENTESCO) values
((select COD_CLI from CLIENTES where NOME = 'João Silva'), (select COD_CLI from CLIENTES where NOME = 'Maria Souza'), 'Esposa'),
((select COD_CLI from CLIENTES where NOME = 'José Santos'), (select COD_CLI from CLIENTES where NOME = 'Ana Oliveira'), 'Filho'),
((select COD_CLI from CLIENTES where NOME = 'Carlos Pereira'), (select COD_CLI from CLIENTES where NOME = 'Paula Lima'), 'Filha'),
((select COD_CLI from CLIENTES where NOME = 'Rafael Costa'), (select COD_CLI from CLIENTES where NOME = 'Fernanda Alves'), 'Pai'),
((select COD_CLI from CLIENTES where NOME = 'Lucas Rodrigues'), (select COD_CLI from CLIENTES where NOME = 'Juliana Fernandes'), 'Mãe');

-- Inserindo Dados na Tabela CLIENTES_ENDERECOS:
insert into CLIENTES_ENDERECOS (FK_COD_END, FK_COD_CLI) values
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua das Flores' and NUMERO = '100'), (select COD_CLI from CLIENTES where NOME = 'João Silva')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua das Flores' and NUMERO = '100'), (select COD_CLI from CLIENTES where NOME = 'Maria Souza')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua Augusta' and NUMERO = '300'), (select COD_CLI from CLIENTES where NOME = 'José Santos')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua Augusta' and NUMERO = '300'), (select COD_CLI from CLIENTES where NOME = 'Ana Oliveira')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua Vergueiro' and NUMERO = '500'), (select COD_CLI from CLIENTES where NOME = 'Carlos Pereira')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua Vergueiro' and NUMERO = '500'), (select COD_CLI from CLIENTES where NOME = 'Paula Lima')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua 25 de Março' and NUMERO = '700'), (select COD_CLI from CLIENTES where NOME = 'Rafael Costa')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua 25 de Março' and NUMERO = '700'), (select COD_CLI from CLIENTES where NOME = 'Fernanda Alves')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua Oscar Freire' and NUMERO = '900'), (select COD_CLI from CLIENTES where NOME = 'Lucas Rodrigues')),
((select COD_END from ENDERECOS where LOGRADOURO = 'Rua Oscar Freire' and NUMERO = '900'), (select COD_CLI from CLIENTES where NOME = 'Juliana Fernandes'));

-- Inserindo Dados na Tabela LOCACOES:
insert into LOCACOES (DATA_LOC, DESCONTO, MULTA, SUB_TOTAL, FK_COD_CLI) values
('2022-01-01', 5.00, 2.00, 50.00, (select COD_CLI from CLIENTES where NOME = 'João Silva')),
('2022-01-05', 0.00, 0.00, 30.00, (select COD_CLI from CLIENTES where NOME = 'Maria Souza')),
('2022-01-10', 10.00, 0.00, 40.00, (select COD_CLI from CLIENTES where NOME = 'José Santos')),
('2022-01-15', 0.00, 5.00, 50.00, (select COD_CLI from CLIENTES where NOME = 'Ana Oliveira')),
('2022-01-20', 5.00, 0.00, 60.00, (select COD_CLI from CLIENTES where NOME = 'Carlos Pereira')),
('2022-01-25', 0.00, 2.00, 70.00, (select COD_CLI from CLIENTES where NOME = 'Paula Lima')),
('2022-02-01', 0.00, 0.00, 80.00, (select COD_CLI from CLIENTES where NOME = 'Rafael Costa')),
('2022-02-05', 10.00, 0.00, 90.00, (select COD_CLI from CLIENTES where NOME = 'Fernanda Alves')),
('2022-02-10', 0.00, 5.00, 100.00, (select COD_CLI from CLIENTES where NOME = 'Lucas Rodrigues')),
('2022-02-15', 0.00, 0.00, 110.00, (select COD_CLI from CLIENTES where NOME = 'Juliana Fernandes')),
('2022-02-20', 5.00, 2.00, 120.00, (select COD_CLI from CLIENTES where NOME = 'João Silva')),
('2022-02-25', 0.00, 0.00, 130.00, (select COD_CLI from CLIENTES where NOME = 'Maria Souza')),
('2022-03-01', 10.00, 0.00, 140.00, (select COD_CLI from CLIENTES where NOME = 'José Santos')),
('2022-03-05', 0.00, 5.00, 150.00, (select COD_CLI from CLIENTES where NOME = 'Ana Oliveira')),
('2022-03-10', 5.00, 0.00, 160.00, (select COD_CLI from CLIENTES where NOME = 'Carlos Pereira')),
('2022-03-15', 0.00, 2.00, 170.00, (select COD_CLI from CLIENTES where NOME = 'Paula Lima')),
('2022-03-20', 0.00, 0.00, 180.00, (select COD_CLI from CLIENTES where NOME = 'Rafael Costa')),
('2022-03-25', 10.00, 0.00, 190.00, (select COD_CLI from CLIENTES where NOME = 'Fernanda Alves')),
('2022-04-01', 0.00, 5.00, 200.00, (select COD_CLI from CLIENTES where NOME = 'Lucas Rodrigues')),
('2022-04-05', 0.00, 0.00, 210.00, (select COD_CLI from CLIENTES where NOME = 'Juliana Fernandes'));

-- Inserindo Dados na Tabela LOCACOES_FILMES:
insert into LOCACOES_FILMES (FK_COD_LOC, FK_COD_FILME, VALOR, NUM_DIAS, DATA_DEVOL) values
((select COD_LOC from LOCACOES where DATA_LOC = '2022-01-01' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'João Silva')), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro'), 10.00, 3, '2022-01-04'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-01-05' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Maria Souza')), (select COD_FILME from FILMES where TITULO = 'O Incrível Hulk'), 15.00, 4, '2022-01-09'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-01-10' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'José Santos')), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro 2'), 20.00, 5, '2022-01-15'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-01-15' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Ana Oliveira')), (select COD_FILME from FILMES where TITULO = 'Thor'), 25.00, 6, '2022-01-21'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-01-20' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Carlos Pereira')), (select COD_FILME from FILMES where TITULO = 'Capitão América: O Primeiro Vingador'), 30.00, 7, '2022-01-27'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-01-25' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Paula Lima')), (select COD_FILME from FILMES where TITULO = 'Os Vingadores'), 35.00, 8, '2022-02-02'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-02-01' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Rafael Costa')), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro 3'), 40.00, 9, '2022-02-08'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-02-05' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Fernanda Alves')), (select COD_FILME from FILMES where TITULO = 'Thor: O Mundo Sombrio'), 45.00, 10, '2022-02-14'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-02-10' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Lucas Rodrigues')), (select COD_FILME from FILMES where TITULO = 'Capitão América: O Soldado Invernal'), 50.00, 11, '2022-02-20'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-02-15' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Juliana Fernandes')), (select COD_FILME from FILMES where TITULO = 'Guardiões da Galáxia'), 55.00, 12, '2022-02-26'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-02-20' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'João Silva')), (select COD_FILME from FILMES where TITULO = 'Homem de Ferro 3'), 60.00, 13, '2022-03-04'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-02-25' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Maria Souza')), (select COD_FILME from FILMES where TITULO = 'Thor: O Mundo Sombrio'), 65.00, 14, '2022-03-10'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-03-01' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'José Santos')), (select COD_FILME from FILMES where TITULO = 'Capitão América: O Soldado Invernal'), 70.00, 15, '2022-03-16'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-03-05' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Ana Oliveira')), (select COD_FILME from FILMES where TITULO = 'Vingadores: Era de Ultron'), 75.00, 16, '2022-03-22'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-03-10' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Carlos Pereira')), (select COD_FILME from FILMES where TITULO = 'Homem-Formiga'), 80.00, 17, '2022-03-28'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-03-15' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Paula Lima')), (select COD_FILME from FILMES where TITULO = 'Capitão América: Guerra Civil'), 85.00, 18, '2022-04-04'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-03-20' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Rafael Costa')), (select COD_FILME from FILMES where TITULO = 'Doutor Estranho'), 90.00, 19, '2022-04-10'),
((select COD_LOC from LOCACOES where DATA_LOC = '2022-03-25' and FK_COD_CLI = (select COD_CLI from CLIENTES where NOME = 'Fernanda Alves')), (select COD_FILME from FILMES where TITULO = 'Guardiões da Galáxia Vol. 2'), 95.00, 20, '2022-04-15');