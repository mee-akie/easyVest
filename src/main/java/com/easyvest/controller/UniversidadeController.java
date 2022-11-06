package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Universidade;
import com.easyvest.repository.RepositorioUniversidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/universidade")
public class UniversidadeController {
    @Autowired
    private RepositorioUniversidade repositorioUniversidade;

    /**
     * <p>Lista todas as universidades registradas do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/universidade/listar
     */
    @GetMapping("/listar")
    public List<Universidade> getAllUniversities(HttpServletRequest request) {
        return repositorioUniversidade.findAll();
    }

    /**
     * <p>Informa os dados da universidade cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/universidade/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Universidade> getUniversityByid(@PathVariable long id) throws ResourceNotFoundException {
        Universidade dadosUniversidade = repositorioUniversidade.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Universidade com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosUniversidade);
    }
}
