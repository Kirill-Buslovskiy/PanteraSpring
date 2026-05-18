package com.javarush.lesson10.web;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String notFoundGift) {
    }
}
