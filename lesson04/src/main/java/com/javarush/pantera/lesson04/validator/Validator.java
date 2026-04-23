package com.javarush.pantera.lesson04.validator;

import java.lang.reflect.Field;

public interface Validator<T> {

    default void validate(T entity){
        Class<?> aClass = entity.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.trySetAccessible()){
                validate(entity,field);
            } else {
                String message = "Field " + field.getName() + " is not accessible";
                throw new IllegalStateException(message);
            }
        }
    };

    void validate(T entity, Field field);
}
