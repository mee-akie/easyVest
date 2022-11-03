package com.easyvest.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "vestibulares")
public class Vestibular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long vestibular_id;

    @Column(nullable = false, length = 20)
    private String vestibular_nome;

    @Column(nullable = false)
    private Date vestibular_data;

    @Column(nullable = false, length = 100)
    private String vestibular_link;

    @ManyToMany(mappedBy = "vestibulares")
    private List<Universidade> universidades;

    public Vestibular() {}

    public Date getData() {
        return vestibular_data;
    }

    public Long getId() {
        return vestibular_id;
    }

    public String getLink() {
        return vestibular_link;
    }

    public String getNome() {
        return vestibular_nome;
    }

    public List<Universidade> getUniversidades() {
        return universidades;
    }

    public void setData(Date vestibular_data) {
        this.vestibular_data = vestibular_data;
    }

    public void setLink(String vestibular_link) {
        this.vestibular_link = vestibular_link;
    }

    public void setNome(String vestibular_nome) {
        this.vestibular_nome = vestibular_nome;
    }
}
