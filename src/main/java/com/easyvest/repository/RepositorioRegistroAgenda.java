package com.easyvest.repository;

import com.easyvest.model.RegistroAgenda;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegistroAgenda extends JpaRepository<RegistroAgenda, Long>{

    List<RegistroAgenda> findByUser(Long usuario_id);
}
