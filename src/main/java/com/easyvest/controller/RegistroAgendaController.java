package com.easyvest.controller;

import java.util.List;

import com.easyvest.model.RegistroAgendaId;
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

    @GetMapping("/listar/{idUsuario}")
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
        RegistroAgendaId registroAgendaId = new RegistroAgendaId(registroAgenda.getUsuario_id(), registroAgenda.getRegistro_data());

        RegistroAgenda patchedRegistroAgenda = repositorioRegistroAgenda.findById(registroAgendaId)
        .orElseThrow(() -> new ResourceNotFoundException("Registro com id '" + registroAgendaId + "' nao foi encontrado"));

        patchedRegistroAgenda.setRegistro_nome(registroAgenda.getRegistro_nome());
        patchedRegistroAgenda.setRegistro_inicio(registroAgenda.getRegistro_inicio());
        patchedRegistroAgenda.setRegistro_fim(registroAgenda.getRegistro_fim());
        patchedRegistroAgenda.setRegistro_data(registroAgenda.getRegistro_data());
        patchedRegistroAgenda.setUsuario_id(registroAgenda.getUsuario_id());

        repositorioRegistroAgenda.save(patchedRegistroAgenda);
        
        return ResponseEntity.ok(patchedRegistroAgenda);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<RegistroAgenda> deleteRegister(@RequestBody RegistroAgenda registroAgenda){
        repositorioRegistroAgenda.delete(registroAgenda);

        return ResponseEntity.ok().body(registroAgenda);
    }
}
