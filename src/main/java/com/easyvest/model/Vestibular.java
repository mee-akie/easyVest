package com.easyvest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "vestibulares")
public class Vestibular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long vestibular_id;

    @Column(nullable = false, length = 100)
    private String vestibular_nome;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date vestibular_data;

    @Column(nullable = false, length = 100)
    private String vestibular_link;

    @ManyToMany(mappedBy = "vestibulares")
    @JsonBackReference
    private List<Universidade> universidades;

    // default constructor. Don't delete
    public Vestibular() {
    }

    public Vestibular(Long vestibular_id, String vestibular_nome, Date vestibular_data, String vestibular_link, List<Universidade> universidades) {
        this.vestibular_id = vestibular_id;
        this.vestibular_nome = vestibular_nome;
        this.vestibular_data = vestibular_data;
        this.vestibular_link = vestibular_link;
        this.universidades = universidades;
    }

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
