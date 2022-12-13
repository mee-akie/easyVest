package com.easyvest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "registro_agenda")
public class RegistroAgenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long registro_id;

    @Column(nullable = false, length = 45)
    private String registro_nome;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp registro_inicio;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp registro_fim;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Long getRegistro_id() {
        return registro_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getRegistro_nome() {
        return registro_nome;
    }

    public Timestamp getRegistro_inicio() {
        return registro_inicio;
    }

    public Timestamp getRegistro_fim() {
        return registro_fim;
    }

    public void setRegistro_nome(String registro_nome) {
        this.registro_nome = registro_nome;
    }

    public void setRegistro_inicio(Timestamp registro_inicio) {
        this.registro_inicio = registro_inicio;
    }

    public void setRegistro_fim(Timestamp registro_fim) {
        this.registro_fim = registro_fim;
    }

    public void setRegistro_id(Long registro_id) {
        this.registro_id = registro_id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
