package com.javarush.pantera.lesson04.service;

import com.javarush.pantera.lesson04.config.PostgresLogger;
import com.javarush.pantera.lesson04.entity.User;
import com.javarush.pantera.lesson04.processor.annotation.AutoInject;
import com.javarush.pantera.lesson04.processor.annotation.TimeLog;
import com.javarush.pantera.lesson04.repository.Repo;
import com.javarush.pantera.lesson04.repository.UserRepository;
import com.javarush.pantera.lesson04.validator.Validator;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@ToString
public class UserService {

    private final UserRepository userRepository;

    private PostgresLogger postgresLogger;

    @PostConstruct
    void init(){
        log.warn("PostgresLogger = {}", postgresLogger);
    }

    public void saveAll(List<User> users) {
        users.forEach(userRepository::save);
    }

    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @AutoInject
    public void setPostgresLogger(PostgresLogger postgresLogger) {
        this.postgresLogger = postgresLogger;
    }
}
