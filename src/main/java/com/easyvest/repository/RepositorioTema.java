package com.easyvest.repository;


import com.easyvest.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTema extends JpaRepository<Tema, Long> {
}
