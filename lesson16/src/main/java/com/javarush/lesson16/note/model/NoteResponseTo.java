package com.javarush.lesson16.note.model;

public record NoteResponseTo(
        Long id,
        Long storyId,
        String content
) {
}
