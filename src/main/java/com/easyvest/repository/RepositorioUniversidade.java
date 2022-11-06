package com.easyvest.repository;

import com.easyvest.model.Universidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUniversidade extends JpaRepository<Universidade, Long> {
}
