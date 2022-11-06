package com.easyvest.repository;

import com.easyvest.model.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCampus extends JpaRepository<Campus, Long> {
}
