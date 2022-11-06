package com.easyvest.repository;

import com.easyvest.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioLista extends JpaRepository<Lista, Long> {
}
