package com.easyvest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.RegistroAgenda;
import com.easyvest.repository.RepositorioRegistroAgenda;

@RestController
@RequestMapping("/api/registro")

public class RegistroAgendaController {
    @Autowired
    private RepositorioRegistroAgenda repositorioRegistroAgenda;

    @GetMapping("/listar/{id}")
    public List<RegistroAgenda> getUserRegisters(@PathVariable long idUsuario){
        List<RegistroAgenda> userRegisters = repositorioRegistroAgenda.findByUser(idUsuario);

        return userRegisters;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistroAgenda> addRegister(@RequestBody RegistroAgenda registroAgenda){
        repositorioRegistroAgenda.save(registroAgenda);

        return ResponseEntity.ok(registroAgenda);
    }

    @PatchMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistroAgenda> updateRegister(@RequestBody RegistroAgenda registroAgenda) throws ResourceNotFoundException{
        RegistroAgenda patchedRegistroAgenda = repositorioRegistroAgenda.findById(registroAgenda.getId())
        .orElseThrow(() -> new ResourceNotFoundException("Registro com id '" + registroAgenda.getId() + "' nao foi encontrado"));

        patchedRegistroAgenda.setNome(registroAgenda.getNome());
        patchedRegistroAgenda.setInicio(registroAgenda.getInicio());
        patchedRegistroAgenda.setFim(registroAgenda.getFim());

        repositorioRegistroAgenda.save(patchedRegistroAgenda);
        
        return ResponseEntity.ok(patchedRegistroAgenda);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Long> deleteRegister(@PathVariable Long id){
        repositorioRegistroAgenda.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
