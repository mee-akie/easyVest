package com.easyvest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "universidades")
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long universidade_id;

    @Column(nullable = false, length = 100)
    private String universidade_nome;

    @ManyToMany
    @JoinTable(name = "universidades_ingressos", joinColumns = @JoinColumn(name = "universidade_id"), inverseJoinColumns = @JoinColumn(name = "ingresso_id"))
    public List<Vestibular> vestibulares;

    // default constructor. Don't delete
    public Universidade() {
    }

    public Long getId() {
        return universidade_id;
    }

    public String getNome() {
        return universidade_nome;
    }

    public List<Vestibular> getVestibulares() {
        return vestibulares;
    }

    public void setNome(String nome) {
        this.universidade_nome = nome;
    }
}
