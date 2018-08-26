CREATE TABLE BANDA (
        id serial primary key,
        localdeorigem varchar,
        nomefantasia varchar
        
);

CREATE TABLE ALBUM(
    id serial primary key,
    estilo varchar,
    banda int,
    lancamento date,
    FOREIGN KEY (banda) references banda(id) on delete cascade
);

CREATE TABLE Integrante(
	id serial primary key,
	nome varchar,
	cpf varchar UNIQUE,
        banda int,
	nascimento Date,
        FOREIGN KEY (banda) REFERENCES banda(id) on delete CASCADE
);

INSERT INTO BANDA (localdeorigem,nomefantasia, id)
VALUES ('sousa','fantasia',12345);

INSERT INTO INTEGRANTE (nome,cpf,nascimento,banda) 
VALUES ('Flavio','111.111.111-01','2000-02-21',12345);

INSERT INTO INTEGRANTE (nome,cpf,nascimento,banda) 
VALUES ('Job','222.222.222-02','1990-07-15',12345);

INSERT INTO INTEGRANTE (nome,cpf,nascimento,banda) 
VALUES ('Maria','333.333.333-03','1950-10-19',12345);

