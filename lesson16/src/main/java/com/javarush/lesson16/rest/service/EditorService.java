package com.javarush.lesson16.rest.service;

import com.javarush.lesson16.rest.mapper.EditorDto;
import com.javarush.lesson16.rest.model.editor.EditorIn;
import com.javarush.lesson16.rest.model.editor.EditorOut;
import com.javarush.lesson16.rest.repository.EditorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EditorService {

    public final EditorRepo editorRepo;

    public final EditorDto mapper;

    public Flux<EditorOut> getAll() {
        return editorRepo
                .getAll()
                .map(mapper::out);
    }

    public Mono<EditorOut> get(Long id) {
        return editorRepo
                .get(id)
                .map(mapper::out);
    }

    @Transactional
    public Mono<EditorOut> create(EditorIn input) {
        return editorRepo
                .create(mapper.in(input))
                .map(mapper::out);
    }

    @Transactional
    public Mono<EditorOut> update(EditorIn input) {
        return editorRepo
                .update(mapper.in(input))
                .map(mapper::out);
    }

    @Transactional
    public Mono<Void> delete(Long id) {
        return editorRepo.delete(id);
    }
}
