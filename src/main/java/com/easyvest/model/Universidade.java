package com.easyvest.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "universidade")
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long universidade_id;

    @Column(nullable = false, length = 100)
    private String universidade_nome;

    @OneToMany(mappedBy = "universidade")
    private List<Campus> campi;

    public Long getId() {
        return universidade_id;
    }

    public String getNome() {
        return universidade_nome;
    }

    public List<Campus> getCampi() {
        return campi;
    }

    public void setNome(String nome) {
        this.universidade_nome = nome;
    }
}
