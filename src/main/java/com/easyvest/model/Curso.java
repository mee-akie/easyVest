package com.easyvest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long curso_id;

    @Column(nullable = false, length = 100)
    private String curso_nome;

    @ManyToMany(mappedBy = "cursos")
    @JsonBackReference
    private List<Campus> campi = new ArrayList<>();

    // default constructor. Don't delete
    public Curso() {
    }

    public Curso(Long curso_id, String curso_nome, List<Campus> campi) {
        this.curso_id = curso_id;
        this.curso_nome = curso_nome;
        this.campi = campi;
    }

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

    public void setCampi(List<Campus> campi) {
        this.campi = campi;
    }
}
