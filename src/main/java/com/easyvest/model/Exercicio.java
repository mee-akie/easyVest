package com.easyvest.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "exercicio")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long exercicio_id;

    @Column(nullable = false, length = 1500)
    private String exercicio_texto;

    @Column(nullable = false, length = 1)
    private Character exercicio_resposta;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    @ManyToMany(mappedBy = "lista_exercicio")
    private List<Lista> listas;

    public Exercicio() {}

    public Long getId() {
        return exercicio_id;
    }

    public String getTexto() {
        return exercicio_texto;
    }

    public Character getResposta() {
        return exercicio_resposta;
    }

    public Tema getTema() {
        return tema;
    }

    public List<Lista> getListas() {
        return listas;
    }

    public void setTexto(String exercicio_texto) {
        this.exercicio_texto = exercicio_texto;
    }

    public void setResposta(Character exercicio_resposta) {
        this.exercicio_resposta = exercicio_resposta;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
