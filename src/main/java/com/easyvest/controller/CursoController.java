package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Curso;
import com.easyvest.repository.RepositorioCampus;
import com.easyvest.repository.RepositorioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private RepositorioCurso repositorioCurso;

    @Autowired
    private RepositorioCampus repositorioCampus;

    /**
     * <p>Lista todos os cursos registrados do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/curso/listar
     */
    @GetMapping("/listar")
    public List<Curso> getAllCourses(HttpServletRequest request) {
        return repositorioCurso.findAll();
    }

    /**
     * <p>Informa os dados do curso cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/curso/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCourseByid(@PathVariable long id) throws ResourceNotFoundException {
        Curso dadosCurso = repositorioCurso.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso com id '" + id + "' nao foi encontrado"));

        return ResponseEntity.ok().body(dadosCurso);
    }
}
