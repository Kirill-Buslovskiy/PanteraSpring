package com.javarush.lesson10.service;

import com.javarush.lesson10.mapper.EditorDto;
import com.javarush.lesson10.model.editor.Editor;
import com.javarush.lesson10.model.editor.EditorIn;
import com.javarush.lesson10.model.editor.EditorOut;
import com.javarush.lesson10.repository.impl.EditorRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EditorServiceTest {

    @Mock
    EditorRepo repo;

    @Mock
    EditorDto mapper;

    @InjectMocks
    EditorService service;

    private record TestData(EditorIn in, Editor entity, EditorOut out) {}

    private final TestData data = new TestData(
            EditorIn.builder().id(1L).login("dev").firstname("Max").build(),
            Editor.builder().id(1L).login("dev").firstname("Max").build(),
            EditorOut.builder().id(1L).login("dev").firstname("Max").build()
    );

    @Test
    void getAll() {
        when(repo.getAll()).thenReturn(Stream.of(data.entity()));
        when(mapper.out(data.entity())).thenReturn(data.out());

        List<EditorOut> result = service.getAll();

        assertFalse(result.isEmpty());
        assertEquals(data.out().getLogin(), result.getFirst().getLogin());
        verify(repo).getAll();
    }

    @Test
    void get() {
        when(repo.get(1L)).thenReturn(Optional.of(data.entity()));
        when(mapper.out(data.entity())).thenReturn(data.out());

        EditorOut result = service.get(1L);

        assertNotNull(result);
        assertEquals(data.out().getId(), result.getId());
        verify(repo).get(1L);
    }

    @Test
    void create() {
        when(mapper.in(data.in())).thenReturn(data.entity());
        when(repo.create(data.entity())).thenReturn(Optional.of(data.entity()));
        when(mapper.out(data.entity())).thenReturn(data.out());

        EditorOut result = service.create(data.in());

        assertNotNull(result);
        assertEquals(data.out().getLogin(), result.getLogin());
        verify(repo).create(any(Editor.class));
    }

    @Test
    void update() {
        when(mapper.in(data.in())).thenReturn(data.entity());
        when(repo.update(data.entity())).thenReturn(Optional.of(data.entity()));
        when(mapper.out(data.entity())).thenReturn(data.out());

        EditorOut result = service.update(data.in());

        assertEquals(data.out().getFirstname(), result.getFirstname());
        verify(repo).update(data.entity());
    }

    @Test
    void delete() {
        when(repo.delete(1L)).thenReturn(true);

        boolean deleted = service.delete(1L);

        assertTrue(deleted);
        verify(repo).delete(1L);
    }
}