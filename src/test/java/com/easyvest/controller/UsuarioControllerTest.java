package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Usuario;
import com.easyvest.repository.RepositorioUsuario;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class UsuarioControllerTest {

    private final RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
    private final UsuarioController usuarioController = new UsuarioController(repositorioUsuario);

    @Test
    public void testGetAllUsers() {
        Usuario maria = new Usuario(1L, "maria.fernanda", "Maria Fernanda", "maria123", true);
        Usuario joao = new Usuario(2L, "joao.pedro", "Joao Pedro", "abcdef", false);
        Usuario julia = new Usuario(3L, "julia.silva", "Julia Silva", "strongpassword", true);

        List<Usuario> expected = new ArrayList<>();
        expected.add(maria);
        expected.add(joao);
        expected.add(julia);

        when(repositorioUsuario.findAll()).thenReturn(expected);

        List<Usuario> allUsers = usuarioController.getAllUsers();

        assertThat(allUsers.size()).isEqualTo(3);
        assertThat(allUsers.contains(maria)).isTrue();
        assertThat(allUsers.contains(joao)).isTrue();
        assertThat(allUsers.contains(julia)).isTrue();
    }

    @Test
    public void testGetAllUsersReturnEmptyList() {
        when(repositorioUsuario.findAll()).thenReturn(new ArrayList<>());
        List<Usuario> allCampus = usuarioController.getAllUsers();

        assertThat(allCampus.size()).isEqualTo(0);
    }

    @Test
    public void testGetUserById() throws ResourceNotFoundException {
        Usuario maria = new Usuario(1L, "maria.fernanda", "Maria Fernanda", "maria123", true);

        when(repositorioUsuario.findById(1L)).thenReturn(Optional.of(maria));

        ResponseEntity expected = usuarioController.getUserByid(1L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(maria);
    }

    @Test
    public void testGetUserByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            usuarioController.getUserByid(12L);
        });

        String expectedMessage = "Usuario com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }

    @Test
    public void testAddUser() {
        Usuario maria = new Usuario(1L, "maria.fernanda", "Maria Fernanda", "maria123", true);

        when(repositorioUsuario.save(maria)).thenReturn(maria);

        ResponseEntity expected = usuarioController.addUser(maria);
        verify(repositorioUsuario).save(maria);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(maria);
    }

    @Test
    public void testUpdateUser() throws ResourceNotFoundException {
        Usuario maria = new Usuario(1L, "maria.fernanda", "Maria Fernanda", "maria123", true);
        Usuario novosDadosMaria = mock(Usuario.class);

        when(repositorioUsuario.findById(1L)).thenReturn(Optional.of(maria));
        when(novosDadosMaria.getNome()).thenReturn("Maria Fernanda Silva");
        when(novosDadosMaria.getLogin()).thenReturn("mari123");

        ResponseEntity responseEntity = usuarioController.updateUser(1L, novosDadosMaria);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        Usuario expected = (Usuario) responseEntity.getBody();
        assertThat(expected.getNome()).isEqualTo("Maria Fernanda Silva");
        assertThat(expected.getLogin()).isEqualTo("mari123");
    }

    @Test
    public void testDeleteUserById() {
        ResponseEntity expected = usuarioController.deleteUserById(2L);
        verify(repositorioUsuario).deleteById(2L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(2L);
    }
}