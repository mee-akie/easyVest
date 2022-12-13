package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Lista;
import com.easyvest.repository.RepositorioLista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/lista")
public class ListaController {
    @Autowired
    private RepositorioLista repositorioLista;

    public ListaController(RepositorioLista repositorioLista) {
        this.repositorioLista = repositorioLista;
    }

    /**
     * <p>Lista todas as listas de exercicios registradas do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/aula/listar
     */
    @GetMapping("/listar")
    public List<Lista> getAllLists() {
        return repositorioLista.findAll();
    }

    /**
     * <p>Informa os dados da lista de exercicio cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/aula/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Lista> getExerciseListByid(@PathVariable long id) throws ResourceNotFoundException {
        Lista dadosLista = repositorioLista.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lista com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosLista);
    }
}
