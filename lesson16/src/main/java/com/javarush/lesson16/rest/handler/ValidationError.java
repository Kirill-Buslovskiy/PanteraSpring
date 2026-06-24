package com.javarush.lesson16.rest.handler;

public record ValidationError(
        String object,
        String field,
        String message) {
}
