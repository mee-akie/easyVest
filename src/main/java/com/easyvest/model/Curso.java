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

    public Curso() {
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
