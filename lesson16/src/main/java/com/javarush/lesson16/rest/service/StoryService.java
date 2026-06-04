package com.javarush.lesson16.rest.service;

import com.javarush.lesson16.rest.mapper.StoryDto;
import com.javarush.lesson16.rest.model.story.Story;
import com.javarush.lesson16.rest.model.story.StoryIn;
import com.javarush.lesson16.rest.model.story.StoryOut;
import com.javarush.lesson16.rest.repository.EditorRepo;
import com.javarush.lesson16.rest.repository.StoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class StoryService {

    public final StoryRepo storyRepo;
    public final EditorRepo editorRepo;
    public final StoryDto mapper;

    public Flux<StoryOut> getAll() {
        return storyRepo
                .getAll()
                .map(mapper::out);
    }

    public Mono<StoryOut> get(Long id) {
        return storyRepo
                .get(id)
                .map(mapper::out);
    }

    @Transactional
    public Mono<StoryOut> create(StoryIn input) {
        return createStory(input)
                .flatMap(storyRepo::create)
                .map(mapper::out);
    }

    @Transactional
    public Mono<StoryOut> update(StoryIn input) {
        return storyRepo.get(input.getId())
                .switchIfEmpty(Mono.error(new NoSuchElementException("Story not found id=" + input.getId())))
                .flatMap(existingStory -> {
                    Story updatedData = mapper.in(input);
                    updatedData.setId(existingStory.getId());
                    return storyRepo.update(updatedData);
                })
                .map(mapper::out);
    }

    @Transactional
    public Mono<Boolean> delete(Long id) {
        return storyRepo.findById(id)
                .switchIfEmpty(Mono.error(new NoSuchElementException("Story not found id=" + id)))
                .flatMap(story -> storyRepo.delete(story).then(Mono.just(true)));
    }

    private Mono<Story> createStory(StoryIn input) {
        Story story = mapper.in(input);
        return editorRepo.get(input.getEditorId())
                .switchIfEmpty(Mono.error(new NoSuchElementException("Editor not found id=" + input.getEditorId())))
                .flatMap(editor -> {
                    story.setEditorId(editor.getId());
                    return Mono.just(story);
                });
    }
}