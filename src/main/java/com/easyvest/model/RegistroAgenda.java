package com.easyvest.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "registro_agenda")
public class RegistroAgenda {
    /*usuario_id int  NOT NULL,
    registro_id int NOT NULL,
    registro_inicio timestamp  NOT NULL,
    registro_fim timestamp  NOT NULL,
    registro_nome varchar(45)  NOT NULL */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long registro_id;

    @Column(nullable = false, length = 45)
    private String registro_nome;

    @Column(nullable = false)
    private Date registro_inicio;

    @Column(nullable = false)
    private Date registro_fim;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getId() {
        return registro_id;
    }

    public String getNome() {
        return registro_nome;
    }

    public Date getInicio() {
        return registro_inicio;
    }

    public Date getFim() {
        return registro_fim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setNome(String registro_nome) {
        this.registro_nome = registro_nome;
    }

    public void setInicio(Date registro_inicio) {
        this.registro_inicio = registro_inicio;
    }

    public void setFim(Date registro_fim) {
        this.registro_fim = registro_fim;
    }
}
