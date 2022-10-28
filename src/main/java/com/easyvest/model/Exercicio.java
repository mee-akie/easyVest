package com.easyvest.model;

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

    public Long getId() {
        return exercicio_id;
    }

    public String getTexto() {
        return exercicio_texto;
    }

    public Character getResposta() {
        return exercicio_resposta;
    }

    public void setTexto(String exercicio_texto) {
        this.exercicio_texto = exercicio_texto;
    }

    public void setResposta(Character exercicio_resposta) {
        this.exercicio_resposta = exercicio_resposta;
    }
}
