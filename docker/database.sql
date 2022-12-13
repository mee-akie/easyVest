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
insert into campus (campus_nome, campus_endereco, universidade_id) VALUES
('Campus de São Paulo - Cidade Universitária', 'Av. Prof. Almeida Prado, 1280 - Butantã, São Paulo - SP, 05508-900', 1),
('Campus de São Paulo - USP Leste', 'Rua Arlindo Béttio, 1000 - Ermelino Matarazzo, São Paulo - SP, 03828-000', 1),
('Campus de Bauru', 'Alameda Dr. Octávio Pinheiro Brisolla, 9-75 - Vila Nova Cidade Universitária, Bauru - SP, 17012-901', 1),
('Campus de Lorena', 'Estrada Municipal do Campinho, s/n - Pte. Nova, Lorena - SP, 12602-810', 1),
('Campus de Ribeirão Preto', 'Rua Monte Alegre, Av. Bandeirantes, 3900 - Subsetor Oeste - 11 (N-11), Ribeirão Preto - SP, 14040-900', 1),
('Campus de Piracicaba', 'Av. Pádua Dias, 11 - Agronomia, Piracicaba - SP, 13418-900', 1),
('Campus de Pirassununga', 'R. Duque de Caxias, 225 - Jardim Elite, Pirassununga - SP, 13635-900', 1),
('Campus de Santos', 'Praça Cel. Narciso de Andrade, 36 - Vila Matias, Santos - SP, 11013-552', 1),
('Campus de São Carlos', 'Av. Trab. São Carlense, 400 - Parque Arnold Schimidt, São Carlos - SP, 13566-590', 1),

('Faculdade de Tecnologia de Limeira', 'R. Paschoal Marmo, 1888 - Jd. Nova Itália - CEP: 13484-332 - Limeira, SP', 2),
('Faculdade de Ciências Aplicadas de Limeira', 'R. Pedro Zaccaria, 1300, Limeira - SP, 13484-350', 2),
('Faculdade de Odontologia de Piracicaba', 'Av. Limeira, 901 - Areião - CEP: 13414-903 - Piracicaba, SP', 2),
('Cidade Universitária "Zeferino Vaz" de Campinas', 'CEP 13083-970 | Campinas-SP', 2),

('Faculdade de Medicina Veterinária', 'R. Clóvis Pestana, 793 - CEP 16050-680', 3),
('Faculdade de Odontologia', 'R. José Bonifácio, 1193 - CEP 16015-050', 3),
('Faculdade de Ciências Farmacêuticas', 'Rodovia Araraquara-Jaú, km 1 - CP 502 - CEP 14801-902', 3),
('Faculdade de Ciências e Letras', 'Rodovia Araraquara-Jaú, km 1 - CP 174 - CEP 14800-901', 3),
('Faculdade de Odontologia', 'R. Humaitá, 1680 - CP 33 - Centro - CEP 14801-903', 3),
('Instituto de Química', 'R. Prof. Francisco Degni, s/n - CP 355 - CEP 14800-900', 3),
('Faculdade de Ciências e Letras', 'Av. Dom Antonio, 2100 - CEP 19806-900', 3),
('Faculdade de Arquitetura, Artes e Comunicação', 'Av. Eng. Luiz Edmundo Carrijo Coube, 14-01 - CEP 17033-360', 3),
('Faculdade de Ciências', 'Av. Eng. Luiz Edmundo Carrijo Coube, 14-01 - CEP 17033-360', 3),
('Faculdade de Engenharia', 'Av. Eng. Luiz Edmundo Carrijo Coube, 14-01 - CEP 17033-360', 3),
('Faculdade de Ciências Agronômicas', 'Fazenda Experimental Lageado. R. José Barbosa de Barros, 1780 - CP 237 - CEP 18610-307', 3),
('Faculdade de Medicina', 'Distrito de Rubião Júnior, s/n - CEP 18618-970', 3),
('Faculdade de Medicina Veterinária e Zootecnia', 'Distrito de Rubião Júnior, s/n - CP 237 - CEP 18618-970', 3),
('Instituto de Biociências', 'Distrito de Rubião Júnior, s/n - CEP 18618-970', 3),
('Faculdade de Ciências Agrárias e Tecnológicas', 'Rod. Comte. João Ribeiro de Barros (SP 294), km 651', 3),
('Faculdade de Ciências Humanas e Sociais', 'Rua Eufrásia Monteiro Petráglia, 900, Jardim Dr. Antonio Petráglia - CEP 14409-160', 3),
('Faculdade de Engenharia', 'Av. Dr. Ariberto Pereira da Cunha, 333 - CEP 12516-410', 3),
('Faculdade de Engenharia de Ilha Solteira', 'Av. Brasil, 56 - Centro - CEP 15385-000', 3),
('Câmpus de Itapeva', 'R. Geraldo Alckmin, 519 - CEP 18409-010', 3),
('Faculdade de Ciências Agrárias e Veterinárias', 'Via de Acesso Prof. Paulo Donato Castellane, s/n, CEP 14884-900', 3),
('Faculdade de Filosofia e Ciências', 'Av. Hygino Muzzi Filho, 737 - CP 181 - CEP 17525-900', 3),
('Câmpus de Ourinhos', 'Av Renato da Costa Lima, 451, Ville de France, Ourinhos-SP, CEP 19.903-302', 3),
('Faculdade de Ciências e Tecnologia', 'R. Roberto Simonsen, 305 - CP 266, Bairro Centro Educacional - CEP 19060-080', 3),
('Câmpus de Registro', 'R. Nelson Brihi Badur, 430 - Vila Tupy - CEP 11900-000', 3),
('Instituto de Biociências', 'Av. 24-A, 1515 - CP 199 - CEP 13506-900', 3),
('Instituto de Geociências e Ciências Exatas', 'Av. 24-A, 1515 - CP 199, CEP 13506-900 - Fone (55) 19 3526-9011', 3),
('Câmpus de Rosana', 'Av. dos Barrageiros, s/n, esquina com Estrada dos Alojamentos, s/no, CEP 19274-000', 3),
('Câmpus de São João da Boa Vista', ' Avenida Professora Isette Corrêa Fontão, no 1 Jardim das Flores - CEP 13876-150', 3),
('Instituto de Biociências, Letras e Ciências Exatas', 'R. Cristóvão Colombo, 2265 - Jardim Nazareth, CEP 15054-000', 3),
('Instituto de Ciência e Tecnologia', 'Av. Eng. Francisco José Longo, 777, São Dimas - CEP 12245-000', 3),
('Instituto de Artes', 'R. Dr. Bento Teobaldo Ferraz, 271, Barra Funda - CEP 01140-070', 3),
('Instituto de Biociências - Câmpus do Litoral Paulista', 'Praça Infante D. Henrique, s/n - CEP 11330-900', 3),
('Instituto de Ciência e Tecnologia/Sorocaba', 'Av. Três de Março, 511 - Bairro Alto da Boa Vista, CEP 18087-180', 3),
('Câmpus de Tupã', 'Av. Domingos da Costa Lopes, 780 - Jardim Itaipu, CEP 17602-496', 3),

('São Paulo - Enfermagem', 'R. Napoleão de Barros, 754 - Vila Clementino, São Paulo - SP, 04024-002', 4),
('São Paulo', 'R. Botucatu, 862 - Vila Clementino, São Paulo - SP, 04023-062', 4),
('São Paulo', 'Av. Padre José Maria, 545 - Santo Amaro, São Paulo - SP, 04753-060', 4),
('Baixada Santista', 'Edifício Central - R. Silva Jardim, 136 - Vila Matias, Santos - SP, 11015-020', 4),
('Osasco', 'R. Angélica, 100 - Jardim das Flores, Osasco - SP, 06132-380', 4),
('São José dos Campos', 'R. Talim, 330 - Vila Nair, São José dos Campos - SP, 12231-280', 4),
('Diadema', 'Av. Conceição, 545 - Centro, Diadema - SP', 4),
('Guarulhos', 'Estr. do Caminho Velho, 333 - Jardim Nova Cidade, Guarulhos - SP, 07252-312', 4),
('Zona Leste', 'Av. Jacu Pêssego, 2630 - Itaquera, São Paulo - SP, 08260-001', 4),

('Campus Santo André', 'Avenida dos Estados, 5001 - Bairro Santa Terezinha, Santo André - CEP: 09210-580', 5),
('Campus São Bernardo do Campo', 'Alameda da Universidade, s/nº - Bairro Anchieta, São Bernardo do Campo - CEP: 09606-045', 5),

('Campus São Carlos', 'Rod. Washington Luís, km 235 - SP-310 - São Carlos, CEP 13565-905', 6),
('Campus Araras', 'Rod. Anhanguera, km 174 - SP-330 - Araras, CEP 13600-970', 6),
('Campus Sorocaba', 'Rod. João Leme dos Santos, km 110 - SP-264, Bairro do Itinga - Sorocaba', 6),
('Campus Lagoa do Sino', 'Rod. Lauri Simões de Barros, km 12 - SP-189, Bairro Aracaçu - Buri', 6),

('Instituto Tecnológico de Aeronáutica', 'Praça Marechal Eduardo Gomes, 50 - Vila das Acacias, São José dos Campos - SP, 12228-900', 7);

-- Table: cursos
insert into cursos (curso_nome) VALUES
('Artes Cênicas'),
('Artes Visuais'),
('Audiovisual'),
('Biblioteconomia'),
('Editoração'),
('Educomunicação'),
('Jornalismo'),
('Musica'),
('Publicidade e Propaganda'),
('Relações Públicas'),
('Turismo'),
('Licenciatura em Educação Física'),
('Bacharelado em Educação Física'),
('Bacharelado em Enfermagem'),
('Engenharia Ambiental'),
('Engenharia Civil'),
('Engenharia da Computação'),
('Engenharia Metalúrgica, de Materiais e Nuclear'),
('Engenharia de Minas'),
('Engenharia de Petróleo'),
('Engenharia de Produção'),
('Engenharia Elétrica, com ênfases: Automação e Controle'),
('Engenharia Elétrica, com ênfases: Energia e Automação Elétricas'),
('Engenharia Elétrica, com ênfases: Eletrônica e Sistemas'),
('Engenharia Elétrica, com ênfases: Telecomunicações'),
('Engenharia Mecânica'),
('Engenharia Mecatrônica'),
('Engenharia Naval'),
('Engenharia Química'),
('Arquitetura e Urbanismo'),
('Design'),
('Farmácia'),
('Direito'),
('Economia'),
('Administração'),
('Ciências Contabeis'),
('Pedagogia'),
('Ciências Sociais'),
('Filosofia'),
('Geografia'),
('História'),
('Letras'),
('Medicina'),
('Fisioterapia'),
('Fonoaudiologia'),
('Terapia Ocupacional'),
('Física Médica'),
('Medicina Veterinária'),
('Odontologia'),
('Nutrição'),
('Saúde Pública'),
('Bacharelado em Astronomia'),
('Bacharelado em Geofísica'),
('Bacharelado em Metereologia'),
('Ciências Biológicas'),
('Ciências Biomédicas'),
('Ciências Fundamentais para a Saúde'),
('Física'),
('Bacharelado em Geologia'),
('Licenciatura em Geociências e Educação Ambiental'),
('Bacharelado em Ciência da Computação'),
('Bacharelado em Estatística'),
('Bacharelado em Matemática'),
('Bacharelado em Matemática Aplicada '),
('Bacharelado em Matemática Aplicada e Computacional'),
('Licenciatura em Matemática'),
('Psicologia'),
('Bacharelado em Química'),
('Bacharelado em Química com ênfase em Bioquímica e Biologia Molecular'),
('Bacharelado em Química com ênfase em Biotecnologia'),
('Bacharelado em Química com ênfase em Química Ambiental'),
('Bacharelado em Química com ênfase em Química Tecnológica'),
('Licenciatura em Química'),
('Bacharelado em Relações Internacionais'),
('Oceanografia'),
('Biotecnologia'),
('Ciências da Natureza'),
('Educação Física e Saúde'),
('Gerontologia'),
('Gestão Ambiental'),
('Gestão de Políticas Públicas'),
('Lazer e Turismo'),
('Marketing'),
('Obstetrícia'),
('Sistemas de Informação'),
('Têxtil e Moda'),
('Engenharia Aeronáutica'),
('Engenharia Bioquímica'),
('Engenharia de Materiais'),
('Engenharia de Produção'),
('Engenharia Física'),
('Engenharia de Biotecnologia'),
('Licenciatura em Enfermagem'),
('Ciências dos Alimentos'),
('Ciências Econômicas'),
('Engenharia Agronômica'),
('Engenharia Florestal'),
('Engenharia de Alimentos'),
('Engenharia de Biossistemas'),
('Zootecnia'),
('Bacharelado em Matemática Aplicada a Negócios'),
('Bacharelado com Habilitação em Música'),
('Bacharelado com Habilitação em Canto e Arte Lírica'),
('Bacharelado com Habilitação em Flauta'),
('Bacharelado com Habilitação em Percussão'),
('Bacharelado com Habilitação em Viola Caipira'),
('Bacharelado com Habilitação em Piano'),
('Bacharelado com Habilitação em Violao'),
('Bacharelado com Habilitação em Violoncelo'),
('Licenciatura com Habilitação em Música'),
('Licenciatura em Pedagogia'),
('Informatica Biomedica'),
('Bacharelado de estatistica e ciencia de dados'),
('Licenciatura em Ciencias Exatas'),
('Engenharia de Telecomunicações'),
('Engenharia de Transportes'),
('Tecnologia em Análise e desenvolvimento de Sistemas'),
('Tecmologia em Saneamento Ambiental'),
('Administração Publica'),
('Ciência do Esporte'),
('Engenharia de Manufatura'),
('Gestão'),
('Biologia'),
('Estudos da Linguagem'),
('Geociências'),
('Filosofia e Ciências Humanas'),
('Ciências Farmacêuticas'),
('Engenharia Agrícola'),
('Midialogia'),
('Dança'),
('Ciências Médicas'),
('Engenharia Elétrica'),
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
('Matemática'),
('Língua Portuguesa'),
('Geografia'),
('História'),
('Física'),
('Química'),
('Inglês'),
('Filosofia'),
('Sociologia'),
('Biologia');

-- Table: temas
insert into temas (tema_nome, disciplina_id) VALUES
('Trigonometria', 1),
('Geometria', 1),
('Funções de 1o grau', 1),
('Funções de 2o grau', 1),
('Porcentagem', 1),
('Estatística e Probabilidade', 1),
('Prismas', 1),
('Interpretação de texto', 2),
('Interpretação de texto não verbal', 2),
('Domínio da norma culta', 2),
('Análise de discurso', 2),
('Gêneros textuais', 2),
('Figuras de linguagem', 2),
('Relevo', 3),
('Globalização', 3),
('Urbanização', 3),
('Energia elétrica', 3),
('Clima', 3),
('Teorias demográficas', 3),
('Migrações internacionais', 3),
('Antiguidade Clássica: Grécia e Roma Antiga', 4),
('Feudalismo', 4),
('Civilizações pré-colombianas: Incas, Maias e Astecas', 4),
('Absolutismo', 4),
('Revolução Francesa', 4),
('Colonização mercantilista', 4),
('Processo de Independência do Brasil', 4),
('Segundo reinado: D. Pedro II', 4),
('Era Vargas', 4),
('Ditadura Militar', 4),
('Energia', 5),
('Mecânica', 5),
('Eletricidade', 5),
('Óptica', 5),
('Termofísica', 5),
('Leis de Newton', 5),
('Correntes e potência elétrica', 5),
('Fenômenos ondulatórios', 5),
('Estequiometria', 6),
('Funções inorgânicas', 6),
('Termoquímica', 6),
('Funções oxigenadas e nitrogenadas', 6),
('Química Ambiental', 6),
('Química Orgânica', 6),
('Reações Orgânicas', 6),
('Unidades de Concentração', 6),
('Forças Intermoleculares', 6),
('Substantivos contáveis e incontáveis', 7),
('Tempos verbais em inglês', 7),
('Voz passiva em inglês', 7),
('Pronomes pessoais', 7),
('Linking words', 7),
('Ética e Justiça', 8),
('Natureza do Conhecimento', 8),
('Democracia e Cidadania', 8),
('Filosofia Contemporânea', 8),
('Filosofia Moderna', 8),
('Mundo do trabalho', 9),
('Cultura e indústria cultural', 9),
('Meios de comunicação, tecnologia e cultura de massa', 9),
('Ideologia', 9),
('Cidadania', 9),
('Movimentos sociais', 9),
('Desigualdades sociais', 9),
('Teorias Sociológicas', 9),
('Ecologia', 10),
('Evolução', 10),
('Biomas', 10),
('Genética', 10),
('Ciclos biogeoquímicos', 10),
('Fisiologia humana', 10);

-- Table: aulas
insert into aulas (aula_titulo, aula_link, aula_canal, tema_id) VALUES
('Me Salva! TRG01 - Trigonometria - Noção intuitiva', 'https://youtu.be/j_qkYmhUHow', 'Me Salva!', 1),
('Me Salva! TRG02 - Trigonometria - Unidades de medida da trigonometria e conversões', 'https://youtu.be/8Jky7RvNQnc', 'Me Salva!', 1),
('Me Salva! TRG03 - Trigonometria - Círculo trigonométrico', 'https://youtu.be/-qVIXr-x0JA', 'Me Salva!', 1),
('Me Salva! TRG04 - Trigonometria - Arcos côngruos', 'https://youtu.be/YYAfoqsHzkk', 'Me Salva!', 1),
('Me Salva! TRG05 - Trigonometria - Funções seno e cosseno', 'https://youtu.be/LUZH0kgug8M', 'Me Salva!', 1),
('Me Salva! TRG06 - Trigonometria - Funções tangente e secante', 'https://youtu.be/nhlRbWuJvsE', 'Me Salva!', 1),
('Me Salva! GP01 - Ângulos complementares, suplementares e replementares', 'https://youtu.be/GsYeN1tDw1c', 'Me Salva!', 2),
('Me Salva! GP02 - Teorema de Tales, definição e aplicação', 'https://youtu.be/tP0CdtMnR0Y', 'Me Salva!', 2),
('Me Salva! GP03 - Geometria Plana - Ângulos entre retas concorrentes e transversais', 'https://youtu.be/IjhO_F6YepY', 'Me Salva!', 2),
('Me Salva! GP05 - Geometria Plana - Polígonos Regulares definição e nomenclatura', 'https://youtu.be/swcFcJ8pRoo', 'Me Salva!', 2),
('Me Salva! PRC07 - Funções de primeiro grau', 'https://youtu.be/KB7NezH1ZK4', 'Me Salva!', 3),
('Me Salva! PRC09 - Funções de segundo grau', 'https://youtu.be/Nx6oLGKWzBA', 'Me Salva!', 4),
('Me Salva! FIN04 - Porcentagem: teoria, taxa percentual, proporção e taxa decimal', 'https://youtu.be/jNDdP9d6lr0', 'Me Salva!', 5),
('Me Salva! INEST03 - Médias', 'https://youtu.be/uNe81VZvqJg', 'Me Salva!', 6),
('Me Salva! INEST05 - Amplitude e Variância', 'https://youtu.be/Cq_a5ySEClk', 'Me Salva!', 6),
('Me Salva! PBB01 - Conceitos Iniciais de Probabilidade', 'https://youtu.be/eFyAyz6Xy6g', 'Me Salva!', 6),
('Me Salva! PBB02 - Eventos e Combinações', 'https://youtu.be/_dPD-_S0aY8', 'Me Salva!', 6),
('Me Salva! DPB05 - Distribuição Normal (Aula I)', 'https://youtu.be/MoGes4OzsIk', 'Me Salva!', 6),
('Me Salva! EPA01 - Introdução à Estimação de Parâmetros', 'https://youtu.be/V0xQcRMU-zE', 'Me Salva!', 6),
('Me Salva! EPA02 - Conceito de Erro Amostral', 'https://youtu.be/xesxrMUBgNk', 'Me Salva!', 6),
('Me Salva! EPA16 - Exercício do Método da Máxima Verossimilhança', 'https://youtu.be/XylQQ_BawTU', 'Me Salva!', 6),
('Me Salva! EPA20 - Intervalos de Confiança para a Média', 'https://youtu.be/26CkHyfOYq0', 'Me Salva!', 6),
('Me Salva! GE01 - Geometria Espacial - Poliedros Regulares e Teorema de Euler', 'https://youtu.be/PDxmyRwntXg', 'Me Salva!', 7);

-- -- Table: exercicios
-- insert into exercicios (exercicio_texto, tema_id, exercicio_resposta) VALUES

-- -- Table: listas
-- insert into listas (lista_nome, disciplina_id) VALUES

-- -- Table: listas_exercicios
-- insert into listas_exercicios (lista_id, exercicio_id) VALUES

-- -- Table: registro_agenda
-- insert into registro_agenda (usuario_id, registro_data, registro_duracao, tema_id) VALUES
