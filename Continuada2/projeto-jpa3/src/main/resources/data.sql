-- Aqui podemos ter comandos DML (insert, update e delete)
-- podem haver mais de 1 instrução.
-- Cada instrução SEMPRE deve terminar com ; (ponto e vírgula)

insert into compositor
(nome,apelido)
values
    ('cantor 1','p1'),
    ('cantor 2','p2'),
    ('cantor 3','p3'),
    ('cantor 4','p4');

insert into musica
(nome, ouvintes_total, lancamento, estilo, classico, cod_compositor_codigo)
values
('musica 1', 1, '2023-01-01', 'pop', true,1),
('musica 2', 22, '2022-01-01', 'pop', false, 2),
('musica 3', 333, '2021-01-01', 'rock', true, 3),
('musica 4', 4444, '2020-01-01', 'rock', true, 4),
('melodia 5', 55555, '2019-01-01', 'funk', false,2);

