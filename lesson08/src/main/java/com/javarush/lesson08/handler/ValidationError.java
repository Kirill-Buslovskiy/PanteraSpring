package com.javarush.lesson08.handler;

public record ValidationError(
        String object,
        String field,
        String message) {
}
