package com.easyvest.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long curso_id;

    @Column(nullable = false, length = 50)
    private String curso_nome;

    @ManyToMany(mappedBy = "campus_curso")
    private List<Campus> campi;

    public Curso() {}

    public Long getId() {
        return curso_id;
    }

    public String getNome() {
        return curso_nome;
    }

    public List<Campus> getCampi() {
        return campi;
    }

    public void setNome(String curso_nome) {
        this.curso_nome = curso_nome;
    }
}
