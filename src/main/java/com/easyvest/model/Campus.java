package com.easyvest.model;

import javax.persistence.*;

@Entity
@Table(name = "campus")
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long campus_id;

    @Column(nullable = false, length = 100)
    private String campus_nome;

    @Column(nullable = false, length = 100)
    private String campus_endereco;

    @ManyToOne
    @JoinColumn(name = "universidade_id")
    private Universidade universidade;

    public Long getId() {
        return campus_id;
    }

    public String getNome() {
        return campus_nome;
    }

    public String getEndereco() {
        return campus_endereco;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setNome(String campus_nome) {
        this.campus_nome = campus_nome;
    }

    public void setEndereco(String campus_endereco) {
        this.campus_endereco = campus_endereco;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }
}
