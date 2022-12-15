package com.easyvest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "listas")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long lista_id;

    @Column(nullable = false, length = 30)
    private String lista_nome;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(name = "listas_exercicios", joinColumns = @JoinColumn(name = "lista_id"), inverseJoinColumns = @JoinColumn(name = "exercicio_id"))
    public List<Curso> exercicios;

    // default constructor. Don't delete
    public Lista() {
    }

    public Lista(Long lista_id, String lista_nome, Disciplina disciplina, List<Curso> exercicios) {
        this.lista_id = lista_id;
        this.lista_nome = lista_nome;
        this.disciplina = disciplina;
        this.exercicios = exercicios;
    }

    public Long getId() {
        return lista_id;
    }

    public String getNome() {
        return lista_nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Curso> getExercicios() {
        return exercicios;
    }

    public void setNome(String lista_nome) {
        this.lista_nome = lista_nome;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setExercicios(List<Curso> exercicios) {
        this.exercicios = exercicios;
    }
}
