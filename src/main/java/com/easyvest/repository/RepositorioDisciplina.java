package com.easyvest.repository;

import com.easyvest.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDisciplina extends JpaRepository<Disciplina, Long> {
}
