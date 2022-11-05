package com.easyvest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long curso_id;

    @Column(nullable = false, length = 50)
    private String curso_nome;

    @ManyToMany(targetEntity = Campus.class)
    private List<Campus> campi;

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
}
