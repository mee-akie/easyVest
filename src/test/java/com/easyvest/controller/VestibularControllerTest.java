package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Universidade;
import com.easyvest.model.Vestibular;
import com.easyvest.repository.RepositorioVestibular;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VestibularControllerTest {

    private final RepositorioVestibular repositorioVestibular = mock(RepositorioVestibular.class);
    private final VestibularController vestibularController = new VestibularController(repositorioVestibular);

    @Test
    public void testGetAllExam() {
        Universidade usp = mock(Universidade.class);
        Universidade ufmg = mock(Universidade.class);
        Universidade ufrj = mock(Universidade.class);
        Universidade ufes = mock(Universidade.class);

        List<Universidade> universidadesFuvest = new ArrayList<Universidade>(Arrays.asList(usp));
        List<Universidade> universidadesSisu = new ArrayList<Universidade>(Arrays.asList(usp, ufmg, ufrj, ufes));

        Vestibular fuvest = new Vestibular(1L, "Fuvest", new Date(2022, 11, 5), "http://fuvest.com.br", universidadesFuvest);
        Vestibular sisu = new Vestibular(2L, "Sisu", new Date(2022, 10, 15), "http://sisu.com.br", universidadesSisu);

        List<Vestibular> expected = new ArrayList<>();
        expected.add(fuvest);
        expected.add(sisu);

        when(repositorioVestibular.findAll()).thenReturn(expected);

        List<Vestibular> allExam = vestibularController.getAllExam();

        assertThat(allExam.size()).isEqualTo(2);
        assertThat(allExam.contains(fuvest)).isTrue();
        assertThat(allExam.contains(sisu)).isTrue();
    }

    @Test
    public void testGetAllExamReturnEmptyList() {
        when(repositorioVestibular.findAll()).thenReturn(new ArrayList<>());
        List<Vestibular> allCampus = vestibularController.getAllExam();

        assertThat(allCampus.size()).isEqualTo(0);
    }

    @Test
    public void testGetExamById() throws ResourceNotFoundException {
        Universidade usp = mock(Universidade.class);
        Universidade ufmg = mock(Universidade.class);
        Universidade ufrj = mock(Universidade.class);
        Universidade ufes = mock(Universidade.class);

        List<Universidade> universidadesSisu = new ArrayList<Universidade>(Arrays.asList(usp, ufmg, ufrj, ufes));

        Vestibular sisu = new Vestibular(2L, "Sisu", new Date(2022, 10, 15), "http://sisu.com.br", universidadesSisu);

        when(repositorioVestibular.findById(12L)).thenReturn(Optional.of(sisu));

        ResponseEntity expected = vestibularController.getExamByid(12L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(sisu);
    }

    @Test
    public void testGetExamByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            vestibularController.getExamByid(12L);
        });

        String expectedMessage = "Vestibular com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}