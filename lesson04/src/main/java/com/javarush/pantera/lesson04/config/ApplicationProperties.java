package com.javarush.pantera.lesson04.config;

import lombok.SneakyThrows;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;


@Configuration
@ToString
public class ApplicationProperties extends Properties {

    public static final String HIBERNATE_CONNECTION_URL = "hibernate.connection.url";
    public static final String HIBERNATE_CONNECTION_USERNAME = "hibernate.connection.username";
    public static final String HIBERNATE_CONNECTION_PASSWORD = "hibernate.connection.password";
    public static final String HIBERNATE_CONNECTION_DRIVER_CLASS = "hibernate.connection.driver_class";
    public static final String ENV_EXPRESSION = "\\$\\{[A-Z_]+:.+}";

    @SneakyThrows
    public ApplicationProperties(
            @Value("${" + HIBERNATE_CONNECTION_URL + "}") String url,
            @Value("${" + HIBERNATE_CONNECTION_DRIVER_CLASS + "}") String driverClass,
            @Value("${" + HIBERNATE_CONNECTION_USERNAME + "}") String username,
            @Value("${" + HIBERNATE_CONNECTION_PASSWORD + "}") String password
    ) {
        this.put(HIBERNATE_CONNECTION_URL, url);
        this.put(HIBERNATE_CONNECTION_USERNAME, username);
        this.put(HIBERNATE_CONNECTION_PASSWORD, password);
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this);
    }


    //any runtime
    public final static Path CLASSES_ROOT = Paths.get(URI.create(
            Objects.requireNonNull(
                    ApplicationProperties.class.getResource("/")
            ).toString()));

    //only in Tomcat (not use in tests)
    public final static Path WEB_INF = CLASSES_ROOT.getParent();
}
