package com.easyvest.model;

import java.io.Serializable;
import java.sql.Date;

public class RegistroAgendaId implements Serializable {
    private Long usuario_id;
    private Date registro_data;

    // default constructor. Don't delete
    public RegistroAgendaId() {
    }

    public RegistroAgendaId(Long usuario_id, Date registro_data) {
        this.usuario_id = usuario_id;
        this.registro_data = registro_data;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public Date getRegistro_data() {
        return registro_data;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setRegistro_data(Date registro_data) {
        this.registro_data = registro_data;
    }
}
