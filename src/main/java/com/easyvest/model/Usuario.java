package com.easyvest.model;

import com.sun.istack.NotNull;

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

    public void setLogin(@NotNull String login) {
        this.usuario_login = login;
    }

    public void setNome(@NotNull String nome) {
        this.usuario_nome = nome;
    }

    public void setSenha(@NotNull String senha) {
        this.usuario_senha = senha;
    }

    public void setPremium(@NotNull boolean premium) {
        this.usuario_premium = premium;
    }
}
