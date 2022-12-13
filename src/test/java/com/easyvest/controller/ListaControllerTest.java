package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Curso;
import com.easyvest.model.Disciplina;
import com.easyvest.model.Lista;
import com.easyvest.repository.RepositorioLista;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListaControllerTest {
    private final RepositorioLista repositorioLista = mock(RepositorioLista.class);
    private final ListaController listaController = new ListaController(repositorioLista);

    @Test
    public void testGetAllExerciseLists() {
        Curso sistemasInformacao = mock(Curso.class);
        Curso engenhariaCivil = mock(Curso.class);
        Curso bachareladoMatematica = mock(Curso.class);

        ArrayList<Curso> cursosComCalculoI = new ArrayList<>(Arrays.asList(sistemasInformacao, engenhariaCivil, bachareladoMatematica));
        ArrayList<Curso> cursosComCalculoIII = new ArrayList<>(Arrays.asList(engenhariaCivil, bachareladoMatematica));
        Disciplina matematica = mock(Disciplina.class);

        Lista listaCalculoI = new Lista(8L, "Calculo I", matematica, cursosComCalculoI);
        Lista listaCalculoII = new Lista(19L, "Calculo II", matematica, cursosComCalculoIII);

        List<Lista> expected = new ArrayList<>();
        expected.add(listaCalculoI);
        expected.add(listaCalculoII);

        when(repositorioLista.findAll()).thenReturn(expected);

        List<Lista> allExerciseLists = listaController.getAllExerciseLists();

        assertThat(allExerciseLists.size()).isEqualTo(2);
        assertThat(allExerciseLists.contains(listaCalculoI)).isTrue();
        assertThat(allExerciseLists.contains(listaCalculoII)).isTrue();
    }

    @Test
    public void testGetAllExerciseListsReturnEmptyList() {
        when(repositorioLista.findAll()).thenReturn(new ArrayList<>());
        List<Lista> allExerciseLists = listaController.getAllExerciseLists();

        assertThat(allExerciseLists.size()).isEqualTo(0);
    }

    @Test
    public void testGetExerciseListById() throws ResourceNotFoundException {
        Curso sistemasInformacao = mock(Curso.class);
        Curso engenhariaCivil = mock(Curso.class);
        Curso bachareladoMatematica = mock(Curso.class);
        ArrayList<Curso> cursosComCalculoI = new ArrayList<>(Arrays.asList(sistemasInformacao, engenhariaCivil, bachareladoMatematica));
        Disciplina matematica = mock(Disciplina.class);

        Lista listaCalculoI = new Lista(8L, "Calculo I", matematica, cursosComCalculoI);

        when(repositorioLista.findById(8L)).thenReturn(Optional.of(listaCalculoI));

        ResponseEntity expected = listaController.getExerciseListByid(8L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(listaCalculoI);
    }

    @Test
    public void testGetExerciseListByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            listaController.getExerciseListByid(12L);
        });

        String expectedMessage = "Lista com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}