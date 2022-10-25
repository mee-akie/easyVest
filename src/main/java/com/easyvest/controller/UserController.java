package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.User;
import com.easyvest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * <p>Retorna uma lista com todos os usuarios existentes no banco de dados.</p>
     * Path: /api/usuario/listar
     *
     * @return Uma lista (JSON) com todos os usuarios existentes no banco de dados.
     */
    @GetMapping("/listar")
    public List<User> getAllUsers(HttpServletRequest request) {
        return userRepository.findAll();
    }

    /**
     * <p>Retorna os dados de um usuario com base no ID fornecido na requisicao.</p>
     * Path: /api/usuario/{id}
     *
     * @param id ID do usuario buscado.
     * @return Os dados de um usuario (JSON).
     * @throws ResourceNotFoundException
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserByid(@PathVariable long id) throws ResourceNotFoundException {
        User targetUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(targetUser);
    }

    /**
     * <p>Adiciona um novo usuario ao Banco de Dados. Esse end-point so ira consumir
     * dados no formato JSON.</p>
     * Path: /api/usuario/add
     *
     * @param usuario JSON com os dados do novo usuario.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User newUser) {
        userRepository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    /**
     * <p>Altera os dados do usuario, cujo ID eh enviado na requisicao.</p>
     * Path: /api/usuario/alterarDados/{id}
     *
     * @param id           Id que identifica o usuario no banco de dados.
     * @param dadosUsuario JSON com os dados do usuario que devem ser alterados.
     * @throws ResourceNotFoundException
     */
    @PutMapping(path = "/alterarDados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updatedUser) throws ResourceNotFoundException {
        User targetUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));

        targetUser.setName(updatedUser.getName());
        targetUser.setEmail(updatedUser.getEmail());

        userRepository.save(targetUser);

        return ResponseEntity.ok(targetUser);
    }

    /**
     * Remove um usuario cadastrado atraves de seu ID fornecido no path da requisicao.
     *
     * @param id ID do usuario que se quer remove.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
