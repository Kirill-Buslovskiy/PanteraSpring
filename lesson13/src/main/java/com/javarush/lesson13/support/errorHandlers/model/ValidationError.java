package com.javarush.lesson13.support.errorHandlers.model;

public record ValidationError(
        String object,
        String field,
        String message) {
}