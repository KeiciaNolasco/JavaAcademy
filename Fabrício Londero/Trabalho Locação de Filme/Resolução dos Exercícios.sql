-- SOLUÇÃO DA LISTA DE EXERCÍCIOS

-- 1 Listar todos os filmes alugados por um cliente específico, incluindo a data de locação e a data de devolução:
select C.NOME as Cliente, F.TITULO as Filme, L.DATA_LOC as DataLocacao, LF.DATA_DEVOL as DataDevolucao 
from CLIENTES C
join LOCACOES L on C.COD_CLI = L.FK_COD_CLI
join LOCACOES_FILMES LF on L.COD_LOC = LF.FK_COD_LOC
join FILMES F on LF.FK_COD_FILME = F.COD_FILME
where C.NOME = 'nome do cliente';

-- 2 Obter uma lista de clientes e seus dependentes:
select C.NOME as Cliente, D.NOME as Dependente, DEP.PARENTESCO as Parentesco 
from CLIENTES C
join DEPENDENTES DEP on C.COD_CLI = DEP.FK_COD_CLI
join CLIENTES D on DEP.FK_COD_DEP = D.COD_CLI;

-- 3 Listar todos os filmes de um determinado gênero:
select F.TITULO as Filme, G.NOME as Genero 
from FILMES F
join GENEROS G on F.FK_COD_GEN = G.COD_GEN
where G.NOME = 'nome do genero';

-- 4 Exibir todos os clientes que têm uma profissão específica:
select C.NOME as Cliente, P.NOME as Profissao
from CLIENTES C
join PROFISSOES P on C.FK_COD_PROF = P.COD_PROF
where P.NOME = 'nome da profissao';

-- 5 Encontrar todos os filmes em uma categoria específica com quantidade disponível maior que 5:
select F.TITULO as Filme, C.NOME as Categoria, F.QUANTIDADE as Quantidade 
from FILMES F
join CATEGORIAS C on F.FK_COD_CAT = C.COD_CAT
where C.NOME = 'nome da categoria' and F.QUANTIDADE > 5;

-- 6 Listar todos os atores que participaram de filmes com um determinado título:
select A.NOME as Ator, F.TITULO as Filme
from ATORES A
join FILMES_ATORES FA on A.COD_ATOR = FA.FK_COD_ATOR
join FILMES F on FA.FK_COD_FILME = F.COD_FILME
where F.TITULO = 'titulo do filme';

-- 7 Obter o endereço completo de um cliente específico:
select C.NOME as Cliente, E.LOGRADOURO || ', ' || E.NUMERO || ' - ' || E.COMPLEMENTO || ', ' || E.BAIRRO || ', ' || E.CIDADE || ' - ' || E.UF || ', ' || E.CEP as EnderecoCompleto
from CLIENTES C
join CLIENTES_ENDERECOS CE on C.COD_CLI = CE.FK_COD_CLI
join ENDERECOS E on CE.FK_COD_END = E.COD_END
where C.NOME = 'nome do cliente';

-- 8 Listar todos os filmes e seus respectivos gêneros e categorias:
select F.TITULO as Filme, G.NOME as Genero, C.NOME as Categoria
from FILMES F
join GENEROS G on F.FK_COD_GEN = G.COD_GEN
join CATEGORIAS C on F.FK_COD_CAT = C.COD_CAT;

-- 9 Mostrar todos os clientes que alugaram um filme específico e a data de locação:
select C.NOME as Cliente, F.TITULO as Filme, L.DATA_LOC as DataLocacao
from CLIENTES C
join LOCACOES L on C.COD_CLI = L.FK_COD_CLI
join LOCACOES_FILMES LF on L.COD_LOC = LF.FK_COD_LOC
join FILMES F on LF.FK_COD_FILME = F.COD_FILME
where F.TITULO = 'titulo do filme';

-- 10 Exibir a lista de clientes com m ultas superiores a um valor específico:
select C.NOME as Cliente, L.MULTA as Multa
from CLIENTES C
join LOCACOES L on C.COD_CLI = L.FK_COD_CLI
where L.MULTA > ValorEspecifico;

-- 11 Listar todas as locações feitas em um período específico:
select L.COD_LOC as LocacaoID, C.NOME as Cliente, L.DATA_LOC as DataLocacao
from LOCACOES L
join CLIENTES C on L.FK_COD_CLI = C.COD_CLI
where L.DATA_LOC between 'datainicio' and 'datafim';

-- 12 Obter a quantidade total de filmes alugados por cada cliente:
select C.NOME as Cliente,
count (LF.FK_COD_FILME) as TotalFilmesAlugados
from CLIENTES C
join LOCACOES L on C.COD_CLI = L.FK_COD_CLI
join LOCACOES_FILMES LF on L.COD_LOC = LF.FK_COD_LOC
group by C.NOME;

-- 13 Listar os clientes e os filmes que eles alugaram, ordenados por data de locação:
select C.NOME as Cliente, F.TITULO as Filme, L.DATA_LOC as DataLocacao
from CLIENTES C
join LOCACOES L on C.COD_CLI = L.FK_COD_CLI
join LOCACOES_FILMES LF on L.COD_LOC = LF.FK_COD_LOC
join FILMES F on LF.FK_COD_FILME = F.COD_FILME
order by L.DATA_LOC;

-- 14 Mostrar todos os clientes que moram em uma cidade específica e que alugaram filmes de uma categoria específica:
select C.NOME as Cliente, F.TITULO as Filme, CA.NOME as Categoria
from CLIENTES C
join CLIENTES_ENDERECOS CE on C.COD_CLI = CE.FK_COD_CLI
join ENDERECOS E on CE.FK_COD_END = E.COD_END
join LOCACOES L on C.COD_CLI = L.FK_COD_CLI
join LOCACOES_FILMES LF on L.COD_LOC = LF.FK_COD_LOC
join FILMES F on LF.FK_COD_FILME = F.COD_FILME
join CATEGORIAS CA on F.FK_COD_CAT = CA.COD_CAT
where E.CIDADE = 'cidade especifica' and CA.NOME = 'categoria especifica';

-- 15 Encontrar todos os atores que participaram de pelo menos 5 filmes, listando o nome do ator e o número de filmes em que atuou:
select A.NOME as Ator,
count (FA.FK_COD_FILME) as NumFilmes
from ATORES A
join FILMES_ATORES FA on A.COD_ATOR = FA.FK_COD_ATOR
group by A.NOME
having count (FA.FK_COD_FILME) >= 5;

-- 16 Exibir a quantidade total de filmes alugados por categoria e gênero, incluindo apenas as categorias e gêneros que têm mais de 50 filmes alugados no total:
select CA.NOME as Categoria, G.NOME as Genero,
count (LF.FK_COD_FILME) as TotalFilmesAlugados
from LOCACOES_FILMES LF
join FILMES F on LF.FK_COD_FILME = F.COD_FILME
join CATEGORIAS CA on F.FK_COD_CAT = CA.COD_CAT
join GENEROS G on F.FK_COD_GEN = G.COD_GEN
group by CA.NOME, G.NOME
having count (LF.FK_COD_FILME) > 50;



