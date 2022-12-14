-- Table: aulas
CREATE TABLE aulas (
    aula_id serial  NOT NULL,
    aula_titulo varchar(100)  NOT NULL,
    aula_link varchar(100)  NOT NULL,
    aula_canal varchar(30)  NOT NULL,
    tema_id int  NOT NULL,
    CONSTRAINT aulas_pk PRIMARY KEY (aula_id)
);

-- Table: campus
CREATE TABLE campus (
    campus_id serial  NOT NULL,
    campus_nome varchar(200)  NOT NULL,
    campus_endereco varchar(200)  NOT NULL,
		campus_cidade varchar(100)  NOT NULL,
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
    curso_nome varchar(100)  NOT NULL,
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
    registro_id serial NOT NULL,
    usuario_id int  NOT NULL,
    registro_inicio timestamp  NOT NULL,
    registro_fim timestamp  NOT NULL,
    registro_nome varchar(45)  NOT NULL,
    CONSTRAINT registro_agenda_pk PRIMARY KEY (registro_id)
);

-- Table: temas
CREATE TABLE temas (
    tema_id serial  NOT NULL,
    tema_nome varchar(60)  NOT NULL,
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
    usuario_id serial  NOT NULL,
    usuario_login varchar(30)  NOT NULL,
    usuario_nome varchar(30)  NOT NULL,
    usuario_senha varchar(200)  NOT NULL,
    usuario_premium boolean  NOT NULL,
    CONSTRAINT usuarios_pk PRIMARY KEY (usuario_id)
);

-- Table: vestibulares
CREATE TABLE vestibulares (
    vestibular_id serial  NOT NULL,
    vestibular_nome varchar(100)  NOT NULL,
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

-- Reference: registro_agenda_usuarios (table: registro_agenda)
ALTER TABLE registro_agenda ADD CONSTRAINT registro_agenda_usuarios
    FOREIGN KEY (usuario_id)
    REFERENCES usuarios (usuario_id)
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


-------------- POPULACAO DO BANCO DE DADOS --------------


-- Table: usuarios
insert into usuarios (usuario_login, usuario_nome, usuario_senha, usuario_premium) VALUES
('maria.luiza', 'Maria Luiza', 'marialuiza123', false),
('justin.maclean01', 'Justin C. Maclean', '12345', true),
('amanda.castro', 'Amanda Sousa Castro', 'c4str000', true),
('kgomes', 'Kauan Castro Gomes', 'castro2g0m3s', false),
('mari_ferreira', 'Marisa Dias Ferreira', '12345', false),
('isa.souza', 'Isabela Castro Sousa', '12345', true),
('renan_ferreira', 'Renan Ferreira Cavalcanti', 're12345', false);

-- Table: universidades
insert into universidades (universidade_nome) VALUES
('USP'),
('UNICAMP'),
('UNESP'),
('UNIFESP'),
('UFABC'),
('UFSCAR'),
('IFSP'),
('UNIVESP'),
('ITA'),
('FATEC'),
('FAMEMA'),
('FAMERP'),
('USCS'),
('UNITAU');

-- Table: campus
insert into campus (campus_nome, campus_endereco, campus_cidade, universidade_id) VALUES
('Campus de S??o Paulo - Cidade Universit??ria', 'Av. Prof. Almeida Prado, 1280 - Butant??, S??o Paulo - SP, 05508-900', 'S??o Paulo', 1),
('Campus de S??o Paulo - USP Leste', 'Rua Arlindo B??ttio, 1000 - Ermelino Matarazzo, S??o Paulo - SP, 03828-000', 'S??o Paulo', 1),
('Campus de Bauru', 'Alameda Dr. Oct??vio Pinheiro Brisolla, 9-75 - Vila Nova Cidade Universit??ria, Bauru - SP, 17012-901', 'Bauru', 1),
('Campus de Lorena', 'Estrada Municipal do Campinho, s/n - Pte. Nova, Lorena - SP, 12602-810', 'Lorena', 1),
('Campus de Ribeir??o Preto', 'Rua Monte Alegre, Av. Bandeirantes, 3900 - Subsetor Oeste - 11 (N-11), Ribeir??o Preto - SP, 14040-900', 'Ribeir??o Preto', 1),
('Campus de Piracicaba', 'Av. P??dua Dias, 11 - Agronomia, Piracicaba - SP, 13418-900', 'Piracicaba', 1),
('Campus de Pirassununga', 'R. Duque de Caxias, 225 - Jardim Elite, Pirassununga - SP, 13635-900', 'Pirassununga', 1),
('Campus de Santos', 'Pra??a Cel. Narciso de Andrade, 36 - Vila Matias, Santos - SP, 11013-552', 'Santos', 1),
('Campus de S??o Carlos', 'Av. Trab. S??o Carlense, 400 - Parque Arnold Schimidt, S??o Carlos - SP, 13566-590', 'S??o Carlos', 1),

('Faculdade de Tecnologia de Limeira', 'R. Paschoal Marmo, 1888 - Jd. Nova It??lia - CEP: 13484-332 - Limeira, SP', 'Limeira', 2),
('Faculdade de Ci??ncias Aplicadas de Limeira', 'R. Pedro Zaccaria, 1300, Limeira - SP, 13484-350', 'Limeira', 2),
('Faculdade de Odontologia de Piracicaba', 'Av. Limeira, 901 - Arei??o - CEP: 13414-903 - Piracicaba, SP', 'Piracicaba', 2),
('Cidade Universit??ria "Zeferino Vaz" de Campinas', 'CEP 13083-970 | Campinas-SP', 'Campinas', 2),

('Faculdade de Medicina Veterin??ria', 'R. Cl??vis Pestana, 793 - CEP 16050-680', 'Ara??atuba', 3),
('Faculdade de Odontologia', 'R. Jos?? Bonif??cio, 1193 - CEP 16015-050', 'Ara??atuba', 3),
('Faculdade de Ci??ncias Farmac??uticas', 'Rodovia Araraquara-Ja??, km 1 - CP 502 - CEP 14801-902', 'Araraquara', 3),
('Faculdade de Ci??ncias e Letras', 'Rodovia Araraquara-Ja??, km 1 - CP 174 - CEP 14800-901', 'Araraquara', 3),
('Faculdade de Odontologia', 'R. Humait??, 1680 - CP 33 - Centro - CEP 14801-903', 'Araraquara', 3),
('Instituto de Qu??mica', 'R. Prof. Francisco Degni, s/n - CP 355 - CEP 14800-900', 'Araraquara', 3),
('Faculdade de Ci??ncias e Letras', 'Av. Dom Antonio, 2100 - CEP 19806-900', 'S??o Paulo', 3),
('Faculdade de Arquitetura, Artes e Comunica????o', 'Av. Eng. Luiz Edmundo Carrijo Coube, 14-01 - CEP 17033-360', 'Bauru', 3),
('Faculdade de Ci??ncias', 'Av. Eng. Luiz Edmundo Carrijo Coube, 14-01 - CEP 17033-360', 'Bauru', 3),
('Faculdade de Engenharia', 'Av. Eng. Luiz Edmundo Carrijo Coube, 14-01 - CEP 17033-360', 'Bauru', 3),
('Faculdade de Ci??ncias Agron??micas', 'Fazenda Experimental Lageado. R. Jos?? Barbosa de Barros, 1780 - CP 237 - CEP 18610-307', 'Botucatu', 3),
('Faculdade de Medicina', 'Distrito de Rubi??o J??nior, s/n - CEP 18618-970', 'Botucatu', 3),
('Faculdade de Medicina Veterin??ria e Zootecnia', 'Distrito de Rubi??o J??nior, s/n - CP 237 - CEP 18618-970', 'Botucatu', 3),
('Instituto de Bioci??ncias', 'Distrito de Rubi??o J??nior, s/n - CEP 18618-970', 'Botucatu', 3),
('Faculdade de Ci??ncias Agr??rias e Tecnol??gicas', 'Rod. Comte. Jo??o Ribeiro de Barros (SP 294), km 651', 'Dracena', 3),
('Faculdade de Ci??ncias Humanas e Sociais', 'Rua Eufr??sia Monteiro Petr??glia, 900, Jardim Dr. Antonio Petr??glia - CEP 14409-160', 'Franca', 3),
('Faculdade de Engenharia', 'Av. Dr. Ariberto Pereira da Cunha, 333 - CEP 12516-410', 'Guaratinguet??', 3),
('Faculdade de Engenharia de Ilha Solteira', 'Av. Brasil, 56 - Centro - CEP 15385-000', 'Ilha Solteira', 3),
('C??mpus de Itapeva', 'R. Geraldo Alckmin, 519 - CEP 18409-010', 'Itapeva', 3),
('Faculdade de Ci??ncias Agr??rias e Veterin??rias', 'Via de Acesso Prof. Paulo Donato Castellane, s/n, CEP 14884-900', 'S??o Paulo', 3),
('Faculdade de Filosofia e Ci??ncias', 'Av. Hygino Muzzi Filho, 737 - CP 181 - CEP 17525-900', 'S??o Paulo', 3),
('C??mpus de Ourinhos', 'Av Renato da Costa Lima, 451, Ville de France, Ourinhos-SP, CEP 19.903-302', 'Ourinhos', 3),
('Faculdade de Ci??ncias e Tecnologia', 'R. Roberto Simonsen, 305 - CP 266, Bairro Centro Educacional - CEP 19060-080', 'Presidente Prudente', 3),
('C??mpus de Registro', 'R. Nelson Brihi Badur, 430 - Vila Tupy - CEP 11900-000', 'Registro', 3),
('Instituto de Bioci??ncias', 'Av. 24-A, 1515 - CP 199 - CEP 13506-900', 'S??o Paulo', 3),
('Instituto de Geoci??ncias e Ci??ncias Exatas', 'Av. 24-A, 1515 - CP 199, CEP 13506-900 - Fone (55) 19 3526-9011', 'S??o Paulo', 3),
('C??mpus de Rosana', 'Av. dos Barrageiros, s/n, esquina com Estrada dos Alojamentos, s/no, CEP 19274-000', 'Rosana', 3),
('C??mpus de S??o Jo??o da Boa Vista', ' Avenida Professora Isette Corr??a Font??o, no 1 Jardim das Flores - CEP 13876-150', 'S??o Jo??o da Boa Vista', 3),
('Instituto de Bioci??ncias, Letras e Ci??ncias Exatas', 'R. Crist??v??o Colombo, 2265 - Jardim Nazareth, CEP 15054-000', 'S??o Jos?? do Rio Preto', 3),
('Instituto de Ci??ncia e Tecnologia', 'Av. Eng. Francisco Jos?? Longo, 777, S??o Dimas - CEP 12245-000', 'S??o Jos?? dos Campos', 3),
('Instituto de Artes', 'R. Dr. Bento Teobaldo Ferraz, 271, Barra Funda - CEP 01140-070', 'S??o Paulo', 3),
('Instituto de Bioci??ncias - C??mpus do Litoral Paulista', 'Pra??a Infante D. Henrique, s/n - CEP 11330-900', 'S??o Paulo', 3),
('Instituto de Ci??ncia e Tecnologia/Sorocaba', 'Av. Tr??s de Mar??o, 511 - Bairro Alto da Boa Vista, CEP 18087-180', 'Sorocaba', 3),
('C??mpus de Tup??', 'Av. Domingos da Costa Lopes, 780 - Jardim Itaipu, CEP 17602-496', 'Tup??', 3),

('S??o Paulo - Enfermagem', 'R. Napole??o de Barros, 754 - Vila Clementino, S??o Paulo - SP, 04024-002', 'S??o Paulo', 4),
('S??o Paulo', 'R. Botucatu, 862 - Vila Clementino, S??o Paulo - SP, 04023-062', 'S??o Paulo', 4),
('S??o Paulo', 'Av. Padre Jos?? Maria, 545 - Santo Amaro, S??o Paulo - SP, 04753-060', 'S??o Paulo', 4),
('Baixada Santista', 'Edif??cio Central - R. Silva Jardim, 136 - Vila Matias, Santos - SP, 11015-020', 'Santos', 4),
('Osasco', 'R. Ang??lica, 100 - Jardim das Flores, Osasco - SP, 06132-380', 'Osasco', 4),
('S??o Jos?? dos Campos', 'R. Talim, 330 - Vila Nair, S??o Jos?? dos Campos - SP, 12231-280', '', 4),
('Diadema', 'Av. Concei????o, 545 - Centro, Diadema - SP', 'Diadema', 4),
('Guarulhos', 'Estr. do Caminho Velho, 333 - Jardim Nova Cidade, Guarulhos - SP, 07252-312', 'Guarulhos', 4),
('Zona Leste', 'Av. Jacu P??ssego, 2630 - Itaquera, S??o Paulo - SP, 08260-001', 'S??o Paulo', 4),

('Campus Santo Andr??', 'Avenida dos Estados, 5001 - Bairro Santa Terezinha, Santo Andr?? - CEP: 09210-580', 'Santo Andr??', 5),
('Campus S??o Bernardo do Campo', 'Alameda da Universidade, s/n?? - Bairro Anchieta, S??o Bernardo do Campo - CEP: 09606-045', 'S??o Bernardo do Campo', 5),

('Campus S??o Carlos', 'Rod. Washington Lu??s, km 235 - SP-310 - S??o Carlos, CEP 13565-905', 'S??o Carlos', 6),
('Campus Araras', 'Rod. Anhanguera, km 174 - SP-330 - Araras, CEP 13600-970', 'Araras', 6),
('Campus Sorocaba', 'Rod. Jo??o Leme dos Santos, km 110 - SP-264, Bairro do Itinga - Sorocaba', 'Sorocaba', 6),
('Campus Lagoa do Sino', 'Rod. Lauri Sim??es de Barros, km 12 - SP-189, Bairro Araca??u - Buri', 'Buri', 6),

('Instituto Tecnol??gico de Aeron??utica', 'Pra??a Marechal Eduardo Gomes, 50 - Vila das Acacias, S??o Jos?? dos Campos - SP, 12228-900', 'S??o Jos?? dos Campos', 7);

-- Table: cursos
insert into cursos (curso_nome) VALUES
('Artes C??nicas'),
('Artes Visuais'),
('Audiovisual'),
('Biblioteconomia'),
('Editora????o'),
('Educomunica????o'),
('Jornalismo'),
('Musica'),
('Publicidade e Propaganda'),
('Rela????es P??blicas'),
('Turismo'),
('Licenciatura em Educa????o F??sica'),
('Bacharelado em Educa????o F??sica'),
('Bacharelado em Enfermagem'),
('Engenharia Ambiental'),
('Engenharia Civil'),
('Engenharia da Computa????o'),
('Engenharia Metal??rgica, de Materiais e Nuclear'),
('Engenharia de Minas'),
('Engenharia de Petr??leo'),
('Engenharia de Produ????o'),
('Engenharia El??trica, com ??nfases: Automa????o e Controle'),
('Engenharia El??trica, com ??nfases: Energia e Automa????o El??tricas'),
('Engenharia El??trica, com ??nfases: Eletr??nica e Sistemas'),
('Engenharia El??trica, com ??nfases: Telecomunica????es'),
('Engenharia Mec??nica'),
('Engenharia Mecatr??nica'),
('Engenharia Naval'),
('Engenharia Qu??mica'),
('Arquitetura e Urbanismo'),
('Design'),
('Farm??cia'),
('Direito'),
('Economia'),
('Administra????o'),
('Ci??ncias Contabeis'),
('Pedagogia'),
('Ci??ncias Sociais'),
('Filosofia'),
('Geografia'),
('Hist??ria'),
('Letras'),
('Medicina'),
('Fisioterapia'),
('Fonoaudiologia'),
('Terapia Ocupacional'),
('F??sica M??dica'),
('Medicina Veterin??ria'),
('Odontologia'),
('Nutri????o'),
('Sa??de P??blica'),
('Bacharelado em Astronomia'),
('Bacharelado em Geof??sica'),
('Bacharelado em Metereologia'),
('Ci??ncias Biol??gicas'),
('Ci??ncias Biom??dicas'),
('Ci??ncias Fundamentais para a Sa??de'),
('F??sica'),
('Bacharelado em Geologia'),
('Licenciatura em Geoci??ncias e Educa????o Ambiental'),
('Bacharelado em Ci??ncia da Computa????o'),
('Bacharelado em Estat??stica'),
('Bacharelado em Matem??tica'),
('Bacharelado em Matem??tica Aplicada '),
('Bacharelado em Matem??tica Aplicada e Computacional'),
('Licenciatura em Matem??tica'),
('Psicologia'),
('Bacharelado em Qu??mica'),
('Bacharelado em Qu??mica com ??nfase em Bioqu??mica e Biologia Molecular'),
('Bacharelado em Qu??mica com ??nfase em Biotecnologia'),
('Bacharelado em Qu??mica com ??nfase em Qu??mica Ambiental'),
('Bacharelado em Qu??mica com ??nfase em Qu??mica Tecnol??gica'),
('Licenciatura em Qu??mica'),
('Bacharelado em Rela????es Internacionais'),
('Oceanografia'),
('Biotecnologia'),
('Ci??ncias da Natureza'),
('Educa????o F??sica e Sa??de'),
('Gerontologia'),
('Gest??o Ambiental'),
('Gest??o de Pol??ticas P??blicas'),
('Lazer e Turismo'),
('Marketing'),
('Obstetr??cia'),
('Sistemas de Informa????o'),
('T??xtil e Moda'),
('Engenharia Aeron??utica'),
('Engenharia Bioqu??mica'),
('Engenharia de Materiais'),
('Engenharia de Produ????o'),
('Engenharia F??sica'),
('Engenharia de Biotecnologia'),
('Licenciatura em Enfermagem'),
('Ci??ncias dos Alimentos'),
('Ci??ncias Econ??micas'),
('Engenharia Agron??mica'),
('Engenharia Florestal'),
('Engenharia de Alimentos'),
('Engenharia de Biossistemas'),
('Zootecnia'),
('Bacharelado em Matem??tica Aplicada a Neg??cios'),
('Bacharelado com Habilita????o em M??sica'),
('Bacharelado com Habilita????o em Canto e Arte L??rica'),
('Bacharelado com Habilita????o em Flauta'),
('Bacharelado com Habilita????o em Percuss??o'),
('Bacharelado com Habilita????o em Viola Caipira'),
('Bacharelado com Habilita????o em Piano'),
('Bacharelado com Habilita????o em Violao'),
('Bacharelado com Habilita????o em Violoncelo'),
('Licenciatura com Habilita????o em M??sica'),
('Licenciatura em Pedagogia'),
('Informatica Biomedica'),
('Bacharelado de estatistica e ciencia de dados'),
('Licenciatura em Ciencias Exatas'),
('Engenharia de Telecomunica????es'),
('Engenharia de Transportes'),
('Tecnologia em An??lise e desenvolvimento de Sistemas'),
('Tecmologia em Saneamento Ambiental'),
('Administra????o Publica'),
('Ci??ncia do Esporte'),
('Engenharia de Manufatura'),
('Gest??o'),
('Biologia'),
('Estudos da Linguagem'),
('Geoci??ncias'),
('Filosofia e Ci??ncias Humanas'),
('Ci??ncias Farmac??uticas'),
('Engenharia Agr??cola'),
('Midialogia'),
('Dan??a'),
('Ci??ncias M??dicas'),
('Engenharia El??trica'),
('Engenharia de Bioprocessos e Biotecnologia');

-- Table: campus_cursos
insert into campus_cursos (campus_id, curso_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(1, 11),
(1, 12),
(1, 13),
(1, 14),
(1, 15),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 28),
(1, 29),
(1, 30),
(1, 31),
(1, 32),
(1, 33),
(1, 34),
(1, 35),
(1, 36),
(1, 37),
(1, 38),
(1, 39),
(1, 40),
(1, 41),
(1, 42),
(1, 43),
(1, 44),
(1, 45),
(1, 46),
(1, 47),
(1, 48),
(1, 49),
(1, 50),
(1, 51),
(1, 52),
(1, 53),
(1, 54),
(1, 55),
(1, 56),
(1, 57),
(1, 58),
(1, 59),
(1, 60),
(1, 61),
(1, 62),
(1, 63),
(1, 64),
(1, 65),
(1, 66),
(1, 67),
(1, 68),
(1, 69),
(1, 70),
(1, 71),
(1, 72),
(1, 73),
(1, 74),
(1, 75),
(2, 76),
(2, 77),
(2, 78),
(2, 79),
(2, 80),
(2, 81),
(2, 82),
(2, 83),
(2, 84),
(2, 85),
(2, 86),
(3, 49),
(4, 15),
(4, 88),
(4, 89),
(4, 90),
(4, 91),
(4, 29),
(5, 78),
(5, 14),
(5, 93),
(5, 33),
(5, 95),
(5, 35),
(5, 36),
(5, 4),
(5, 55),
(5, 61),
(5, 47),
(5, 101),
(5, 103),
(5, 104),
(5, 105),
(5, 106),
(5, 107),
(5, 108),
(5, 109),
(5, 111),
(5, 67),
(5, 68),
(5, 73),
(5, 56),
(5, 44),
(5, 45),
(5, 112),
(5, 43),
(5, 50),
(5, 46),
(5, 49),
(6, 35),
(6, 55),
(6, 94),
(6, 95),
(6, 96),
(6, 97),
(6, 80),
(7, 98),
(7, 48),
(7, 99),
(7, 100),
(8, 19),
(8, 20),
(9, 87),
(9, 15),
(9, 16),
(9, 17),
(9, 89),
(9, 90),
(9, 24),
(9, 23),
(9, 26),
(9, 27),
(9, 30),
(9, 85),
(9, 66),
(9, 63),
(9, 64),
(9, 113),
(9, 114),
(9, 58),
(9, 68),
(10, 15),
(10, 115),
(10, 116),
(10, 85),
(10, 117),
(10, 118),
(11, 35),
(11, 90),
(11, 50),
(11, 119),
(11, 120),
(11, 121),
(11, 122),
(12, 49),
(13, 123),
(13, 124),
(13, 125),
(13, 126),
(13, 127),
(13, 128),
(13, 131),
(13, 129),
(13, 130),
(13, 65),
(13, 63),
(13, 62),
(13, 17),
(13, 61),
(13, 1),
(13, 2),
(13, 34),
(13, 98),
(13, 16),
(13, 30),
(13, 26),
(13, 29),
(13, 13),
(13, 12),
(13, 111),
(13, 93),
(13, 8),
(13, 68),
(13, 58),
(13, 132),
(14, 48),
(15, 49),
(16, 32),
(16, 133),
(17, 119),
(17, 95),
(17, 38),
(17, 42),
(17, 37),
(18, 49),
(19, 68),
(19, 72),
(19, 29),
(19, 73),
(20, 55),
(20, 92),
(20, 41),
(20, 42),
(20, 67);

-- Table: vestibulares
insert into vestibulares (vestibular_nome, vestibular_data, vestibular_link) VALUES
('Fuvest - 1a fase', '2022-12-04', 'https://www.fuvest.br/'),
('Fuvest - 2a fase - 1o dia', '2023-01-08', 'https://www.fuvest.br/'),
('Fuvest - 2a fase - 2o dia', '2023-01-09', 'https://www.fuvest.br/'),
('Comvest - 1a fase', '2022-11-06', 'https://www.comvest.unicamp.br/vest2023/F1/localf1/local.php'),
('Comvest - 2a fase - 1o dia', '2022-12-11', 'https://www.comvest.unicamp.br/vest2023/F1/localf1/local.php'),
('Comvest - 2a fase - 2o dia', '2022-12-12', 'https://www.comvest.unicamp.br/vest2023/F1/localf1/local.php'),
('Vunesp - 1a fase', '2022-11-15', 'https://www.vunesp.com.br/VNSP2206'),
('Vunesp - 2a fase', '2022-12-19', 'https://www.vunesp.com.br/VNSP2206'),
('Enem - 1o dia', '2022-11-13', 'https://enem.inep.gov.br/participante/#!/'),
('Enem - 2o dia', '2022-11-20', 'https://enem.inep.gov.br/participante/#!/'),
('Ita - 1a fase', '2022-10-16', 'https://www.vestibular.ita.br/'),
('Ita - 2a fase - 1o dia', '2022-11-08', 'https://www.vestibular.ita.br/'),
('Ita - 2a fase - 2o dia', '2022-11-09', 'https://www.vestibular.ita.br/');

-- Table: universidades_ingressos
insert into universidades_ingressos (universidade_id, ingresso_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 4),
(2, 5),
(2, 6);

-- Table: disciplinas
insert into disciplinas (disciplina_nome) VALUES
('Matem??tica'),
('L??ngua Portuguesa'),
('Geografia'),
('Hist??ria'),
('F??sica'),
('Qu??mica'),
('Ingl??s'),
('Filosofia'),
('Sociologia'),
('Biologia');

-- Table: temas
insert into temas (tema_nome, disciplina_id) VALUES
('Trigonometria', 1),
('Geometria', 1),
('Fun????es de 1o grau', 1),
('Fun????es de 2o grau', 1),
('Porcentagem', 1),
('Estat??stica e Probabilidade', 1),
('Prismas', 1),
('Interpreta????o de texto', 2),
('Interpreta????o de texto n??o verbal', 2),
('Dom??nio da norma culta', 2),
('An??lise de discurso', 2),
('G??neros textuais', 2),
('Figuras de linguagem', 2),
('Relevo', 3),
('Globaliza????o', 3),
('Urbaniza????o', 3),
('Energia el??trica', 3),
('Clima', 3),
('Teorias demogr??ficas', 3),
('Migra????es internacionais', 3),
('Antiguidade Cl??ssica: Gr??cia e Roma Antiga', 4),
('Feudalismo', 4),
('Civiliza????es pr??-colombianas: Incas, Maias e Astecas', 4),
('Absolutismo', 4),
('Revolu????o Francesa', 4),
('Coloniza????o mercantilista', 4),
('Processo de Independ??ncia do Brasil', 4),
('Segundo reinado: D. Pedro II', 4),
('Era Vargas', 4),
('Ditadura Militar', 4),
('Energia', 5),
('Mec??nica', 5),
('Eletricidade', 5),
('??ptica', 5),
('Termof??sica', 5),
('Leis de Newton', 5),
('Correntes e pot??ncia el??trica', 5),
('Fen??menos ondulat??rios', 5),
('Estequiometria', 6),
('Fun????es inorg??nicas', 6),
('Termoqu??mica', 6),
('Fun????es oxigenadas e nitrogenadas', 6),
('Qu??mica Ambiental', 6),
('Qu??mica Org??nica', 6),
('Rea????es Org??nicas', 6),
('Unidades de Concentra????o', 6),
('For??as Intermoleculares', 6),
('Substantivos cont??veis e incont??veis', 7),
('Tempos verbais em ingl??s', 7),
('Voz passiva em ingl??s', 7),
('Pronomes pessoais', 7),
('Linking words', 7),
('??tica e Justi??a', 8),
('Natureza do Conhecimento', 8),
('Democracia e Cidadania', 8),
('Filosofia Contempor??nea', 8),
('Filosofia Moderna', 8),
('Mundo do trabalho', 9),
('Cultura e ind??stria cultural', 9),
('Meios de comunica????o, tecnologia e cultura de massa', 9),
('Ideologia', 9),
('Cidadania', 9),
('Movimentos sociais', 9),
('Desigualdades sociais', 9),
('Teorias Sociol??gicas', 9),
('Ecologia', 10),
('Evolu????o', 10),
('Biomas', 10),
('Gen??tica', 10),
('Ciclos biogeoqu??micos', 10),
('Fisiologia humana', 10);

-- Table: aulas
insert into aulas (aula_titulo, aula_link, aula_canal, tema_id) VALUES
('Me Salva! TRG01 - Trigonometria - No????o intuitiva', 'https://youtu.be/j_qkYmhUHow', 'Me Salva!', 1),
('Me Salva! TRG02 - Trigonometria - Unidades de medida da trigonometria e convers??es', 'https://youtu.be/8Jky7RvNQnc', 'Me Salva!', 1),
('Me Salva! TRG03 - Trigonometria - C??rculo trigonom??trico', 'https://youtu.be/-qVIXr-x0JA', 'Me Salva!', 1),
('Me Salva! TRG04 - Trigonometria - Arcos c??ngruos', 'https://youtu.be/YYAfoqsHzkk', 'Me Salva!', 1),
('Me Salva! TRG05 - Trigonometria - Fun????es seno e cosseno', 'https://youtu.be/LUZH0kgug8M', 'Me Salva!', 1),
('Me Salva! TRG06 - Trigonometria - Fun????es tangente e secante', 'https://youtu.be/nhlRbWuJvsE', 'Me Salva!', 1),
('Me Salva! GP01 - ??ngulos complementares, suplementares e replementares', 'https://youtu.be/GsYeN1tDw1c', 'Me Salva!', 2),
('Me Salva! GP02 - Teorema de Tales, defini????o e aplica????o', 'https://youtu.be/tP0CdtMnR0Y', 'Me Salva!', 2),
('Me Salva! GP03 - Geometria Plana - ??ngulos entre retas concorrentes e transversais', 'https://youtu.be/IjhO_F6YepY', 'Me Salva!', 2),
('Me Salva! GP05 - Geometria Plana - Pol??gonos Regulares defini????o e nomenclatura', 'https://youtu.be/swcFcJ8pRoo', 'Me Salva!', 2),
('Me Salva! PRC07 - Fun????es de primeiro grau', 'https://youtu.be/KB7NezH1ZK4', 'Me Salva!', 3),
('Me Salva! PRC09 - Fun????es de segundo grau', 'https://youtu.be/Nx6oLGKWzBA', 'Me Salva!', 4),
('Me Salva! FIN04 - Porcentagem: teoria, taxa percentual, propor????o e taxa decimal', 'https://youtu.be/jNDdP9d6lr0', 'Me Salva!', 5),
('Me Salva! INEST03 - M??dias', 'https://youtu.be/uNe81VZvqJg', 'Me Salva!', 6),
('Me Salva! INEST05 - Amplitude e Vari??ncia', 'https://youtu.be/Cq_a5ySEClk', 'Me Salva!', 6),
('Me Salva! PBB01 - Conceitos Iniciais de Probabilidade', 'https://youtu.be/eFyAyz6Xy6g', 'Me Salva!', 6),
('Me Salva! PBB02 - Eventos e Combina????es', 'https://youtu.be/_dPD-_S0aY8', 'Me Salva!', 6),
('Me Salva! DPB05 - Distribui????o Normal (Aula I)', 'https://youtu.be/MoGes4OzsIk', 'Me Salva!', 6),
('Me Salva! EPA01 - Introdu????o ?? Estima????o de Par??metros', 'https://youtu.be/V0xQcRMU-zE', 'Me Salva!', 6),
('Me Salva! EPA02 - Conceito de Erro Amostral', 'https://youtu.be/xesxrMUBgNk', 'Me Salva!', 6),
('Me Salva! EPA16 - Exerc??cio do M??todo da M??xima Verossimilhan??a', 'https://youtu.be/XylQQ_BawTU', 'Me Salva!', 6),
('Me Salva! EPA20 - Intervalos de Confian??a para a M??dia', 'https://youtu.be/26CkHyfOYq0', 'Me Salva!', 6),
('Me Salva! GE01 - Geometria Espacial - Poliedros Regulares e Teorema de Euler', 'https://youtu.be/PDxmyRwntXg', 'Me Salva!', 7);

-- -- Table: exercicios
-- insert into exercicios (exercicio_texto, tema_id, exercicio_resposta) VALUES

-- -- Table: listas
-- insert into listas (lista_nome, disciplina_id) VALUES

-- -- Table: listas_exercicios
-- insert into listas_exercicios (lista_id, exercicio_id) VALUES

-- -- Table: registro_agenda
-- insert into registro_agenda (usuario_id, registro_data, registro_duracao, tema_id) VALUES
