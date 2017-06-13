

CREATE DATABASE alunos

create table aluno(
	id serial,
	nome varchar(100),
	idade int,
	telefone varchar(11)
)

insert into aluno(nome,idade,telefone)
values
('um',14,'1111111111'),
('dois',15,'22222222'),
('tres',16,'33333333'),
('quatro',18,'4444444');