package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Tema;
import com.easyvest.repository.RepositorioTema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tema")
public class TemaController {
    @Autowired
    private RepositorioTema repositorioTema;

    public TemaController(RepositorioTema repositorioTema) {
        this.repositorioTema = repositorioTema;
    }

    /**
     * <p>Lista todos os temas registrados do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/tema/listar
     */
    @GetMapping("/listar")
    public List<Tema> getAllThemes() {
        return repositorioTema.findAll();
    }

    /**
     * <p>Informa os dados do tema cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/tema/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tema> getThemeByid(@PathVariable long id) throws ResourceNotFoundException {
        Tema dadosTema = repositorioTema.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tema com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosTema);
    }
}
