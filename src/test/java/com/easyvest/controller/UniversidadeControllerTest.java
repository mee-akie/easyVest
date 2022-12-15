package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Campus;
import com.easyvest.model.Curso;
import com.easyvest.model.Universidade;
import com.easyvest.model.Vestibular;
import com.easyvest.repository.RepositorioCampus;
import com.easyvest.repository.RepositorioCurso;
import com.easyvest.repository.RepositorioUniversidade;
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

public class UniversidadeControllerTest {
    private final RepositorioUniversidade repositorioUniversidade = mock(RepositorioUniversidade.class);
    private final RepositorioCampus repositorioCampus = mock(RepositorioCampus.class);
    private final RepositorioCurso repositorioCurso = mock(RepositorioCurso.class);
    private final UniversidadeController universidadeController = new UniversidadeController(repositorioUniversidade, repositorioCampus, repositorioCurso);

    @Test
    public void testGetAllUniversities() {
        Vestibular fuvest = mock(Vestibular.class);
        Vestibular vunesp = mock(Vestibular.class);
        Vestibular sisu = mock(Vestibular.class);

        ArrayList<Vestibular> vestibularesUsp = new ArrayList<>(Arrays.asList(fuvest, sisu));
        ArrayList<Vestibular> vestibularesUnesp = new ArrayList<>(Arrays.asList(vunesp));

        Universidade usp = new Universidade(3L, "Universidade de Sao Paulo", vestibularesUsp);
        Universidade unesp = new Universidade(4L, "Universidade de Estadual Paulista", vestibularesUnesp);

        List<Universidade> expected = new ArrayList<>();
        expected.add(usp);
        expected.add(unesp);

        when(repositorioUniversidade.findAll()).thenReturn(expected);

        List<Universidade> allUniversities = universidadeController.getAllUniversities();

        assertThat(allUniversities.size()).isEqualTo(2);
        assertThat(allUniversities.contains(usp)).isTrue();
        assertThat(allUniversities.contains(unesp)).isTrue();
    }

    @Test
    public void testGetAllUniversitiesReturnEmptyList() {
        when(repositorioCampus.findAll()).thenReturn(new ArrayList<>());
        List<Universidade> allUniversities = universidadeController.getAllUniversities();

        assertThat(allUniversities.size()).isEqualTo(0);
    }

    @Test
    public void testAllUniversityCourses() throws ResourceNotFoundException {
        Vestibular fuvest = mock(Vestibular.class);
        Vestibular vunesp = mock(Vestibular.class);
        Vestibular sisu = mock(Vestibular.class);

        ArrayList<Vestibular> vestibularesUsp = new ArrayList<>(Arrays.asList(fuvest, sisu));
        ArrayList<Vestibular> vestibularesUnesp = new ArrayList<>(Arrays.asList(vunesp));

        Universidade usp = new Universidade(3L, "Universidade de Sao Paulo", vestibularesUsp);
        Universidade unesp = new Universidade(4L, "Universidade de Estadual Paulista", vestibularesUnesp);

        Curso nutricao = mock(Curso.class);
        Curso sistemasInformacao = mock(Curso.class);
        Curso engenhariaCivil = mock(Curso.class);
        Curso engenhariaProducao = mock(Curso.class);

        Campus uspBauru = mock(Campus.class);
        Campus uspLeste = mock(Campus.class);
        Campus unespLimeira = mock(Campus.class);
        Campus unespAraraquara = mock(Campus.class);

        ArrayList<Curso> allCourses = new ArrayList<>(Arrays.asList(nutricao, sistemasInformacao, engenhariaCivil, engenhariaProducao));
        ArrayList<Campus> cursosNutricao = new ArrayList<>(Arrays.asList(uspBauru, unespLimeira));
        ArrayList<Campus> cursosEngenhariaCivil = new ArrayList<>(Arrays.asList(uspBauru));

        when(repositorioCurso.findAll()).thenReturn(allCourses);
        when(nutricao.getCampi()).thenReturn(cursosNutricao);
        when(engenhariaCivil.getCampi()).thenReturn(cursosEngenhariaCivil);
        when(uspBauru.getUniversidade()).thenReturn(usp);
        when(uspLeste.getUniversidade()).thenReturn(usp);
        when(unespLimeira.getUniversidade()).thenReturn(unesp);
        when(unespAraraquara.getUniversidade()).thenReturn(unesp);

        List<Curso> allUspCourses = universidadeController.getAllUniversityCourses(3L);

        assertThat(allUspCourses.size()).isEqualTo(2);
        assertThat(allUspCourses.contains(nutricao)).isTrue();
        assertThat(allUspCourses.contains(engenhariaCivil)).isTrue();
    }

    @Test
    public void testAllUniversityCoursesReturnEmptyList() throws ResourceNotFoundException {
        Vestibular fuvest = mock(Vestibular.class);
        Vestibular vunesp = mock(Vestibular.class);
        Vestibular sisu = mock(Vestibular.class);

        ArrayList<Vestibular> vestibularesUsp = new ArrayList<>(Arrays.asList(fuvest, sisu));
        ArrayList<Vestibular> vestibularesUnesp = new ArrayList<>(Arrays.asList(vunesp));

        Universidade usp = new Universidade(3L, "Universidade de Sao Paulo", vestibularesUsp);
        Universidade unesp = new Universidade(4L, "Universidade de Estadual Paulista", vestibularesUnesp);

        Curso nutricao = mock(Curso.class);
        Curso sistemasInformacao = mock(Curso.class);
        Curso engenhariaCivil = mock(Curso.class);
        Curso engenhariaProducao = mock(Curso.class);

        Campus uspBauru = mock(Campus.class);
        Campus uspLeste = mock(Campus.class);
        Campus unespLimeira = mock(Campus.class);
        Campus unespAraraquara = mock(Campus.class);

        ArrayList<Curso> allCourses = new ArrayList<>(Arrays.asList(nutricao, sistemasInformacao, engenhariaCivil, engenhariaProducao));
        ArrayList<Campus> cursosNutricao = new ArrayList<>(Arrays.asList(uspBauru, unespLimeira));
        ArrayList<Campus> cursosEngenhariaCivil = new ArrayList<>(Arrays.asList(uspBauru));

        when(repositorioCurso.findAll()).thenReturn(allCourses);
        when(nutricao.getCampi()).thenReturn(cursosNutricao);
        when(engenhariaCivil.getCampi()).thenReturn(cursosEngenhariaCivil);
        when(uspBauru.getUniversidade()).thenReturn(usp);
        when(uspLeste.getUniversidade()).thenReturn(usp);
        when(unespLimeira.getUniversidade()).thenReturn(unesp);
        when(unespAraraquara.getUniversidade()).thenReturn(unesp);

        List<Curso> allUspCourses = universidadeController.getAllUniversityCourses(5L);

        assertThat(allUspCourses.size()).isEqualTo(0);
    }

    @Test
    public void testAllUniversityCampus() {
        Vestibular fuvest = mock(Vestibular.class);
        Vestibular vunesp = mock(Vestibular.class);
        Vestibular sisu = mock(Vestibular.class);

        ArrayList<Vestibular> vestibularesUsp = new ArrayList<>(Arrays.asList(fuvest, sisu));
        ArrayList<Vestibular> vestibularesUnesp = new ArrayList<>(Arrays.asList(vunesp));

        Universidade usp = new Universidade(3L, "Universidade de Sao Paulo", vestibularesUsp);
        Universidade unesp = new Universidade(4L, "Universidade de Estadual Paulista", vestibularesUnesp);

        Campus uspBauru = mock(Campus.class);
        Campus uspLeste = mock(Campus.class);
        Campus unespLimeira = mock(Campus.class);
        Campus unespAraraquara = mock(Campus.class);

        ArrayList<Campus> allCampus = new ArrayList<>(Arrays.asList(uspBauru, uspLeste, unespLimeira, unespAraraquara));

        when(repositorioCampus.findAll()).thenReturn(allCampus);
        when(uspBauru.getUniversidade()).thenReturn(usp);
        when(uspLeste.getUniversidade()).thenReturn(usp);
        when(unespLimeira.getUniversidade()).thenReturn(unesp);
        when(unespAraraquara.getUniversidade()).thenReturn(unesp);
        when(uspBauru.getNome()).thenReturn(usp.getNome());
        when(uspLeste.getNome()).thenReturn(usp.getNome());
        when(unespLimeira.getNome()).thenReturn(unesp.getNome());
        when(unespAraraquara.getNome()).thenReturn(unesp.getNome());

        List<Campus> allUspCampus = universidadeController.getAllUniversityCampus(3L);

        assertThat(allUspCampus.size()).isEqualTo(2);
        assertThat(allUspCampus.contains(uspBauru)).isTrue();
        assertThat(allUspCampus.contains(uspLeste)).isTrue();
    }

    @Test
    public void testAllUniversityCampusReturnEmptyList() {
        Vestibular fuvest = mock(Vestibular.class);
        Vestibular vunesp = mock(Vestibular.class);
        Vestibular sisu = mock(Vestibular.class);

        ArrayList<Vestibular> vestibularesUsp = new ArrayList<>(Arrays.asList(fuvest, sisu));
        ArrayList<Vestibular> vestibularesUnesp = new ArrayList<>(Arrays.asList(vunesp));

        Universidade usp = new Universidade(3L, "Universidade de Sao Paulo", vestibularesUsp);
        Universidade unesp = new Universidade(4L, "Universidade de Estadual Paulista", vestibularesUnesp);

        Campus uspBauru = mock(Campus.class);
        Campus uspLeste = mock(Campus.class);
        Campus unespLimeira = mock(Campus.class);
        Campus unespAraraquara = mock(Campus.class);

        ArrayList<Campus> allCampus = new ArrayList<>(Arrays.asList(uspBauru, uspLeste, unespLimeira, unespAraraquara));

        when(repositorioCampus.findAll()).thenReturn(allCampus);
        when(uspBauru.getUniversidade()).thenReturn(usp);
        when(uspLeste.getUniversidade()).thenReturn(usp);
        when(unespLimeira.getUniversidade()).thenReturn(unesp);
        when(unespAraraquara.getUniversidade()).thenReturn(unesp);
        when(uspBauru.getNome()).thenReturn(usp.getNome());
        when(uspLeste.getNome()).thenReturn(usp.getNome());
        when(unespLimeira.getNome()).thenReturn(unesp.getNome());
        when(unespAraraquara.getNome()).thenReturn(unesp.getNome());

        List<Campus> allUspCampus = universidadeController.getAllUniversityCampus(5L);

        assertThat(allUspCampus.size()).isEqualTo(0);
    }

    @Test
    public void testGetUniversityById() throws ResourceNotFoundException {
        Vestibular fuvest = mock(Vestibular.class);
        Vestibular sisu = mock(Vestibular.class);

        ArrayList<Vestibular> vestibularesUsp = new ArrayList<>(Arrays.asList(fuvest, sisu));

        Universidade usp = new Universidade(3L, "Universidade de Sao Paulo", vestibularesUsp);

        when(repositorioUniversidade.findById(3L)).thenReturn(Optional.of(usp));

        ResponseEntity expected = universidadeController.getUniversityByid(3L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(usp);
    }

    @Test
    public void testGetUniversityByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            universidadeController.getUniversityByid(12L);
        });

        String expectedMessage = "Universidade com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}