package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Disciplina;
import com.easyvest.repository.RepositorioDisciplina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
    @Autowired
    private RepositorioDisciplina repositorioDisciplina;

    /**
     * <p>Lista todas as disciplinas registradas do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/disciplina/listar
     */
    @GetMapping("/listar")
    public List<Disciplina> getAllClasses(HttpServletRequest request) {
        return repositorioDisciplina.findAll();
    }

    /**
     * <p>Informa os dados da disciplina cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/disciplina/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getClassByid(@PathVariable long id) throws ResourceNotFoundException {
        Disciplina dadosDisciplina = repositorioDisciplina.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Disciplina com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosDisciplina);
    }
}
