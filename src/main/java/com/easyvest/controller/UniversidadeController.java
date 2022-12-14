package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Campus;
import com.easyvest.model.Curso;
import com.easyvest.model.Universidade;
import com.easyvest.repository.RepositorioCampus;
import com.easyvest.repository.RepositorioCurso;
import com.easyvest.repository.RepositorioUniversidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/universidade")
public class UniversidadeController {
    @Autowired
    private RepositorioUniversidade repositorioUniversidade;

    @Autowired
    private RepositorioCampus repositorioCampus;

    @Autowired
    private RepositorioCurso repositorioCurso;

    public UniversidadeController(RepositorioUniversidade repositorioUniversidade, RepositorioCampus repositorioCampus, RepositorioCurso repositorioCurso) {
        this.repositorioUniversidade = repositorioUniversidade;
        this.repositorioCampus = repositorioCampus;
        this.repositorioCurso = repositorioCurso;
    }

    /**
     * <p>Lista todas as universidades registradas do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/universidade/listar
     */
    @GetMapping("/listar")
    public List<Universidade> getAllUniversities() {
        return repositorioUniversidade.findAll().stream().sorted((e1, e2) -> e1.getNome().compareTo(e2.getNome())).collect(Collectors.toList());
    }

    /**
     * <p>Lista todos os cursos da universidade cujo ID eh informado no path da requisicao. Os dados sao retornados em formato JSON.</p>
     * Path: /api/universidade/listarCursos/{idUniversidade}
     */
    @GetMapping("/listarCursos/{idUniversidade}")
    public List<Curso> getAllUniversityCourses(@PathVariable long idUniversidade) throws ResourceNotFoundException {
        List<Curso> allCourses = repositorioCurso.findAll();
        Set<Curso> cursos = new HashSet<>();

        for (Curso curso : allCourses) {
            List<Campus> campi = curso.getCampi();

            for (Campus campus : campi) {
                if (campus.getUniversidade().getId() == idUniversidade) {
                    cursos.add(curso);
                }
            }
        }

        return cursos.stream().collect(Collectors.toList());
    }

    /**
     * <p>Lista todos os campus da universidade cujo ID eh informado no path da requisicao. Os dados sao retornados em formato JSON.</p>
     * Path: /api/universidade/listarCampus/{idUniversidade}
     */
    @GetMapping("/listarCampus/{idUniversidade}")
    public List<Campus> getAllUniversityCampus(@PathVariable long idUniversidade) {
        List<Campus> allCampus = repositorioCampus.findAll();
        Set<Campus> campus = new HashSet<>();

        for (Campus campi : allCampus) {
            if (campi.getUniversidade().getId() == idUniversidade) {
                campus.add(campi);
            }
        }
        return campus.stream().sorted((e1, e2) -> e1.getNome().compareTo(e2.getNome())).collect(Collectors.toList());
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
