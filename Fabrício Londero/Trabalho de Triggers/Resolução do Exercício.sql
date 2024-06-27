-- RESOLUÇÃO DO EXERCÍCIO DE TRIGGER

-- 5. Faça uma trigger que valide os anos iniciais e finais da existência do dinossauro inserido ou atualizado. Caso os anos não estejam corretos, cancele a operação e mostre uma mensagem ao usuário.:
CREATE OR REPLACE FUNCTION validar_anos()
RETURNS TRIGGER AS $BODY$
BEGIN
    IF NEW.inicio > NEW.fim THEN
        RAISE EXCEPTION 'O ano de início deve ser menor ou igual ao ano de fim.';
        RETURN NULL;
    END IF;
    RETURN NEW;
END
$BODY$
LANGUAGE plpgsql VOLATILE;

CREATE TRIGGER trig_validar_anos
BEFORE INSERT OR UPDATE ON dinossauros
FOR EACH ROW
EXECUTE FUNCTION validar_anos();

-- 6. Atualize a trigger anterior, para validar a inserção e alteração do dinossauro, conforme as eras (verificar se os anos de existência do dinossauro condizem com a era informada), informando que os valores de anos estão errados ou não condizem com a era informada:
CREATE OR REPLACE FUNCTION validar_anos_era()
RETURNS TRIGGER AS $BODY$
DECLARE
    era_inicio INTEGER;
    era_fim INTEGER;
BEGIN
    SELECT ano_inicio, ano_fim INTO era_inicio, era_fim
    FROM eras
    WHERE id = NEW.fk_era;

    IF NEW.inicio > NEW.fim THEN
        RAISE EXCEPTION 'O ano de início deve ser menor ou igual ao ano de fim.';
        RETURN NULL;
    END IF;

    IF NEW.inicio < era_inicio OR NEW.fim > era_fim THEN
        RAISE EXCEPTION 'Os anos de existência do dinossauro não condizem com a era informada.';
        RETURN NULL;
    END IF;

    RETURN NEW;
END
$BODY$
LANGUAGE plpgsql VOLATILE;

CREATE TRIGGER trig_validar_anos_era
BEFORE INSERT OR UPDATE ON dinossauros
FOR EACH ROW
EXECUTE FUNCTION validar_anos_era();

-- DINOSSAUROS que NÃO correspondem as ERAS:
Nome: Pinacossauro
Era: Triássico (251-200)
Anos: (85-75)

Nome: Anquilossauro
Era: Triássico (251-200)
Anos: (66-63)


