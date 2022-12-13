package com.easyvest.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long usuario_id;

    @Column(nullable = false, unique = true, length = 30)
    private String usuario_login;

    @Column(nullable = false, length = 30)
    private String usuario_nome;

    @Column(nullable = false, length = 200)
    private String usuario_senha;

    @Column(nullable = false)
    private boolean usuario_premium;

    public Usuario() {
    }

    public Long getId() {
        return usuario_id;
    }

    public String getLogin() {
        return usuario_login;
    }

    public String getNome() {
        return usuario_nome;
    }

    public String getSenha() {
        return usuario_senha;
    }

    public Boolean getPremium() {
        return usuario_premium;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }

    public void setUsuario_nome(String usuario_nome) {
        this.usuario_nome = usuario_nome;
    }

    public void setUsuario_senha(String usuario_senha) {
        this.usuario_senha = usuario_senha;
    }

    public void setUsuario_premium(boolean usuario_premium) {
        this.usuario_premium = usuario_premium;
    }
}
