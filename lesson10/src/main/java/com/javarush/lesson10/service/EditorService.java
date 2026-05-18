package com.javarush.lesson10.service;

import com.javarush.lesson10.mapper.EditorDto;
import com.javarush.lesson10.model.editor.EditorIn;
import com.javarush.lesson10.model.editor.EditorOut;
import com.javarush.lesson10.repository.impl.EditorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EditorService {
    //todo напиши Unit Test применяй Mockito и используй Builder для сущностей. надо какие-то данные в сущности положить заранее
    public final EditorRepo repoImpl;
    public final EditorDto mapper;

    public List<EditorOut> getAll() {
        return repoImpl
                .getAll()
                .map(mapper::out)
                .toList();
    }

    public EditorOut get(Long id) {
        return repoImpl
                .get(id)
                .map(mapper::out)
                .orElseThrow();
    }

    @Transactional
    public EditorOut create(EditorIn input) {
        return repoImpl
                .create(mapper.in(input))
                .map(mapper::out)
                .orElseThrow();
    }

    @Transactional
    public EditorOut update(EditorIn input) {
        return repoImpl
                .update(mapper.in(input))
                .map(mapper::out)
                .orElseThrow();
    }

    @Transactional
    public boolean delete(Long id) {
        return repoImpl.delete(id);
    }
}
