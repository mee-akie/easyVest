package com.easyvest.model;

import javax.persistence.*;

@Entity
@Table(name = "aulas")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long aula_id;

    @Column(nullable = false, length = 100)
    private String aula_titulo;

    @Column(nullable = false, length = 100)
    private String aula_link;

    @Column(nullable = false, length = 30)
    private String aula_canal;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    // default constructor. Don't delete
    public Aula() {
    }

    public Aula(Long aula_id, String aula_titulo, String aula_link, String aula_canal, Tema tema) {
        this.aula_id = aula_id;
        this.aula_titulo = aula_titulo;
        this.aula_link = aula_link;
        this.aula_canal = aula_canal;
        this.tema = tema;
    }

    public Long getId() {
        return aula_id;
    }

    public String getTitulo() {
        return aula_titulo;
    }

    public String getLink() {
        return aula_link;
    }

    public String getCanal() {
        return aula_canal;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTitulo(String aula_titulo) {
        this.aula_titulo = aula_titulo;
    }

    public void setLink(String aula_link) {
        this.aula_link = aula_link;
    }

    public void setCanal(String aula_canal) {
        this.aula_canal = aula_canal;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
