package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Exercicio;
import com.easyvest.repository.RepositorioExercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exercicio")
public class ExercicioController {
    @Autowired
    private RepositorioExercicio repositorioExercicio;

    /**
     * <p>Lista todos os exercicios registrados do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/exercicio/listar
     */
    @GetMapping("/listar")
    public List<Exercicio> getAllExercises() {
        return repositorioExercicio.findAll();
    }

    /**
     * <p>Informa os dados do exercicio cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/exercicio/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> getExerciseByid(@PathVariable long id) throws ResourceNotFoundException {
        Exercicio dadosExercicio = repositorioExercicio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exercicio com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosExercicio);
    }
}
