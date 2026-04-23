package com.javarush.pantera.lesson04.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class PostgresCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            Class.forName("org.postgresql.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
