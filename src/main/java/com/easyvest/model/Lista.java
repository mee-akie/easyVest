package com.easyvest.model;

import javax.persistence.*;

@Entity
@Table(name = "lista")
public class Lista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long lista_id;

    @Column(nullable = false, length = 30)
    private String lista_nome;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    public Lista(){}

    public Long getId() {
        return lista_id;
    }

    public String getNome() {
        return lista_nome;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setNome(String lista_nome) {
        this.lista_nome = lista_nome;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
