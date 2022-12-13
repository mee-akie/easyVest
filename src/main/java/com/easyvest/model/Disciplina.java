package com.easyvest.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "disciplinas")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long disciplina_id;

    @Column(nullable = false, length = 30)
    private String disciplina_nome;

    @OneToMany(mappedBy = "disciplina")
    private List<Tema> temas;

    @OneToMany(mappedBy = "disciplina")
    private List<Lista> listas;

    // default constructor. Don't delete
    public Disciplina() {
    }

    public Long getId() {
        return disciplina_id;
    }

    public String getNome() {
        return disciplina_nome;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setNome(String disciplina_nome) {
        this.disciplina_nome = disciplina_nome;
    }
}
