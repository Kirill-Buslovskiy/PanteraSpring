package com.javarush.pantera.lesson04.validator.impl;

import com.javarush.pantera.lesson04.validator.Validator;
import com.javarush.pantera.lesson04.validator.annotation.Max;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
@Order(2)
public class MaxValidator<T> implements Validator<T> {
    @Override
    public void validate(T entity, Field field) {
        if (field.isAnnotationPresent(Max.class)) {
            try {
                Max max = field.getAnnotation(Max.class);
                String name = field.getName();
                Object value = field.get(entity);
                if (value.toString().length() > max.value()) {
                    String messageError = String.format("Incorrect max length for %s cause: %s>%d"
                            , name, value, max.value());
                    throw new IllegalArgumentException(messageError);
                }
            } catch (IllegalAccessException e) {
                String messageArg = "Field " + field.getName() + " is not readable";
                throw new IllegalArgumentException(messageArg);
            }
        }
    }
}
