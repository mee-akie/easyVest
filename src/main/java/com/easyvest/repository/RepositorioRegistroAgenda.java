package com.easyvest.repository;

import com.easyvest.model.RegistroAgenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioRegistroAgenda extends JpaRepository<RegistroAgenda, Long> {

    @Query(value = "SELECT * FROM registro_agenda where usuario_id = :usuario_id", nativeQuery = true)
    List<RegistroAgenda> findByUser(Long usuario_id);
}
