package com.javarush.lesson13.impl.note.model;

public record NoteResponseTo(
        Long id,
        Long storyId,
        String content
) {
}
