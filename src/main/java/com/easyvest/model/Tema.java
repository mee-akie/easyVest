package com.easyvest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "temas")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long tema_id;

    @Column(nullable = false, length = 60)
    private String tema_nome;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    @JsonBackReference
    private Disciplina disciplina;

    @OneToMany(mappedBy = "tema")
    @JsonBackReference
    private List<Aula> aulas;

    @OneToMany(mappedBy = "tema")
    private List<Exercicio> exercicios;

    // default constructor. Don't delete
    public Tema() {
    }

    public Tema(Long tema_id, String tema_nome, Disciplina disciplina, List<Aula> aulas, List<Exercicio> exercicios) {
        this.tema_id = tema_id;
        this.tema_nome = tema_nome;
        this.disciplina = disciplina;
        this.aulas = aulas;
        this.exercicios = exercicios;
    }

    public Long getId() {
        return tema_id;
    }

    public String getNome() {
        return tema_nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setNome(String tema_nome) {
        this.tema_nome = tema_nome;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
