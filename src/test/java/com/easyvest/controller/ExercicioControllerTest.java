package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Exercicio;
import com.easyvest.model.Lista;
import com.easyvest.model.Tema;
import com.easyvest.repository.RepositorioExercicio;
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

public class ExercicioControllerTest {
    private final RepositorioExercicio repositorioExercicio = mock(RepositorioExercicio.class);
    private final ExercicioController exercicioController = new ExercicioController(repositorioExercicio);

    @Test
    public void testGetAllExercises() {
        Tema geometria = mock(Tema.class);
        Lista listaExercioGeometriaNivelI = mock(Lista.class);
        Lista listaExercioGeometriaNivelII = mock(Lista.class);
        Lista listaExercioGeometriaNivelIII = mock(Lista.class);

        List<Lista> temasMatematicaEnsinoMedio = new ArrayList<>(Arrays.asList(listaExercioGeometriaNivelI, listaExercioGeometriaNivelII, listaExercioGeometriaNivelIII));
        List<Lista> temasMatematicaEnsinoFundamental = new ArrayList<>(Arrays.asList(listaExercioGeometriaNivelI));

        String textoExercicio01 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
        String textoExercicio02 = "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        Exercicio exercicioMatematica01 = new Exercicio(3L, textoExercicio01, 'B', geometria, temasMatematicaEnsinoMedio);
        Exercicio exercicioMatematica02 = new Exercicio(3L, textoExercicio02, 'A', geometria, temasMatematicaEnsinoFundamental);

        List<Exercicio> expected = new ArrayList<>();
        expected.add(exercicioMatematica01);
        expected.add(exercicioMatematica02);

        when(repositorioExercicio.findAll()).thenReturn(expected);

        List<Exercicio> allExercises = exercicioController.getAllExercises();

        assertThat(allExercises.size()).isEqualTo(2);
        assertThat(allExercises.contains(exercicioMatematica01)).isTrue();
        assertThat(allExercises.contains(exercicioMatematica02)).isTrue();
    }

    @Test
    public void testGetAllExercisesReturnEmptyList() {
        when(repositorioExercicio.findAll()).thenReturn(new ArrayList<>());
        List<Exercicio> allExercises= exercicioController.getAllExercises();

        assertThat(allExercises.size()).isEqualTo(0);
    }

    @Test
    public void testGetExerciseById() throws ResourceNotFoundException {
        Tema geometria = mock(Tema.class);
        Lista listaExercioGeometriaNivelI = mock(Lista.class);
        Lista listaExercioGeometriaNivelII = mock(Lista.class);
        Lista listaExercioGeometriaNivelIII = mock(Lista.class);

        List<Lista> temasMatematicaEnsinoMedio = new ArrayList<>(Arrays.asList(listaExercioGeometriaNivelI, listaExercioGeometriaNivelII, listaExercioGeometriaNivelIII));

        String textoExercicio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

        Exercicio exercicioMatematica = new Exercicio(3L, textoExercicio, 'B', geometria, temasMatematicaEnsinoMedio);

        when(repositorioExercicio.findById(21L)).thenReturn(Optional.of(exercicioMatematica));

        ResponseEntity expected = exercicioController.getExerciseByid(21L);
        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(exercicioMatematica);
    }

    @Test
    public void testGetExerciseByIdReturnException() {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            exercicioController.getExerciseByid(12L);
        });

        String expectedMessage = "Exercicio com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}