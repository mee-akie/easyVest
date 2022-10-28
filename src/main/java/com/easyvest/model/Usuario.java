package com.easyvest.model;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
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
    private Boolean usuario_premium;

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

    public Boolean getPrermium() {
        return usuario_premium;
    }

    public void setLogin(String login) {
        this.usuario_login = login;
    }

    public void setNome(String nome) {
        this.usuario_nome = nome;
    }

    public void setSenha(String senha) {
        this.usuario_senha = senha;
    }

    public void setPremium(Boolean premium){
        this.usuario_premium = premium;
    }
}

