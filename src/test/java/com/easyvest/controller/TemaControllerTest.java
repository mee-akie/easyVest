package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Aula;
import com.easyvest.model.Disciplina;
import com.easyvest.model.Exercicio;
import com.easyvest.model.Tema;
import com.easyvest.repository.RepositorioTema;
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

public class TemaControllerTest {
    private final RepositorioTema repositorioTema = mock(RepositorioTema.class);
    private final TemaController temaController = new TemaController(repositorioTema);

    @Test
    public void testGetAllThemes() {
        Aula aulaGeometriaBasica = mock(Aula.class);
        Aula aulaGeometriaAvancada = mock(Aula.class);
        Aula aulaPorcentagemBasica = mock(Aula.class);
        Aula aulaPorcentagemAvancada = mock(Aula.class);

        Exercicio exercicioGeometria01 = mock(Exercicio.class);
        Exercicio exercicioGeometria02 = mock(Exercicio.class);
        Exercicio exercicioGeometria03 = mock(Exercicio.class);
        Exercicio exercicioPorcentagem01 = mock(Exercicio.class);
        Exercicio exercicioPorcentagem02 = mock(Exercicio.class);

        ArrayList<Aula> aulasGeometria = new ArrayList<>(Arrays.asList(aulaGeometriaBasica, aulaGeometriaAvancada));
        ArrayList<Aula> aulasPorcentagem = new ArrayList<>(Arrays.asList(aulaPorcentagemBasica, aulaPorcentagemAvancada));

        ArrayList<Exercicio> exerciciosGeometria = new ArrayList<>(Arrays.asList(exercicioGeometria01, exercicioGeometria02, exercicioGeometria03));
        ArrayList<Exercicio> exerciciosPorcentagem = new ArrayList<>(Arrays.asList(exercicioPorcentagem01, exercicioPorcentagem02));

        Disciplina matematica = mock(Disciplina.class);

        Tema geometria = new Tema(2L, "Geometria", matematica, aulasGeometria, exerciciosGeometria);
        Tema porcentagem = new Tema(5L, "Porcentagem", matematica, aulasPorcentagem, exerciciosPorcentagem);

        List<Tema> expected = new ArrayList<>();
        expected.add(geometria);
        expected.add(porcentagem);

        when(repositorioTema.findAll()).thenReturn(expected);

        List<Tema> allThemes = temaController.getAllThemes();

        assertThat(allThemes.size()).isEqualTo(2);
        assertThat(allThemes.contains(geometria)).isTrue();
        assertThat(allThemes.contains(porcentagem)).isTrue();
    }

    @Test
    public void testGetAllThemesReturnEmptyList() {
        when(repositorioTema.findAll()).thenReturn(new ArrayList<>());
        List<Tema> allThemes = temaController.getAllThemes();

        assertThat(allThemes.size()).isEqualTo(0);
    }

    @Test
    public void testGetThemeById() throws ResourceNotFoundException {
        Aula aulaGeometriaBasica = mock(Aula.class);
        Aula aulaGeometriaAvancada = mock(Aula.class);
        Exercicio exercicio01 = mock(Exercicio.class);
        Exercicio exercicio02 = mock(Exercicio.class);
        Exercicio exercicio03 = mock(Exercicio.class);
        ArrayList<Aula> aulasGeometria = new ArrayList<>(Arrays.asList(aulaGeometriaBasica, aulaGeometriaAvancada));
        ArrayList<Exercicio> exerciciosGeometria = new ArrayList<>(Arrays.asList(exercicio01, exercicio02, exercicio03));
        Disciplina matematica = mock(Disciplina.class);

        Tema geometria = new Tema(2L, "Geometria", matematica, aulasGeometria, exerciciosGeometria);

        when(repositorioTema.findById(2L)).thenReturn(Optional.of(geometria));

        ResponseEntity expected = temaController.getThemeByid(2L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(geometria);
    }

    @Test
    public void testGetThemeByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            temaController.getThemeByid(12L);
        });

        String expectedMessage = "Tema com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}