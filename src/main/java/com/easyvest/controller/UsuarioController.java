package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.LoginUsuario;
import com.easyvest.model.Usuario;
import com.easyvest.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public UsuarioController(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    /**
     * <p>Retorna uma lista com todos os usuarios existentes no banco de dados.</p>
     * Path: /api/usuario/listar
     *
     * @return Uma lista (JSON) com todos os usuarios existentes no banco de dados.
     */
    @GetMapping("/listar")
    public List<Usuario> getAllUsers() {
        return repositorioUsuario.findAll();
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
    public ResponseEntity<Usuario> getUserByid(@PathVariable long id) throws ResourceNotFoundException {
        Usuario dadosUsuario = repositorioUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));
        return ResponseEntity.ok().body(dadosUsuario);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> getUserByUsernamePassword(@RequestBody LoginUsuario dadosUsuario) {
        List<Usuario> todosUsuarios = repositorioUsuario.findAll();

        String login = dadosUsuario.getLogin();
        String senha = dadosUsuario.getSenha();

        for (Usuario usuario : todosUsuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return ResponseEntity.ok().body(usuario);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * <p>Adiciona um novo usuario ao Banco de Dados. Esse end-point so ira consumir
     * dados no formato JSON.</p>
     * Path: /api/usuario/add
     *
     * @param usuario JSON com os dados do novo usuario.
     */
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Usuario> addUser(@RequestBody Usuario usuario) {
        repositorioUsuario.save(usuario);

        return ResponseEntity.ok(usuario);
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
    public ResponseEntity<Usuario> updateUser(@PathVariable long id, @RequestBody Usuario dadosUsuario) throws ResourceNotFoundException {
        Usuario usuarioAlterado = repositorioUsuario.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario com id '" + id + "' nao foi encontrado"));

        usuarioAlterado.setUsuario_nome(dadosUsuario.getNome());
        usuarioAlterado.setUsuario_login(dadosUsuario.getLogin());
        usuarioAlterado.setUsuario_premium(dadosUsuario.getPremium());
        usuarioAlterado.setUsuario_senha(dadosUsuario.getSenha());

        repositorioUsuario.save(usuarioAlterado);

        return ResponseEntity.ok(usuarioAlterado);
    }

    /**
     * Remove um usuario cadastrado atraves de seu ID fornecido no path da requisicao.
     *
     * @param id ID do usuario que se quer remove.
     */
    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Long> deleteUserById(@PathVariable Long id) {
        repositorioUsuario.deleteById(id);

        return ResponseEntity.ok(id);
    }
}
