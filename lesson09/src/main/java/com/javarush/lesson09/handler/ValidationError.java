package com.javarush.lesson09.handler;

public record ValidationError(
        String object,
        String field,
        String message) {
}
