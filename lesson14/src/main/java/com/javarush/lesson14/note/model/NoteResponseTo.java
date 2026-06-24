package com.javarush.lesson14.note.model;

public record NoteResponseTo(
        Long id,
        Long storyId,
        String content
) {
}
