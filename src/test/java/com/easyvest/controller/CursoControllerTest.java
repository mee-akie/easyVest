package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Campus;
import com.easyvest.model.Curso;
import com.easyvest.repository.RepositorioCampus;
import com.easyvest.repository.RepositorioCurso;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CursoControllerTest {
    private final RepositorioCurso repositorioCurso = mock(RepositorioCurso.class);
    private final RepositorioCampus repositorioCampus = mock(RepositorioCampus.class);
    private final CursoController cursoController = new CursoController(repositorioCurso, repositorioCampus);

    @Test
    public void testGetAllCourses() {
        Campus uspBauru = mock(Campus.class);
        Campus uspLeste = mock(Campus.class);
        Campus unespBauru = mock(Campus.class);
        Campus unespAraraquara = mock(Campus.class);
        ArrayList<Campus> campusNutricao = new ArrayList<>(Arrays.asList(uspBauru, uspLeste, unespBauru));
        ArrayList<Campus> campusSistemasInformacao = new ArrayList<>(Arrays.asList(uspBauru, uspLeste));
        ArrayList<Campus> campusDireito = new ArrayList<>(Arrays.asList(uspBauru, uspLeste, unespAraraquara));
        ArrayList<Campus> campusEngenhariaCivil = new ArrayList<>(Arrays.asList(uspBauru, unespAraraquara));

        Curso nutricao = new Curso(1L, "Nutricao", campusNutricao);
        Curso sistemasInformacao = new Curso(12L, "Sistemas de Informacao", campusSistemasInformacao);
        Curso direito = new Curso(3L, "Direito", campusDireito);
        Curso engenhariaCivil = new Curso(31L, "Engenharia Civil", campusEngenhariaCivil);

        List<Curso> expected = new ArrayList<>();
        expected.add(nutricao);
        expected.add(sistemasInformacao);
        expected.add(direito);
        expected.add(engenhariaCivil);

        when(repositorioCurso.findAll()).thenReturn(expected);

        List<Curso> allCourses = cursoController.getAllCourses();

        assertThat(allCourses.size()).isEqualTo(4);
        assertThat(allCourses.contains(nutricao)).isTrue();
        assertThat(allCourses.contains(sistemasInformacao)).isTrue();
        assertThat(allCourses.contains(direito)).isTrue();
        assertThat(allCourses.contains(engenhariaCivil)).isTrue();
    }

    @Test
    public void testGetAllCoursesReturnEmptyList() {
        when(repositorioCurso.findAll()).thenReturn(new ArrayList<>());
        List<Curso> allCourses = cursoController.getAllCourses();

        assertThat(allCourses.size()).isEqualTo(0);
    }

    @Test
    public void testGetCourseById() throws ResourceNotFoundException {
        Campus uspBauru = mock(Campus.class);
        Campus uspLeste = mock(Campus.class);
        Campus unespBauru = mock(Campus.class);
        ArrayList<Campus> campusNutricao = new ArrayList<>(Arrays.asList(uspBauru, uspLeste, unespBauru));

        Curso nutricao = new Curso(1L, "Nutricao", campusNutricao);

        when(repositorioCurso.findById(12L)).thenReturn(Optional.of(nutricao));

        ResponseEntity expected = cursoController.getCourseByid(12L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(nutricao);
    }

    @Test
    public void testGetCourseByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            cursoController.getCourseByid(12L);
        });

        String expectedMessage = "Curso com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }

}