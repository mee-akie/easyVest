package com.easyvest.controller;

import com.easyvest.exception.ResourceNotFoundException;
import com.easyvest.model.Aula;
import com.easyvest.model.Tema;
import com.easyvest.repository.RepositorioAula;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AulaControllerTest {
    private final RepositorioAula repositorioAula = mock(RepositorioAula.class);
    private final AulaController aulaController = new AulaController(repositorioAula);

    @Test
    public void testGetAllClasses() {
        Tema geometria = mock(Tema.class);
        Tema trigonometria = mock(Tema.class);
        Tema porcentagem = mock(Tema.class);
        Tema prismas = mock(Tema.class);

        Aula aulaGeometria = new Aula(1L, "Geometria Plana - Ângulos entre retas concorrentes e transversais", "http://testeABC.com.br", "canal abc", geometria);
        Aula aulaTrigonometria = new Aula(1L, "Trigonometria - Noção intuitiva", "http://teste.com.br", "teste canal", trigonometria);
        Aula aulaPorcentagem = new Aula(1L, "Porcentagem: teoria, taxa percentual, proporção e taxa decimal", "http://testeXYZ.com.br", "canal xyz", porcentagem);
        Aula aulaPrismas = new Aula(1L, "Noção intuitiva", "http://testeDEF.com.br", "canal def", prismas);

        List<Aula> expected = new ArrayList<>();
        expected.add(aulaGeometria);
        expected.add(aulaTrigonometria);
        expected.add(aulaPorcentagem);
        expected.add(aulaPrismas);

        when(repositorioAula.findAll()).thenReturn(expected);

        List<Aula> allClasses = aulaController.getAllClasses();

        assertThat(allClasses.size()).isEqualTo(4);
        assertThat(allClasses.contains(aulaGeometria)).isTrue();
        assertThat(allClasses.contains(aulaTrigonometria)).isTrue();
        assertThat(allClasses.contains(aulaPorcentagem)).isTrue();
        assertThat(allClasses.contains(aulaPrismas)).isTrue();
    }

    @Test
    public void testGetAllClassesReturnEmptyList() {
        when(repositorioAula.findAll()).thenReturn(new ArrayList<>());
        List<Aula> allClasses = aulaController.getAllClasses();

        assertThat(allClasses.size()).isEqualTo(0);
    }

    @Test
    public void testGetClassById() throws ResourceNotFoundException {
        Tema geometria = mock(Tema.class);
        Aula aulaGeometria = new Aula(12L, "Geometria Plana - Ângulos entre retas concorrentes e transversais", "http://testeABC.com.br", "canal abc", geometria);

        when(repositorioAula.findById(12L)).thenReturn(Optional.of(aulaGeometria));

        ResponseEntity expected = aulaController.getClassByid(12L);

        assertThat(expected.getStatusCodeValue()).isEqualTo(200);
        assertThat(expected.getBody()).isEqualTo(aulaGeometria);
    }

    @Test
    public void testGetClassByIdReturnException() throws ResourceNotFoundException {
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            aulaController.getClassByid(12L);
        });

        String expectedMessage = "Aula com id '12' nao foi encontrado";
        String actualMessage = exception.getMessage();

        assertThat(expectedMessage).isEqualTo(actualMessage);
    }
}