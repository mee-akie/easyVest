package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Vestibular;
import com.easyvest.repository.RepositorioVestibular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/vestibular")
public class VestibularController {
    @Autowired
    private RepositorioVestibular repositorioVestibular;

    /**
     * <p>Lista todos os vestibulares registrados do banco de dados e informa os dados
     * de cada um. Os dados sao retornados em formato JSON.</p>
     * Path: /api/vestibular/listar
     */
    @GetMapping("/listar")
    public List<Vestibular> getAllExam(HttpServletRequest request) {
        return repositorioVestibular.findAll();
    }

    /**
     * <p>Informa os dados do vestibular cujo ID eh dado no path da requisicao.
     * Os dados sao retornados em formato JSON.</p>
     * Path: /api/vestibular/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vestibular> getExamByid(@PathVariable long id) throws ResourceNotFoundException {
        Vestibular dadosVestibular = repositorioVestibular.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vestibular com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosVestibular);
    }
}
