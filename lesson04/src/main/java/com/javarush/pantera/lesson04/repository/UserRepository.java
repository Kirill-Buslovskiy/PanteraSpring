package com.javarush.pantera.lesson04.repository;

import com.javarush.pantera.lesson04.config.SessionCreator;
import com.javarush.pantera.lesson04.entity.User;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Repository
@AllArgsConstructor
@ToString
public class UserRepository implements Repo {

    private final SessionCreator sessionCreator;

    private final Map<Long, User> users = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getById(Long id) {
        User user = users.get(id);
        if (user == null) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        }
        return user;
    }
}
