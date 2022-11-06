package com.easyvest.repository;

import com.easyvest.model.Vestibular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVestibular extends JpaRepository<Vestibular, Long> {
}
