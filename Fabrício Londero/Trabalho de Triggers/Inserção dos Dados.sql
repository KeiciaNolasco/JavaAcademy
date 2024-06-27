-- Inserção de Regiões
INSERT INTO regioes (nome) VALUES ('Mongólia');
INSERT INTO regioes (nome) VALUES ('Canadá');
INSERT INTO regioes (nome) VALUES ('Tanzânia');
INSERT INTO regioes (nome) VALUES ('China');
INSERT INTO regioes (nome) VALUES ('América do Norte');
INSERT INTO regioes (nome) VALUES ('USA');

-- Inserção de Grupos
INSERT INTO grupos (nome) VALUES ('Anquilossauros');
INSERT INTO grupos (nome) VALUES ('Ceratopsídeos');
INSERT INTO grupos (nome) VALUES ('Estegossauros');
INSERT INTO grupos (nome) VALUES ('Terópodes');

-- Inserção de Eras
INSERT INTO eras (nome, ano_inicio, ano_fim) VALUES ('Triássico', 251, 200);
INSERT INTO eras (nome, ano_inicio, ano_fim) VALUES ('Jurássico', 200, 145);
INSERT INTO eras (nome, ano_inicio, ano_fim) VALUES ('Cretáceo', 145, 65);

-- Inserção de Descobridores
INSERT INTO descobridores (nome) VALUES ('Maryanska');
INSERT INTO descobridores (nome) VALUES ('John Bell Hatcher');
INSERT INTO descobridores (nome) VALUES ('Cientistas Alemães');
INSERT INTO descobridores (nome) VALUES ('Museu Americano de História Natural');
INSERT INTO descobridores (nome) VALUES ('Othniel Charles Marsh');
INSERT INTO descobridores (nome) VALUES ('Barnum Brown');

-- Inserção de Dinossauros
INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Saichania', 4, 1977, (SELECT id FROM grupos WHERE nome = 'Anquilossauros'), 
        (SELECT id FROM descobridores WHERE nome = 'Maryanska'), 
        (SELECT id FROM eras WHERE nome = 'Cretáceo'), 145, 66, 
        (SELECT id FROM regioes WHERE nome = 'Mongólia'));

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Tricerátops', 6, 1887, (SELECT id FROM grupos WHERE nome = 'Ceratopsídeos'), 
        (SELECT id FROM descobridores WHERE nome = 'John Bell Hatcher'), 
        (SELECT id FROM eras WHERE nome = 'Cretáceo'), 70, 66, 
        (SELECT id FROM regioes WHERE nome = 'Canadá'));

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Kentrossauro', 2, 1909, (SELECT id FROM grupos WHERE nome = 'Estegossauros'), 
        (SELECT id FROM descobridores WHERE nome = 'Cientistas Alemães'), 
        (SELECT id FROM eras WHERE nome = 'Jurássico'), 200, 145, 
        (SELECT id FROM regioes WHERE nome = 'Tanzânia'));

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Pinacossauro', 6, 1999, (SELECT id FROM grupos WHERE nome = 'Anquilossauros'), 
        (SELECT id FROM descobridores WHERE nome = 'Museu Americano de História Natural'), 
        (SELECT id FROM eras WHERE nome = 'Triássico'), 85, 75, 
        (SELECT id FROM regioes WHERE nome = 'China'));

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Alossauro', 3, 1877, (SELECT id FROM grupos WHERE nome = 'Terópodes'), 
        (SELECT id FROM descobridores WHERE nome = 'Othniel Charles Marsh'), 
        (SELECT id FROM eras WHERE nome = 'Jurássico'), 155, 150, 
        (SELECT id FROM regioes WHERE nome = 'América do Norte'));

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Torossauro', 8, 1891, (SELECT id FROM grupos WHERE nome = 'Ceratopsídeos'), 
        (SELECT id FROM descobridores WHERE nome = 'John Bell Hatcher'), 
        (SELECT id FROM eras WHERE nome = 'Cretáceo'), 67, 65, 
        (SELECT id FROM regioes WHERE nome = 'USA'));

INSERT INTO dinossauros (nome, toneladas, ano_descoberta, fk_grupo, fk_descobridor, fk_era, inicio, fim, fk_regiao)
VALUES ('Anquilossauro', 8, 1906, (SELECT id FROM grupos WHERE nome = 'Anquilossauros'), 
        (SELECT id FROM descobridores WHERE nome = 'Barnum Brown'), 
        (SELECT id FROM eras WHERE nome = 'Triássico'), 66, 63, 
        (SELECT id FROM regioes WHERE nome = 'América do Norte'));
