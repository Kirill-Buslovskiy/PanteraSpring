package com.javarush.pantera.lesson04.repository;

import com.javarush.pantera.lesson04.entity.User;

public interface Repo {
    void save(User user);

    User getById(Long id);
}
