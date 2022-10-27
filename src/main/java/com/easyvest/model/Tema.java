package com.easyvest.model;

import javax.persistence.*;

@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long tema_id;

    @Column(nullable = false, length = 30)
    private String tema_nome;

    public Long getId() {
        return tema_id;
    }

    public String getNome() {
        return tema_nome;
    }

    public void setNome(String tema_nome) {
        this.tema_nome = tema_nome;
    }
}
