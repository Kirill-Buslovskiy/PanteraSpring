package com.javarush.lesson15.rest.handler;

public record ValidationError(
        String object,
        String field,
        String message) {
}
