-- RESOLUÇÃO DO EXERCÍCIO DE TRIGGER

-- Atualizando a Estrutura da Tabela eras:
ALTER TABLE eras
ADD COLUMN inicio INTEGER,
ADD COLUMN fim INTEGER;

-- Atualizando Dados da Tabela eras:
UPDATE eras
SET inicio = 251, fim = 200
WHERE nome = 'Triássico';

UPDATE eras
SET inicio = 200, fim = 145
WHERE nome = 'Jurássico';

UPDATE eras
SET inicio = 145, fim = 65
WHERE nome = 'Cretáceo';

-- Atualizando o Comando de NOT NULL na Estrutura da Tabela eras:
ALTER TABLE eras
ALTER COLUMN inicio SET NOT NULL,
ALTER COLUMN fim SET NOT NULL;

SELECT * FROM eras;

-- 5. Faça uma trigger que valide os anos iniciais e finais da existência do dinossauro inserido ou atualizado. Caso os anos não estejam corretos, cancele a operação e mostre uma mensagem ao usuário.:
CREATE OR REPLACE FUNCTION verifica_anos_existencia()
RETURNS TRIGGER AS $BODY$
DECLARE
    era_inicio INTEGER;
    era_fim INTEGER;
BEGIN
    SELECT inicio, fim INTO era_inicio, era_fim
    FROM eras
    WHERE id = NEW.fk_era;

    IF NEW.inicio < era_inicio OR NEW.fim > era_fim THEN
        RAISE EXCEPTION 'Inserção cancelada (os anos em que o dinossauro existiu não condizem com a era)';
        RETURN NULL;
    ELSE
        RETURN NEW;
    END IF;
END
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_verifica_anos_existencia
BEFORE INSERT OR UPDATE
ON dinossauros
FOR EACH ROW
EXECUTE FUNCTION verifica_anos_existencia();

-- 6. Atualize a trigger anterior, para validar a inserção e alteração do dinossauro, conforme as eras (verificar se os anos de existência do dinossauro condizem com a era informada), informando que os valores de anos estão errados ou não condizem com a era informada:
CREATE OR REPLACE FUNCTION verifica_anos_era()
RETURNS TRIGGER AS $BODY$
DECLARE
    era_inicio INTEGER;
    era_fim INTEGER;
BEGIN
    SELECT inicio, fim INTO era_inicio, era_fim
    FROM eras
    WHERE id = NEW.fk_era;

    IF NEW.inicio < era_inicio OR NEW.fim > era_fim THEN
        RAISE EXCEPTION 'Inserção cancelada (os anos em que o dinossauro existiu (% - %) não condizem com a era informada (% - %))',
                        NEW.inicio, NEW.fim, era_inicio, era_fim;
        RETURN NULL;
    ELSE
        RETURN NEW;
    END IF;
END
$BODY$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_verifica_anos_era
BEFORE INSERT OR UPDATE
ON dinossauros
FOR EACH ROW
EXECUTE FUNCTION verifica_anos_era();

