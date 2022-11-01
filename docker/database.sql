CREATE TABLE aulas (
    aula_id serial  NOT NULL,
    aula_titulo varchar(50)  NOT NULL,
    aula_link varchar(100)  NOT NULL,
    aula_canal varchar(30)  NOT NULL,
    tema_id int  NOT NULL,
    CONSTRAINT aulas_pk PRIMARY KEY (aula_id)
);

-- Table: campus
CREATE TABLE campus (
    campus_id serial  NOT NULL,
    campus_nome varchar(100)  NOT NULL,
    campus_endereco varchar(100)  NOT NULL,
    universidade_id int  NOT NULL,
    CONSTRAINT campus_pk PRIMARY KEY (campus_id)
);

-- Table: campus_cursos
CREATE TABLE campus_cursos (
    campus_id int  NOT NULL,
    curso_id int  NOT NULL,
    CONSTRAINT campus_cursos_pk PRIMARY KEY (campus_id,curso_id)
);

-- Table: cursos
CREATE TABLE cursos (
    curso_id serial  NOT NULL,
    curso_nome varchar(50)  NOT NULL,
    CONSTRAINT cursos_pk PRIMARY KEY (curso_id)
);

-- Table: disciplinas
CREATE TABLE disciplinas (
    disciplina_id serial  NOT NULL,
    disciplina_nome varchar(30)  NOT NULL,
    CONSTRAINT disciplinas_pk PRIMARY KEY (disciplina_id)
);

-- Table: exercicios
CREATE TABLE exercicios (
    exercicio_id serial  NOT NULL,
    exercicio_texto varchar(1500)  NOT NULL,
    tema_id int  NOT NULL,
    exercicio_resposta char(1)  NOT NULL,
    CONSTRAINT exercicios_pk PRIMARY KEY (exercicio_id)
);

-- Table: listas
CREATE TABLE listas (
    lista_id serial  NOT NULL,
    lista_nome varchar(30)  NOT NULL,
    disciplina_id int  NOT NULL,
    CONSTRAINT listas_pk PRIMARY KEY (lista_id)
);

-- Table: listas_exercicios
CREATE TABLE listas_exercicios (
    lista_id int  NOT NULL,
    exercicio_id int  NOT NULL,
    CONSTRAINT listas_exercicios_pk PRIMARY KEY (lista_id,exercicio_id)
);

-- Table: registro_agenda
CREATE TABLE registro_agenda (
    usuario_id int  NOT NULL,
    registro_data timestamp  NOT NULL,
    registro_duracao int  NOT NULL,
    tema_id int  NOT NULL,
    CONSTRAINT registro_agenda_pk PRIMARY KEY (usuario_id,registro_data)
);

-- Table: temas
CREATE TABLE temas (
    tema_id serial  NOT NULL,
    tema_nome varchar(30)  NOT NULL,
    disciplina_id int  NOT NULL,
    CONSTRAINT temas_pk PRIMARY KEY (tema_id)
);

-- Table: universidades
CREATE TABLE universidades (
    universidade_id serial  NOT NULL,
    universidade_nome varchar(100)  NOT NULL,
    CONSTRAINT universidades_pk PRIMARY KEY (universidade_id)
);

-- Table: universidades_ingressos
CREATE TABLE universidades_ingressos (
    universidade_id int  NOT NULL,
    ingresso_id int  NOT NULL,
    CONSTRAINT universidades_ingressos_pk PRIMARY KEY (universidade_id,ingresso_id)
);

-- Table: usuarios
CREATE TABLE usuarios (
    id serial  NOT NULL,
    login varchar(30)  NOT NULL,
    nome varchar(30)  NOT NULL,
    senha varchar(200)  NOT NULL,
    premium boolean  NOT NULL,
    CONSTRAINT usuarios_pk PRIMARY KEY (id)
);

-- Table: vestibulares
CREATE TABLE vestibulares (
    vestibular_id serial  NOT NULL,
    vestibular_nome varchar(20)  NOT NULL,
    vestibular_data date  NOT NULL,
    vestibular_link varchar(100)  NOT NULL,
    CONSTRAINT vestibulares_pk PRIMARY KEY (vestibular_id)
);

-- foreign keys
-- Reference: aula_tema (table: aulas)
ALTER TABLE aulas ADD CONSTRAINT aula_tema
    FOREIGN KEY (tema_id)
    REFERENCES temas (tema_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: campus_cursos_campus (table: campus_cursos)
ALTER TABLE campus_cursos ADD CONSTRAINT campus_cursos_campus
    FOREIGN KEY (campus_id)
    REFERENCES campus (campus_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: campus_cursos_cursos (table: campus_cursos)
ALTER TABLE campus_cursos ADD CONSTRAINT campus_cursos_cursos
    FOREIGN KEY (curso_id)
    REFERENCES cursos (curso_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: campus_universidades (table: campus)
ALTER TABLE campus ADD CONSTRAINT campus_universidades
    FOREIGN KEY (universidade_id)
    REFERENCES universidades (universidade_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: exercicios_temas (table: exercicios)
ALTER TABLE exercicios ADD CONSTRAINT exercicios_temas
    FOREIGN KEY (tema_id)
    REFERENCES temas (tema_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listas_disciplinas (table: listas)
ALTER TABLE listas ADD CONSTRAINT listas_disciplinas
    FOREIGN KEY (disciplina_id)
    REFERENCES disciplinas (disciplina_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listas_exercicios_exercicios (table: listas_exercicios)
ALTER TABLE listas_exercicios ADD CONSTRAINT listas_exercicios_exercicios
    FOREIGN KEY (exercicio_id)
    REFERENCES exercicios (exercicio_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: listas_exercicios_listas (table: listas_exercicios)
ALTER TABLE listas_exercicios ADD CONSTRAINT listas_exercicios_listas
    FOREIGN KEY (lista_id)
    REFERENCES listas (lista_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: registro_agenda_temas (table: registro_agenda)
ALTER TABLE registro_agenda ADD CONSTRAINT registro_agenda_temas
    FOREIGN KEY (tema_id)
    REFERENCES temas (tema_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: registro_agenda_usuarios (table: registro_agenda)
ALTER TABLE registro_agenda ADD CONSTRAINT registro_agenda_usuarios
    FOREIGN KEY (id)
    REFERENCES usuarios (id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: temas_disciplinas (table: temas)
ALTER TABLE temas ADD CONSTRAINT temas_disciplinas
    FOREIGN KEY (disciplina_id)
    REFERENCES disciplinas (disciplina_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: universidades_ingressos_ingressos (table: universidades_ingressos)
ALTER TABLE universidades_ingressos ADD CONSTRAINT universidades_ingressos_ingressos
    FOREIGN KEY (ingresso_id)
    REFERENCES vestibulares (vestibular_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: universidades_ingressos_universidades (table: universidades_ingressos)
ALTER TABLE universidades_ingressos ADD CONSTRAINT universidades_ingressos_universidades
    FOREIGN KEY (universidade_id)
    REFERENCES universidades (universidade_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;