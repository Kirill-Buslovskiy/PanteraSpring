package com.javarush.lesson09.web;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@ControllerAdvice
public class GlobalWebExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalWebExceptionHandler.class);

    /**
     * Обрабатывает ResourceNotFoundException из любого контроллера приложения.
     * Возвращает пользователю кастомную страницу 404.
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFound(ResourceNotFoundException ex, Model model) {
        // Уровень логирования WARN подходит для ошибок, связанных с пользовательским вводом (4xx)
        log.warn("Resource not found: {}", ex.getMessage()); 
        model.addAttribute("errorMessage", ex.getMessage());
        return "error-404"; // Отображение кастомного шаблона
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleResourceNotFound(MethodArgumentNotValidException ex, Model model) {
        // Уровень логирования WARN подходит для ошибок, связанных с пользовательским вводом (4xx)
        List<String> list = ex.getBindingResult().getAllErrors()
                .stream()
                .map(oe->oe.getObjectName()+" has erros: "+oe.getDefaultMessage()).toList();
        log.warn("Resource not found: {}", list);
        model.addAttribute("errorMessage", list);
        return "error-404"; // Отображение кастомного шаблона
    }


    /**
     * Обрабатывает общие исключения, которые не были перехвачены более специфичными обработчиками.
     * Это обработчик "последней инстанции", ловит Exception.class.
     */
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model model) {
        // Уровень LOG ERROR подходит для неожиданных системных ошибок (5xx)
        log.error("An unexpected error occurred", ex); // Логирование полного стектрейса
        model.addAttribute("errorMessage", "An unexpected error occurred. Please try again later.");
        return "error-500"; // Отображение общей страницы ошибки 500
    }
}