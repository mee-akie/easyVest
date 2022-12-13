package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Disciplina;
import com.easyvest.model.Lista;
import com.easyvest.model.Tema;
import com.easyvest.repository.RepositorioDisciplina;
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

public class DisciplinaControllerTest {
    private final RepositorioDisciplina repositorioDisciplina = mock(RepositorioDisciplina.class);
    private final DisciplinaController disciplinaController = new DisciplinaController(repositorioDisciplina);

    @Test
    public void testGetAllSubjects() {
        Tema trigonometria = mock(Tema.class);
        Tema geometria = mock(Tema.class);
        Tema porcentagem = mock(Tema.class);
        Tema relevo = mock(Tema.class);
        Tema globalizacao = mock(Tema.class);

        Lista listaExercioTrigonometria = mock(Lista.class);
        Lista listaExercioGeometria = mock(Lista.class);
        Lista listaExercioRelevo = mock(Lista.class);
        Lista listaExercioGlobalizacao = mock(Lista.class);

        List<Tema> temasMatematica = new ArrayList<>(Arrays.asList(trigonometria, geometria, porcentagem));
        List<Tema> temasGeografia = new ArrayList<>(Arrays.asList(relevo, globalizacao));

        List<Lista> listaExercicioMatematica = new ArrayList<>(Arrays.asList(listaExercioTrigonometria, listaExercioGeometria));
        List<Lista> listaExercicioGeografia = new ArrayList<>(Arrays.asList(listaExercioRelevo, listaExercioGlobalizacao));


        Disciplina matematica = new Disciplina(43L, "Matematica", temasMatematica, listaExercicioMatematica);
        Disciplina historia = new Disciplina(1L, "Historia", new ArrayList<>(), new ArrayList<>());
        Disciplina geografia = new Disciplina(54L, "Geografia", temasGeografia, listaExercicioGeografia);

        List<Disciplina> expected = new ArrayList<>();
        expected.add(matematica);
        expected.add(historia);
        expected.add(geografia);

        when(repositorioDisciplina.findAll()).thenReturn(expected);

        List<Disciplina> allSubjects = disciplinaController.getAllSubjects();

        assertThat(allSubjects.size()).isEqualTo(3);
        assertThat(allSubjects.contains(matematica)).isTrue();
        assertThat(allSubjects.contains(historia)).isTrue();
        assertThat(allSubjects.contains(geografia)).isTrue();
    }

    @Test
    public void testGetAllSubjectsReturnEmptyList() {
        when(repositorioDisciplina.findAll()).thenReturn(new ArrayList<>());
        List<Disciplina> allSubjects = disciplinaController.getAllSubjects();

        assertThat(allSubjects.size()).isEqualTo(0);
    }

    @Test
    public void testGetSubjectById() throws ResourceNotFoundException {
        Tema trigonometria = mock(Tema.class);
        Tema geometria = mock(Tema.class);
        Tema porcentagem = mock(Tema.class);
        Lista listaExercioTrigonometria = mock(Lista.class);
        Lista listaExercioGeometria = mock(Lista.class);
        List<Tema> temasMatematica = new ArrayList<>(Arrays.asList(trigonometria, geometria, porcentagem));
        List<Lista> listaExercicioMatematica = new ArrayList<>(Arrays.asList(listaExercioTrigonometria, listaExercioGeometria));


        Disciplina matematica = new Disciplina(43L, "Matematica", temasMatematica, listaExercicioMatematica);

        when(repositorioDisciplina.findById(43L)).thenReturn(Optional.of(matematica));

        ResponseEntity expected = disciplinaController.getSubjectByid(43L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(matematica);
    }

    @Test
    public void testGetSubjectByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            disciplinaController.getSubjectByid(12L);
        });

        String expectedMessage = "Disciplina com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}