package com.javarush.lesson12.support.errorHandlers.model;

public record ValidationError(
        String object,
        String field,
        String message) {
}