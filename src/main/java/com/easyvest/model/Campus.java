package com.easyvest.model;

import javax.persistence.*;

@Entity
public class Campus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long campus_id;

    @Column(nullable = false, length = 100)
    private String campus_nome;

    @Column(nullable = false, length = 100)
    private String campus_endereco;

    public Long getId() {
        return campus_id;
    }

    public String getNome() {
        return campus_nome;
    }

    public String getEndereco() {
        return campus_endereco;
    }

    public void setNome(String campus_nome) {
        this.campus_nome = campus_nome;
    }

    public void setEndereco(String campus_endereco) {
        this.campus_endereco = campus_endereco;
    }
}
