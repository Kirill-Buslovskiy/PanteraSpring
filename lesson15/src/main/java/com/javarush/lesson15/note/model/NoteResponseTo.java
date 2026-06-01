package com.javarush.lesson15.note.model;

public record NoteResponseTo(
        Long id,
        Long storyId,
        String content
) {
}
