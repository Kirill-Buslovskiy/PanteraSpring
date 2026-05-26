package com.javarush.lesson12.impl.note.model;

public record NoteResponseTo(
        Long id,
        Long storyId,
        String content
) {
}
