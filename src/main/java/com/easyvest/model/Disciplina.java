package com.easyvest.model;

import javax.persistence.*;

@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long disciplina_id;

    @Column(nullable = false, length = 30)
    private String disciplina_nome;

    public Long getId() {
        return disciplina_id;
    }

    public String getNome() {
        return disciplina_nome;
    }

    public void setNome(String disciplina_nome) {
        this.disciplina_nome = disciplina_nome;
    }
}
