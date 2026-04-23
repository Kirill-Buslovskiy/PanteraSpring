package com.javarush.pantera.lesson04.validator.impl;

import com.javarush.pantera.lesson04.validator.Validator;
import com.javarush.pantera.lesson04.validator.annotation.Min;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Order(1)
public class MinValidator<T> implements Validator<T> {
    @Override
    public void validate(T entity, Field field) {
        if (field.isAnnotationPresent(Min.class)) {
            try {
                Min min = field.getAnnotation(Min.class);
                String name = field.getName();
                Object value = field.get(entity);
                if (value.toString().length() < min.value()) {
                    String messageError = String.format("Incorrect min length for %s cause: %s<%d"
                            , name, value, min.value());
                    throw new IllegalArgumentException(messageError);
                }
            } catch (IllegalAccessException e) {
                String messageArg = "Field " + field.getName() + " is not readable";
                throw new IllegalArgumentException(messageArg);
            }
        }
    }
}
