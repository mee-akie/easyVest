package com.easyvest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "campus")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long campus_id;

    @Column(nullable = false, length = 200)
    private String campus_nome;

    @Column(nullable = false, length = 200)
    private String campus_endereco;

    @ManyToOne
    @JoinColumn(name = "universidade_id")
    private Universidade universidade;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "campus_cursos", joinColumns = @JoinColumn(name = "campus_id"), inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private List<Curso> cursos = new ArrayList<>();

    // default constructor. Don't delete
    public Campus() {
    }

    public Campus(Long campus_id, String campus_nome, String campus_endereco, Universidade universidade, List<Curso> cursos) {
        this.campus_id = campus_id;
        this.campus_nome = campus_nome;
        this.campus_endereco = campus_endereco;
        this.universidade = universidade;
        this.cursos = cursos;
    }

    public Long getId() {
        return campus_id;
    }

    public String getNome() {
        return campus_nome;
    }

    public String getEndereco() {
        return campus_endereco;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setNome(String campus_nome) {
        this.campus_nome = campus_nome;
    }

    public void setEndereco(String campus_endereco) {
        this.campus_endereco = campus_endereco;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
