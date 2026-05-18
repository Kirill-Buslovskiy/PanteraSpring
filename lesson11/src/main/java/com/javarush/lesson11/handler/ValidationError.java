package com.javarush.lesson11.handler;

public record ValidationError(
        String object,
        String field,
        String message) {
}
