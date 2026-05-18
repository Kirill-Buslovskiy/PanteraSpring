package com.javarush.lesson09.web;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String notFoundGift) {
    }
}
