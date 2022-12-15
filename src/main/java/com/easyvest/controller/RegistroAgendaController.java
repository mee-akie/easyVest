package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.RegistroAgenda;
import com.easyvest.repository.RepositorioRegistroAgenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registro")

public class RegistroAgendaController {
    @Autowired
    private RepositorioRegistroAgenda repositorioRegistroAgenda;

    @GetMapping("/listar/{idUsuario}")
    public List<RegistroAgenda> getUserRegisters(@PathVariable long idUsuario){
        List<RegistroAgenda> userRegisters = repositorioRegistroAgenda.findByUser(idUsuario);

        return userRegisters;
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistroAgenda> addRegister(@RequestBody RegistroAgenda registroAgenda) {
        repositorioRegistroAgenda.save(registroAgenda);

        return ResponseEntity.ok(registroAgenda);
    }

    @PutMapping(path = "/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistroAgenda> updateRegister(@PathVariable long id, @RequestBody RegistroAgenda registroAgenda) throws ResourceNotFoundException {
        RegistroAgenda updateRegistroAgenda = repositorioRegistroAgenda.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro com id '" + id + "' nao foi encontrado"));

        updateRegistroAgenda.setRegistro_nome(registroAgenda.getRegistro_nome());
        updateRegistroAgenda.setRegistro_inicio(registroAgenda.getRegistro_inicio());
        updateRegistroAgenda.setRegistro_fim(registroAgenda.getRegistro_fim());
        updateRegistroAgenda.setUsuario(registroAgenda.getUsuario());

        repositorioRegistroAgenda.save(updateRegistroAgenda);

        return ResponseEntity.ok(updateRegistroAgenda);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<RegistroAgenda> deleteRegister(@RequestBody RegistroAgenda registroAgenda){
        repositorioRegistroAgenda.delete(registroAgenda);

        return ResponseEntity.ok().body(registroAgenda);
    }
}
