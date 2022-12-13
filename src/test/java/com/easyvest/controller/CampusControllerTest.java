package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Campus;
import com.easyvest.model.Curso;
import com.easyvest.model.Universidade;
import com.easyvest.repository.RepositorioCampus;
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

public class CampusControllerTest {
    private final RepositorioCampus repositorioCampus = mock(RepositorioCampus.class);
    private final CampusController campusController = new CampusController(repositorioCampus);

    @Test
    public void testGetAllCampus() {
        Universidade usp = mock(Universidade.class);
        Universidade unesp = mock(Universidade.class);
        Curso nutricao = mock(Curso.class);
        Curso sistemasInformacao = mock(Curso.class);
        Curso direito = mock(Curso.class);
        Curso engenhariaCivil = mock(Curso.class);
        Curso engenhariaProducao = mock(Curso.class);
        ArrayList<Curso> cursosUspBauru = new ArrayList<>(Arrays.asList(nutricao, direito));
        ArrayList<Curso> cursosUspLeste = new ArrayList<>(Arrays.asList(sistemasInformacao, direito));
        ArrayList<Curso> cursosUnespBauru = new ArrayList<>(Arrays.asList(engenhariaCivil, sistemasInformacao));
        ArrayList<Curso> cursosUnespAraraquara = new ArrayList<>(Arrays.asList(engenhariaCivil, engenhariaProducao));

        Campus uspBauru = new Campus(1L, "Campus bauru", "rua ABC - Bauru", usp, cursosUspBauru);
        Campus uspLeste = new Campus(1L, "Campus leste", "rua ABC - SP", usp, cursosUspLeste);
        Campus unespBauru = new Campus(1L, "Campus bauru", "rua XYZ - Bauru", unesp, cursosUnespBauru);
        Campus unespAraraquara = new Campus(1L, "Campus araraquara", "rua DEF - SP", unesp, cursosUnespAraraquara);

        List<Campus> expected = new ArrayList<>();
        expected.add(uspBauru);
        expected.add(uspLeste);
        expected.add(unespBauru);
        expected.add(unespAraraquara);

        when(repositorioCampus.findAll()).thenReturn(expected);

        List<Campus> allCampus = campusController.getAllCampus();

        assertThat(allCampus.size()).isEqualTo(4);
        assertThat(allCampus.contains(uspBauru)).isTrue();
        assertThat(allCampus.contains(uspLeste)).isTrue();
        assertThat(allCampus.contains(unespBauru)).isTrue();
        assertThat(allCampus.contains(unespAraraquara)).isTrue();
    }

    @Test
    public void testGetAllCampusReturnEmptyList() {
        when(repositorioCampus.findAll()).thenReturn(new ArrayList<>());
        List<Campus> allCampus = campusController.getAllCampus();

        assertThat(allCampus.size()).isEqualTo(0);
    }

    @Test
    public void testGetCampusById() throws ResourceNotFoundException {
        Universidade usp = mock(Universidade.class);
        Curso nutricao = mock(Curso.class);
        Curso direito = mock(Curso.class);
        ArrayList<Curso> cursosUspBauru = new ArrayList<>(Arrays.asList(nutricao, direito));

        Campus uspBauru = new Campus(1L, "Campus bauru", "rua ABC - Bauru", usp, cursosUspBauru);

        when(repositorioCampus.findById(12L)).thenReturn(Optional.of(uspBauru));

        ResponseEntity expected = campusController.getCampusByid(12L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(uspBauru);
    }

    @Test
    public void testGetCampusByIdReturnException() throws ResourceNotFoundException {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            campusController.getCampusByid(12L);
        });

        String expectedMessage = "Campus com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }

}