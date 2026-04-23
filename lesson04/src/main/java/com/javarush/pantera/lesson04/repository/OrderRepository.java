package com.javarush.pantera.lesson04.repository;

import com.javarush.pantera.lesson04.config.SessionCreator;
import com.javarush.pantera.lesson04.entity.User;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor
@ToString
public class OrderRepository implements Repo {

    private final SessionCreator sessionCreator;

    @Override
    public void save(User user) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }
}
