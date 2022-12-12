package com.easyvest.repository;

import com.easyvest.model.RegistroAgenda;
import com.easyvest.model.RegistroAgendaId;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioRegistroAgenda extends JpaRepository<RegistroAgenda, RegistroAgendaId>{

    @Query(value = "SELECT * FROM registro_agenda where usuario_id = :usuario_id", nativeQuery = true)
    List<RegistroAgenda> findByUser(Long usuario_id);
}
