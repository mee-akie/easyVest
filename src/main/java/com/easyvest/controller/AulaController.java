package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Aula;
import com.easyvest.repository.RepositorioAula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/aula")
public class AulaController {
    @Autowired
    private RepositorioAula repositorioAula;

    /**
     * <p>Lista todas as aulas registradas do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/aula/listar
     */
    @GetMapping("/listar")
    public List<Aula> getAllClasses(HttpServletRequest request) {
        return repositorioAula.findAll();
    }

    /**
     * <p>Informa os dados da aula cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/aula/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Aula> getClassByid(@PathVariable long id) throws ResourceNotFoundException {
        Aula dadosAula = repositorioAula.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aula com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosAula);
    }
}
