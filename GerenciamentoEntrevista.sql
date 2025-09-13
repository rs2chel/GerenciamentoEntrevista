-- Criação do banco de dados
CREATE DATABASE GerenciamentoEntrevista;

\c GerenciamentoEntrevista;

-- Tabela de Candidatos
CREATE TABLE Candidato (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefone VARCHAR(20)
);

-- Tabela de Entrevistadores
CREATE TABLE Entrevistador (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE
);

-- Tabela de Tópicos
CREATE TABLE Topico (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL
);

-- Tabela de Avaliações
CREATE TABLE Avaliacao (
    id SERIAL PRIMARY KEY,
    candidato_id INT NOT NULL REFERENCES Candidato(id) ON DELETE CASCADE,
    entrevistador_id INT NOT NULL REFERENCES Entrevistador(id) ON DELETE CASCADE,
    topico_id INT NOT NULL REFERENCES Topico(id) ON DELETE CASCADE,
    nota NUMERIC(3,1) NOT NULL,
    observacao TEXT
);

-- Inserção de dados de exemplo
INSERT INTO Candidato (nome, email, telefone) VALUES
('Ana Silva', 'ana@gmail.com', '11999999999'),
('Bruno Costa', 'bruno@gmail.com', '11988888888');

INSERT INTO Entrevistador (nome, email) VALUES
('Carlos Souza', 'carlos@gmail.com'),
('Daniela Lima', 'daniela@gmail.com');

INSERT INTO Topico (descricao) VALUES
('Conhecimentos Técnicos'),
('Comunicação'),
('Experiência Profissional');

INSERT INTO Avaliacao (candidato_id, entrevistador_id, topico_id, nota, observacao) VALUES
(1, 1, 1, 8.5, 'Bom domínio técnico'),
(1, 1, 2, 7.0, 'Comunica-se bem'),
(1, 2, 3, 9.0, 'Experiência sólida'),
(2, 2, 1, 6.5, 'Precisa melhorar conhecimentos técnicos'),
(2, 1, 2, 8.0, 'Boa comunicação');

-- Consulta completa mostrando Candidato, Entrevistador, Tópico e Nota
SELECT
    c.nome AS candidato,
    e.nome AS entrevistador,
    t.descricao AS topico,
    a.nota,
    a.observacao
FROM Avaliacao a
JOIN Candidato c ON a.candidato_id = c.id
JOIN Entrevistador e ON a.entrevistador_id = e.id
JOIN Topico t ON a.topico_id = t.id
ORDER BY c.nome, e.nome, t.id;
