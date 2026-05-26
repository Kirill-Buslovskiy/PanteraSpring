package com.javarush.lesson12.message.model;

public record NoteResponseTo(
        Long id,
        Long storyId,
        String content
) {
}
