package com.easyvest.repository;

import com.easyvest.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioExercicio extends JpaRepository<Exercicio, Long> {
}
