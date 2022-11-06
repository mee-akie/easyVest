package com.easyvest.repository;

import com.easyvest.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAula extends JpaRepository<Aula, Long> {
}
