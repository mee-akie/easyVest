package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Campus;
import com.easyvest.repository.RepositorioCampus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campus")
public class CampusController {

    @Autowired
    private RepositorioCampus repositorioCampus;

    public CampusController(RepositorioCampus repositorioCampus) {
        this.repositorioCampus = repositorioCampus;
    }

    /**
     * <p>Lista todos os campus registrados do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/campus/listar
     */
    @GetMapping("/listar")
    public List<Campus> getAllCampus() {
        return repositorioCampus.findAll();
    }

    /**
     * <p>Informa os dados do campus cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/campus/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Campus> getCampusByid(@PathVariable long id) throws ResourceNotFoundException {
        Campus dadosCampus = repositorioCampus.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campus com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosCampus);
    }
}
