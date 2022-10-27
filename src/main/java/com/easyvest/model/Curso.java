package com.easyvest.model;

import javax.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long curso_id;

    @Column(nullable = false, length = 50)
    private String curso_nome;

    public Long getId() {
        return curso_id;
    }

    public String getNome() {
        return curso_nome;
    }

    public void setNome(String curso_nome) {
        this.curso_nome = curso_nome;
    }
}
