create database triggers;

-- Cria a tabela 'produtos' para armazenar informações sobre produtos
create table produtos 
(
    id integer not null primary key,
    nome varchar(50) not null,
    estoque integer
); 

-- Cria uma sequência 'seq_produtos' que será usada para gerar IDs automáticos para a tabela 'produtos'
create sequence seq_produtos
increment by 1 no maxvalue no minvalue
cache 1;

-- Associa a sequência 'seq_produtos' ao campo 'id' da tabela 'produtos'
alter sequence seq_produtos owned by produtos.id;

-- Define o valor padrão do campo 'id' em 'produtos' para o próximo valor da sequência 'seq_produtos'
alter table produtos 
alter column id set default nextval('seq_produtos':: regclass);

-- Insere dados na tabela 'produtos'
insert into produtos(nome, estoque) 
values ('teclado dell 10PH', 23), 
('monitor dell P22H27', 7), 
('monitor dell 77F24', 10), 
('mouse dell MS22', 18);

-- Cria a tabela 'vendas' para armazenar informações sobre vendas
create table vendas (
    id integer not null unique,
    fk_produto integer,
    quantidade integer not null,
    constraint fk_produto_id 
	foreign key (fk_produto) references produtos(id)
);

-- Cria uma sequência 'seq_vendas' que será usada para gerar IDs automáticos para a tabela 'vendas'
create sequence seq_vendas increment by 1 no maxvalue no minvalue cache 1;

-- Associa a sequência 'seq_vendas' ao campo 'id' da tabela 'vendas'
alter sequence seq_vendas owned by vendas.id;

-- Define o valor padrão do campo 'id' em 'vendas' para o próximo valor da sequência 'seq_vendas'
alter table vendas 
alter column id set default nextval('seq_vendas'::regclass);

-- tabelas temporarias
--NEW - novo registro que estou inserindo ou alterando
--OLD - é o registro que esta sendo apagado
 
Professor
ID - NOME 
1 - Fabrício
2 - Fabrício
 
update professores set nome = 'Lucas'
where id = 2
 
NEW 
2 - Lucas
 
OLD
2 - Fabrício

-- Consulta para visualizar todos os registros na tabela 'produtos'
select * from produtos;

-- Consulta para visualizar todos os registros na tabela 'vendas'
select * from vendas;

insert into vendas(fk_produto, quantidade) values (11, 2);
insert into vendas(fk_produto, quantidade) values (10, 8);
insert into vendas(fk_produto, quantidade) values (11, 7);





SIGNIFICADO DE TRIGGERS
	
-- 1. Um trigger é uma especificação que o sistema de banco de dados deve automaticamente executar uma função específica sempre que ocorrerem determinados tipos de operações, como INSERT, UPDATE ou DELETE.

-- 2. A função invocada por um trigger é chamada de 'trigger function'. Esta função deve ser definida antes de criar o trigger e pode ser escrita em PL/pgSQL (a linguagem procedural do PostgreSQL) ou outras linguagens suportadas.

-- 3. Triggers podem ser configurados para executar antes ou depois do evento que os aciona: 
--    BEFORE: A função é chamada antes de a operação ser concluída. Útil para validar ou modificar dados antes de efetivar a operação.
--    AFTER: A função é chamada depois de a operação ser concluída. Útil para realizar ações de acompanhamento, como atualizações em cascata.

-- 4. Triggers ajudam a manter a integridade dos dados, automatizar tarefas e impor regras de negócios sem intervenção manual.

-- 5. Exemplo de uso de um trigger: registrar todas as mudanças feitas em uma tabela de 'usuários' para uma tabela de 'log' para auditoria.

EVENTO -> CONDIÇÃO -> AÇÃO = MODELO ECA

-- EVENTO: Refere-se à operação específica na tabela que ativa o trigger.
--         Exemplos incluem INSERT, UPDATE, DELETE, ou até mesmo operações mais específicas como UPDATE de uma coluna específica.

-- CONDIÇÃO: Uma verificação que é executada quando o evento ocorre.
--           O trigger só procederá à ação se esta condição for verdadeira.
--           Exemplo: verificar se a quantidade de um produto está abaixo do mínimo necessário antes de emitir um alerta.

-- AÇÃO: A operação que é realizada quando a condição é verdadeira.
--       Isso pode incluir uma variedade de tarefas, como inserir um registro em outra tabela,
--       enviar uma notificação, realizar cálculos, entre outros.


	
-- Cria ou substitui a função 'verificaestoque', que retorna um tipo 'trigger'
CREATE OR REPLACE FUNCTION verificaestoque()
RETURNS TRIGGER AS $body$
DECLARE
       estoqueatual INTEGER := 0; -- Declara uma variável 'estoqueatual' para armazenar o estoque atual do produto
BEGIN 
       -- Seleciona a quantidade de estoque do produto referenciado pela venda
       estoqueatual := (SELECT produtos.estoque 
	                    FROM produtos 
	                    WHERE produtos.id = NEW.fk_produto);

       -- Checa se o estoque atual é suficiente para cobrir a quantidade da venda
       IF (estoqueatual >= NEW.quantidade) THEN 
            -- Se suficiente, atualiza o estoque subtraindo a quantidade vendida
		    UPDATE produtos SET estoque = (estoqueatual - NEW.quantidade)
		    WHERE produtos.id = NEW.fk_produto;
            -- Retorna 'NEW' para permitir a operação de inserção ou atualização
            RETURN NEW;
       ELSE 
            -- Se não houver estoque suficiente, a função interrompe a operação de inserção ou atualização
		    RETURN NULL;
       END IF;
END;
$body$
LANGUAGE plpgsql VOLATILE;  -- Define a linguagem da função como PL/pgSQL e o comportamento como VOLATILE (pode ter efeitos colaterais)

-- Cria um novo trigger chamado 'trigger_estoque'
create trigger trigger_estoque after insert 
on vendas                                       -- Define que o trigger será ativado após cada operação de INSERT na tabela 'vendas'
for each row                                    -- Especifica que o trigger deve ser executado para cada linha inserida
execute procedure verificaestoque();            -- Define que a função 'verificaestoque' será executada quando o trigger for ativado

-- Exemplo a mais
CREATE OR REPLACE FUNCTION verificaestoque() 
RETURNS TRIGGER AS $BODY$
DECLARE 
	estoqueatual integer := 0;
BEGIN
	estoqueatual := (select produtos.estoque 
					 from produtos 
					 where produtos.id = NEW.fk_produto );
	IF(estoqueatual >= NEW.quantidade)
	THEN
		update produtos set estoque = (estoqueatual - NEW.quantidade)
		where produtos.id = new.fk_produto;
		raise notice 'Tudo certo!';
		return new;
	ELSE
		RAISE EXCEPTION 'Inserção cancelada!';
		return null;
	END IF;
END
$BODY$
language plpgsql volatile; 

