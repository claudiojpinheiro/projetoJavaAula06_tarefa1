CREATE DATABASE bd_projetojavaaula06tarefa1;
USE bd_projetojavaaula06tarefa1;


CREATE TABLE aluno( 

idAluno		INT							AUTO_INCREMENT	PRIMARY KEY,
nome			VARCHAR(100)		NOT NULL,
matricula		VARCHAR(50)			NOT NULL,
cpf 				VARCHAR(14)		NOT NULL UNIQUE);

