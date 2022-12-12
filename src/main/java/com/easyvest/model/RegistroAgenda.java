package com.easyvest.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@IdClass(RegistroAgendaId.class)
@Table(name = "registro_agenda")
public class RegistroAgenda {

    @Id
    private Date registro_data;

    @Column(nullable = false, length = 45)
    private String registro_nome;

    @Column(nullable = false)
    private Date registro_inicio;

    @Column(nullable = false)
    private Date registro_fim;

    @Id
    private Long usuario_id;

    public Long getUsuario_id() {
        return usuario_id;
    }

    public Date getRegistro_data() {
        return registro_data;
    }

    public String getRegistro_nome() {
        return registro_nome;
    }

    public Date getRegistro_inicio() {
        return registro_inicio;
    }

    public Date getRegistro_fim() {
        return registro_fim;
    }

    public void setRegistro_data(Date registro_data) {
        this.registro_data = registro_data;
    }

    public void setRegistro_nome(String registro_nome) {
        this.registro_nome = registro_nome;
    }

    public void setRegistro_inicio(Date registro_inicio) {
        this.registro_inicio = registro_inicio;
    }

    public void setRegistro_fim(Date registro_fim) {
        this.registro_fim = registro_fim;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }
}
